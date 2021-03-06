package eu.nifti.context.ref;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapPotential
implements Potential {

	private Map<Referent, Double> positive = null;
	private double max = 0.0;

	public MapPotential() {
		positive = new HashMap<Referent, Double>();
	}

	public MapPotential(Potential p) {
		positive = new HashMap<Referent, Double>();
		Iterator<Entry<Referent, Double>> iter = p.positiveElementsIterator();
		while (iter.hasNext()) {
			Entry<Referent, Double> e = iter.next();
			positive.put(e.getKey(), e.getValue());
		}
	}

	public MapPotential(Map<Referent, Double> map) {
		positive = new HashMap<Referent, Double>(map);
	}

	@Override
	public Iterator<Entry<Referent, Double>> positiveElementsIterator() {
		return positive.entrySet().iterator();
	}

	@Override
	public Map<Referent, Double> asMap() {
		return positive;
	}

	@Override
	public void setScore(Referent r, double score) {
		if (r != null && score > 0.0) {
			double current_score = getScore(r);
			positive.put(r, score);
			if (score > max) {
				max = score;
			}
			if (score < current_score) {
				// we might have decreased the maximum
				max = computeMaxScore();
			}
		}
	}

	public double computeMaxScore() {
		Iterator<Entry<Referent, Double>> iter = positiveElementsIterator();
		double tmp_max = 0.0;
		while (iter.hasNext()) {
			Entry<Referent, Double> e = iter.next();
			if (e.getValue() > tmp_max) {
				tmp_max = e.getValue();
			}
		}
		return tmp_max;
	}

	@Override
	public double getScore(Referent r) {
		if (r != null) {
			Double score = positive.get(r);
			return (score == null ? 0.0 : (score > 0.0 ? score : 0.0));
		}
		else {
			return 0.0;
		}
	}

	@Override
	public double getMaxScore() {
		return max;
	}

}
