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

    private static final int NANO_TO_SEC = 1000000;
    private static final int SEC_OR_MIN = 60;

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

    private void addPosts(List<TimedPosts> allPosts) {
        for (TimedPosts post : this.posts) {
            String newPost = this.name + ": " + post.getPost();
            long time = post.getTime();
            allPosts.add(new TimedPosts(newPost, time));
        }
    }

    private void addFollowersPosts(List<TimedPosts> allPosts) {
        for (User follower : followers) {
            for (TimedPosts post : follower.getPosts()) {
                String newPost = follower.getName() + ": " + post.getPost();
                long time = post.getTime();
                allPosts.add(new TimedPosts(newPost, time));
            }
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
        this.addPosts(allPosts);
        this.addFollowersPosts(allPosts);
        this.sortAllPosts(allPosts);
        this.show(allPosts);
    }

    public void showProfile() throws ProfileNotSetException {
        String exceptionGenerator = "";
        if (profile.getEmail().equals(exceptionGenerator)) {
            throw new ProfileNotSetException();
        } else {
            out.println("User " + this.getName() + " has the following info:");
            out.println("    -Email: " + profile.getEmail());
            out.println("    -Telephone nr: " + profile.getPhone());
            out.println("    -Description: " + profile.getDescription());
        }
    }

    private void show(List<TimedPosts> postsList) {
        for (TimedPosts post : postsList) {
            long elapsedTimeInSec = (System.nanoTime() - post.getTime()) / NANO_TO_SEC;
            if (elapsedTimeInSec < SEC_OR_MIN) {
                int elapsedTime = (int) elapsedTimeInSec;
                out.println(post.getPost() + "(" + elapsedTime
                        + " seconds ago)");
            } else {
                int elapsedTime = (int) (elapsedTimeInSec / SEC_OR_MIN);
                out.println(post.getPost() + "(" + elapsedTime
                        + " minutes ago)");
            }
        }
    }

    public void getPeopleYouMightKnow() {
        ArrayList<String> ppl;
        ppl = new ArrayList<String>();
        for (User user : followers) {
            for (User personYouMightKnow : user.getFollowers()) {
                if (!personYouMightKnow.getName().equals(this.getName())) {
                    boolean alreadyAdded = false;
                    for (String aux : ppl) {
                        if (aux.contains(personYouMightKnow.getName())) {
                            alreadyAdded = true;
                        }
                    }
                    if (!alreadyAdded) {
                        ppl.add("You might know: " + personYouMightKnow.getName() + ".");
                    }
                }
            }
        }

        out.println("Dear " + this.getName() + ":");
        for (String s : ppl) {
            out.println(s);
        }
    }
}
