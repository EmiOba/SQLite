package es.etg.daw.prog.prueba.view;

import es.etg.daw.prog.prueba.controller.InstitutoController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InstitutoMatriculaViewController {

   @FXML
   private Button btnAnyadirMatricula;

   @FXML
   private Button btnBuscar;

   @FXML
   private Button btnImprimirMatricula;

   @FXML
   private Button btnVaciarTabla;

   @FXML
   private TableColumn<?, ?> colModulosAMatricular;

   @FXML
   private TableView<?> tblTablaModulo;

   @FXML
   private TextField txfDniAlumno;

   @FXML
   private TextField txfIdModulo;

    //InstitutoController -> Controlador principal de la aplicación (para llamarlo)
    protected InstitutoController institutoController;
    
    public void setInstitutoController(InstitutoController controller){
        this.institutoController = controller;
    }

   @FXML
   void anyadirMatricula(MouseEvent event) {

   }

   @FXML
   void buscar(MouseEvent event) {

   }

   @FXML
   void imprimirMatricula(MouseEvent event) {

   }

   @FXML
   void vaciarTabla(MouseEvent event) {

   }
}
