/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import exceptions.InvalidUserException;
import userinfo.User;

/**
 *
 * @author Brindusa
 */
public class CommandPost implements Command {

    private final Operator operator;

    public CommandPost(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws InvalidUserException {
        operator.setUser();
        if (operator.getUserId() == -1) {
            this.addUserAndPost();
        } else {
            operator.getUsers().getUser(operator.getUserId()).addPost(operator.getWordFrom(1), System.nanoTime());
        }
    }

    private void addUserAndPost() throws InvalidUserException {
        if (operator.getWordsLength() == 1) {
            throw new InvalidUserException(operator.getWordFrom(0));
        }
        User temp = new User(operator.getWordFrom(0));
        temp.addPost(operator.getWordFrom(1), System.nanoTime());
        operator.getUsers().addUser(temp);
    }

}
