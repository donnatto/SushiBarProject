/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.daos;

import com.hamachisushi.connexion.ConexionBD;
import com.hamachisushi.model.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class EmpleadoDAO {

  private static PreparedStatement pstm = null;
  private static ResultSet res = null;
  private static ConexionBD con = ConexionBD.instanciar();
  private static final String SQL_VALIDATE = "select * from empleado where codigoEmpleado=? and nombre=? and apellido=?";

  public boolean validar(Empleado emp) {
    boolean result = false;
    try {

      pstm = con.getCon().prepareStatement(SQL_VALIDATE);
      pstm.setString(1, emp.getCodigoEmpleado());
      pstm.setString(2, emp.getNombre());
      pstm.setString(3, emp.getApellido());
      res = pstm.executeQuery();
      while(res.next()) {
        result = true;
      }

    } catch (Exception e) {
      System.out.println("Error al validar :" + e.getMessage());
      e.printStackTrace();
    } finally {
      cerrarConexion();
    }

    return result;
  }

  private void cerrarConexion() {
    try {
      if (res != null) {
        res.close();
      }
      if (pstm != null) {
        pstm.close();
      }
      if (con != null) {
        con.cerrarConexion();
      }
    } catch (Exception e) {
    }

  }

}
