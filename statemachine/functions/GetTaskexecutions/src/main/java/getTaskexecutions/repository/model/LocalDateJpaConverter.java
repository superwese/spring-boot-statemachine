package getTaskexecutions.repository.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by wese on 04.04.17.
 */
@Converter
public class LocalDateJpaConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if ( attribute == null ) {
            return null;
        }
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        if ( sqlDate == null ) {
            return null;
        }

        return sqlDate.toLocalDate();
    }
}
