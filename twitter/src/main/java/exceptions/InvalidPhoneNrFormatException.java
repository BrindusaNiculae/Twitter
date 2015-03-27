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
public class InvalidPhoneNrFormatException extends Exception {

    public InvalidPhoneNrFormatException() {
        super();
        final Logger log = Logger.getLogger(getClass().getName());
        log.log(Level.SEVERE, "Invalid phone nr!", this);
    }

}
