package date;

import java.util.Calendar;

/**
 * 予定日を表すクラス.
 */
public class DueDate implements Comparable<DueDate> {

    private static final int LESS_THAN = -1;
    private static final int GREATER_THAN = 1;
    private static final int EQUAL = 0;

    private final int year;
    private final int month;
    private final int day;

    /**
     * 指定した年月日を持つ予定日.
     * 
     * @param year 年
     * @param month 月
     * @param day 日
     * @throws IllegalArgumentException 指定した日付が正しくない場合
     */
    public DueDate(final int year, final int month, final int day) {
        if (isValid(year, month, day) == false) {
            throw new IllegalArgumentException(String.format(
                    "[%d年%d月%d日]は正しくない日付です", year, month, day));
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    private static boolean isValid(final int year, final int month,
            final int day) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false); // 日付の解釈を厳密に行う
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // 月は0-11で指定
        calendar.set(Calendar.DAY_OF_MONTH, day);
        try {
            calendar.getTime(); // 日付が正しくないと IllegalArgumentException をスローする
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public int compareTo(final DueDate another) {
        if (getYear() < another.getYear()) {
            return LESS_THAN;
        } else if (another.getYear() < getYear()) {
            return GREATER_THAN;
        }
        if (getMonth() < another.getMonth()) {
            return LESS_THAN;
        } else if (another.getMonth() < getMonth()) {
            return GREATER_THAN;
        }
        if (getDay() < another.getDay()) {
            return LESS_THAN;
        } else if (another.getDay() < getDay()) {
            return GREATER_THAN;
        }
        return EQUAL;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof DueDate) == false) {
            return false;
        }
        final DueDate another = (DueDate) o;
        return (getYear() == another.getYear())
                && (getMonth() == another.getMonth())
                && (getDay() == another.getDay());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getYear();
        result = 31 * result + getMonth();
        result = 31 * result + getDay();
        return result;
    }

    @Override
    public String toString() {
        return String.format("有効期限[%d年%d月%d日]", year, month, day);
    }
}
