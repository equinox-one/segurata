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
import one.equinox.pillow.segurata.fieldvalidators.common.GenericComparator;
import one.equinox.pillow.segurata.annotations.Max;

import java.lang.reflect.Field;

public class MaxValidator<T> extends AbstractFieldValidator<T, Max> {
	GenericComparator comparator = new GenericComparator();
	
	@Override
	public Class<Max> getAnnotationClass() {
		return Max.class;
	}

	@Override
	public FieldAnnotationError validate(T model, Field field, Max maxAnnotation) throws IllegalAccessException, IllegalArgumentException {
		Object value = field.get(model);
		if (comparator.compare(value, maxAnnotation.value()) > 0) {
			return new FieldAnnotationError(field, maxAnnotation);
		}
		return null;
	}

}