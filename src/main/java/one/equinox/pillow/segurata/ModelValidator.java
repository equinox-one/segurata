/*
 * Copyright (c) Mateu Yabar Valles (http://mateuyabar.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package one.equinox.pillow.segurata;

import one.equinox.pillow.baseutil.reflection.ReflectionUtil;
import one.equinox.pillow.segurata.errors.ValidationError;
import one.equinox.pillow.segurata.fieldvalidators.*;
import one.equinox.pillow.segurata.fieldvalidators.common.GenericComparator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModelValidator<T> implements Validator<T> {
	Class<T> modelClass;
	GenericComparator comparator = new GenericComparator();
	
	GreaterThanValidator<T> greaterThanValidator  = new GreaterThanValidator<T>();
	NotNullValidator<T> notNullValidator = new NotNullValidator<T>();
	NotEmptyValidator<T> notEmptyValidator = new NotEmptyValidator<T>();
	MaxValidator<T> maxValidator = new MaxValidator<T>();
	MinValidator<T> minValidator = new MinValidator<T>();
    PatternValidator<T> patternValidator = new PatternValidator<T>();
	
	
	public ModelValidator(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	@Override
	public List<ValidationError> validate(T model) {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        for(Field field : ReflectionUtil.getStoredFields(modelClass)){
            field.setAccessible(true);

            //NotNull validation
            ValidationError notNullError = notNullValidator.validate(model, field);
            if(notNullError!=null){
                errors.add(notNullError);
                continue;
            }

            //NotEmpty validation
            ValidationError notEmptyError = notEmptyValidator.validate(model, field);
            if(notEmptyError!=null){
                errors.add(notEmptyError);
                continue;
            }

            //Max validation
            ValidationError error = maxValidator.validate(model, field);
            addIfNotNull(errors, error);

            //Min validation
            error = minValidator.validate(model, field);
            addIfNotNull(errors, error);

            //GreaterThan validation
            error = greaterThanValidator.validate(model, field);
            addIfNotNull(errors,error);

            //pattern validator
            error = patternValidator.validate(model, field);
            addIfNotNull(errors,error);
        }
        return errors;
	}

	
	public static <Q> void addIfNotNull(List<Q> list, Q item){
		if(item!=null){
			list.add(item);
		}
	}
	
	


}

