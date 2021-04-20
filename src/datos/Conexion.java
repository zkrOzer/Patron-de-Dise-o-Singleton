/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krOzer
 */
public class Conexion {
    
    private static Connection coneccion;
    private static int numConexiones;
    private static Conexion conexion;
    
    
    public Conexion(String url, String usuario, String password){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        try{
            coneccion = (Connection) DriverManager.getConnection(url,usuario,password);
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    
    public static Conexion getConexion(String url, String usuario, String password){
        numConexiones++;
        if(coneccion == null){
            conexion = new Conexion(url, usuario, password);
        }
        return conexion;
    }
    
    public static Connection getConeccion(){
        return coneccion;
    }
    
    public boolean cerrarConexion(){
        try{
            if(coneccion != null)
                if(numConexiones==1){
                    coneccion.close();
                    return true;
                }
            else
                    numConexiones--;
            return false;
        }
        catch(SQLException e){
            System.err.println("Error al tratar de cerrar la conexion");
        }
        return false;
    }
    }

