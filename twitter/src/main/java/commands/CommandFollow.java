/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import exceptions.InvalidUserException;
import userinfo.Users;

/**
 *
 * @author Brindusa
 */
public class CommandFollow extends Command {

    public CommandFollow(Users users) {
        super(users);
    }

    @Override
    public void tweet() throws InvalidUserException {
        this.setUser();
        String name2 = words[1];
        int i = getUserId(" " + name2 + " ");
        if (i == -1) {
            throw new InvalidUserException(name2);
        }
        users.getUser(userId).addFollower(users.getUser(i));
    }

}
