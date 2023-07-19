package com.flexion.assessment.enums;

import lombok.Getter;

@Getter
public enum ConversionResponse {
    INVALID("invalid"),
    CORRECT("correct"),
    INCORRECT("incorrect");

    private final String val;

    ConversionResponse(String val) {
        this.val = val;
    }
}
