package one.equinox.pillow.segurata;


import one.equinox.pillow.segurata.errors.ValidationError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generic validator.
 * By default validates a model using its annotations.
 * Specific validators can be added.
 */
public class Segurata implements Validator<Object> {
    Map<Class<?>, Validator<?>> validators = new HashMap<Class<?>, Validator<?>>();

    /**
     * Add an specific validator for a class
     * @param clazz class
     * @param validator validator to be used for the class
     * @param <T> class type
     * @return same Segurata (not a copy)
     */
    public <T> Segurata addValidator(Class<T> clazz, Validator<T> validator){
        validators.put(clazz, validator);
        return this;
    }


    @Override
    public List<ValidationError> validate(Object model) {
        Validator validator = validators.get(model.getClass());
        if(validator!=null){
            return validator.validate(model);
        } else {
            return new ModelValidator(model.getClass()).validate(model);
        }
    }
}
