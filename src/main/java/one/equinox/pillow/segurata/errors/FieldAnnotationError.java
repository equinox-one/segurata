package one.equinox.pillow.segurata.errors;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldAnnotationError implements ValidationError{
    Field field;
    Annotation annotation;

    public FieldAnnotationError(Field field, Annotation annotation) {
        this.field = field;
        this.annotation = annotation;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }
}
