/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and o7en the template in the editor.
 */
package ro.exenne.twitter;

import UserPackage.Users;
import Exceptions.InvalidMailFormatException;
import Exceptions.ProfileNotSetException;
import Exceptions.InvalidUserException;
import Exceptions.InvalidInputException;
import Exceptions.InvalidPhoneNrFormatException;
import Commands.CommandSeeAnotherProfile;
import Commands.CommandEditProfile;
import Commands.CommandUnfollow;
import Commands.Command;
import Commands.CommandFollow;
import Commands.CommandShowPersonalPosts;
import Commands.CommandPeopleYouMightKnow;
import Commands.CommandSeeProfile;
import Commands.CommandShowWall;
import Commands.CommandPost;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Twitter {

    private final Users users;
    private String[] words;
    private final BufferedReader buff;
    private final static List<String> commandIdentifier = Arrays.asList("->", " follows ",
            " wall", " unfollow ", " see profile", " see ",
            " people you might know");
    private final static List<String> commandClass = Arrays.asList("Commands.CommandPost",
            "Commands.CommandFollow", "Commands.CommandShowWall", "Commands.CommandUnfollow",
            "Commands.CommandSeeProfile", "Commands.CommandSeeAnotherProfile",
            "Commands.CommandPeopleYouMightKnow");

    Twitter(BufferedReader buff) {
        this.buff = buff;
        users = new Users();
    }

    private Command initialize(String command, int index) throws InvalidUserException, ProfileNotSetException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException, InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        words = command.split(commandIdentifier.get(index));
        return (Command) Class.forName(commandClass.get(index)).getConstructor(UserPackage.Users.class).newInstance(users);

    }

    private Command initializeEdit(String command) {
        words = command.split(" edit profile");
        return new CommandEditProfile(users, words, buff);
    }

    private Command initializeShow(String command) {
        words = command.split(" ");
        return new CommandShowPersonalPosts(users);
    }

    private Command processCommand(String command) throws InvalidUserException, ProfileNotSetException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException, InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        for (int i = 0; i < commandIdentifier.size(); i++) {
            if (command.contains(commandIdentifier.get(i))) {
                return initialize(command, i);
            }
        }
        if (command.contains(" edit profile")) {
            return initializeEdit(command);
        }
        return initializeShow(command);
    }

    public void tweet(String stringCommand) throws InvalidUserException,
            ProfileNotSetException,
            InvalidPhoneNrFormatException, InvalidMailFormatException, IOException, InvalidInputException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Command command = processCommand(stringCommand);
        command.setWords(words);
        command.tweet();
    }

}
