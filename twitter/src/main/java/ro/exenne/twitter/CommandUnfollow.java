/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

/**
 *
 * @author Brindusa
 */
public class CommandUnfollow extends Command {

    public CommandUnfollow(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() throws InvalidUserException {
        this.setUser();
        String name2 = words[1];
        int i = getUserId(" " + name2 + " ");
        if (i == -1) {
            throw new InvalidUserException(name2);
        }
        users.getUser(userId).removeFollower(users.getUser(i));
    }

}