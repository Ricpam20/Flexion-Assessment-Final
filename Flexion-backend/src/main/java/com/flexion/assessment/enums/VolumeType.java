package com.flexion.assessment.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum VolumeType {
    LITRES("litres"),
    TABLESPOONS("tablespoons"),
    CUBIC_INCHES("cubicinches"),
    CUPS("cups"),
    CUBIC_FEET("cubicfeet"),
    GALLONS("gallons");
    
    private final String val;
    
    VolumeType(String val){
        this.val = val;
    }

    public static Set<String> valueSet() {
        return Arrays.stream(VolumeType.values()).map(VolumeType::getVal).collect(Collectors.toSet());
    }
}
