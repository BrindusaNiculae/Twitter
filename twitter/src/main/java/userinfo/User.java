/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo;

import exceptions.InvalidInputException;
import exceptions.InvalidMailFormatException;
import exceptions.InvalidPhoneNrFormatException;
import exceptions.ProfileNotSetException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import ro.exenne.twitter.ListOfPosts;

/**
 *
 * @author Brindu
 */
public class User {

    private final String name;
    private final ListOfPosts posts;
    private final Followers followers;
    private final UserProfile profile;
    private final PrintStream out = System.out;

    public User(String name) {
        this.name = name;
        posts = new ListOfPosts();
        followers = new Followers();
        profile = new UserProfile();
    }

    public String getName() {
        return name;
    }

    public ListOfPosts getPosts() {
        return posts;
    }

    public void addPost(String post, long time) {
        this.posts.addPost(post, time);
    }

    public Followers getFollowers() {
        return followers;
    }

    public void addFollower(User user) {
        followers.addFollower(user);
    }

    public void removeFollower(User user) {
        followers.removeFollower(user);
    }

    public void showPersonalPosts() {
        posts.show(out);
    }

    public void showWall() {
        ListOfPosts allPosts = new ListOfPosts();
        allPosts.showSelfToWall(this.posts, this.name, this.followers.getFollowers(), out);
    }

    public void showProfile() throws ProfileNotSetException {
        profile.checkProfileSet();
        profile.showProfileToOutput(out, this.name);
    }

    private void showPeopleYouMightKnow(List<String> people) {
        out.println("Dear " + this.name + ":");
        for (String s : people) {
            out.println(s);
        }
    }

    public void getPeopleYouMightKnow() {
        List<String> people = new ArrayList<String>();
        followers.editPeopleYouMightKnowList(people, this.name);
        this.showPeopleYouMightKnow(people);
    }

    public void setBuffForProfileEdit(BufferedReader buff) throws InvalidInputException, InvalidMailFormatException, IOException, InvalidPhoneNrFormatException {
        profile.editSelf(buff);
    }
}
