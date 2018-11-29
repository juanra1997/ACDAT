/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import com.mysql.jdbc.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juanra
 */
public class ObtenerMetadatos {

    //Para poder crear tablas, tenemos que conectarnos a la base de datos. Por lo tanto vamos a conectarnos
    //Creamos el objeto que nos dara la conexion
    static private Connection con;
    //Creamos el objeto que nos guardara el resultado de la consulta
    static private ResultSet result;
    //Creamos el objeto que nos proporcionara los datos
    static DatabaseMetaData dbmd;
    //Creamos los objetos para guardar los datos
    static String nombre, driver, url_name, usuario, catalogo, esquema, tabla, tipo;

    //Todos los objetos que creemos tenemos que cerrarlos en el finally
    public static void main(String[] args) {

        try {

            //Cargar el driver de mysql
            Class.forName("com.mysql.jdbc.Driver");

            //Cadena de conexion para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada 'instituto'
            //con usuario y contraseña del servidor de MySQL: root y juanra(en mi caso)
            String connectionUrl = "jdbc:mysql://localhost/instituto?user=root&password=juanra&useSSL=false";

            //Obtener la conexion
            con = (Connection) DriverManager.getConnection(connectionUrl);

            System.out.println("Conexion establecida con exito");
            //------------------------------------------------------------------
            //Cuando nos hayamos conectado, procedemos a obtener los datos
            //Obtenemos los datos de la base de datos
            dbmd = con.getMetaData();
            nombre = dbmd.getDatabaseProductName();
            driver = dbmd.getDriverName();
            url_name = dbmd.getURL();
            usuario = dbmd.getUserName();
            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println("===================================");
            System.out.println("Nombre: " + nombre);
            System.out.println("Driver: " + driver);
            System.out.println("URL: " + url_name);
            System.out.println("Usuario: " + usuario + "\n");
            result = dbmd.getTables(null, "instituto", null, null);
            while (result.next()) {
                catalogo = result.getString(1); /*result.getString(“TABLE_CAT”);*/
                esquema = result.getString(2);  /*result.getString(“TABLE_SCHEM”);*/
                tabla = result.getString(3);    /*result.getString(“TABLE_NAME”);*/
                tipo = result.getString(4);     /*result.getString(“TABLE_TYPE”);*/

                System.out.println(tipo + " -Catálogo: " + catalogo + ", Esquema: " + esquema + ", Nombre: " + tabla);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exception: " + cE.toString());
        } finally {
            if (result != null) {
                try {
                    result.close();
                    System.out.println("Result cerrado con exito");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada con exito");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
