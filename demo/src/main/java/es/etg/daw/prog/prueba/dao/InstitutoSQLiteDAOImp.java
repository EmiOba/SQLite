package es.etg.daw.prog.prueba.dao;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.prog.prueba.model.Alumno;

public class InstitutoSQLiteDAOImp implements InstitutoDAO {
   private final String DATABASE_NAME = "/es/etg/daw/prog/prueba/mybasededatos.db";
   private final String JDBC_URL = "jdbc:sqlite:%s";
   private Connection conn;

  // public InstitutoSQLiteDAOImp()throws Exception{
  //    URL resources = InstitutoSQLiteDAOImp.class.getResource(DATABASE_NAME);
  //    String path = new File(resources.toURI()).getAbsolutePath();
  //    String url = String.format(JDBC_URL, path);
  //    conn = DriverManager.getConnection(url);
//
  // }

   @Override
   public Connection connect() throws Exception {
      URL resource = InstitutoSQLiteDAOImp.class.getResource(DATABASE_NAME);
      String path = new File(resource.toURI()).getAbsolutePath(); 
      String url = String.format(JDBC_URL, path);
       /*el método getConnection() de la clase DriverManager. Este método recibe
       como parámetro la URL de JDBC que identifica a la base de 
       datos con la que queremos realizar la conexión.*/
      conn = DriverManager.getConnection(url);
      return conn;
   }

   @Override
   public void crearTablaAlumno() throws SQLException {
      final String SQL = "CREATE TABLE Alumno (" +
                        "nombre VARCHAR(100) PRIMARY KEY," + 
                        "apellidos VARCHAR(255)," + 
                        "edad int " + 
                        ");" ;

      Statement st = conn.createStatement();
      st.execute(SQL);
      st.close();

   }

   @Override
   public int insertar(List<Alumno> alumnos) throws SQLException {
   final String SQL = "INSERT INTO Alumno VALUES ( ?, ?, ?)";
   PreparedStatement ps = conn.prepareStatement(SQL);

   for (Alumno alumno : alumnos) {
      ps.setString(1, alumno.getNombre());
      ps.setString(2, alumno.getApellidos());
      ps.setInt(3, alumno.getEdad());

      ps.addBatch(SQL); // no tiene nada en el ejemplo dentro de los parentecis pero probaremos
   }
   conn.close();
   return alumnos.size();
   
   }

   @Override
   public int insertar(Alumno alumno) throws SQLException {
      int numRegistrosActualizados = 0;
      final String SQL = "INSERT INTO Alumno VALUES (?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(SQL);

      ps.setString(1, alumno.getNombre());
      ps.setString(2, alumno.getApellidos());
      ps.setInt(3, alumno.getEdad());

      numRegistrosActualizados = ps.executeUpdate();
      ps.close();
      return numRegistrosActualizados;
   }

   @Override
   public int actualizar(Alumno alumno) throws SQLException {
      int numRegistrosActualizados = 0 ;
      final String SQL = "UPDATE Alumno SET edad= ? where nombre= ?";
      PreparedStatement ps = conn.prepareStatement(SQL);

      ps.setInt(1, alumno.getEdad());
      ps.setString(2, alumno.getNombre());

      numRegistrosActualizados = ps.executeUpdate();
      ps.close();
      return numRegistrosActualizados;

   }

   @Override
   public int borrar(Alumno alumno) throws SQLException {
      int numRegistrosActualizados = 0;
      final String SQL = "DELETE FROM Alumno where nombre= ?";
      PreparedStatement ps = conn.prepareStatement(SQL);

      ps.setString(1, alumno.getNombre());
      numRegistrosActualizados = ps.executeUpdate();
      ps.close();
      return numRegistrosActualizados;

   }

   @Override
   public List<Alumno> listar() throws SQLException {
      final String SQL = "SELECT nombre, apellido, edad FROM Alumno";
      List<Alumno> alumnos = new ArrayList<>();
      PreparedStatement ps = conn.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
         String nombre = rs.getString("nombre");
         String apellidos= rs.getString("nombre");
         int edad = rs.getInt("edad");

         Alumno alumno = new Alumno(nombre, apellidos, edad);
         alumnos.add(alumno);
      }
      rs.close();
      return alumnos;
   }

   @Override
   public List<Alumno> listar(int edad) throws SQLException {
      final String SQL = "SELECT nombre, apellido, edad FROM Alumno where edad = ?";
      List<Alumno> alumnos = new ArrayList<>();
      PreparedStatement ps = conn.prepareStatement(SQL);
      ps.setInt(1, edad);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
         String nombre = rs.getString("nombre");
         String apellidos = rs.getString("Apellidos");
          edad = rs.getInt("edad");

          Alumno alumno = new Alumno(nombre, apellidos, edad);
          alumnos.add(alumno);
      }
      rs.close();
      ps.close();
      return alumnos;

   }
   public Connection getConn() {
      return conn;
   }

   public void setConn(Connection conn) {
      this.conn = conn;
   }

   
}
