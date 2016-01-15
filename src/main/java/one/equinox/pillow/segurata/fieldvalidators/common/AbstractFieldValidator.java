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

package one.equinox.pillow.segurata.fieldvalidators.common;

import one.equinox.pillow.baseutil.exceptions.BreakFastException;
import one.equinox.pillow.segurata.errors.FieldAnnotationError;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractFieldValidator<T, K extends Annotation> implements IFieldValidator<T> {
	
	public abstract Class<K> getAnnotationClass();
	
	@Override
	public FieldAnnotationError validate(T model, Field field) {
		try{
			K annotation = field.getAnnotation(getAnnotationClass());
			if(annotation!=null){
				return validate(model, field, annotation);
			}
			return null;
		} catch(Exception e){
			throw new BreakFastException(e);
		}
	}

	public abstract FieldAnnotationError validate(T model, Field field, K annotation) throws Exception;

}
