/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Twitter {

    private ArrayList<User> users = new ArrayList();
    private int commandId = 0;
    private long startTime = 0;
    String fileWriterName = "Scenario.out";
    FileWriter fw;

    private String[] processCommand(String command) {
        String[] words;
        if (command.contains("->")) {
            words = command.split("->");
            commandId = 1;
            return words;
        } else if (command.contains(" follows ")) {
            words = command.split(" follows ");
            commandId = 2;
            return words;
        } else if (command.contains(" wall")) {
            words = command.split(" wall");
            commandId = 3;
            return words;
        } else if (command.contains(" unfollow ")) {
            words = command.split(" unfollow ");
            commandId = 4;
            return words;
        } else if (command.contains(" see profile")) {
            words = command.split(" see profile");
            commandId = 5;
            return words;
        } else if (command.contains(" edit profile")) {
            words = command.split(" edit profile");
            commandId = 6;
            return words;
        } else if (command.contains(" see ")) {
            words = command.split(" see ");
            commandId = 7;
            return words;
        } else if (command.contains(" notifications")) {
            words = command.split(" notifications");
            commandId = 8;
            return words;
        } else if (command.contains(" people you might know")) {
            words = command.split(" people");
            commandId = 9;
            return words;
        } else {
            commandId = 0;
            words = command.split("->");
            return words;
        }
    }

    private int getUserId(String name) {

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            String nameTest = " " + user.getName() + " ";
            if (nameTest.contains(name) && name.contains(nameTest)) {
                return i;
            }
        }
        return -1;
    }

    private void getFollowees(String name, String post, long time) {
        for (User user : users) {
            if (!user.getName().equals(name)) {
                for (User followee : user.getFollowers()) {
                    if (followee.getName().equals(name)) {
                        String newPost = name + ": ";
                        if (post.length() < 20) {
                            newPost += post;
                        } else {
                            char[] postToChar = post.toCharArray();
                            for (int i = 0; i < 20; i++) {
                                newPost += postToChar[i];
                            }
                        }
                        user.addNotification(newPost, time);
                    }
                }
            }
        }
    }

    public void tweet(String command) throws InvalidUserException,
            ProfileNotSetException, InvalidEditProfileInputException,
            InvalidPhoneNrFormatException, InvalidMailFormatException, IOException {
        String words[] = processCommand(command);
        String name = " " + words[0] + " ";
        int i = getUserId(name);

        if (i > -1) {
            if (words.length == 1 && commandId != 3 && commandId != 5
                    && commandId != 6 && commandId != 8) {
                users.get(i).showPersonalPosts();
            } else {
                switch (commandId) {
                    case 1:
                        long time = System.nanoTime();
                        users.get(i).addPost(words[1], time);
                        break;
                    case 2:
                        String name2 = words[1];
                        int j = getUserId(" " + name2 + " ");
                        if (j == -1) {
                            throw new InvalidUserException(name2);
                        } else {
                            users.get(i).addFollower(users.get(j));
                        }
                        break;
                    case 3:
                        users.get(i).showWall();
                        break;
                    case 4:
                        name2 = words[1];
                        j = getUserId(" " + name2 + " ");
                        if (j == -1) {
                            throw new InvalidUserException(name2);
                        } else {
                            users.get(i).removeFollower(users.get(j));
                        }
                        break;
                    case 5:
                        users.get(i).showProfile();
                        break;
                    case 6:
                        String scanner;
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

                        String email,
                         phoneNr,
                         description;
                        System.out.println("Set email:");
                        scanner = buff.readLine();
                        email = scanner;
                        if (!email.contains("@")) {
                            throw new InvalidMailFormatException();
                        }

                        System.out.println("Set phone number: ");
                        scanner = buff.readLine();
                        phoneNr = scanner;

                        if (phoneNr.length() > 10) {
                            throw new InvalidPhoneNrFormatException();
                        }
                        for (char c : phoneNr.toCharArray()) {
                            if (c < '0' || c > '9') {
                                throw new InvalidPhoneNrFormatException();
                            }
                        }

                        System.out.println("Set description: ");
                        scanner = buff.readLine();
                        description = scanner;

                        users.get(i).editProfile(email, phoneNr, description);
                        break;

                    case 7:
                        name2 = words[1];
                        String[] aux = name2.split(" profile");
                        j = getUserId(" " + aux[0] + " ");
                        if (j == -1) {
                            throw new InvalidUserException(name2);
                        } else {
                            users.get(j).showProfile();
                        }
                        break;
                    case 8:
                        users.get(i).showNotifications();
                        break;
                    case 9:
                        users.get(i).getPeopleYouMightKnow();
                        break;
                    default:
                        break;
                }
            }
        }

        if (i == -1) {
            if (words.length == 1) {
                throw new InvalidUserException(words[0]);
            } else if (commandId == 1) {
                User temp = new User(words[0]);
                long time = System.nanoTime();
                temp.addPost(words[1], time);
                users.add(temp);
            }
        }
    }

    public void writeToFile(String command) throws IOException, InvalidUserException,
            InvalidMailFormatException, InvalidEditProfileInputException,
            InvalidPhoneNrFormatException, ProfileNotSetException {
        String words[] = processCommand(command);
        String name = " " + words[0] + " ";
        int i = getUserId(name);

        if (i > -1) {
            if (words.length == 1 && commandId != 3 && commandId != 5
                    && commandId != 6 && commandId != 8) {
                users.get(i).showPersonalPostsToFile(fw);
            } else {
                switch (commandId) {
                    case 1:
                        long time = startTime;
                        startTime += 1;
                        users.get(i).addPost(words[1], time);
                        getFollowees(words[0], words[1], time);
                        break;
                    case 2:
                        String name2 = words[1];
                        int j = getUserId(" " + name2 + " ");
                        if (j == -1) {
                            throw new InvalidUserException(name2);
                        } else {
                            users.get(i).addFollower(users.get(j));
                        }
                        break;
                    case 3:
                        users.get(i).showWallToFile(fw);
                        break;
                    case 4:
                        name2 = words[1];
                        j = getUserId(" " + name2 + " ");
                        if (j == -1) {
                            throw new InvalidUserException(name2);
                        } else {
                            users.get(i).removeFollower(users.get(j));
                        }
                        break;
                    case 5:
                        users.get(i).showProfileToFile(fw);
                        break;
                    case 6:
                        Scanner scanner = new Scanner(new File("editProfile.in"));
                        String email,
                         phoneNr,
                         description;
                        if (!scanner.hasNext()) {
                            throw new InvalidEditProfileInputException();
                        } else {
                            email = scanner.nextLine();
                            if (!email.contains("@")) {
                                throw new InvalidMailFormatException();
                            }
                        }
                        if (!scanner.hasNext()) {
                            throw new InvalidEditProfileInputException();
                        } else {
                            phoneNr = scanner.nextLine();
                            if (phoneNr.length() > 10) {
                                throw new InvalidPhoneNrFormatException();
                            }
                            for (char c : phoneNr.toCharArray()) {
                                if (c < '0' || c > '9') {
                                    throw new InvalidPhoneNrFormatException();
                                }
                            }
                        }
                        if (!scanner.hasNext()) {
                            throw new InvalidEditProfileInputException();
                        } else {
                            description = scanner.nextLine();
                        }
                        users.get(i).editProfile(email, phoneNr, description);
                        break;
                    case 7:
                        name2 = words[1];
                        String[] aux = name2.split(" profile");
                        j = getUserId(" " + aux[0] + " ");
                        if (j == -1) {
                            throw new InvalidUserException(name2);
                        } else {
                            users.get(j).showProfileToFile(fw);
                        }
                        break;
                    case 8:
                        users.get(i).showNotificationsToFile(fw);
                        break;
                    case 9:
                        users.get(i).getPeopleYouMightKnowToFile(fw);
                        break;
                    default:
                        break;
                }
            }
        }
        if (i == -1) {
            if (words.length == 1) {
                throw new InvalidUserException(words[0]);
            } else if (commandId == 1) {
                User temp = new User(words[0]);
                long time = startTime;
                startTime += 1;
                temp.addPost(words[1], time);
                users.add(temp);
            }
        }

    }

    public void readFile(String filename) throws FileNotFoundException, IOException, InvalidUserException {
        Scanner scanner = new Scanner(new File(filename));
        fw = new FileWriter(new File(fileWriterName));

        while (true) {
            String s = scanner.nextLine();
            if (s.contains("EXIT")) {
                break;
            } else {
                try {
                    writeToFile(s);
                } catch (InvalidMailFormatException ex) {
                    Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidEditProfileInputException ex) {
                    Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidPhoneNrFormatException ex) {
                    Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ProfileNotSetException ex) {
                    Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        fw.flush();
        fw.close();

    }

    public String compareFiles(String filenameOK, String filenameOUT) throws FileNotFoundException {
        Scanner sOK = new Scanner(new File(filenameOK));
        Scanner sOUT = new Scanner(new File(filenameOUT));

        while (sOUT.hasNext()) {
            String s1 = sOK.nextLine();
            String s2 = sOUT.nextLine();

            if (!s2.contains(s1)) {
                System.out.println(s2 + " " + s1);
                return "Invalid output";
            }
        }
        return "Valid output";
    }
}
