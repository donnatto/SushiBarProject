/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamachisushi.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alumno
 */
public class ConexionBD {
    
    private static ConexionBD instance=null;
    private static final String url="jdbc:sqlserver://172.17.38.15\\MSSQLSERVER:1433;databaseName=hamachiSushi";
    private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String user="sa";
    private static final String clave="123456";
    private static Connection con=null;
    
    private ConexionBD(){      
        try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, user,clave);
        } catch (Exception e) {
            System.out.println("Error de conexion :"+e.getMessage());
            e.printStackTrace();// DETALLE ERROR Y/O EXCEPCION
        }          
    }
    public synchronized static ConexionBD instanciar(){
        if(instance==null){
        instance = new ConexionBD();
        }
    return instance;
    }

    public  Connection getCon() {
        return con;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
}
