package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloBrinduTest {

    @Test
    public void testMain1() throws IOException {
        System.out.println("1");
        String filenameRead = "Scenario1.in";
        String filenameWrite = "Scenario.out";
        FileWriter f = new FileWriter(new File(filenameWrite));
        Twitter twitter = new Twitter();
        TInput tInput = new TInput();
        tInput.initializeParameters(twitter, filenameRead, f);
        twitter.readCommand(tInput);
        f.flush();
        f.close();
        assertEquals("Valid output", compareFiles("Scenario1.ok", "Scenario.out"));
    }

    @Test
    public void testMain2() throws IOException {

        System.out.println("2");
        String filenameRead = "Scenario2.in";
        String filenameWrite = "Scenario.out";
        FileWriter f = new FileWriter(new File(filenameWrite));
        Twitter twitter = new Twitter();
        TInput tInput = new TInput();
        tInput.initializeParameters(twitter, filenameRead, f);
        twitter.readCommand(tInput);
        f.flush();
        f.close();
        assertEquals("Valid output", compareFiles("Scenario2.ok", "Scenario.out"));
    }

    @Test
    public void testMain3() throws IOException {
        System.out.println("3");
        String filenameRead = "Scenario3.in";
        String filenameWrite = "Scenario.out";
        FileWriter f = new FileWriter(new File(filenameWrite));
        Twitter twitter = new Twitter();
        TInput tInput = new TInput();
        tInput.initializeParameters(twitter, filenameRead, f);
        twitter.readCommand(tInput);
        f.flush();
        f.close();
        assertEquals("Valid output", compareFiles("Scenario3.ok", "Scenario.out"));
    }

    @Test
    public void testMain4() throws IOException {
        System.out.println("4");
        String filenameRead = "Scenario4.in";
        String filenameWrite = "Scenario.out";
        FileWriter f = new FileWriter(new File(filenameWrite));
        Twitter twitter = new Twitter();
        TInput tInput = new TInput();
        tInput.initializeParameters(twitter, filenameRead, f);
        twitter.readCommand(tInput);
        f.flush();
        f.close();
        assertEquals("Valid output", compareFiles("Scenario4.ok", "Scenario.out"));
    }

    @Test
    public void testMain5() throws IOException {
        System.out.println("5");
        String filenameRead = "Scenario5.in";
        String filenameWrite = "Scenario.out";
        FileWriter f;
        f = new FileWriter(new File(filenameWrite));
        Twitter twitter = new Twitter();
        TInput tInput = new TInput();
        tInput.initializeParameters(twitter, filenameRead, f);
        twitter.readCommand(tInput);
        f.flush();
        f.close();
        assertEquals("Valid output", compareFiles("Scenario5.ok", "Scenario.out"));
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

class TInput implements InputHandler {

    Twitter twitter;
    String filenameRead;
    FileWriter f;

    public TInput() {
        this.twitter = new Twitter();
        this.filenameRead = null;
        this.f = null;
    }

    public void initializeParameters(Twitter twitter, String filenameRead, FileWriter f) {
        this.twitter = twitter;
        this.filenameRead = filenameRead;
        this.f = f;
    }

    @Override
    public void read() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filenameRead));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloBrinduTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            String s = scanner.nextLine();
            if (s.contains("EXIT")) {
                break;
            } else {
                try {
                    try {
                        TOutput tOutput = new TOutput();
                        tOutput.initializeParameter(f);
                        twitter.tweet(s, tOutput);
                    } catch (IOException ex) {
                        Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InvalidUserException ex) {
                    Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ProfileNotSetException ex) {
                    Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidEditProfileInputException ex) {
                    Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidPhoneNrFormatException ex) {
                    Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidMailFormatException ex) {
                    Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        scanner.close();
    }
}

class TOutput implements OutputHandler {

    FileWriter f;

    public TOutput() {
        this.f = null;
    }

    public void initializeParameter(FileWriter f) {
        this.f = f;
    }

    @Override
    public void publish(String s) {
        try {
            f.write(s);
        } catch (IOException ex) {
            Logger.getLogger(TOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
