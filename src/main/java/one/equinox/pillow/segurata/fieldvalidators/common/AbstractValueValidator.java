//package one.equinox.pillow.segurata.fieldvalidators.common;
//
//
//import one.equinox.pillow.baseutil.exceptions.BreakFastException;
//import one.equinox.pillow.segurata.errors.FieldAnnotationError;
//
//import java.lang.reflect.Field;
//
//public abstract class AbstractValueValidator<T> implements IFieldValidator {
//    @Override
//    public FieldAnnotationError validate(Object model, Field field) {
//        try {
//            Object value = field.get(model);
//            if(isValid(value)){
//                return null;
//            } else {
//                return new FieldAnnotationError(field, annotation);
//            }
//        } catch (IllegalAccessException e) {
//            throw new BreakFastException(e);
//        }
//        return null;
//    }
//
//    protected abstract boolean isValid(Object value);
//}
