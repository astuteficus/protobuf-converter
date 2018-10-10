package net.badata.protobuf.converter.type;


import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class LocalDateTimestampConverterImpl implements TypeConverter<LocalDate, Timestamp> {

	@Override
	public LocalDate toDomainValue(final Object instance) {
		Timestamp ts = (Timestamp) instance;
		return Instant.ofEpochSecond(ts.getSeconds() , ts.getNanos())
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
	}

	@Override
	public Timestamp toProtobufValue(final Object instance) {
		LocalDate localDate = (LocalDate) instance;
		return Timestamp.newBuilder()
				.setSeconds(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond())
				.build();
	}
}
