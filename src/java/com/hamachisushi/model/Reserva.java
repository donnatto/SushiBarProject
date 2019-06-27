/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.model;

/**
 *
 * @author Alumno
 */
public class Reserva {

  private int id;
  private String nombre;
  private String apellido;
  private String fecha;
  private String hora;
  private int comensales;
  private String telefono;
  private String correo;
  private int estado;

  public Reserva(String nombre, String apellido, String fecha, String hora, int comensales, String telefono, String correo, int estado) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha = fecha;
    this.hora = hora;
    this.comensales = comensales;
    this.telefono = telefono;
    this.correo = correo;
    this.estado = estado;
  }

  public Reserva(int id, String nombre, String apellido, String fecha, String hora, int comensales, String telefono, String correo, int estado) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha = fecha;
    this.hora = hora;
    this.comensales = comensales;
    this.telefono = telefono;
    this.correo = correo;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public int getComensales() {
    return comensales;
  }

  public void setComensales(int comensales) {
    this.comensales = comensales;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

}
