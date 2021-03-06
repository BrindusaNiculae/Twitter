package ro.exenne.twitter;

import exceptions.InvalidInputException;
import exceptions.InvalidMailFormatException;
import exceptions.InvalidUserException;
import exceptions.InvalidPhoneNrFormatException;
import exceptions.ProfileNotSetException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

public class HelloBrinduTest {

    FileOutputStream f;

    private void generalTest() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        f = new FileOutputStream("Scenario.out");
        System.setOut(new PrintStream(f));
        HelloBrindu.main(null);
    }

    private void closeFiles() throws IOException {
        f.flush();
        f.close();
    }

    @Test
    public void test1() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario1.in"));
        generalTest();
        assertEquals("Valid output", compareFiles("Scenario1.ok", "Scenario.out"));
        closeFiles();
    }

    @Test
    public void test2() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario2.in"));
        generalTest();
        assertEquals("Valid output", compareFiles("Scenario2.ok", "Scenario.out"));
        closeFiles();
    }

    @Test
    public void test3() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario3.in"));
        generalTest();
        assertEquals("Valid output", compareFiles("Scenario3.ok", "Scenario.out"));
        closeFiles();
    }

    @Test
    public void test4() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario4.in"));
        generalTest();
        assertEquals("Valid output", compareFiles("Scenario4.ok", "Scenario.out"));
        closeFiles();
    }

    @Test
    public void test5() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario5.in"));
        generalTest();
        assertEquals("Valid output", compareFiles("Scenario5.ok", "Scenario.out"));
        closeFiles();
    }

    @Test(expected = InvalidUserException.class)
    public void test6() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario6.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = ProfileNotSetException.class)
    public void test7() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario7.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidMailFormatException.class)
    public void test8() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario8.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidPhoneNrFormatException.class)
    public void test9() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario9.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidPhoneNrFormatException.class)
    public void test10() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario10.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidInputException.class)
    public void test11() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario11.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidUserException.class)
    public void test12() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario12.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidUserException.class)
    public void test13() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario13.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidUserException.class)
    public void test14() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario14.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidInputException.class)
    public void test15() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario15.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidInputException.class)
    public void test16() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario16.in"));
        generalTest();
        closeFiles();
    }

    @Test
    public void test17() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario17.in"));
        generalTest();
        assertEquals("Valid output", compareFiles("Scenario17.ok", "Scenario.out"));
        closeFiles();
    }

    @Test(expected = InvalidUserException.class)
    public void test18() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario18.in"));
        generalTest();
        closeFiles();
    }

    @Test(expected = InvalidInputException.class)
    public void test19() throws FileNotFoundException, IOException, ProfileNotSetException, InvalidUserException, InvalidInputException, InvalidPhoneNrFormatException, InvalidMailFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.setIn(new FileInputStream("Scenario19.in"));
        generalTest();
        closeFiles();
    }

    @Test
    public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<HelloBrindu> constructor = HelloBrindu.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
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
