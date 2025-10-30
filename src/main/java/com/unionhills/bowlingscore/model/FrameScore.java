package com.unionhills.bowlingscore.model;

import lombok.Getter;
import lombok.Setter;

public class FrameScore {
    public static final int DEFAULT_THROW_COUNT = 2;

    @Getter
    @Setter
    private int[] throwValues;

    @Getter
    @Setter
    private int scoreValue;

    public FrameScore() {
        throwValues = new int[DEFAULT_THROW_COUNT];
    }
}
