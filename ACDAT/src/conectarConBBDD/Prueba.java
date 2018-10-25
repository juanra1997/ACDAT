/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarConBBDD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Prueba {

    //private static final String url = "jdbc:mysql://localhost/sys", user = "root", password = "juanra";//&useSSL=false";
    static private Connection con;
    static private Statement sentencia;

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String connectionUrl = "jdbc:mysql://localhost/empresa?user=root&password=juanra&useSSL=false";

            con = (Connection) DriverManager.getConnection(connectionUrl);

            System.out.println("Conexion establecida con exito");

            sentencia = con.createStatement();
            System.out.println("Sentencia creada con exito");
            int resultado = sentencia.executeUpdate("CREATE OR REPLACE VIEW totales(dep,dnombre,nemp,media) AS SELECT d.dept_no, dnombre, COUNT(emp_no),AVG(salario) FROM departamentos d LEFT JOIN empleados e ON e.dept_no=d.dept_no GROUP BY d.dept_no, dnombre");
            System.out.println("************************ Resultado: " + resultado + " ************************");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exception: " + cE.toString());
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexion cerrada con exito");
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
        }
    }
}
