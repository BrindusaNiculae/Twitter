/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Exceptions.ProfileNotSetException;
import UserPackage.Users;

/**
 *
 * @author Brindusa
 */
public class CommandSeeProfile extends Command {

    public CommandSeeProfile(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() throws ProfileNotSetException {
        this.setUser();
        users.getUser(userId).showProfile();
    }

}