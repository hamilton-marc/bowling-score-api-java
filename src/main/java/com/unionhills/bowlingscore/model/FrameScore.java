package com.unionhills.bowlingscore.model;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the score for a single frame in a bowling game.
 * It contains the values of the throws made in that frame as well as
 * the total score for the frame.
 */
public class FrameScore {
    public static final int DEFAULT_THROW_COUNT = 2;

    @Getter
    @Setter
    private int[] throwValues;

    @Getter
    @Setter
    private int scoreValue;

    public FrameScore(int[] throwValues, int scoreValue) {
        this(throwValues);
        this.scoreValue = scoreValue;
    }

    public FrameScore(int[] throwValues) {
        this.throwValues = throwValues;
        this.scoreValue = 0;
    }
}
