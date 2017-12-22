package timecard.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * {@link LocalDate}のコンバータークラスです。<br/>
 * <p>
 * {@link LocalDate} と {@link String} との相互変換を実現します。<br/>
 * 注意点として、文字列の形式は {@code yyyy-mm-dd} です。
 */
public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert(final LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public LocalDate unconvert(final String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
