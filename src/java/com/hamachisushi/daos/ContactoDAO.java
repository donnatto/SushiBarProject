/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.daos;

import com.hamachisushi.connexion.ConexionBD;
import com.hamachisushi.model.Contacto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class ContactoDAO {
    
    private static final String sql_insertReserva="insert into contacto"
            + " values(?,?,?,?)";
    
    private PreparedStatement pstm=null;
    private ResultSet res=null;
    private ConexionBD con = ConexionBD.instanciar();
    
    public boolean sql_insert(Contacto t) {
        boolean result = false;
        try {
             pstm=con.getCon().prepareStatement(sql_insertReserva);
             pstm.setString(1, t.getNombre());
             pstm.setString(2, t.getCorreo());
             pstm.setString(3, t.getAsunto());
             pstm.setString(4, t.getMensaje());            
                       
             if(pstm.executeUpdate()>0){
              result=true;
             }
            
        } catch (Exception e) {
            System.out.println("Error al insertar :"+e.getMessage());
            e.printStackTrace();
        }
        finally{
         cerrarConexiones();
        }
        return result;
    }
    
    private void cerrarConexiones(){
    
        try {
            if(res!=null)res.close();
            if(pstm!=null)pstm.close();
            if(con!=null)con.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error de Cierre :"+e.getMessage());
            e.printStackTrace();
        }
    }
}
