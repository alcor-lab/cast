package de.dfki.lt.tr.cast.dialogue;

import cast.SubarchitectureComponentException;
import cast.architecture.ChangeFilterFactory;
import cast.architecture.WorkingMemoryChangeReceiver;
import cast.cdl.WorkingMemoryAddress;
import cast.cdl.WorkingMemoryChange;
import cast.cdl.WorkingMemoryOperation;
import de.dfki.lt.tr.beliefs.slice.intentions.PossibleInterpretedIntentions;
import de.dfki.lt.tr.cast.dialogue.util.VerbalisationUtils;
import de.dfki.lt.tr.dialogue.interpret.Rephraser;
import de.dfki.lt.tr.dialogue.slice.asr.UnclarifiedPhonString;
import de.dfki.lt.tr.dialogue.slice.asr.UnclarifiedPossibleInterpretedIntentions;
import java.util.Map;

public class ASRClarifier
extends AbstractDialogueComponent {

	public final float DEFAULT_THRESHOLD = 0.6f;
        public final String DEFAULT_AFFIRMATIVE = "affirmative";
        public final String DEFAULT_NEGATIVE = "negative";

	private float threshold;
        private String affirmative;
        private String negative;

	private PossibleInterpretedIntentions currentlyUnclarified;

	private final Rephraser rephraser;

	public ASRClarifier() {
		this.threshold = DEFAULT_THRESHOLD;
                this.affirmative = DEFAULT_AFFIRMATIVE;
                this.negative = DEFAULT_NEGATIVE;
		currentlyUnclarified = null;
		rephraser = new BasicRephraser();
	}

	@Override
	public void onConfigure(Map<String, String> args) {
		if (args.containsKey("--threshold")) {
			try {
				threshold = Float.parseFloat(args.get("--threshold"));
			}
			catch (NumberFormatException ex) {
				logException(ex);
			}
		}

//		threshold = 1.1f;
		getLogger().debug("using " + threshold + " for the ASR confidence threshold");
	}

	@Override
	public void onStart() {
		addChangeFilter(ChangeFilterFactory.createLocalTypeFilter(
						UnclarifiedPhonString.class,
						WorkingMemoryOperation.ADD),
				new WorkingMemoryChangeReceiver() {
					@Override
					public void workingMemoryChanged(WorkingMemoryChange _wmc) {
						handleUnclarifiedPhonString(_wmc);
					}
				});

		addChangeFilter(ChangeFilterFactory.createLocalTypeFilter(
						UnclarifiedPossibleInterpretedIntentions.class,
						WorkingMemoryOperation.ADD),
				new WorkingMemoryChangeReceiver() {
					@Override
					public void workingMemoryChanged(WorkingMemoryChange _wmc) {
						handleUnclarifiedPossibleInterpretedIntentions(_wmc);
					}
				});
	}

	protected PossibleInterpretedIntentions getCurrentlyUnclarified() {
		return currentlyUnclarified;
	}

	protected void setCurrentlyUnclarified(PossibleInterpretedIntentions pii) {
		currentlyUnclarified = pii;
	}

	protected void clearCurrentlyUnclarified() {
		currentlyUnclarified = null;
	}

	private void handleUnclarifiedPhonString(WorkingMemoryChange _wmc) {
		addTask(new ProcessingTaskWithDataAndComponent<WorkingMemoryAddress, ASRClarifier>(_wmc.address, this) {

			@Override
			public void execute(WorkingMemoryAddress addr) {
				try {
					getLogger().debug("got an UnclarifiedPhonString");
					UnclarifiedPhonString ups = getMemoryEntry(addr, UnclarifiedPhonString.class);

					PossibleInterpretedIntentions current = getCurrentlyUnclarified();
					if (current == null) {
						getLogger().debug("there's nothing unclarified at the moment -> passing a PhonString on");
						addToWorkingMemory(newDataID(), ups.ps);
					}
					else {
						String words = ups.ps.wordSequence;
						if (words.contains(affirmative)) {
							getLogger().debug("it contained \"" + affirmative + "\" -> will forward the PossibleInterpretedIntentions");
							clearCurrentlyUnclarified();
                                                        VerbalisationUtils.verbaliseString(getComponent(), "acknowledged");
							addToWorkingMemory(newDataID(), current);
						}
						else if (words.contains(negative)) {
							getLogger().debug("it contained \"" + negative + "\" -> dropping the PossibleInterpretedIntentions");
							clearCurrentlyUnclarified();
							VerbalisationUtils.verbaliseString(getComponent(), "understood, negative");
						}
						else {
							getLogger().debug("it doesn't contain \"" + affirmative + "\" or \"" + negative + "\" -> dropping the PossibleInterpretedIntentions");
							clearCurrentlyUnclarified();
							getLogger().debug("passing a PhonString on");
							addToWorkingMemory(newDataID(), ups.ps);
						}
					}
				}
				catch (SubarchitectureComponentException ex) {
					logException(ex);
				}
				
			}
			
		});
	}

	private void handleUnclarifiedPossibleInterpretedIntentions(WorkingMemoryChange _wmc) {
		addTask(new ProcessingTaskWithDataAndComponent<WorkingMemoryAddress, ASRClarifier>(_wmc.address, this) {

			@Override
			public void execute(WorkingMemoryAddress addr) {
				try {
					UnclarifiedPossibleInterpretedIntentions upii = getMemoryEntry(addr, UnclarifiedPossibleInterpretedIntentions.class);
					
					float confidence = upii.asrConfidence;
					if (confidence > threshold) {
						getLogger().debug("we're above the threshold, passing a PossibleInterpretatedIntentions on");
						addToWorkingMemory(newDataID(), upii.pii);
					}
					else {
						getLogger().debug("we're BELOW the threshold, will attempt to clarify this");
						VerbalisationUtils.verbaliseString(getComponent(), rephraser.rephrase(upii));
						setCurrentlyUnclarified(upii.pii);
					}
				}
				catch (SubarchitectureComponentException ex) {
					logException(ex);
				}
			}

		});
	}

	private static class BasicRephraser implements Rephraser {

		@Override
		public String rephrase(UnclarifiedPossibleInterpretedIntentions pii) {
			return "confirm, did you say " + pii.phonStringWordList;
		}
		
	}

}
