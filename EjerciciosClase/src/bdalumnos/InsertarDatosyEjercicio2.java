/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdalumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juanra
 */
public class InsertarDatosyEjercicio2 {
    
    static private Connection con=null;
    static private Statement sentencia=null;
    
    public static void main(String[] args){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/alumnos?user=root&password=juanra&useSSL=false";  
            con = (Connection) DriverManager.getConnection(connectionUrl);
            System.out.println("Conexion establecida con exito");
            
            sentencia=con.createStatement();
            
            sentencia.executeUpdate("INSERT INTO alumno VALUES('23334373E', 'JUAN RAUL', 21, 'NO'), ('23334374T', 'TANIA', 16, 'NO')");
            
            sentencia.executeUpdate("INSERT INTO asignatura VALUES(1, 'ACDAT', 10, 10), (2, 'PSP', 16, 20)");
            
            sentencia.executeUpdate("INSERT INTO matricula VALUES('23334373E', 1, 4, 4), ('23334374T', 2, 10, 1)");
            
            System.out.println("Introduccion de datos correcta");
            
            sentencia.execute("create procedure alumnossinconvocatoria() begin select alumno.nombre as alumno, asignatura.nombre as asignatura from alumno, asignatura, matricula where alumno.dni=matricula.dni and asignatura.asg=matricula.asg and matricula.nota<5 and nconvocatoria=4; end");
            
            System.out.println("Procedimiento creado");
            
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
            if(sentencia!=null){
                try{
                    con.close();
                    System.out.println("Sentencia cerrada con exito");
                } catch(SQLException ex){
                    
                }
            }
        }
    }
}
