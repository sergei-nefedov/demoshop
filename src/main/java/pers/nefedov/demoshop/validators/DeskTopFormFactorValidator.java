package pers.nefedov.demoshop.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pers.nefedov.demoshop.entities.FormFactor;

import java.util.Arrays;
public class DeskTopFormFactorValidator implements ConstraintValidator<DeskTopFormFactor, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(FormFactor.values()).anyMatch((f) -> f.name().equals(value));
    }
}
