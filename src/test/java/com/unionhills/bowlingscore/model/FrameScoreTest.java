package com.unionhills.bowlingscore.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FrameScoreTest {
    @Test
    public void itShouldReflectInitializedValues() {
        var frameScore = new FrameScore(new int[] {0, 1}, 1);

        assertEquals(1, frameScore.getScoreValue());
        assertArrayEquals(new int[] {0, 1}, frameScore.getThrowValues());
    }
}
