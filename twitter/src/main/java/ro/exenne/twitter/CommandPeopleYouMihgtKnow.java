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
class CommandPeopleYouMihgtKnow extends Command {

    public CommandPeopleYouMihgtKnow(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() {
        this.setUser();
        users.getUser(userId).getPeopleYouMightKnow();
    }

}
