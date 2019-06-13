/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hamachisushi.connexion.ConexionBD;
import com.hamachisushi.model.Usuario;
/**
 *
 * @author Alumno
 */
public class UsuarioDAO {
    
    private static PreparedStatement pstm=null;
    private static ResultSet res = null;
    private static ConexionBD con = ConexionBD.instanciar();
    private static final String SQL_LOGIN = "select * from usuario where correo=? and contraseña=? ";
    
    public Usuario login(Usuario usuario){
        Usuario usuario1 = null;
        try {
            pstm = con.getCon().prepareStatement(SQL_LOGIN);
            pstm.setString(1,Integer.toString(usuario.getId()));
            pstm.setString(2,usuario.getClave());
            res = pstm.executeQuery();
            while(res.next()){
            usuario1 = new Usuario(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
            
            }
            
        } catch (Exception e) {
            System.out.println("Error login :"+e.getMessage());
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
     return usuario1;   
    }
    
    private void cerrarConexion(){
        try {
            if(res!=null)res.close();
            if(pstm!=null)pstm.close();
            if(con!=null)con.cerrarConexion();
        } catch (Exception e) {
        }
        
    }
}
