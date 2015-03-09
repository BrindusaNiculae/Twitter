/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.PrintStream;

/**
 *
 * @author Brindusa
 */
public class TimedPosts {

    private static final int NANO_TO_SEC = 1000000;
    private static final int SEC_OR_MIN = 60;

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

    private void decidePostTime(PrintStream out, long elapsedTime) {
        if ((System.nanoTime() - this.time) / NANO_TO_SEC < SEC_OR_MIN) {
            out.println(this.post + "(" + (int) elapsedTime
                    + " seconds ago)");
        } else {
            out.println(this.post + "(" + (int) (elapsedTime / SEC_OR_MIN)
                    + " minutes ago)");
        }
    }

    public void showSelf(PrintStream out) {
        long elapsedTime = (System.nanoTime() - this.time) / NANO_TO_SEC;
        this.decidePostTime(out, elapsedTime);
    }
}
