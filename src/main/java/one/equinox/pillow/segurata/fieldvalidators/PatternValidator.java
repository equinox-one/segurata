package one.equinox.pillow.segurata.fieldvalidators;

import one.equinox.pillow.segurata.errors.FieldAnnotationError;
import one.equinox.pillow.segurata.fieldvalidators.common.AbstractFieldValidator;
import one.equinox.pillow.segurata.Validator;
import one.equinox.pillow.segurata.annotations.MatchesPattern;

import java.lang.reflect.Field;
import java.util.regex.Pattern;


/**
 * Validates that matches a certain pattern
 * @param <T>
 */
public class PatternValidator<T> extends AbstractFieldValidator<T, MatchesPattern> {
    @Override
    public Class<MatchesPattern> getAnnotationClass() {
        return MatchesPattern.class;
    }

    @Override
    public FieldAnnotationError validate(T model, Field field, MatchesPattern annotation) throws Exception {
        FieldAnnotationError error = new FieldAnnotationError(field, annotation);
        Object value = field.get(model);
        if(value==null)
            return error;
        String stringValue = value.toString();
        String stringPattern =  annotation.pattern();
        Pattern pattern = Pattern.compile(stringPattern);

        if (pattern.matcher(stringValue).matches()) {
            return null;
        } else {
            return error;
        }
    }
}
