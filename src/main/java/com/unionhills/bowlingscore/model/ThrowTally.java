package com.unionhills.bowlingscore.model;

import java.util.Arrays;

/**
 * This class encapsulates and represents the throws that a player
 * makes during the course of a game.
 * A scorecard consists of 10 frames. Each frame contains 2 throws,
 * except for the 10th frame which contains an extra bonus throw
 * for a total of 3 throws.
 * <p>
 * The implementation is backed by a simple array with methods to get
 * the values for each frame.
 *
 */
public class ThrowTally {
    public static final int MAX_FRAMES = 10;
    public static final int MAX_PINS = 10;

    // 10 frames * 2 throws + the potential for 1 extra in frame 10
    public static final int MAX_THROWS = MAX_FRAMES * 2 + 1;

    private int[] throwsArray = new int[MAX_THROWS];

    /**
     * Constructor takes an array of throw values. The length of the array
     * must not exceed MAX_THROWS.
     *
     * @param throwValues - incoming array of bowling throws
     */
    public ThrowTally(int[] throwValues) {
        System.arraycopy(throwValues, 0, throwsArray, 0, throwValues.length);
    }

    /**
     * Retrieve the array of pins knocked down for a given frame
     *
     * @param index - the frame index for which to get the throws
     */
    public int[] getFrame(int index) {
        final int start = index * 2;
        int end = start + 2;

        // Special case for the final frame where a player can potentially have
        // 3 throws.
        if (index + 1 == ThrowTally.MAX_FRAMES) {
            end = start + 3;
        }

        int[] frameSet = Arrays.copyOfRange(throwsArray, start, end);

        return frameSet;
    }

    /**
     * Get the pins knocked down for the given throw index
     *
     * @param throwIndex
     * @return the pins knocked down for the given throw index
     */
    public int getThrow(int throwIndex) {
        return throwsArray[throwIndex];
    }

    /**
     * Set the pins knocked down for the given throw index
     *
     * @param throwIndex
     */
    public void setThrow(int throwIndex, int pinCount) {
        throwsArray[throwIndex] = pinCount;
    }
}
