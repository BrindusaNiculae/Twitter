/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and o7en the template in the editor.
 */
package ro.exenne.twitter;

import userInfo.Users;
import exceptionsPackage.InvalidMailFormatException;
import exceptionsPackage.ProfileNotSetException;
import exceptionsPackage.InvalidUserException;
import exceptionsPackage.InvalidInputException;
import exceptionsPackage.InvalidPhoneNrFormatException;
import commandsPackage.CommandEditProfile;
import commandsPackage.Command;
import commandsPackage.CommandShowPersonalPosts;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Twitter {

    private final Users users;
    private String[] words;
    private final BufferedReader buff;
    private static final List<String> COMM_IDENTIFIER = Arrays.asList("->", " follows ",
            " wall", " unfollow ", " see profile", " see ",
            " people you might know");
    private static final List<String> COMM_CLASS = Arrays.asList("commandsPackage.CommandPost",
            "commandsPackage.CommandFollow", "commandsPackage.CommandShowWall", "commandsPackage.CommandUnfollow",
            "commandsPackage.CommandSeeProfile", "commandsPackage.CommandSeeAnotherProfile",
            "commandsPackage.CommandPeopleYouMightKnow");

    Twitter(BufferedReader buff) {
        this.buff = buff;
        users = new Users();
    }

    private Command initialize(String command, int index) throws ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        words = command.split(COMM_IDENTIFIER.get(index));
        return (Command) Class.forName(COMM_CLASS.get(index)).getConstructor(userInfo.Users.class).newInstance(users);

    }

    private Command initializeEdit(String command) {
        words = command.split(" edit profile");
        return new CommandEditProfile(users, words, buff);
    }

    private Command initializeShow(String command) {
        words = command.split(" ");
        return new CommandShowPersonalPosts(users);
    }

    private Command processCommand(String command) throws ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        for (int i = 0; i < COMM_IDENTIFIER.size(); i++) {
            if (command.contains(COMM_IDENTIFIER.get(i))) {
                return initialize(command, i);
            }
        }
        if (command.contains(" edit profile")) {
            return initializeEdit(command);
        }
        return initializeShow(command);
    }

    public void tweet(String stringCommand) throws ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InvalidUserException, ProfileNotSetException, InvalidInputException, InvalidMailFormatException,
            InvalidPhoneNrFormatException, IOException {
        Command command = processCommand(stringCommand);
        command.setWords(words);
        command.tweet();
    }

}
