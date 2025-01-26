package gui;

import application.controller.Controller;
import javafx.application.Application;
import storage.Storage;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        System.out.println(Storage.getSalgsannoncer());
        Application.launch(Gui.class);
    }


}
