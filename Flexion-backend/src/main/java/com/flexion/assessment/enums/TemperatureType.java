package com.flexion.assessment.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum TemperatureType {
    FAHRENHEIT("fahrenheit"), CELSIUS("celsius"), KELVIN("kelvin"), RANKING("rankine");

    private final String val;

    TemperatureType(String val) {
        this.val = val;
    }

    public static Set<String> valueSet() {
        return Arrays.stream(TemperatureType.values()).map(TemperatureType::getVal).collect(Collectors.toSet());
    }
}
