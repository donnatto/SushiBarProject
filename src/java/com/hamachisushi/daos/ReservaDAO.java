/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hamachisushi.connexion.ConexionBD;
import com.hamachisushi.interfaces.OperacionesBD;
import com.hamachisushi.model.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class ReservaDAO {

  private static final String sql_insertReserva = "insert into Reserva "
          + "(nombre, apellidos, fecha, hora, comensales, nro_Contacto, correo, estado)"
          + " values(?,?,?,?,?,?,?,?)";
  private PreparedStatement pstm = null;
  private ResultSet res = null;
  private ConexionBD con = ConexionBD.instanciar();

  public boolean sql_insert(Reserva t) {
    boolean result = false;
    try {
      pstm = con.getCon().prepareStatement(sql_insertReserva);
      pstm.setString(1, t.getNombre());
      pstm.setString(2, t.getApellido());
      pstm.setString(3, t.getFecha());
      pstm.setString(4, t.getHora());
      pstm.setString(5, Integer.toString(t.getComensales()));
      pstm.setString(6, t.getTelefono());
      pstm.setString(7, t.getCorreo());
      pstm.setString(8, Integer.toString(t.getEstado()));

      if (pstm.executeUpdate() > 0) {
        result = true;
      }

    } catch (Exception e) {
      System.out.println("Error al insertar :" + e.getMessage());
      e.printStackTrace();
    } finally {
      cerrarConexiones();
    }
    return result;
  }

  private void cerrarConexiones() {

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
      System.out.println("Error de Cierre :" + e.getMessage());
      e.printStackTrace();
    }
  }

  
}
