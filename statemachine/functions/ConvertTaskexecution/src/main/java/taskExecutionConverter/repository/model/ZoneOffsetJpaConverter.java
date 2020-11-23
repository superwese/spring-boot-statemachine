package taskExecutionConverter.repository.model;

import javax.persistence.AttributeConverter;
import java.time.ZoneOffset;

/**
 * Converts a {@link ZoneOffset} to an int via its #getTotalSeconds().
 * And vice versa.
 * Created by wese on 16.08.16.
 */
public class ZoneOffsetJpaConverter implements AttributeConverter<ZoneOffset,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ZoneOffset attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getTotalSeconds();
    }

    @Override
    public ZoneOffset convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return ZoneOffset.ofTotalSeconds(dbData);

    }
}
