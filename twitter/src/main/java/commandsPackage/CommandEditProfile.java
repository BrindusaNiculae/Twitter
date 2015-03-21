/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandsPackage;

import java.io.BufferedReader;
import java.io.IOException;
import exceptionsPackage.InvalidInputException;
import exceptionsPackage.InvalidMailFormatException;
import exceptionsPackage.InvalidPhoneNrFormatException;
import userInfo.Users;

/**
 *
 * @author Brindusa
 */
public class CommandEditProfile extends Command {

    public CommandEditProfile(Users users, String[] words, BufferedReader buff) {
        super(users, words, buff);
    }

    @Override
    public void tweet() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
        this.setUser();
        this.tellProfileToSet();
    }

    private void tellProfileToSet() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
        users.getUser(userId).setBuffForProfileEdit(buff);
    }
}
