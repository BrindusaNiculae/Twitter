package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class HelloBrindu {

    public static void main(String[] args) throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, FileNotFoundException, InvalidInputException {
        String s = null;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
        Twitter twitter = new Twitter(buff);
        while (true) {
            s = buff.readLine();
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
