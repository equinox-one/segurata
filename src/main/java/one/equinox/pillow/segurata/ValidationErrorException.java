package one.equinox.pillow.segurata;

import java.util.List;

import one.equinox.pillow.segurata.errors.ValidationError;

public class ValidationErrorException extends Exception {
    List<ValidationError> validationErrors;
    public ValidationErrorException(List<ValidationError> validationErrors) {
        this.validationErrors=validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}
