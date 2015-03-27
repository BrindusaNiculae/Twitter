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

/**
 *
 * @author Brindusa
 */
public class CommandEditProfile implements Command {

    Operator operator = new Operator();

    public CommandEditProfile(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
       operator.setUser();
        this.tellProfileToSet();
    }

    private void tellProfileToSet() throws InvalidInputException, InvalidMailFormatException, InvalidPhoneNrFormatException, IOException {
        operator.getUsers().getUser(operator.getUserId()).setBuffForProfileEdit(operator.getBuff());
    }
}
