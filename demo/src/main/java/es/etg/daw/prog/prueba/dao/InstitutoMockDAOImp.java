package es.etg.daw.prog.prueba.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.prog.prueba.model.Alumno;

public class InstitutoMockDAOImp implements InstitutoDAO{
   private Connection conn;

   @Override
   public Connection connect() throws Exception {
      return null;
   }

   @Override
   public void crearTablaAlumno() throws SQLException {
      final String SQL = "CREATE TABLE Alumno (" +
                        " dni VARCHAR(100) PRIMARY KEY," + 
                        "nombre VARCHAR(100)," +
                        "apellidos VARCHAR(255)," +
                        "edad DATE"+
                        ")";
      Statement st = conn.createStatement();
      st.execute(SQL);
      st.close();
   }

   @Override
   public int insertar(List<Alumno> alumnos) throws SQLException {
   alumnos.add(new Alumno(null, null, null, 0));
   return alumnos.size();
   }

   @Override
   public int insertar(Alumno alumno) throws SQLException {
      return 1;
   }

   @Override
   public int actualizar(Alumno alumno) throws SQLException {
      return 2;
   }

   @Override
   public int borrar(Alumno alumno) throws SQLException {
   return 1;
   
   }

   @Override
   public List<Alumno> listar() throws SQLException {
      List<Alumno> alumnos = new ArrayList<>();
      alumnos.add(new Alumno("test1","test1", "test1", 20));
      alumnos.add(new Alumno("test2","test2", "test2", 21));
      return alumnos;
   }

   @Override
   public List<Alumno> listar(int edad) throws SQLException {
   List<Alumno> alumnos = new ArrayList<>();
   Alumno alumno = new Alumno("test3", "test3", "test3", 23);
   alumnos.add(alumno);
   edad = alumno.getEdad();
   return alumnos;
   
   }
   
}
