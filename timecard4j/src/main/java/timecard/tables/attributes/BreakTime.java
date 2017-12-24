package timecard.tables.attributes;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.Data;
import timecard.converter.LocalTimeConverter;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * 休憩時間クラスです。
 * 開始時刻と終了時刻を保持します。
 */
@Data
@DynamoDBDocument
public class BreakTime implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = 1L;

    /** 休憩開始時刻 */
    @DynamoDBAttribute(attributeName = "start")
    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    private LocalTime start;

    /** 休憩終了時刻 */
    @DynamoDBAttribute(attributeName = "end")
    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    private LocalTime end;

    /**
     * 休憩時間を、分単位で返却します。
     *
     * @return 休憩時間（分）
     */
    public long duration(){
        return ChronoUnit.MINUTES.between(start, end);
    }

}
