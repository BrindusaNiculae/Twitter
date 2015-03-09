/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brindusa
 */
public class Users {

    private final List<User> users;

    Users() {
        users = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return users;
    }

    void addUser(User temp) {
        users.add(temp);
    }

    User getUser(int userId) {
        return users.get(userId);
    }

}
