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
    private static final String SQL_INSERT = "insert into usuario values (?, ?, ?, ?, ?)";
    
    public Usuario login(Usuario usuario){
        Usuario usuario1 = null;
        try {
            pstm = con.getCon().prepareStatement(SQL_LOGIN);
            pstm.setString(1,usuario.getCorreo());
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
    
    public boolean register(Usuario u) {
        
        boolean result = false;
        try {
            
             pstm=con.getCon().prepareStatement(SQL_INSERT);
             pstm.setString(1, u.getNombre());
             pstm.setString(2, u.getApellido());
             pstm.setString(3, u.getCorreo());
             pstm.setString(4, u.getArea());
             pstm.setString(5, u.getClave());
                         
             if(pstm.executeUpdate()>0){
              result=true;
             }
            
        } catch (Exception e) {
            System.out.println("Error al insertar :"+e.getMessage());
            e.printStackTrace();
        }
        finally{
         cerrarConexion();
        }
        return result;
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
