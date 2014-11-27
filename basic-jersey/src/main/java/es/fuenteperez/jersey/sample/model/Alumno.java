package es.fuenteperez.jersey.sample.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alumno")
public class Alumno {
  private String dni;
  private String nombre;
  private String apellidos;
  private String email;
  private String telefono;

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}