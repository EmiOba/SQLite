module es.etg.daw.prog.prueba {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens es.etg.daw.prog.prueba to javafx.fxml;

    exports es.etg.daw.prog.prueba;
}
