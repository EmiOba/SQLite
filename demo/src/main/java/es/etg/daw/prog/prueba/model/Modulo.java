package es.etg.daw.prog.prueba.model;

public class Modulo {
   private int identificador;
   private String nombre;
   private String descripcion;
   private int horas;
   
   public Modulo(int identificador, String nombre, String descripcion, int horas) {
      this.identificador = identificador;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.horas = horas;
   }
   public int getIdentificador() {
      return identificador;
   }
   public void setIdentificador(int identificador) {
      this.identificador = identificador;
   }
   public String getNombre() {
      return nombre;
   }
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   public String getDescripcion() {
      return descripcion;
   }
   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }
   public int getHoras() {
      return horas;
   }
   public void setHoras(int horas) {
      this.horas = horas;
   }
}
