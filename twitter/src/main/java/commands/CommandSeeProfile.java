/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import exceptions.ProfileNotSetException;
import user_info.Users;

/**
 *
 * @author Brindusa
 */
public class CommandSeeProfile extends Command {

    public CommandSeeProfile(Users users) {
        super(users);
    }

    @Override
    public void tweet() throws ProfileNotSetException {
        this.setUser();
        users.getUser(userId).showProfile();
    }

}
