package timecard.tables;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * タイムカードクラスです。
 */
@Data
public class TimeCard implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    private long id;

    /** 日付 */
    private LocalDate date;

    /** 業務開始時間 */
    private LocalTime startTime;

    /** 業務終了時間 */
    private LocalTime endTime;

    /** 休憩時間 */
    private List<String> breakTimes;

}
