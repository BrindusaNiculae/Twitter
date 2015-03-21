/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Exceptions.InvalidUserException;
import UserPackage.User;
import UserPackage.Users;

/**
 *
 * @author Brindusa
 */
public class CommandPost extends Command {

    public CommandPost(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() throws InvalidUserException {
        this.setUser();
        if (userId == -1) {
            this.addUserAndPost();
        } else {
            users.getUser(userId).addPost(words[1], System.nanoTime());
        }
    }

    private void addUserAndPost() throws InvalidUserException {
        if (words.length == 1) {
            throw new InvalidUserException(words[0]);
        }
        User temp = new User(words[0]);
        temp.addPost(words[1], System.nanoTime());
        users.addUser(temp);
    }

}
