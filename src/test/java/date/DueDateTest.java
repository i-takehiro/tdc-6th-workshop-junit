package date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.number.OrderingComparison.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DueDateTest {

    public static class _2014年1月11日の場合 {
        private DueDate sut;

        @Before
        public void setUp() {
            sut = new DueDate(2014, 1, 11);
        }

        @Test
        public void _2014年1月11日の年は2014() throws Exception {
            // SetUp
            int expected = 2014;
            // Exercise
            int actual = sut.getYear();
            // Verify
            assertThat(actual, is(expected));
        }

        @Test
        public void _2014年1月11日の月は1() throws Exception {
            // SetUp
            int expected = 1;
            // Exercises
            int actual = sut.getMonth();
            // Verify
            assertThat(actual, is(expected));
        }

        @Test
        public void _2014年1月11日の日は11() throws Exception {
            // SetUp
            int expected = 11;
            // Exercise
            int actual = sut.getDay();
            // Verify
            assertThat(actual, is(expected));
        }

        @Test
        public void _2014年1月11日は自分自身と等しい() throws Exception {
            // SetUp
            // Exercise
            // Verify
            assertThat(sut, is(sut));
        }

        @Test
        public void _2014年1月11日は2014年1月11日と等しい() throws Exception {
            // SetUp
            final DueDate dueDateOf20140111 = new DueDate(2014, 1, 11);
            // Exercise
            // Verify
            assertThat(sut, is(dueDateOf20140111));
            assertThat(sut, comparesEqualTo(dueDateOf20140111));
        }

        @Test
        public void _2014年1月11日は2014年1月12日と等しくない() throws Exception {
            // SetUp
            final DueDate dueDateOf20140112 = new DueDate(2014, 1, 12);
            // Exercise
            // Verify
            assertThat(sut, is(not(dueDateOf20140112)));
            assertThat(sut, not(comparesEqualTo(dueDateOf20140112)));
        }

        @Test
        public void _2014年1月11日は2014年1月12日より小さい() throws Exception {
            // SetUp
            final DueDate dueDateOf20140112 = new DueDate(2014, 1, 12);
            // Exercise
            // Verify
            assertThat(sut, is(lessThan(dueDateOf20140112)));
        }

        @Test
        public void _2014年1月11日は2014年1月10日より大きい() throws Exception {
            // SetUp
            final DueDate dueDateOf20140110 = new DueDate(2014, 1, 10);
            // Exercise
            // Verify
            assertThat(sut, is(greaterThan(dueDateOf20140110)));
        }
    }

    public static class _2015年2月22日の場合 {
        private DueDate sut;

        @Before
        public void setUp() throws Exception {
            sut = new DueDate(2015, 2, 22);
        }

        @Test
        public void _2015年2月22日の年は2015() throws Exception {
            // SetUp
            int expected = 2015;
            // Exercise
            int actual = sut.getYear();
            // Verify
            assertThat(actual, is(expected));
        }

        @Test
        public void _2015年2月22日の月は2() throws Exception {
            //SetUp
            int expected = 2;
            //Exercise
            int actual = sut.getMonth();
            //Verify
            assertThat(actual, is(expected));
        }

        @Test
        public void _2015年2月22日の日は22() throws Exception {
            //SetUp
            int expected = 22;
            //Exercise
            int actual = sut.getDay();
            //Verify
            assertThat(actual, is(expected));
        }
    }

    @RunWith(Theories.class)
    public static class 正しい日付のテスト {

        @DataPoints
        public static Fixture[] getFixtures() {
            final List<Fixture> fixtures = new ArrayList<Fixture>();
            fixtures.add(new Fixture(2014, 1, 1));
            fixtures.add(new Fixture(2014, 1, 31));
            fixtures.add(new Fixture(2014, 2, 1));
            fixtures.add(new Fixture(2014, 2, 28));
            fixtures.add(new Fixture(2014, 3, 1));
            fixtures.add(new Fixture(2014, 3, 31));
            fixtures.add(new Fixture(2014, 4, 1));
            fixtures.add(new Fixture(2014, 4, 30));
            fixtures.add(new Fixture(2014, 5, 1));
            fixtures.add(new Fixture(2014, 5, 31));
            fixtures.add(new Fixture(2014, 6, 1));
            fixtures.add(new Fixture(2014, 6, 30));
            fixtures.add(new Fixture(2014, 7, 1));
            fixtures.add(new Fixture(2014, 7, 31));
            fixtures.add(new Fixture(2014, 8, 1));
            fixtures.add(new Fixture(2014, 8, 31));
            fixtures.add(new Fixture(2014, 9, 1));
            fixtures.add(new Fixture(2014, 9, 30));
            fixtures.add(new Fixture(2014, 10, 1));
            fixtures.add(new Fixture(2014, 10, 31));
            fixtures.add(new Fixture(2014, 11, 1));
            fixtures.add(new Fixture(2014, 11, 30));
            fixtures.add(new Fixture(2014, 12, 1));
            fixtures.add(new Fixture(2014, 12, 31));
            fixtures.add(new Fixture(2012, 2, 29)); // うるう日
            return fixtures.toArray(new Fixture[fixtures.size()]);
        }

        @Theory
        public void 指定した日付は正しい(final Fixture p) {
            // IllegalArgumentException が発生しなければ正しい日付
            new DueDate(p.year, p.month, p.day);
        }

        static class Fixture {
            int year;
            int month;
            int day;

            Fixture(int year, int month, int day) {
                this.year = year;
                this.month = month;
                this.day = day;
            }
        }
    }

    @RunWith(Theories.class)
    public static class 正しくない日付のテスト {

        @DataPoints
        public static Fixture[] getFixtures() {
            final List<Fixture> fixtures = new ArrayList<Fixture>();
            fixtures.add(new Fixture(2014, 1, 0));
            fixtures.add(new Fixture(2014, 1, 32));
            fixtures.add(new Fixture(2014, 2, 0));
            fixtures.add(new Fixture(2014, 2, 29));
            fixtures.add(new Fixture(2014, 3, 0));
            fixtures.add(new Fixture(2014, 3, 32));
            fixtures.add(new Fixture(2014, 4, 0));
            fixtures.add(new Fixture(2014, 4, 31));
            fixtures.add(new Fixture(2014, 5, 0));
            fixtures.add(new Fixture(2014, 5, 32));
            fixtures.add(new Fixture(2014, 6, 0));
            fixtures.add(new Fixture(2014, 6, 31));
            fixtures.add(new Fixture(2014, 7, 0));
            fixtures.add(new Fixture(2014, 7, 32));
            fixtures.add(new Fixture(2014, 8, 0));
            fixtures.add(new Fixture(2014, 8, 32));
            fixtures.add(new Fixture(2014, 9, 0));
            fixtures.add(new Fixture(2014, 9, 31));
            fixtures.add(new Fixture(2014, 10, 0));
            fixtures.add(new Fixture(2014, 10, 32));
            fixtures.add(new Fixture(2014, 11, 0));
            fixtures.add(new Fixture(2014, 11, 31));
            fixtures.add(new Fixture(2014, 12, 0));
            fixtures.add(new Fixture(2014, 12, 32));
            fixtures.add(new Fixture(2012, 2, 30));
            return fixtures.toArray(new Fixture[fixtures.size()]);
        }

        @Theory
        public void 指定した日付は正しくない(final Fixture p) {
            try {
                new DueDate(p.year, p.month, p.day);
                // どのパラメータで例外が発生しなかったかが分かるように
                // 明示的にメッセージを指定してテストを失敗させる
                fail("When " + p.toString());
            } catch (IllegalArgumentException e) {
                assertThat(true, is(true));
            }
        }

        static class Fixture {
            int year;
            int month;
            int day;

            Fixture(int year, int month, int day) {
                this.year = year;
                this.month = month;
                this.day = day;
            }
            @Override
            public String toString() {
                return String.format("%d年%d月%d月", year, month, day);
            }
        }
    }
}
