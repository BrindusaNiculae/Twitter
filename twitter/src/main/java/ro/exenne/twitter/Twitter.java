/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.IOException;

public class Twitter {

    private final Users users;
    private Command command;
    private String[] words;
    private final BufferedReader buff;

    Twitter(BufferedReader buff) {
        this.buff = buff;
        users = new Users();
    }

    private Command processCommand(String command) throws InvalidUserException, ProfileNotSetException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException, InvalidInputException {
        if (command.contains("->")) {
            words = command.split("->");
            return new CommandPost(users, words);
        }
        if (command.contains(" follows ")) {
            words = command.split(" follows ");
            return new CommandFollow(users, words);
        }
        if (command.contains(" wall")) {
            words = command.split(" wall");
            return new CommandShowWall(users, words);
        }
        if (command.contains(" unfollow ")) {
            words = command.split(" unfollow ");
            return new CommandUnfollow(users, words);
        }
        if (command.contains(" see profile")) {
            words = command.split(" see profile");
            return new CommandSeeProfile(users, words);
        }
        if (command.contains(" edit profile")) {
            words = command.split(" edit profile");
            return new CommandEditProfile(users, words, buff);
        }
        if (command.contains(" see ")) {
            words = command.split(" see ");
            return new CommandSeeAnotherProfile(users, words);
        }
        if (command.contains(" people you might know")) {
            words = command.split(" people you might know");
            return new CommandPeopleYouMihgtKnow(users, words);
        }
        words = command.split(" ");
        return new CommandShowPersonalPosts(users, words);

    }

    public void tweet(String command) throws InvalidUserException,
            ProfileNotSetException,
            InvalidPhoneNrFormatException, InvalidMailFormatException, IOException, InvalidInputException {
        this.command = processCommand(command);
        this.command.tweet();
    }

    
}
