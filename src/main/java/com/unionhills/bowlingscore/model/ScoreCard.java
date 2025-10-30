package com.unionhills.bowlingscore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ScoreCard {
    private static final int DEFAULT_MAX_FRAMES = 10;

    private final ArrayList<FrameScore> frameScores = new ArrayList<FrameScore>(0);

    @Getter
    @Setter
    private int finalScore;

    /** adds another FrameScore to this ScoreCard */
    public void addFrameScore(FrameScore frameScore) {
        frameScores.add(frameScore);
    }

    /** overwrites a FrameScore in this ScoreCard at the given index */
    public void setFrameScore(int index, FrameScore frameScore) {
        frameScores.set(index, frameScore);
    }

    /** retrieves the FrameScore at the given index */
    public FrameScore getFrameScore(int index) {
        return frameScores.get(index);
    }

    /** returns a copy of the array of FrameScores */
    public FrameScore[] getFrameScores() {
        return frameScores.toArray(new FrameScore[0]);
    }
}
