/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brindu
 */
public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super();
        final Logger log = Logger.getLogger(getClass().getName());
        log.log(Level.SEVERE, "The format of the input is not valid", this);
    }
}
