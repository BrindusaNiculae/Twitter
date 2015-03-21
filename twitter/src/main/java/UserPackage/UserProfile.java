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

    private static final int MAX_LEN = 10;
    private String email;
    private String phoneNr;
    private String description;

    UserProfile() {
        email = "";
        phoneNr = "";
        description = "";
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public void setPhone(String tel) {
        phoneNr = tel;
    }

    public void setDescription(String descr) {
        description = descr;
    }

    public void showProfileToOutput(PrintStream out, String name) {
        out.println("User " + name + " has the following info:");
        out.println("    -Email: " + this.email);
        out.println("    -Telephone nr: " + this.phoneNr);
        out.println("    -Description: " + this.description);
    }

    public void editSelf(BufferedReader buff) throws InvalidInputException, InvalidMailFormatException, IOException, InvalidPhoneNrFormatException {
        checkEmail(buff);
        checkPhoneNr(buff);
        checkDescription(buff);
    }

    private void checkEmailFormat() throws InvalidMailFormatException {
        if (!email.contains("@")) {
            throw new InvalidMailFormatException();
        }
    }

    private void checkEmail(BufferedReader buff) throws InvalidInputException, InvalidMailFormatException, IOException {
        this.email = buff.readLine();
        if (null == this.email) {
            throw new InvalidInputException();
        }
        this.checkEmailFormat();
    }

    private void checkPhoneNrLength() throws InvalidPhoneNrFormatException {
        if (phoneNr.length() > MAX_LEN) {
            throw new InvalidPhoneNrFormatException();
        }
    }

    private void checkPhoneNrFormat() throws InvalidPhoneNrFormatException {
        for (char c : phoneNr.toCharArray()) {
            if (c > '9') {
                throw new InvalidPhoneNrFormatException();
            }
        }
    }

    private void checkPhoneNr(BufferedReader buff) throws InvalidMailFormatException, IOException, InvalidPhoneNrFormatException, InvalidInputException {
        phoneNr = buff.readLine();
        if (null == phoneNr) {
            throw new InvalidInputException();
        }
        this.checkPhoneNrLength();
        this.checkPhoneNrFormat();
    }

    private void checkDescription(BufferedReader buff) throws InvalidInputException, IOException {
        description = buff.readLine();
        if (null == description) {
            throw new InvalidInputException();
        }
    }

    public void checkProfileSet() throws ProfileNotSetException {
        if (this.email.equals("")) {
            throw new ProfileNotSetException();
        }
    }
}
