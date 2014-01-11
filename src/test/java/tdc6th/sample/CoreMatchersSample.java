package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * CoreMatchers が提供する Matcher のサンプル.
 */
public class CoreMatchersSample {

    @Test
    public void オブジェクトが同一であることを検証する() throws Exception {
        // CoreMatchers#is(T)を使用する
        // -> equalsメソッドによる比較
        assertThat(3 + 4, is(7));
        // 以下も同じ意味
        // assertThat(3 + 4, is(equalTo(7)));
        // assertThat(3 + 4, equalTo(7));
    }

    @Test
    public void オブジェクトが同一でないことを検証する() throws Exception {
        // CoreMatchers#not(T)を使用する
        assertThat(3 + 4, is(not(5)));
    }

    @Test
    public void nullであることを検証する() throws Exception {
        // CoreMatchers#nullValue()を使用する
        final String actual = null;
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void nullでないことを検証する() throws Exception {
        // CoreMatchers#notNullValue()を使用する
        assertThat("abc", is(notNullValue()));
    }

    @Test
    public void 指定したクラスのインスタンスであること検証する() throws Exception {
        // CoreMatchers#instanceOf(T)を使用する
        assertThat("abc", is(instanceOf(String.class)));
    }

    @Test
    public void 同一インスタンスであることを検証する() throws Exception {
        // CoreMatchers#sameInstance(T)を使用する
        final Object object = new Object();
        final Object actual = object;
        final Object expected = object;
        assertThat(actual, is(sameInstance(expected)));
    }

    @Test
    public void 指定した文字列を含むことを検証する() throws Exception {
        // CoreMatchers#containsString(String)を使用する
        assertThat("Hello, World!", containsString("World"));
    }

    @Test
    public void Iterableを実装したオブジェクトが指定した要素を持つことを検証する() throws Exception {
        // CoreMatchers#hasItem(T)を使用する
        assertThat(Arrays.asList("aaa", "bbb", "ccc"), hasItem("aaa"));
    }

    @Test
    public void 全てのMatcherを満たすことを検証する() throws Exception {
        // CoreMatchers#allOf(Matcher<? super T>... matchers)を使用する
        assertThat(Arrays.asList("aaa", "bbb", "ccc"),
                allOf(hasItem("aaa"), hasItem("bbb")));
    }

    @Test
    public void いずれかのMatherを満たすことを検証する() throws Exception {
        // CoreMatchers#anyOf(Matcher<? super T>... matchers)を使用する
        assertThat(Arrays.asList("aaa", "bbb", "ccc"),
                anyOf(hasItem("aaa"), hasItem("ddd")));
    }
}
