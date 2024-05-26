package es.etg.daw.prog.prueba.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import es.etg.daw.prog.prueba.model.Alumno;

public interface InstitutoDAO {
   
   public Connection connect() throws Exception;

   public void crearTablaAlumno() throws SQLException;

   public int insertar(List<Alumno> alumnos) throws SQLException;

   public int insertar(Alumno alumno) throws SQLException;

   public int actualizar(Alumno alumno) throws SQLException;

   public int borrar(Alumno alumno) throws SQLException;

   public List<Alumno> listar() throws SQLException;

   public List<Alumno> listar(int edad) throws SQLException;
}
