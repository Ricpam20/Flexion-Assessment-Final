package com.flexion.assessment.util;


public class TemperatureConversionUtils {
    public static Double celsius_fahrenheit(Double celsius){
        return (celsius * 9/5) + 32;
    }
    public static Double celsius_kelvin(Double celsius){
        return celsius + 273.15;
    }
    public static Double celsius_rankine(Double celsius){
        return (celsius * 9/5) + 491.67;
    }
    public static Double fahrenheit_celsius(Double fahrenheit){
        return (fahrenheit-32) * 5/9;
    }
    public static Double fahrenheit_kelvin(Double fahrenheit){
        return (fahrenheit-32)*5/9 + 327.15;
    }
    public static Double fahrenheit_rankine(Double fahrenheit){
        return fahrenheit + 459.67;
    }
    public static Double kelvin_celsius(Double kelvin){
        return kelvin - 273.15;
    }
    public static Double kelvin_fahrenheit(Double kelvin){
        return (kelvin - 273.15)*9/5 + 32;
    }
    public static Double kelvin_rankine(Double kelvin){
        return kelvin*9/5;
    }
    public static Double rankine_celsius(Double rankine){
        return (rankine-491.67)*5/9;
    }
    public static Double rankine_fahrenheit(Double rankine){
        return rankine-459.67;
    }
    public static Double rankine_kelvin(Double rankine){
        return rankine*5/9;
    }
}
