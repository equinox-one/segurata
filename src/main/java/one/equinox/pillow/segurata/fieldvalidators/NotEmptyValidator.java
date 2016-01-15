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

package one.equinox.pillow.segurata.fieldvalidators;

import one.equinox.pillow.segurata.errors.FieldAnnotationError;
import one.equinox.pillow.segurata.fieldvalidators.common.AbstractFieldValidator;
import one.equinox.pillow.segurata.annotations.NotEmpty;
import one.equinox.pillow.baseutil.exceptions.UnimplementedException;

import java.lang.reflect.Field;
import java.util.Collection;

public class NotEmptyValidator<T> extends AbstractFieldValidator<T, NotEmpty> {
	@Override
	public Class<NotEmpty> getAnnotationClass() {
		return NotEmpty.class;
	}
	
	@Override
	public FieldAnnotationError validate(T model, Field field, NotEmpty notEmpty) throws IllegalAccessException, IllegalArgumentException {

		boolean notEmptyError = false;
		Object value = field.get(model);
		if(value == null) {
			notEmptyError = true;
		} else if (value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) value;
			notEmptyError = collection.isEmpty();
		} else if (value instanceof String) {
			String string = (String) value;
			notEmptyError = string.length() == 0;
		} else {
			throw new UnimplementedException();
		}
		if (notEmptyError) {
			return new FieldAnnotationError(field, notEmpty);
		}

		return null;

	}

}
