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
class CommandShowPersonalPosts extends Command {

    public CommandShowPersonalPosts(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() throws InvalidUserException {
        this.setUser();
        if (userId == -1) {
            throw new InvalidUserException(name);
        }
        users.getUser(userId).showPersonalPosts();
    }

}
