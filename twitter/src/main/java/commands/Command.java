/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import exceptions.InvalidInputException;
import exceptions.InvalidMailFormatException;
import exceptions.InvalidPhoneNrFormatException;
import exceptions.InvalidUserException;
import exceptions.ProfileNotSetException;

/**
 *
 * @author Brindusa
 */
public interface Command {
    
    public abstract void tweet() throws InvalidUserException,
            ProfileNotSetException, InvalidInputException,
            InvalidMailFormatException, InvalidPhoneNrFormatException, IOException;
}
