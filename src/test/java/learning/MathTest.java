package learning;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MathTest {

    @Test
    public void absに1を渡すと1が返される() throws Exception {
        // SetUp
        int expected = 1;
        // Exercise
        int actual = Math.abs(1);
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void absにマイナス1を渡すと1が返される() throws Exception {
        // SetUp
        int expected = 1;
        // Exercise
        int actual = Math.abs(-1);
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void absに0を渡すと0が返される() throws Exception {
        assertThat(Math.abs(0), is(0));
    }

    @Test
    public void absにintの最大値を渡すとintの最大値が返される() throws Exception {
        // SetUp
        int expected = Integer.MAX_VALUE;
        // Exercise
        int actual = Math.abs(Integer.MAX_VALUE);
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void absにintの最小値を渡すとintの最小値が返される() throws Exception {
        // SetUp
        int expected = Integer.MIN_VALUE;
        // Exercise
        int actual = Math.abs(Integer.MIN_VALUE);
        // Verify
        assertThat(actual, is(expected));
    }
    
    @Test
    public void testName() throws Exception {
        List<String> arrayList = new ArrayList<String>();
    }
}
