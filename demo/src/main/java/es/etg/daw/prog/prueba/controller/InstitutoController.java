package es.etg.daw.prog.prueba.controller;

import java.io.IOException;

import es.etg.daw.prog.prueba.App;
import es.etg.daw.prog.prueba.dao.InstitutoDAO;
import es.etg.daw.prog.prueba.dao.InstitutoDAOFactory;
import es.etg.daw.prog.prueba.dao.Tipo;
import es.etg.daw.prog.prueba.view.InstitutoMatriculaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InstitutoController extends Application {

   private final static String VIEW_MAIN = "resources/es/etg/daw/prog/prueba/view/institutoMatriculaView.fxml";
   private static Scene scene;
   private static InstitutoDAO dao;

   @Override
   public void start(Stage stage) throws Exception {
       dao = InstitutoDAOFactory.obtenerDao(Tipo.SQLITE);
       stage.setScene(cargarVista(VIEW_MAIN));
       stage.show();
   }

   private Scene cargarVista(String ficheroView) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
       Parent root = fxmlLoader.load();

       InstitutoMatriculaViewController viewController = fxmlLoader.getController();
       viewController.setInstitutoController(this);
       Scene scene = new Scene(root);

       return scene;
   }

   public static Scene getScene() {
       return scene;
   }

   public static void setScene(Scene scene) {
       InstitutoController.scene = scene;
   }

   public static InstitutoDAO getDao() {
       return dao;
   }

   public static void setDao(InstitutoDAO dao) {
       InstitutoController.dao = dao;
   }   
}
