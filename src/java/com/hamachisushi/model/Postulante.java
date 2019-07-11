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
public class Postulante {

  private int id;
  private String nombre;
  private String correo;
  private String curriculm;
  private String telefono;
  private String descripcion;

  public Postulante(String nombre, String correo, String curriculum,
          String telefono, String descripcion) {
    this.nombre = nombre;
    this.correo = correo;
    this.curriculm = curriculum;
    this.telefono = telefono;
    this.descripcion = descripcion;
  }

  public Postulante(int id, String nombre, String correo, String curriculm, String telefono, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.curriculm = curriculm;
    this.telefono = telefono;
    this.descripcion = descripcion;
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

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getCurriculm() {
    return curriculm;
  }

  public void setCurriculm(String curriculm) {
    this.curriculm = curriculm;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
