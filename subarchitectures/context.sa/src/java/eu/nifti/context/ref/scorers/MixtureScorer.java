// =================================================================
// Copyright (C) 2011 DFKI GmbH Talking Robots
// Miroslav Janicek (miroslav.janicek@dfki.de)
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation; either version 2.1 of
// the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
// 02111-1307, USA.
// =================================================================

package eu.nifti.context.ref.scorers;

import eu.nifti.context.ref.TemporalInterval;

public class MixtureScorer<T> implements IntervalScorer<T> {

	private long begin;
	private long end;
	private double mixture;

	private OverlapScorer osc = null;
	private EndpointScorer esc = null;

	/**
	 * Create a mixture scorer.
	 * Mixture determines the relative weight of overlap vs endpoint
	 * scoring (i.e. 1.0 means the score will be determined purely by
	 * overlap, 0.0 means it will be based just on endpoint).
	 * @param _begin begin of the interval
	 * @param _end end of the interval
	 * @param _mixture the mixture
	 * @param _endpointWeight weight for the endpoint scorer
	 */
	public MixtureScorer(long _begin, long _end, double _mixture, double _endpointWeight) {
		begin = _begin;
		end = _end;

		mixture = _mixture;
		assert (mixture >= 0.0 && mixture <= 1.0);

		osc = new OverlapScorer(begin, end);
		esc = new EndpointScorer(begin, end, _endpointWeight);
	}

	@Override
	public double scoreInterval(TemporalInterval<T> ival) {
		double oscore = osc.scoreInterval(ival);
		double escore = esc.scoreInterval(ival);

		return (oscore * mixture) + (escore * (1 - mixture));
	}

}
