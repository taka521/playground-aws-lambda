package timecard.converter;

import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link LocalTimeConverter} のテストクラス。
 */
public class LocalTimeConverterTest {

    /** テスト対象クラス */
    private final LocalTimeConverter converter = new LocalTimeConverter();

    @Test
    public void convert_正常系() throws Exception {
        LocalTime input = LocalTime.of(12, 0, 0);
        String result = converter.convert(input);

        assertThat(result, is("12:00:00"));
    }

    @Test
    public void convert_異常系__引数にnullを渡した場合() throws Exception {
        try {
            converter.convert(null);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void unconvert_正常系() throws Exception {
        String input = "12:01:10";
        LocalTime result = converter.unconvert(input);

        assertThat(result, is(LocalTime.of(12, 1, 10)));
    }

    @Test
    public void unconvert_異常系__引数にnullを渡した時() throws Exception {
        try {
            converter.unconvert(null);
            fail();
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void unconvert_異常系__引数に変換不可文字を渡した時() throws Exception {
        try {
            converter.unconvert("12:1:10");
            fail();
        } catch (DateTimeException e) {
        }
    }

}