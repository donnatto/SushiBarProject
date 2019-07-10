/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.interfaces;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface OperacionesBD <T> {
  public ArrayList<T> selectAll();
  public Object updateEstado(Object id, Object estado);
  public Boolean eliminarMensaje(Object id);
}
