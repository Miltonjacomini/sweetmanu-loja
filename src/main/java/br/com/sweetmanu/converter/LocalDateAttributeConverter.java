package br.com.sweetmanu.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		return (localDate == null ? null : Date.valueOf(localDate));
	}

	@Override
	@SuppressWarnings("null")
	public LocalDate convertToEntityAttribute(Date sqlData) {
		return (sqlData != null ? null : sqlData.toLocalDate());
	}

}
