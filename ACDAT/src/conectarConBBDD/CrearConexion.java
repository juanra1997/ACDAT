/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarConBBDD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juanra
 */
public class CrearConexion {

    private static final String url="jdbc:mysql://localhost/sys", user="root", password="juanra";//&useSSL=false";
    static private Connection con;
    
    public static void main(String[] args) {

        try {

            //Cargar el driver de mysql
            Class.forName("com.mysql.jdbc.Driver");

            //Cadena de conexion para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada 'test'
            //con usuario y contraseña del servidor de MySQL: root y juanra(en mi caso)
            //-----------------------------------------------------------------------------------
            String connectionUrl = "jdbc:mysql://localhost/sys?user=root&password=juanra&useSSL=false";
            //-----------------------------------------------------------------------------------
            
            //Obtener la conexion
            //-----------------------------------------------------------------------------------
            /*Connection*/ con = (Connection) DriverManager.getConnection(connectionUrl);
            //-----------------------------------------------------------------------------------
            // Connection con=(Connection) DriverManager.getConnection(url, user, password);
            //-----------------------------------------------------------------------------------
            System.out.println("Conexion establecida con exito");
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
        }
    }
}
