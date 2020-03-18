DzEuclideanSeq : Pattern {
	var <> series;
	var < pulses;
	var < steps;
	var < rotation;
	var < repeats;

	var innerPos = 0;
	var outerPos = 0;

	/**
	 * @param Float pulses
	 *   The number of positive actions that will happen per bar.
	 * @param Float steps
	 *   The number of beats per bar.
	 * @param Float rotation
	 *   Shifts the positive actions later into the bar.
	 * @param Float repeats
	 *   The number of times to repeat this action.
	 */
	*new {
		arg series, pulses = 5, steps = 8, rotation = 0, repeats = inf;
		^ super.newCopyArgs(series, pulses, steps, rotation, repeats);
	}

	next {
		var n;
		if (((outerPos + rotation) % (steps / pulses)) < 1) {
			innerPos = 0;
		} {
			innerPos = innerPos + 1;
		};
		outerPos = outerPos + 1 % steps;
		^ innerPos;
	}

	embedInStream {
		arg inval;
		repeats.do {
			var event;
			var index = this.next();
			event = series.wrapAt(index);
			event.embedInStream(inval);
		};
		^ inval;
	}

}
