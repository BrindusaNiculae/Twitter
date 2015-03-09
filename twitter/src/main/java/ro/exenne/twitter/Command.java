/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Brindusa
 */
public abstract class Command {

    Users users;
    String[] words;
    String name;
    int userId;
    final BufferedReader buff;

    Command(Users users, String[] words, BufferedReader buff) {
        this.users = users;
        this.words = words;
        this.userId = -1;
        this.buff = buff;
    }

    Command(Users users, String[] words) {
        this.buff = null;
        this.users = users;
        this.words = words;
        this.userId = -1;
    }

    public int getUserId(String name) {

        for (int i = 0; i < users.getUsers().size(); i++) {
            User user = users.getUser(i);
            String nameTest = " " + user.getName() + " ";
            if (nameTest.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void setUser() {
        name = " " + words[0] + " ";
        userId = getUserId(name);
    }

    public abstract void tweet() throws InvalidUserException,
            ProfileNotSetException, InvalidInputException,
            InvalidMailFormatException, InvalidPhoneNrFormatException, IOException;
}
