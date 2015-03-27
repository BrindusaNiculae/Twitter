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
public class CommandShowPersonalPosts implements Command {

    Operator operator = new Operator();

    public CommandShowPersonalPosts(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws InvalidUserException {
        operator.setUser();
        if (operator.getUserId() == -1) {
            throw new InvalidUserException(operator.getName());
        }
        operator.getUsers().getUser(operator.getUserId()).showPersonalPosts();
    }

}
