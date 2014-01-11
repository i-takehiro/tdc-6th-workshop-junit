package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

/**
 * テストメソッドのタイムアウトを設定するルールのサンプル.
 * 
 * @see http://junit.org/javadoc/latest/org/junit/rules/Timeout.html
 */
public class TimeoutSample {

    private static final int TIMEOUT_IN_MILLS = 1000;

    // 全てのテストメソッドにタイムアウトを設定する
    @Rule
    public Timeout globalTimeout = new Timeout(TIMEOUT_IN_MILLS);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Ignore("テストに失敗するので無効化")
    @Test
    public void テストの実行時間が指定値を超えると例外が発生する() throws Exception {
        for (;;) {

        }
    }

    @Ignore("テストに失敗するので無効化")
    @Test(timeout = 10)
    public void Testアノテーションに指定したタイムアウト値が小さい場合はそちらが優先される() throws Exception {
        for (;;) {

        }
    }

    @Ignore("テストに失敗するので無効化")
    @Test(timeout = 10000)
    public void Testアノテーションに指定したタイムアウト値が大きい場合は全体のタイムアウト値が優先される()
            throws Exception {
        for (;;) {

        }
    }

    @Test
    public void タイムアウトが発生した際にテストが成功する() throws Exception {
        thrown.handleAssertionErrors();
        thrown.expect(Exception.class);
        thrown.expectMessage(is("test timed out after 1000 milliseconds"));
        for (;;) {

        }
    }
}
