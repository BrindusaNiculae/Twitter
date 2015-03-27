/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.BufferedReader;
import java.util.Arrays;
import userinfo.User;
import userinfo.Users;

/**
 *
 * @author Brindusa
 */
public class Operator {

    private Users users;
    private String[] words;
    private String name;
    private int userId;
    private final BufferedReader buff;

    Operator() {
        this.users = new Users();
        this.words = null;
        this.userId = -1;
        this.buff = null;
    }

    public Operator(Users users, String[] words, BufferedReader buff) {
        this.buff = buff;
        this.users = users;
        this.words = Arrays.copyOf(words, words.length);
        this.userId = -1;
    }

    public Operator(Users users, String[] words) {
        this.buff = null;
        this.users = users;
        this.words = Arrays.copyOf(words, words.length);
        this.userId = -1;
    }

    public Users getUsers() {
        return this.users;
    }

    private int getUserId(String name) {

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

    public int getUserId() {
        return this.userId;
    }

    public BufferedReader getBuff() {
        return this.buff;
    }

    public int getUserId2() {
        String name2 = words[1];
        return this.getUserId(" " + name2 + " ");
    }

    public String[] getWords() {
        return this.words;
    }

    public int getUserId3() {
        String name2 = words[1];
        String[] aux = name2.split(" profile");
        return this.getUserId(" " + aux[0] + " ");
    }

    public String getName() {
        return this.name;
    }
}
