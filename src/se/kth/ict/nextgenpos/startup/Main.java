package se.kth.ict.nextgenpos.startup;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.view.View;

import java.io.IOException;

/**
 * Starts the application.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Controller cont = new Controller();
        View view = new View(cont);
        view.test();
    }
}
