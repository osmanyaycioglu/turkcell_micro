package com.training.turkcell.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustomValidation implements ConstraintValidator<StringCheck, String> {

    private StringCheck constraintAnnotation;

    @Override
    public void initialize(final StringCheck constraintAnnotationParam) {
        this.constraintAnnotation = constraintAnnotationParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {

        return !valueParam.contains(this.constraintAnnotation.str());
    }

}
