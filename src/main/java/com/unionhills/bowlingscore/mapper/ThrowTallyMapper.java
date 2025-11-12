package com.unionhills.bowlingscore.mapper;

import com.unionhills.bowlingscore.model.ThrowTally;
import com.unionhills.bowlingscore.shared.BowlingScoreException;

public class ThrowTallyMapper {
    public static ThrowTally toThrowTally(String[] throwValueArray) throws BowlingScoreException {
        if (throwValueArray.length > ThrowTally.MAX_THROWS) {
            throw new BowlingScoreException("Too many throws. Maximum allowed is " + ThrowTally.MAX_THROWS);
        }

        var throwValues = new int[ThrowTally.MAX_THROWS];

        for (int i = 0; i < throwValueArray.length; i++) {
            try {
                throwValues[i] = Integer.parseInt(throwValueArray[i]);
            } catch (NumberFormatException e) {
                throw new BowlingScoreException("Invalid throw value: " + throwValueArray[i] +
                        ". Only numeric values between 0 and " + ThrowTally.MAX_PINS +
                        " are allowed");
            }
        }

        return new ThrowTally(throwValues);
    }
}
