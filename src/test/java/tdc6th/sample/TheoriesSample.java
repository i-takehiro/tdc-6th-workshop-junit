package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * パラメータ化テストのサンプル
 */
@RunWith(Enclosed.class)
public class TheoriesSample {

    // @RunWith(Theories.class) を付与する
    @RunWith(Theories.class)
    public static class DataPointアノテーションを使用したパラメータ化テスト {

        // public static なフィールドに DataPoint アノテーションを付与する
        @DataPoint
        public static String STRING_PARAM_1 = "aaa";
        @DataPoint
        public static String STRING_PARAM_2 = "bbb";
        @DataPoint
        public static Integer INT_PARAM_1 = 12345;
        @DataPoint
        public static Integer INT_PARAM_2 = 67890;

        // Test アノテーションの代わりに Theory アノテーションを付与する
        @Theory
        public void 指定した文字列を含む(String s) throws Exception {
            // DataPointアノテーションが指定されているフィールドのうち
            // テストメソッドの引数と型が一致しているものが渡される
            System.out.println("s=" + s);
            final List<String> sut = Arrays.asList("aaa", "bbb", "ccc");
            // アサーションに失敗した場合にどのパラメータで失敗したかが分からないので
            // assertThat の第一引数にパラメータ情報を埋め込む
            assertThat("文字列[" + s + "]を含むはず", sut, hasItem(s));
        }

        // テストメソッドの引数を２つ以上にすると組み合わせテストになる
        @Theory
        public void 組み合わせテスト(String s, Integer i) {
            System.out.println("s=" + s + ",i=" + i);
        }
    }

    @RunWith(Theories.class)
    public static class DataPointsアノテーションを使用したパラメータ化テスト {

        // public static なフィールドに DataPointsアノテーションを付与する
        @DataPoints
        public static String[] STRING_PARAMS = new String[] { "aaa", "bbb" };

        // public static なメソッドでもオーケー
        @DataPoints
        public static Integer[] getIntegers() {
            final List<Integer> list = new ArrayList<Integer>();
            list.add(12345);
            list.add(67890);
            return list.toArray(new Integer[list.size()]);
        }

        @Theory
        public void 指定した文字列を含む(String s) throws Exception {
            // DataPointsアノテーションが指定されているフィールドのうち
            // テストメソッドの引数の配列と型が一致しているものが渡される
            System.out.println("s=" + s);
            final List<String> sut = Arrays.asList("aaa", "bbb", "ccc");
            assertThat("文字列[" + s + "]を含むはず", sut, hasItem(s));
        }

        @Theory
        public void 組み合わせテスト(String s, Integer i) throws Exception {
            System.out.println("s=" + s + ",i=" + i);
        }
    }

    @RunWith(Theories.class)
    public static class フィクスチャオブジェクトを使用したパラメータ化テスト {

        @DataPoints
        public static Fixture[] getFixtures() {
            final List<Fixture> fixtures = new ArrayList<Fixture>();
            fixtures.add(new Fixture(1, 2, 3));
            fixtures.add(new Fixture(4, 5, 9));
            fixtures.add(new Fixture(5, -8, -3));
            return fixtures.toArray(new Fixture[fixtures.size()]);
        }

        @Theory
        public void 足し算のテスト(Fixture fixture) {
            final int expected = fixture.expected;
            final int actual = fixture.x + fixture.y;
            assertThat(fixture.toString(), actual, is(expected));
        }

        // フィクスチャオブジェクト
        // -> 入力値と期待値をクラスとして定義する
        // -> クラス名を Fixture とするのが慣例
        static class Fixture {
            int x;
            int y;
            int expected;

            Fixture(int x, int y, int expected) {
                this.x = x;
                this.y = y;
                this.expected = expected;
            }

            @Override
            public String toString() {
                return "x=" + x + ",y=" + y + ",expected=" + expected;
            }
        }
    }
}
