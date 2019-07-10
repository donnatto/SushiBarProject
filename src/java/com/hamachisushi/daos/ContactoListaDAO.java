/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.daos;

import com.hamachisushi.connexion.ConexionBD;
import com.hamachisushi.interfaces.OperacionesBD;
import com.hamachisushi.model.Contacto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ContactoListaDAO implements OperacionesBD<Contacto> {

  private static final String SQL_SelectAll = "select * from Contacto";
  private static final String SQL_Eliminar = "delete from Contacto where idContacto=?";
  private PreparedStatement pstm = null;
  private ResultSet res = null;
  private ConexionBD con = ConexionBD.instanciar();

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

  @Override
  public ArrayList<Contacto> selectAll() {
    ArrayList<Contacto> lista = new ArrayList<>();
    try {
      pstm = con.getCon().prepareStatement(SQL_SelectAll);
      res = pstm.executeQuery();
      if (res != null) {
        while (res.next()) {
          lista.add(new Contacto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)
          ));
        }
      } else {
        lista = null;
      }
    } catch (Exception e) {
    } finally {
      cerrarConexiones();
    }
    return lista;
  }

  @Override
  public Object updateEstado(Object id, Object estado) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Boolean eliminarMensaje(Object id) {
    Boolean resultado = false;
    try {
      pstm = con.getCon().prepareStatement(SQL_Eliminar);
      pstm.setInt(1, Integer.parseInt((String) id));
      if (pstm.executeUpdate() > 0) {
        resultado = true;
        return resultado;
      }
    } catch (Exception e) {
      System.out.println("Error" + e.getMessage());
    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
        if (con != null) {
          con.cerrarConexion();
        }
      } catch (SQLException ex) {
        Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return resultado;
  }

}
