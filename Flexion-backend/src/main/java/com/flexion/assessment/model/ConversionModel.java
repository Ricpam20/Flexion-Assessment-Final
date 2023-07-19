package com.flexion.assessment.model;

import lombok.Data;

@Data
public class ConversionModel {
    private String sourceUnit;
    private String targetUnit;
    private Double sourceValue;
    private Double targetValue;
}
