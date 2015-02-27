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
public interface InputHandler {

    public void read ()throws ProfileNotSetException, InvalidUserException, InvalidEditProfileInputException, 
            InvalidMailFormatException, InvalidPhoneNrFormatException;

}
