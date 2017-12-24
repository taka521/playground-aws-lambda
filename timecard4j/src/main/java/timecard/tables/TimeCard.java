package timecard.tables;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.Data;
import timecard.converter.LocalDateConverter;
import timecard.converter.LocalTimeConverter;
import timecard.tables.attributes.BreakTime;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * タイムカードクラスです。
 */
@Data
@DynamoDBTable(tableName = "timecards")
public class TimeCard implements Serializable {

    private static final long serialVersionUID = 1L;

    /** パーティションキー: id */
    @DynamoDBHashKey(attributeName = "id")
    private long id;

    /** 日付 */
    @DynamoDBRangeKey(attributeName = "date")
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate date;

    /** 業務開始時間 */
    @DynamoDBAttribute(attributeName = "start_time")
    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    private LocalTime startTime;

    /** 業務終了時間 */
    @DynamoDBAttribute(attributeName = "end_time")
    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    private LocalTime endTime;

    /** 休憩時間 */
    @DynamoDBAttribute(attributeName = "break_times")
    private List<BreakTime> breakTimes;

    /** メモ */
    @DynamoDBAttribute(attributeName = "memo")
    private String memo;
}
