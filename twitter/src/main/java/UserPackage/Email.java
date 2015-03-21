/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

import Exceptions.InvalidInputException;
import Exceptions.InvalidMailFormatException;
import Exceptions.ProfileNotSetException;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Brindusa
 */
public class Email {

    private String email;

    Email() {
        email = "";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void checkEmail(BufferedReader buff) throws IOException, InvalidInputException, InvalidMailFormatException {
        this.email = buff.readLine();
        if (null == this.email) {
            throw new InvalidInputException();
        }
        this.checkEmailFormat();
    }

    private void checkEmailFormat() throws InvalidMailFormatException {
        if (!email.contains("@")) {
            throw new InvalidMailFormatException();
        }
    }

    public void checkSet() throws ProfileNotSetException {
        if (this.email.equals("")) {
            throw new ProfileNotSetException();
        }
    }

    String getEmail() {
        return this.email;
    }

}
