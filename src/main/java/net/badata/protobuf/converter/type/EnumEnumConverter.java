package net.badata.protobuf.converter.type;

import java.lang.reflect.ParameterizedType;

/**
 * Converts domain {@link Enum Enum} field value to protobuf {@link String String} field value.
 *
 * @author jsjem
 * @author Roman Gushel
 */
public class EnumEnumConverter<T extends Enum<T>, D extends Enum<D>> implements TypeConverter<T, D> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T toDomainValue(Object instance) {
		String value = ((Enum) instance).name();
		Class<T> enumType = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return Enum.valueOf(enumType, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public D toProtobufValue(Object instance) {
		String value = ((Enum) instance).name();
		Class<D> enumType = (Class<D>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return Enum.valueOf(enumType, value);
	}
}
