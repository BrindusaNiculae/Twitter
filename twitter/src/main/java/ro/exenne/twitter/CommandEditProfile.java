/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Brindusa
 */
class CommandEditProfile extends Command {

    private static final int MAX_LEN = 10;

    public CommandEditProfile(Users users, String[] words, BufferedReader buff) {
        super(users, words, buff);
    }

    @Override
    public void tweet() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
        this.setUser();
        this.chechAll();
    }

    private void chechAll() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
        String email = checkEmail();
        String phoneNr = checkPhoneNr();
        String description = checkDescription();
        users.getUser(userId).editProfile(email, phoneNr, description);
    }

    private void checkEmailFormat(String email) throws InvalidMailFormatException {
        if (!email.contains("@")) {
            throw new InvalidMailFormatException();
        }
    }

    private String checkEmail() throws InvalidInputException, InvalidMailFormatException, IOException {
        String email = buff.readLine();
        if (null == email) {
            throw new InvalidInputException();
        }
        this.checkEmailFormat(email);
        return email;
    }

    private void checkPhoneNrLength(String phoneNr) throws InvalidPhoneNrFormatException {
        if (phoneNr.length() > MAX_LEN) {
            throw new InvalidPhoneNrFormatException();
        }
    }

    private void checkPhoneNrFormat(String phoneNr) throws InvalidPhoneNrFormatException {
        for (char c : phoneNr.toCharArray()) {
            if (c > '9') {
                throw new InvalidPhoneNrFormatException();
            }
        }
    }

    private String checkPhoneNr() throws InvalidMailFormatException, IOException, InvalidPhoneNrFormatException, InvalidInputException {
        String phoneNr = buff.readLine();
        if (null == phoneNr) {
            throw new InvalidInputException();
        }
        this.checkPhoneNrLength(phoneNr);
        this.checkPhoneNrFormat(phoneNr);
        return phoneNr;
    }

    private String checkDescription() throws InvalidInputException, IOException {
        String description = buff.readLine();
        if (null == description) {
            throw new InvalidInputException();
        }
        return description;
    }

}
