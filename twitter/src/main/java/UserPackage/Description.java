/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

import Exceptions.InvalidInputException;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Brindusa
 */
public class Description {

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void checkDescription(BufferedReader buff) throws InvalidInputException, IOException {
        description = buff.readLine();
        if (null == description) {
            throw new InvalidInputException();
        }
    }

    String getDescription() {
        return this.description;
    }

}
