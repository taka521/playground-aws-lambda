package timecard.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * {@link LocalTime} のコンバータークラスです。
 * <p>
 * {@link LocalTime} と {@link String} との相互変換を実現します。<br/>
 * なお、形式は {@code hh:mm:ss} である必要があります。
 */
public class LocalTimeConverter implements DynamoDBTypeConverter<String, LocalTime> {

    @Override
    public String convert(final LocalTime time) {
        return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    @Override
    public LocalTime unconvert(final String time) {
        return LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
