package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * テストクラスの構造化のサンプル.
 */
@RunWith(Enclosed.class)
public class EnclosedSample {

    // テストクラスに @RunWith(Enclosed.class) を付与する

    // テスト対象のメソッド別にテストメソッドをグループ化
    // テスト対象の初期化処理が共通のもの毎にテストメソッドをグループ化
    // -> グループごとに内部クラスを生成する
    // -> 内部クラスを入れ子にすることも可能

    public static class 初期状態 {
        private List<String> sut;

        @Before
        public void setUp() {
            sut = new ArrayList<String>();
        }

        @Test
        public void sizeは0を返す() throws Exception {
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 文字列abcを含まない() throws Exception {
            assertThat(sut.contains("abc"), is(false));
        }
    }

    public static class 文字列abcが追加された状態 {
        private List<String> sut;

        @Before
        public void setUp() {
            sut = new ArrayList<String>();
            sut.add("abc");
        }

        @Test
        public void sizeは1を返す() throws Exception {
            assertThat(sut.size(), is(1));
        }

        @Test
        public void 文字列abcを含む() throws Exception {
            assertThat(sut, hasItem("abc"));
        }

        @Test
        public void 文字列123は含まない() throws Exception {
            assertThat(sut, not(hasItem("123")));
        }
    }
}
