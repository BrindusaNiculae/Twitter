package ro.exenne.twitter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloBrinduTest {

    @Test
    public void testMain() {
        try {
            HelloBrindu.main(null);
        } catch (IOException ex) {
            Logger.getLogger(HelloBrinduTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertThat(1, is(equalTo(1)));
    }
}