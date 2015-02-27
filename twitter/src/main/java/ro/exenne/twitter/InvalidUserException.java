/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

/**
 *
 * @author Brindu
 */
public class InvalidUserException extends Exception {

    InvalidUserException(String name) {
        System.err.println("Invalid user " + name
                + " please enter a valid user");
    }
}
