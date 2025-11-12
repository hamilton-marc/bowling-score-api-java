package com.unionhills.bowlingscore.shared;

public record ScoreCardDto(int length, FrameScoreDto[] frameScores, int finalScore) {
}
