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
    private final List<TimedPosts> posts;
    private List<TimedPosts> allPosts;
    private final List<User> followers;
    private final UserProfile profile;
    private final PrintStream out = System.out;

    User(String name) {
        this.name = name;
        posts = new ArrayList<TimedPosts>();
        followers = new ArrayList<User>();
        allPosts = new ArrayList<TimedPosts>();
        profile = new UserProfile();
    }

    public String getName() {
        return name;
    }

    public List<TimedPosts> getPosts() {
        return posts;
    }

    public void addPost(String post, long time) {
        this.posts.add(new TimedPosts(post, time));
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
        profile.setEmail(email);
        profile.setPhone(phoneNr);
        profile.setDescription(description);
    }

    public void showPersonalPosts() {
        this.show(posts);
    }

    private void addPostsWithNames(List<TimedPosts> originalPosts,
            List<TimedPosts> allPosts, String name) {
        for (TimedPosts post : originalPosts) {
            boolean add = allPosts.add(new TimedPosts(name + ": "
                    + post.getPost(), post.getTime()));
        }
    }

    private void addFollowersPosts(List<TimedPosts> allPosts) {
        for (User follower : followers) {
            addPostsWithNames(follower.getPosts(), allPosts, follower.getName());
        }
    }

    private void sortAllPosts(List<TimedPosts> allPosts) {
        Collections.sort(allPosts, new Comparator<TimedPosts>() {
            @Override
            public int compare(TimedPosts o1, TimedPosts o2) {
                return (int) (o1.getTime() - o2.getTime());
            }
        });
    }

    public void showWall() {
        allPosts = new ArrayList<TimedPosts>();
        this.addPostsWithNames(this.posts, allPosts, this.name);
        this.addFollowersPosts(allPosts);
        this.sortAllPosts(allPosts);
        this.show(allPosts);
    }

    private void showProfileToOutput() {
        out.println("User " + this.getName() + " has the following info:");
        out.println("    -Email: " + profile.getEmail());
        out.println("    -Telephone nr: " + profile.getPhone());
        out.println("    -Description: " + profile.getDescription());
    }

    public void showProfile() throws ProfileNotSetException {
        if (profile.getEmail().equals("")) {
            throw new ProfileNotSetException();
        } else {
            this.showProfileToOutput();
        }
    }

    private void show(List<TimedPosts> postsList) {
        for (TimedPosts post : postsList) {
            post.showSelf(out);
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
                if (!personYouMightKnow.getName().equals(this.getName())) {
                    if (!alreadyInList(people, personYouMightKnow.getName())) {
                        people.add("You might know: " + personYouMightKnow.getName() + ".");
                    }
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
