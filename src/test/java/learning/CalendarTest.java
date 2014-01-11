package learning;

import java.util.Calendar;

import org.junit.Test;

public class CalendarTest {

    @Test
    public void _2014年1月11日は正しい日付() throws Exception {
        Calendar sut = Calendar.getInstance();
        sut.setLenient(false);
        sut.set(Calendar.YEAR, 2014);
        sut.set(Calendar.MONTH, 1 - 1); // 月は0-11で指定
        sut.set(Calendar.DAY_OF_MONTH, 11);
        // 正しい日付の場合 IllegalArgumentException がスローされない
        sut.getTime();
    }

    @Test(expected = IllegalArgumentException.class)
    public void _2014年2月29日は不正な日付() throws Exception {
        Calendar sut = Calendar.getInstance();
        sut.setLenient(false);
        sut.set(Calendar.YEAR, 2014);
        sut.set(Calendar.MONTH, 2 - 1); // 月は0-11で指定
        sut.set(Calendar.DAY_OF_MONTH, 29);
        // 不正な日付の場合 IllegalArgumentException がスローされる
        sut.getTime();
    }
}
