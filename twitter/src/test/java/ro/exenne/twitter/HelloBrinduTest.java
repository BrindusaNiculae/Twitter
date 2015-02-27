package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloBrinduTest {

    public void generalTest() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {
        FileOutputStream f = new FileOutputStream("Scenario.out");
        System.setOut(new PrintStream(f));
        HelloBrindu.main(null);
    }
    
     @Test
     public void test1() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {

     System.setIn(new FileInputStream("Scenario1.in"));
     generalTest();
     assertEquals("Valid output", compareFiles("Scenario1.ok", "Scenario.out"));
     }

     @Test
     public void test2() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {
     System.setIn(new FileInputStream("Scenario2.in"));
     generalTest();
     assertEquals("Valid output", compareFiles("Scenario2.ok", "Scenario.out"));
     }

     @Test
     public void test3() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {
     System.setIn(new FileInputStream("Scenario3.in"));
     generalTest();
     assertEquals("Valid output", compareFiles("Scenario3.ok", "Scenario.out"));
     }

     @Test
     public void test4() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {
     System.setIn(new FileInputStream("Scenario4.in"));
     generalTest();
     assertEquals("Valid output", compareFiles("Scenario4.ok", "Scenario.out"));
     }

     @Test
     public void test5() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {
     System.setIn(new FileInputStream("Scenario5.in"));
     generalTest();
     assertEquals("Valid output", compareFiles("Scenario5.ok", "Scenario.out"));
     }
     

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test6() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, InvalidPhoneNrFormatException, InvalidMailFormatException {
        System.setIn(new FileInputStream("Scenario6.in"));
        generalTest();
    }

    private String compareFiles(String filenameOK, String filenameOUT) throws FileNotFoundException, IOException {
        BufferedReader sOK = new BufferedReader(new FileReader(filenameOK));
        BufferedReader sOUT = new BufferedReader(new FileReader(filenameOUT));
        String s1 = sOUT.readLine();
        String s2;

        while (s1 != null) {
            s2 = sOK.readLine();
            if (!s1.contains(s2)) {
                System.out.println(s2 + " " + s1);
                return "Invalid output";
            }
            s1 = sOUT.readLine();
        }
        return "Valid output";
    }
}
