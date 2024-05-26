package es.etg.daw.prog.prueba.dao;

public class InstitutoDAOFactory {
   
   public static InstitutoDAO obtenerDao() throws Exception{
      InstitutoDAO dao = new InstitutoSQLiteDAOImp();
      return dao;
   }
}
