/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarConBBDD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author windiurno
 */
public class ModificarProcedimiento {
    
    private static Connection con;
    private static Statement sentencia;
    private static ResultSet resultado; 
    
    public static void main(String[] args){
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            
            String URL = "jdbc:mysql://localhost/sys?user=root&password=root&useSSL=false";
           
            con = (Connection) DriverManager.getConnection(URL);
            System.out.println("Conexion establecida con exito");
            
            sentencia=con.createStatement();
            System.out.println("Sentencia creada con exito");
            
        } catch(SQLException sqe){
            System.out.println("SQL Excepcion: "+sqe.toString());
        } catch(ClassNotFoundException cnfe){
            System.out.println("Excepcion: "+cnfe.toString());
        }finally{
            if(con!=null){
                try {
                    con.close();
                    System.out.println("Conexion cerrada con exito");
                } catch (SQLException ex) {
                    //Logger.getLogger(ModificarProcedimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             if(sentencia!=null){
                try {
                    sentencia.close();
                    System.out.println("Sentencia cerrada con exito");
                } catch (SQLException ex) {
                    //Logger.getLogger(ModificarProcedimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
