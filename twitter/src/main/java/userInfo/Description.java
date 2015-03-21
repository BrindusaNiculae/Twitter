/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInfo;

import exceptionsPackage.InvalidInputException;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Brindusa
 */
public class Description {

    private String description;

    public void setDescription(BufferedReader buff) throws IOException, InvalidInputException {
        description = buff.readLine();
        this.checkDescription();
    }

    private void checkDescription() throws InvalidInputException, IOException {
        if (null == description) {
            throw new InvalidInputException();
        }
    }

    String getDescription() {
        return this.description;
    }

}
