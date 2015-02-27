package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloBrindu {

    public static void main(String[] args) throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, FileNotFoundException, InvalidInputException {
        String s = null;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Twitter twitter = new Twitter(buff);
        while (true) {
            try {
                s = buff.readLine();
            } catch (IOException ex) {
                Logger.getLogger(HelloBrindu.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (null == s) {
                throw new InvalidInputException();
            } else if (s.contains("EXIT")) {
                break;
            } else {
                twitter.tweet(s);
            }
        }
    }
}
