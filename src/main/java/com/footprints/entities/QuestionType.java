package com.footprints.entities;

public enum QuestionType {
    SINGLE_CHOICE("Single Choice"),
    MULTIPLE_CHOICE("Multiple Choice"),
    TRUE_FALSE("True/False"),
    SHORT_ANSWER("Short Answer"),
    MATCHING("Matching"),
    FILL_IN_THE_BLANK("Fill in the Blank");

    private final String displayName;

    QuestionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean supportsMultipleAnswers() {
        return this == MULTIPLE_CHOICE || this == MATCHING;
    }

    public boolean requiresOptions() {
        return this == SINGLE_CHOICE
                || this == MULTIPLE_CHOICE
                || this == TRUE_FALSE
                || this == MATCHING;
    }
}