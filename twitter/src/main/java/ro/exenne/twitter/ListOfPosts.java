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
 * @author Brindusa
 */
public class ListOfPosts {

    private final List<TimedPosts> posts;

    ListOfPosts() {
        posts = new ArrayList<TimedPosts>();
    }

    public void addPost(TimedPosts post) {
        posts.add(post);
    }

    public List<TimedPosts> getPosts() {
        return posts;
    }

    public void show(PrintStream out) {
        for (TimedPosts post : posts) {
            post.showSelf(out);
        }
    }

    public void addPostsWithNames(ListOfPosts originalPosts, String name) {
        for (TimedPosts post : originalPosts.getPosts()) {
            this.addPost(new TimedPosts(name + ": "
                    + post.getPost(), post.getTime()));
        }
    }

    public void addFollowersPosts(List<User> followers) {
        for (User follower : followers) {
            this.addPostsWithNames(follower.getPosts(), follower.getName());
        }
    }

    public void sortAllPosts() {
        Collections.sort(this.getPosts(), new Comparator<TimedPosts>() {
            @Override
            public int compare(TimedPosts o1, TimedPosts o2) {
                return (int) (o1.getTime() - o2.getTime());
            }
        });
    }

}
