/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

import Exceptions.InvalidInputException;
import Exceptions.InvalidMailFormatException;
import Exceptions.InvalidPhoneNrFormatException;
import Exceptions.ProfileNotSetException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Brindusa
 */
public class UserProfile {
    
    private Email email;
    private PhoneNr phoneNr;
    private Description description;

    UserProfile() {
        email = new Email();
        phoneNr = new PhoneNr();
        description = new Description();
    }

    public void showProfileToOutput(PrintStream out, String name) {
        out.println("User " + name + " has the following info:");
        out.println("    -Email: " + email.getEmail());
        out.println("    -Telephone nr: " + phoneNr.getPhoneNr());
        out.println("    -Description: " + description.getDescription());
    }

    public void editSelf(BufferedReader buff) throws InvalidInputException, InvalidMailFormatException, IOException, InvalidPhoneNrFormatException {
        email.setEmail(buff);
        phoneNr.setPhoneNr(buff);
        description.setDescription(buff);
    }

     public void checkProfileSet() throws ProfileNotSetException {
         email.checkSet();
    }
}
