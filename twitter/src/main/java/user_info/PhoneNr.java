/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_info;

import exceptions.InvalidInputException;
import exceptions.InvalidMailFormatException;
import exceptions.InvalidPhoneNrFormatException;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Brindusa
 */
public class PhoneNr {

    private static final int MAX_LEN = 10;
    private String phoneNr;

    public void setPhoneNr(BufferedReader buff) throws IOException, InvalidMailFormatException, InvalidPhoneNrFormatException, InvalidInputException {
        phoneNr = buff.readLine();
        this.checkPhoneNr();
    }

    String getPhoneNr() {
        return this.phoneNr;
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

    private void checkPhoneNr() throws InvalidMailFormatException, IOException, InvalidPhoneNrFormatException, InvalidInputException {
        if (null == phoneNr) {
            throw new InvalidInputException();
        }
        this.checkPhoneNrLength();
        this.checkPhoneNrFormat();
    }
}
