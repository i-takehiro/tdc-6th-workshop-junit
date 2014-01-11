package tdc6th.sample;

// import static を使用する
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

// テストクラス名は [テスト対象クラス]Test とするのが慣習
public class SampleTest {

    // テストメソッド
    // - 引数を持たない public メソッド
    // - 戻り値が void
    // - org.junit.Test アノテーションを付与する
    // - メソッド名に日本語を使うのが好ましい
    // - それぞれのテストメソッドで独立している(他のテストメソッドに依存しない)ようにする
    @Test
    public void sayはHelloWorldを返す() throws Exception {
        // 4フェーズテスト
        // 1. 初期化
        // テスト対象となるクラス・オブジェクトは SUT(System Under Test)と呼ばれる
        final Sample sut = new Sample();
        // 期待値(expected value)の設定
        final String expected = "Hello, World!";
        // 2. テストの実行
        // 実測値(actual value)の取得
        final String actual = sut.say();
        // 3. アサーション
        // 実測値が期待値用いて検証を行う
        // -> CoreMatchers#assertThat(T, Matcher<? super T>) を使用する
        // -> 1つのテストケースに1つのアサーションが理想(多くて数個)
        assertThat(actual, is(expected));
        // 4. (必要ならば) 終了処理
    }
}
