package es.etg.daw.prog.prueba;

import javafx.application.Application;

import es.etg.daw.prog.prueba.controller.InstitutoController;

/**
 * JavaFX App
 */
public class App  {


    public static void main(String[] args) {

        //Inicio la aplicación javafx (se ejecutará el método start del controlador InstitutoController.java)
        Application.launch(InstitutoController.class, args);
    }


}