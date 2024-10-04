package com.myfirst_springapp.springapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CodeConstraintValidator implements ConstraintValidator<Code, String> {

    private String codePrefix;

    @Override
    public void initialize(Code theCode) {
        codePrefix = theCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        boolean result;

        if (code != null) {
            result = code.startsWith(codePrefix);
        } else
            result = true;

        return result;
    }

}
