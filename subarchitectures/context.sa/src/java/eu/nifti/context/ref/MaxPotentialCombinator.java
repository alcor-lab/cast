package eu.nifti.context.ref;

import java.util.Iterator;
import java.util.Map.Entry;

public class MaxPotentialCombinator
implements PotentialCombinator {

	MapPotential pot = null;

	public MaxPotentialCombinator() {
		pot = new MapPotential();
	}
	
	public MaxPotentialCombinator(Potential p) {
		this();
		addPotential(p);
	}

	@Override
	public void addPotential(Potential p) {
		Iterator<Entry<Referent, Double>> iter = p.positiveElementsIterator();
		while (iter.hasNext()) {
			Entry<Referent, Double> rs = iter.next();
			if (pot.getScore(rs.getKey()) < rs.getValue()) {
				pot.setScore(rs.getKey(), rs.getValue());
			}
		}
	}

	@Override
	public Potential toPotential() {
		return pot;
	}

}
