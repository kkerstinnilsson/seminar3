package se.kth.iv1350.pointofsale.startup;

import se.kth.iv1350.pointofsale.controller.Controller;
import se.kth.iv1350.pointofsale.view.View;

/**
 * The entry point of the application. Contains the main method used to start the application.
 */
public class Main {
    /**
     * The main method used to start the application.
     *
     * @param args The command line arguments. This application does not take any command line parameters.
     */
    public static void main(String[] args) {
            Controller contr = new Controller();
            View view = new View(contr);
            view.runFakeExecution();
    }
}
