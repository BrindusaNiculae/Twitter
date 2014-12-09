package ro.exenne.twitter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloBrinduTest {

    @Test
    public void testMain() {
        HelloBrindu.main(null);
        assertThat(1, is(equalTo(1)));
    }
}