/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

/**
 *
 * @author Brindusa
 */
public class TimedPosts {

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
