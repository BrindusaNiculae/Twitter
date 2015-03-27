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
public class CommandFollow implements Command {

    Operator operator = new Operator();

    public CommandFollow(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws InvalidUserException {
        operator.setUser();
        int i = operator.getUserId2();
        if (i == -1) {
            throw new InvalidUserException(operator.getWords()[1]);
        }
        operator.getUsers().getUser(operator.getUserId()).
                addFollower(operator.getUsers().getUser(i));
    }

}
