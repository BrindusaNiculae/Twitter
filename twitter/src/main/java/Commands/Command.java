/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import Exceptions.InvalidInputException;
import Exceptions.InvalidMailFormatException;
import Exceptions.InvalidPhoneNrFormatException;
import Exceptions.InvalidUserException;
import Exceptions.ProfileNotSetException;
import UserPackage.User;
import UserPackage.Users;

/**
 *
 * @author Brindusa
 */
public abstract class Command {

    protected Users users;
    protected String[] words;
    protected String name;
    protected int userId;
    protected final BufferedReader buff;

    Command(Users users, String[] words, BufferedReader buff) {
        this.users = users;
        this.words = Arrays.copyOf(words, words.length);
        this.userId = -1;
        this.buff = buff;
    }

    Command(Users users) {
        this.buff = null;
        this.users = users;
        this.words = new String[10];
        this.userId = -1;
    }

    protected int getUserId(String name) {

        for (int i = 0; i < users.getUsers().size(); i++) {
            User user = users.getUser(i);
            String nameTest = " " + user.getName() + " ";
            if (nameTest.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    protected void setUser() {
        name = " " + words[0] + " ";
        userId = getUserId(name);
    }

    public abstract void tweet() throws InvalidUserException,
            ProfileNotSetException, InvalidInputException,
            InvalidMailFormatException, InvalidPhoneNrFormatException, IOException;

    public void setWords(String[] words) {
        this.words = Arrays.copyOf(words, words.length);
    }

}
