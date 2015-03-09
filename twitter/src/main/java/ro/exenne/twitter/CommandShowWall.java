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
public class CommandShowWall extends Command {

    public CommandShowWall(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() {
        this.setUser();
        users.getUser(userId).showWall();
    }

}
