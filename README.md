##Examples

Play an arpeggio:

```supercollider
Pbind(\dur, 0.25, \freq, (60 + DzEuclideanSeq([0, 4, 7], 5, 12, 0, inf)).midicps,).play
```

Play a syncopated beat:

```supercollider
Pbind(\dur, 0.25, \isRest, DzEuclideanRhythm(5, 12, 0, inf)).play
```

Play a range-based arpeggio

```supercollider
Pbind(\dur, 0.25, \freq, (60 + DzEuclideanArp(12, 5, 12, 0, inf)).midicps,).play
```
