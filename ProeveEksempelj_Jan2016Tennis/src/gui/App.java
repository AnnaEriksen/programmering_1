package gui;

import application.controller.controller;
import javafx.application.Application;
public class App {
    public static void main(String[] args) {
        controller.initStorage();
        Application.launch(Gui.class);
    }


}
