package com.flexion.assessment.service;

import com.flexion.assessment.enums.ConversionResponse;
import com.flexion.assessment.enums.TemperatureType;
import com.flexion.assessment.enums.VolumeType;
import com.flexion.assessment.model.ConversionModel;
import com.flexion.assessment.util.TemperatureConversionUtils;
import com.flexion.assessment.util.VolumeConversionUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

@Service
public class ConversionService {
    private static final String INVALID_TYPE = "invalid-type";
    private static final String TEMPERATURE_TYPE = "temperature-type";
    private static final String VOLUME_TYPE = "volume-type";

    @SneakyThrows
    public ConversionResponse evaluateStudent(ConversionModel conversionModel) {
        if (conversionModel.getSourceUnit() == null || conversionModel.getTargetUnit() == null) {
            return ConversionResponse.INVALID;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        String sourceUnit = conversionModel.getSourceUnit().strip().toLowerCase();
        String targetUnit = conversionModel.getTargetUnit().strip().toLowerCase();
        Double sourceValue = conversionModel.getSourceValue();
        Double targetValue = Double.valueOf(df.format(conversionModel.getTargetValue()));
        if (sourceUnit.equalsIgnoreCase(targetUnit)) {
            return conversionModel.getSourceValue().equals(conversionModel.getTargetValue()) ? ConversionResponse.CORRECT : ConversionResponse.INCORRECT;
        }

        switch (validate(sourceUnit, targetUnit)) {
            case TEMPERATURE_TYPE:
                Method ttMethod = TemperatureConversionUtils.class.getMethod(sourceUnit + "_" + targetUnit, Double.class);
                Double tempExpectedValue = (Double) ttMethod.invoke(null, sourceValue);
                return Double.compare(targetValue, Double.parseDouble(df.format(tempExpectedValue))) == 0 ? ConversionResponse.CORRECT : ConversionResponse.INCORRECT;
            case VOLUME_TYPE:
                Method vtMethod = VolumeConversionUtils.class.getMethod(sourceUnit + "_" + targetUnit, Double.class);
                Double volExpectedValue = (Double) vtMethod.invoke(null, sourceValue);
                return Double.compare(targetValue, Double.parseDouble(df.format(volExpectedValue))) == 0 ? ConversionResponse.CORRECT : ConversionResponse.INCORRECT;
            default:
                return ConversionResponse.INVALID;
        }
    }

    public String validate(String source, String target) {
        if (TemperatureType.valueSet().contains(source) && TemperatureType.valueSet().contains(target)) {
            return TEMPERATURE_TYPE;
        } else if (VolumeType.valueSet().contains(source) && VolumeType.valueSet().contains(target)) {
            return VOLUME_TYPE;
        }
        return INVALID_TYPE;
    }
}
