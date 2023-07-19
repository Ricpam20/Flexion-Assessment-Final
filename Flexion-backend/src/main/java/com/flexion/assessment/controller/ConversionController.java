package com.flexion.assessment.controller;

import com.flexion.assessment.enums.ConversionResponse;
import com.flexion.assessment.model.ConversionModel;
import com.flexion.assessment.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/evaluate")
@CrossOrigin(origins = "*")
public class ConversionController {

    private final ConversionService conversionService;

    @PostMapping
    public ResponseEntity<ConversionResponse> evaluate(@RequestBody ConversionModel conversionModel) {
        return ResponseEntity.ok(conversionService.evaluateStudent(conversionModel));
    }

}
