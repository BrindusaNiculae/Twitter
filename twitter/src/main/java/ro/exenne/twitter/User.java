/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

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
    private String email;
    private String phoneNr;
    private String description;

    private static class TimedPosts {

        private final String post;
        private final Long time;

        TimedPosts(String post, long time) {
            this.post = post;
            this.time = time;
        }

        protected String getPost() {
            return post;
        }

        protected long getTime() {
            return time;
        }
    }

    User(String name) {
        this.name = name;
        posts = new ArrayList<TimedPosts>();
        followers = new ArrayList<User>();
        allPosts = new ArrayList<TimedPosts>();
        email = "";
        phoneNr = "";
        description = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public String getPhone() {
        return phoneNr;
    }

    public void setPhone(String tel) {
        phoneNr = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descr) {
        description = descr;
    }

    public void editProfile(String email, String phoneNr, String description) {
        this.setEmail(email);
        this.setPhone(phoneNr);
        this.setDescription(description);
    }

    public void showPersonalPosts() {
        this.show(posts);
    }

    public void showWall() {
        allPosts = new ArrayList<TimedPosts>();

        for (int i = 0; i < this.posts.size(); i++) {
            String newPost = this.name + ": " + this.posts.get(i).getPost();
            long time = posts.get(i).getTime();
            allPosts.add(new TimedPosts(newPost, time));
        }

        for (User follower : followers) {
            for (TimedPosts post : follower.getPosts()) {
                String newPost = follower.getName() + ": " + post.getPost();
                long time = post.getTime();
                allPosts.add(new TimedPosts(newPost, time));
            }
        }
        Collections.sort(allPosts, new Comparator<TimedPosts>() {

            @Override
            public int compare(TimedPosts o1, TimedPosts o2) {
                return (int) (o1.time - o2.time);
            }
        });

        this.show(allPosts);
    }

    public void showProfile() throws ProfileNotSetException {
        String exceptionGenerator = "";
        if (this.getEmail().equals(exceptionGenerator) || this.getPhone().equals(exceptionGenerator)
                || this.getDescription().equals(exceptionGenerator)) {
            throw new ProfileNotSetException();
        } else {
            System.out.println("User " + this.getName() + " has the following info:");
            System.out.println("    -Email: " + this.getEmail());
            System.out.println("    -Telephone nr: " + this.getPhone());
            System.out.println("    -Description: " + this.getDescription());
        }
    }

    private void show(List<TimedPosts> postsList) {
        for (TimedPosts post : postsList) {
            long elapsedTimeInSec = (System.nanoTime() - post.getTime()) / NANO_TO_SEC;
            if (elapsedTimeInSec < SEC_OR_MIN) {
                int elapsedTime = (int) elapsedTimeInSec;
                System.out.println(post.getPost() + "(" + elapsedTime
                        + " seconds ago)");
            } else {
                int elapsedTime = (int) (elapsedTimeInSec / SEC_OR_MIN);
                System.out.println(post.getPost() + "(" + elapsedTime
                        + " minutes ago)");
            }
        }
    }

    public void getPeopleYouMightKnow() {
        ArrayList<String> ppl = null;
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

        System.out.println("Dear " + this.getName() + ":");
        for (String s : ppl) {
            System.out.println(s);
        }
    }
}
