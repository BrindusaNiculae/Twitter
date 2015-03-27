/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import exceptions.InvalidUserException;
import exceptions.ProfileNotSetException;

/**
 *
 * @author Brindusa
 */
public class CommandSeeAnotherProfile implements Command {

    Operator operator = new Operator();

    public CommandSeeAnotherProfile(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws InvalidUserException, ProfileNotSetException {
        operator.setUser();
        int i = operator.getUserId3();
        if (i == -1) {
            throw new InvalidUserException(operator.getWords()[1]);
        } else {
            operator.getUsers().getUser(i).showProfile();
        }
    }

}
