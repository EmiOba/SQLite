module es.etg.daw.prog.prueba {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens es.etg.daw.prog.prueba.view to javafx.fxml;
    opens es.etg.daw.prog.prueba.controller to javafx.graphics, javafx.fxml;

    exports es.etg.daw.prog.prueba;
    
}
