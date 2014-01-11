package learning;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
}
