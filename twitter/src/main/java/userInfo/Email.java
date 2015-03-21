/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInfo;

import exceptionsPackage.InvalidInputException;
import exceptionsPackage.InvalidMailFormatException;
import exceptionsPackage.ProfileNotSetException;
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

    public void setEmail(BufferedReader buff) throws IOException, InvalidInputException, InvalidMailFormatException {
        this.email = buff.readLine();
        this.checkEmail();
    }

    String getEmail() {
        return this.email;
    }

    private void checkEmail() throws IOException, InvalidInputException, InvalidMailFormatException {

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
}
