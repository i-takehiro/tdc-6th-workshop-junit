package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 発生した例外の詳細を検証するルールのサンプル.
 */
public class ExpectedExceptionSample {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void 例外がスローされない() throws Exception {
        // No exception is thrown.
    }

    @Test
    public void 指定した型の例外がスローされる() throws Exception {
        thrown.expect(instanceOf(NullPointerException.class));
        throw new NullPointerException();
    }

    @Test
    public void 指定した型の例外がスローされる_instanceofを省略できる() throws Exception {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void 指定した例外がスローされる() throws Exception {
        final NullPointerException e = new NullPointerException();
        thrown.expect(is(e));
        throw e;
    }

    @Test
    public void 指定した詳細メッセージを含む例外がスローされる() throws Exception {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(containsString("例外"));
        throw new NullPointerException("これは例外です");
    }

    @Test
    public void 指定した詳細メッセージを含む例外がスローされる_containsStringを省略できる() throws Exception {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("例外");
        throw new NullPointerException("これは例外です");
    }

    @Test
    public void 指定した詳細メッセージを持つ例外がスローされる() throws Exception {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(is("これは例外です"));
        throw new NullPointerException("これは例外です");
    }

    @Test
    public void 指定した原因を持つ例外がスローされる() throws Exception {
        final NullPointerException e = new NullPointerException();
        thrown.expectCause(is(e));
        throw new Exception(e);
    }
}
