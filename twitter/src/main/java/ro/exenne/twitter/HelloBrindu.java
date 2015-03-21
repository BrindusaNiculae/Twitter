package ro.exenne.twitter;

import exceptionsPackage.InvalidMailFormatException;
import exceptionsPackage.ProfileNotSetException;
import exceptionsPackage.InvalidUserException;
import exceptionsPackage.InvalidInputException;
import exceptionsPackage.InvalidPhoneNrFormatException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

final class HelloBrindu {

    private static String s;
    private static BufferedReader buff;
    private static Twitter twitter;
    private static boolean flag;

    private HelloBrindu() {

    }

    private static void initializeVariables() {
        buff = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
        twitter = new Twitter(buff);
        flag = true;
    }

    private static boolean doWhile() throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        if (s.contains("EXIT")) {
            return false;
        } else {
            twitter.tweet(s);
        }
        return true;
    }

    private static void iterate() throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        while (flag) {
            s = buff.readLine();
            if (null == s) {
                throw new InvalidInputException();
            } else {
                flag = doWhile();
            }
        }
    }

    public static void main(String[] args) throws IOException, ProfileNotSetException, InvalidUserException, InvalidPhoneNrFormatException, InvalidMailFormatException, InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        initializeVariables();
        iterate();
    }
}
