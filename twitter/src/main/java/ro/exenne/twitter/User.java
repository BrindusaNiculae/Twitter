/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Brindu
 */
public class User {

    private final String name;
    private final ListOfPosts posts;
    private final List<User> followers;
    private final UserProfile profile;
    private final PrintStream out = System.out;

    User(String name) {
        this.name = name;
        posts = new ListOfPosts();
        followers = new ArrayList<User>();
        profile = new UserProfile();
    }

    public String getName() {
        return name;
    }

    public ListOfPosts getPosts() {
        return posts;
    }

    public void addPost(String post, long time) {
        this.posts.addPost(new TimedPosts(post, time));
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public void editProfile(String email, String phoneNr, String description) {
        profile.edit(email, phoneNr, description);
    }

    public void showPersonalPosts() {
        posts.show(out);
    }

    public void showWall() {
        ListOfPosts allPosts = new ListOfPosts();
        allPosts.addPostsWithNames(this.posts, this.name);
        allPosts.addFollowersPosts(this.followers);
        allPosts.sortAllPosts();
        allPosts.show(out);
    }

    public void showProfile() throws ProfileNotSetException {
        if (profile.getEmail().equals("")) {
            throw new ProfileNotSetException();
        } else {
            profile.showProfileToOutput(out, this.getName());
        }
    }

    private void showPeopleYouMightKnow(List<String> people) {
        out.println("Dear " + this.getName() + ":");
        for (String s : people) {
            out.println(s);
        }
    }

    private boolean alreadyInList(List<String> people, String name) {
        for (String aux : people) {
            if (aux.contains(name)) {
                return true;
            }
        }
        return false;
    }

    private void editPeopleYouMightKnowList(List<String> people) {
        for (User user : followers) {
            for (User personYouMightKnow : user.getFollowers()) {
                if (!personYouMightKnow.getName().equals(this.getName())
                        && !alreadyInList(people, personYouMightKnow.getName())) {
                    people.add("You might know: " + personYouMightKnow.getName() + ".");
                }

            }
        }
    }

    public void getPeopleYouMightKnow() {
        List<String> people = new ArrayList<String>();
        this.editPeopleYouMightKnowList(people);
        this.showPeopleYouMightKnow(people);
    }
}
