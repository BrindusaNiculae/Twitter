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
class CommandSeeAnotherProfile extends Command {

    public CommandSeeAnotherProfile(Users users, String[] words) {
        super(users, words);
    }

    @Override
    public void tweet() throws InvalidUserException, ProfileNotSetException {
        this.setUser();
        String name2 = words[1];
        String[] aux = name2.split(" profile");
        int i = getUserId(" " + aux[0] + " ");
        if (i == -1) {
            throw new InvalidUserException(name2);
        } else {
            users.getUser(i).showProfile();
        }
    }

}
