package pers.nefedov.demoshop.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class NotebookSizeValidator implements ConstraintValidator<NotebookSize, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.asList(new Integer[]{13, 14, 15, 17}).contains(value);
    }
}
