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
public class ObtenerMetadatosTablas {

    //Para poder crear tablas, tenemos que conectarnos a la base de datos. Por lo tanto vamos a conectarnos
    //Creamos el objeto que nos dara la conexion
    static private Connection con;
    //Creamos el objeto que nos guardara el resultado de la consulta
    static private ResultSet result;
    //Creamos el objeto que nos proporcionara los datos
    static DatabaseMetaData dbmd;
    //Creamos los objetos para guardar los datos
    static String nombre, driver, url_name, usuario, nombreCol, tipoCol, tamCol, nula, pkDep, separador, fk_name, pk_name, fk_table, pk_table, proc_name, proc_type;

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
            //Seleccionamos en el segundo campo la base de datos y en el tercer campo la tabla de la que queremos obtener los datos
            result = dbmd.getColumns(null, "instituto", "alumno", null);
            while (result.next()) {

                nombreCol = result.getString(4); /* o .getString("COLUMN_NAME") */

                tipoCol = result.getString(6); /* o .getString("TYPE_NAME") */

                tamCol = result.getString(7); /* o .getString("COLUMN_SIZE") */

                nula = result.getString(18); /* o .getString("IS_NULLABLE") */

                System.out.println(" Columna: " + nombreCol + ", Tipo: " + tipoCol + ", Tamaño: " + tamCol + ", ¿Puede ser Nula?: " + nula);
            }
            System.out.println();

            //Aqui obtenemos las llaves primarias, seleccionamos en el segundo campo la base de datos y en el tercero la tabla
            
            result = dbmd.getPrimaryKeys(null, "instituto", "alumno");
            pkDep = "";
            separador = "";
            while (result.next()) {
                pkDep += separador + result.getString("COLUMN_NAME"); /* o .getString(4) */

                separador = "+";
            }
            System.out.println("Clave primaria: " + pkDep + "\n");

            //Aqui obtenemos las llaves foraneas, seleccionamos en el segundo campo la base de datos y en el tercero la tabla
            result = dbmd.getExportedKeys(null, "instituto", "alumno");
            while (result.next()) {
                fk_name = result.getString("FKCOLUMN_NAME");
                pk_name = result.getString("PKCOLUMN_NAME");
                fk_table = result.getString("FKTABLE_NAME");
                pk_table = result.getString("PKTABLE_NAME");
                System.out.println("Clave ajena: " + fk_name + " en la tabla " + fk_table);
                System.out.println("Clave primaria: " + pk_name + " en la tabla " + pk_table);
            }
            System.out.println();
            
            //Aqui obtenemos los procedimientos almacenados de la base de datos, seleccionamos en el segundo campo la base de datos
            result = dbmd.getProcedures(null, "instituto", null);
            while (result.next()) {
                proc_name = result.getString("PROCEDURE_NAME");
                proc_type = result.getString("PROCEDURE_TYPE");
                System.out.println("Nombre Procedimiento: " + proc_name + " -Tipo "
                        + proc_type);
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
