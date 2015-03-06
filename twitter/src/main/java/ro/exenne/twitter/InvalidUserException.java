/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brindu
 */
public class InvalidUserException extends Exception {

    InvalidUserException(String name) {
        super();
        final Logger log = Logger.getLogger(getClass().getName());
        log.log(Level.SEVERE, "Invalid user " + name
                + " please enter a valid user", this);
    }
}
