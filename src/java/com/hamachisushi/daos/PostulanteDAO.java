/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.daos;

import com.hamachisushi.connexion.ConexionBD;
import com.hamachisushi.model.Postulante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class PostulanteDAO {
    
    private static final String sql_insertPostulante="insert into Postulante "
            + "values(?,?,?,?)";
    
    private PreparedStatement pstm=null;
    private ResultSet res=null;
    private ConexionBD con = ConexionBD.instanciar();
    
    public boolean sql_insert(Postulante t) {
        boolean result = false;
        try {
             pstm=con.getCon().prepareStatement(sql_insertPostulante);
             pstm.setString(1, t.getNombre());
             pstm.setString(2, t.getCorreo());
             pstm.setString(3, t.getTelefono());
             pstm.setString(4, t.getDescripcion());
                       
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
