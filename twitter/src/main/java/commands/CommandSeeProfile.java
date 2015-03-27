/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import exceptions.ProfileNotSetException;
import userinfo.Users;

/**
 *
 * @author Brindusa
 */
public class CommandSeeProfile implements Command {

    Operator operator = new Operator();

    public CommandSeeProfile(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws ProfileNotSetException {
        operator.setUser();
        operator.getUsers().getUser(operator.getUserId()).showProfile();
    }

}
