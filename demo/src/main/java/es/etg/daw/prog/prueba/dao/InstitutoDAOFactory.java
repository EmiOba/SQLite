package es.etg.daw.prog.prueba.dao;

public class InstitutoDAOFactory {

   public static InstitutoDAO obtenerDao(Tipo tipo) throws Exception {
      InstitutoDAO dao = null;
      if (tipo == Tipo.MOCK) {
         dao = new InstitutoMockDAOImp();
      } else if (tipo == Tipo.SQLITE) {
         dao = new InstitutoSQLiteDAOImp();
      }
      return dao;
   }
}
