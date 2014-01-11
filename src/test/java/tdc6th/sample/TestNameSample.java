package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * テストメソッド内で実行中のテスト名を利用可能にするルールのサンプル
 */
public class TestNameSample {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void テストケース１() throws Exception {
        assertThat(testName.getMethodName(), is("テストケース１"));
    }

    @Test
    public void テストケース２() throws Exception {
        assertThat(testName.getMethodName(), is("テストケース２"));
    }
}
