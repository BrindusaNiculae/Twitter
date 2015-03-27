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
public class CommandShowWall implements Command {

    private final Operator operator;

    public CommandShowWall(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void tweet() {
        operator.setUser();
        operator.getUsers().getUser(operator.getUserId()).showWall();
    }

}
