/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.model;

/**
 *
 * @author ASUS
 */
public class Empleado {

  private String codigoEmpleado;
  private String nombre;
  private String apellido;

  public Empleado(String codigoEmpleado, String nombre, String apellido) {
    this.codigoEmpleado = codigoEmpleado;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public String getCodigoEmpleado() {
    return codigoEmpleado;
  }

  public void setCodigoEmpleado(String codigoEmpleado) {
    this.codigoEmpleado = codigoEmpleado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

}
