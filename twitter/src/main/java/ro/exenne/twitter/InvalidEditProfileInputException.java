/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

/**
 *
 * @author Brindu
 */
class InvalidEditProfileInputException extends Exception {

    public InvalidEditProfileInputException() {
        System.err.println("The information is invalid");
       
    }
    
}