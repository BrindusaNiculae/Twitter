/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.exenne.twitter;

import java.io.PrintStream;

/**
 *
 * @author Brindusa
 */
public class UserProfile {

    private String email;
    private String phoneNr;
    private String description;

    UserProfile() {
        email = "";
        phoneNr = "";
        description = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public String getPhone() {
        return phoneNr;
    }

    public void setPhone(String tel) {
        phoneNr = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descr) {
        description = descr;
    }

    public void edit(String email, String phoneNr, String description) {
        this.setEmail(email);
        this.setPhone(phoneNr);
        this.setDescription(description);
    }

    public void showProfileToOutput(PrintStream out, String name) {
        out.println("User " + name + " has the following info:");
        out.println("    -Email: " + this.getEmail());
        out.println("    -Telephone nr: " + this.getPhone());
        out.println("    -Description: " + this.getDescription());
    }
}
