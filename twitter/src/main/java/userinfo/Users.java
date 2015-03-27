/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brindusa
 */
public class Users {

    private final List<User> users;

    public Users() {
        users = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User temp) {
        users.add(temp);
    }

    public User getUser(int userId) {
        return users.get(userId);
    }
}
