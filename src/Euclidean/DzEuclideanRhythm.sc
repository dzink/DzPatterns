DzEuclideanRhythm : DzEuclideanSeq {

	*new {
		arg pulses = 5, steps = 8, rotation = 0, repeats = inf;
		^ super.newCopyArgs([1, Rest(0)], pulses, steps, rotation, repeats);
	}

	embedInStream {
		arg inval;
		repeats.do {
			var event;
			var index = this.next();
			event = series.wrapAt(index.min(1));
			event.embedInStream(inval);
		};
		^ inval;
	}

}
