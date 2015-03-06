package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

final class HelloBrindu {

    static String s;
    static BufferedReader buff;
    static Twitter twitter;
    static boolean flag;

    private HelloBrindu() {

    }

    private static void initializeVariables() {
        buff = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
        twitter = new Twitter(buff);
        flag = true;
    }

    private static boolean doWhile() throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, InvalidInputException {
        if (null == s) {
            throw new InvalidInputException();
        } else if (s.contains("EXIT")) {
            return false;
        } else {
            twitter.tweet(s);
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, InvalidInputException {
        initializeVariables();
        while (flag) {
            s = buff.readLine();
            flag = doWhile();
        }
    }
}
