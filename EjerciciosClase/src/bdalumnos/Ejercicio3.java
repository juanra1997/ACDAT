/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdalumnos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juanra
 */
public class Ejercicio3 {
    
    static private Connection con=null;
    static private CallableStatement cst = null;
    static private ResultSet result;
    
    public static void main(String[] args){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/alumnos?user=root&password=juanra&useSSL=false";  
            con = (Connection) DriverManager.getConnection(connectionUrl);
            System.out.println("Conexion establecida con exito");
            cst=con.prepareCall("call alumnossinconvocatoria()");
            result=cst.executeQuery();
            System.out.println("Alumno\t\tAsignatura");
            while (result.next()) {
                System.out.println(result.getString(1)+"\t"+result.getString(2));  
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exception: " + cE.toString());
        } finally{
            if(con!=null){
                try{
                    con.close();
                    System.out.println("Conexion cerrada con exito");
                } catch(SQLException ex){
                    
                }
            }
            if(cst!=null){
                try{
                    cst.close();
                    System.out.println("Sentencia llamable cerrada con exito");
                } catch(SQLException ex){
                    
                }
            }
        }
    }
}
