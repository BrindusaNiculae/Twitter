/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

/**
 *
 * @author Brindusa
 */
public class CommandPeopleYouMightKnow implements Command {

    Operator operator = new Operator();

    public CommandPeopleYouMightKnow(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() {
        operator.setUser();
        operator.getUsers().getUser(operator.getUserId()).getPeopleYouMightKnow();
    }

}
