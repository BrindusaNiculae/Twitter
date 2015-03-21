/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionsPackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brindu
 */
public class InvalidMailFormatException extends Exception {

    public InvalidMailFormatException() {
        super();
        final Logger log = Logger.getLogger(getClass().getName());
        log.log(Level.SEVERE, "The format of the email is invalid. "
                + "Enter a valid email address", this);
    }

}
