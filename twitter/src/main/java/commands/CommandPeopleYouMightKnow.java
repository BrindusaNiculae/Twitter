/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import user_info.Users;

/**
 *
 * @author Brindusa
 */
public class CommandPeopleYouMightKnow extends Command {

    public CommandPeopleYouMightKnow(Users users) {
        super(users);
    }

    @Override
    public void tweet() {
        this.setUser();
        users.getUser(userId).getPeopleYouMightKnow();
    }

}
