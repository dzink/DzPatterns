DzEuclideanArp : DzEuclideanSeq {
	var <> range = 12;

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
		arg range, pulses, steps, rotation, repeats;
		^ super.new([], pulses, steps, rotation, repeats).range_(range);
	}

	embedInStream {
		arg inval;
		repeats.do {
			var event;
			event = this.next() * range;
			event.embedInStream(inval);
		};
		^ inval;
	}

}
