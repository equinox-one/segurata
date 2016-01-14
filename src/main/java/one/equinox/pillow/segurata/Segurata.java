package one.equinox.pillow.segurata;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Segurata implements IValidator<Object>{
    Map<Class<?>, IValidator<?>> validators = new HashMap<>();

    public <T> void addValidator(Class<T> clazz, IValidator<T> validator){
        validators.put(clazz, validator);
    }


    @Override
    public List<IValidationError> validate(Object model) {
        IValidator validator = validators.get(model.getClass());
        if(validator!=null){
            return validator.validate(model);
        } else {
            return new DefaultValidator(model.getClass()).validate(model);
        }
    }
}
