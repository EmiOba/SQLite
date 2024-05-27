package es.etg.daw.prog.prueba;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import es.etg.daw.prog.prueba.dao.InstitutoDAO;
import es.etg.daw.prog.prueba.dao.InstitutoSQLiteDAOImp;

public class InstitutoSQLiteDAOImpTest {
   private InstitutoDAO dao = new InstitutoSQLiteDAOImp();

   @Test
   public void connectTest() throws Exception {
      Connection conn = dao.connect();
      assertNotNull(conn);
   }
}
