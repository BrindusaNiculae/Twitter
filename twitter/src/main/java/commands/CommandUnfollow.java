/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import exceptions.InvalidUserException;

/**
 *
 * @author Brindusa
 */
public class CommandUnfollow implements Command {

    private final Operator operator;

    public CommandUnfollow(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws InvalidUserException {
        operator.setUser();
        int i = operator.getUserId2();
        if (i == -1) {
            throw new InvalidUserException(operator.getWordFrom(1));
        }
        operator.getUsers().getUser(operator.getUserId()).removeFollower(operator.getUsers().getUser(i));
    }
}
