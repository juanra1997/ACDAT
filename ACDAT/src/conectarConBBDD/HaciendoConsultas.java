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
 * @author Juanra
 */
public class HaciendoConsultas {

    static private Connection con;
    //static private String tabla1="create table departamentos(dept_no tinyint(2) not null primary key, dnombre varchar(15), loc varchar(15))";
    //static private String datos1="insert into departamentos values(10, 'CONTABILIDAD', 'SEVILLA'),(20, 'INVESTIGACION', 'MADRID'),(30, 'PRODUCCION','BARCELONA'),(40, 'VENTAS', 'BILBAO')";
    static private Statement sentencia;
    static private ResultSet result;
    static private String consulta = "select * from departamentos";

    public static void main(String[] args) {

        try {

            //Cargar el driver de mysql
            Class.forName("com.mysql.jdbc.Driver");

            //Cadena de conexion para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada 'test'
            //con usuario y contraseña del servidor de MySQL: root y juanra(en mi caso)
            //-----------------------------------------------------------------------------------
            String connectionUrl = "jdbc:mysql://localhost/empresa?user=root&password=juanra&useSSL=false";
            //-----------------------------------------------------------------------------------

            //Obtener la conexion
            //-----------------------------------------------------------------------------------
            /*Connection*/ con = (Connection) DriverManager.getConnection(connectionUrl);
            //-----------------------------------------------------------------------------------
            // Connection con=(Connection) DriverManager.getConnection(url, user, password);
            //-----------------------------------------------------------------------------------
            System.out.println("Conexion establecida con exito\n");
            //PreparedStatement stmt = con.prepareStatement("create table departamentos(dept_no tinyint(2) not null primary key, dnombre varchar(15), loc varchar(15))");
            /*stmt.execute();
             stmt.close();
             stmt=con.prepareStatement("insert into departamentos values(10, 'CONTABILIDAD', 'SEVILLA'");*/
            sentencia = con.createStatement();
            //sentencia.execute(tabla1);
            //System.out.println("Tabla creada");
            //sentencia.execute(datos1);
            //System.out.println("Datos introducidos");
            result = sentencia.executeQuery(consulta);
            while (result.next()) {
                System.out.printf("%2d %-15s %s\n", result.getInt(1), result.getString("dnombre"), result.getString(3));  
            }
            System.out.println("\nTabla 'departamentos' consultada correctamente\n");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exception: " + cE.toString());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                    System.out.println("Sentencia cerrada con exito");
                } catch (SQLException ex) {

                }
            }
            if (sentencia != null) {
                try {
                    sentencia.close();
                    System.out.println("Sentencia cerrada con exito");
                } catch (SQLException ex) {

                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada con exito");
                } catch (SQLException ex) {

                }
            }
        }
    }
}