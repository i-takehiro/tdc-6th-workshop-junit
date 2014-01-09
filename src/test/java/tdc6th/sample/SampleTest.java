package tdc6th.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import tdc6th.sample.Sample;

public class SampleTest {

    @Test
    public void sayはHelloWorldを返す() throws Exception {
        // SetUp
        final Sample sut = new Sample();
        final String expected = "Hello, World!";
        // Exercise
        final String actual = sut.say();
        // Verify
        assertThat(actual, is(expected));
    }
}
