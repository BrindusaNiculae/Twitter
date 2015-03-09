/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Twitter {

    private static final int MAX_LEN = 10;

    private final List<User> users;
    private int userId;
    private String[] words;
    private String name;
    private final BufferedReader buff;

    Twitter(BufferedReader buff) {
        this.buff = buff;
        users = new ArrayList();
        userId = -1;
    }

    private void processCommand(String command) throws InvalidUserException, ProfileNotSetException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException, InvalidInputException {
        if (command.contains("->")) {
            words = command.split("->");
            this.addPost();
        } else if (command.contains(" follows ")) {
            words = command.split(" follows ");
            this.follow();
        } else if (command.contains(" wall")) {
            words = command.split(" wall");
            this.showWall();
        } else if (command.contains(" unfollow ")) {
            words = command.split(" unfollow ");
            this.unfollow();
        } else if (command.contains(" see profile")) {
            words = command.split(" see profile");
            this.seeProfile();
        } else if (command.contains(" edit profile")) {
            words = command.split(" edit profile");
            this.editProfile();
        } else if (command.contains(" see ")) {
            words = command.split(" see ");
            this.seeAnotherProfile();
        } else if (command.contains(" people you might know")) {
            words = command.split(" people");
            this.showPeople();
        } else {
            words = command.split(" ");
            this.showPersonalPosts();
        }
    }

    private int getUserId(String name) {

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String nameTest = " " + user.getName() + " ";
            if (nameTest.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void tweet(String command) throws InvalidUserException,
            ProfileNotSetException,
            InvalidPhoneNrFormatException, InvalidMailFormatException, IOException, InvalidInputException {
        processCommand(command);
    }

    private void setUser() {
        name = " " + words[0] + " ";
        userId = getUserId(name);
    }

    private void addUserAndPost() throws InvalidUserException {
        if (words.length == 1) {
            throw new InvalidUserException(words[0]);
        } else {
            User temp = new User(words[0]);
            temp.addPost(words[1], System.nanoTime());
            users.add(temp);
        }
    }

    private void addPost() throws InvalidUserException {
        this.setUser();
        if (userId == -1) {
            this.addUserAndPost();
        } else {
            users.get(userId).addPost(words[1], System.nanoTime());
        }
    }

    private void follow() throws InvalidUserException {
        this.setUser();
        String name2 = words[1];
        int i = getUserId(" " + name2 + " ");
        if (i == -1) {
            throw new InvalidUserException(name2);
        } else {
            users.get(userId).addFollower(users.get(i));
        }
    }

    private void showWall() {
        this.setUser();
        users.get(userId).showWall();
    }

    private void showPeople() {
        this.setUser();
        users.get(userId).getPeopleYouMightKnow();
    }

    private void seeAnotherProfile() throws InvalidUserException, ProfileNotSetException {
        this.setUser();
        String name2 = words[1];
        String[] aux = name2.split(" profile");
        int i = getUserId(" " + aux[0] + " ");
        if (i == -1) {
            throw new InvalidUserException(name2);
        } else {
            users.get(i).showProfile();
        }
    }

    private void checkEmailFormat(String email) throws InvalidMailFormatException {
        if (!email.contains("@")) {
            throw new InvalidMailFormatException();
        }
    }

    private String checkEmail() throws InvalidInputException, InvalidMailFormatException, IOException {
        String email = buff.readLine();
        if (null == email) {
            throw new InvalidInputException();
        }
        this.checkEmailFormat(email);
        return email;
    }

    private void checkPhoneNrLength(String phoneNr) throws InvalidPhoneNrFormatException {
        if (phoneNr.length() > MAX_LEN) {
            throw new InvalidPhoneNrFormatException();
        }
    }

    private void checkPhoneNrFormat(String phoneNr) throws InvalidPhoneNrFormatException {
        for (char c : phoneNr.toCharArray()) {
            if (c > '9') {
                throw new InvalidPhoneNrFormatException();
            }
        }
    }

    private String checkPhoneNr() throws InvalidMailFormatException, IOException, InvalidPhoneNrFormatException, InvalidInputException {
        String phoneNr = buff.readLine();
        if (null == phoneNr) {
            throw new InvalidInputException();
        }
        this.checkPhoneNrLength(phoneNr);
        this.checkPhoneNrFormat(phoneNr);
        return phoneNr;
    }

    private String checkDescription() throws InvalidInputException, IOException {
        String description = buff.readLine();
        if (null == description) {
            throw new InvalidInputException();
        }
        return description;
    }

    private void editProfile() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
        this.setUser();
        String email = checkEmail();
        String phoneNr = checkPhoneNr();
        String description = checkDescription();
        users.get(userId).editProfile(email, phoneNr, description);
    }

    private void seeProfile() throws ProfileNotSetException {
        this.setUser();
        users.get(userId).showProfile();
    }

    private void unfollow() throws InvalidUserException {
        this.setUser();
        String name2 = words[1];
        int i = getUserId(" " + name2 + " ");
        if (i == -1) {
            throw new InvalidUserException(name2);
        }
        users.get(userId).removeFollower(users.get(i));
    }

    private void showPersonalPosts() throws InvalidUserException {
        this.setUser();
        if (userId == -1) {
            throw new InvalidUserException(name);
        }
        users.get(userId).showPersonalPosts();
    }
}
