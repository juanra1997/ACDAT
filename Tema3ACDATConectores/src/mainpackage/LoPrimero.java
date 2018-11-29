/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author Juanra
 */
public class LoPrimero {
    
}
//Lo primero que hay que hacer es añadir la libreria del conector

//Recordar que executeUpdate devuelve un entero en el cual nos indica el numero de columnas afectadas

//Esto es para los preparedStatement
/*
Hay 4 formas de declarar las llamadas a los procedimientos y las funciones que dependen del uso u
omisión de parámetros, y de la devolución de valores. Son las siguientes:
 {call procedimiento}: para un procedimiento almacenado sin parámetros.
 {?= call función}: para una función almacenada que devuelve un valor y no recibe parámetros, el
valor se recibe a la izquierda del igual y es el primer parámetro.
 {call procedimiento (?, ?, ….)}: para un procedimiento almacenado que recibe parámetros.
 {?=call función(?, ?, …..)}: para una función almacenada que devuelve un valor (primer parámetro)
y recibe varios parámetros.
*/


//Un ejemplo


/*
import java.sql.*;
public class Ud3_CallableStatement {
//valores de las variables con los posibles datos de entrada
static int depar=10, subida=5;
/* parámetros de conexión con la base de datos MySql 
private static final String url = "jdbc:mysql://localhost/empresaz";
private static final String user = "root";
private static final String password = "";
public static void main(String[] args) {
/* objeto de conexión 
Connection conexion = null;
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
conexion = DriverManager.getConnection(url, user, password);
/*construir la orden de llamada a procAlmacenado 
String sql="{call subida_salario (?,?)}";
/*1. asignar la llamada al procAlmacenado a una CallableStatement
CallableStatement procAlmacenado = conexion.prepareCall(sql);
/*2. establecer el valor de los parámetros del procedimiento almacenado
procAlmacenado.setInt(1, depar); //primer parámetro
procAlmacenado.setInt(2, subida); //segundo parámetro
/*3. ejecutar el procedimiento almacenado
procAlmacenado.execute();
System.out.println("Subida de sueldo realizada al departamento "+ depar);
/*excepciones
} catch (Exception ex) {
ex.printStackTrace();
}finally{
/*librerar recursos
try {
conexion.close();
} catch (SQLException exq) {
exq.printStackTrace();
}
}
}
}
*/


//Un ejemplo que devuelve un entero


/*
import java.sql.*;
public class Ud3_CallableStatementOUT {
//valores de las variables
static int depar=10, totEmple=0;
/* parámetros de conexión con la base de datos MySql 
private static final String url = "jdbc:mysql://localhost/empresaz";
private static final String user = "root";
private static final String password = "";
public static void main(String[] args) {
/* objeto de conexión 
Connection conexion = null;
/* objeto ResultSet para recoger los registros devueltos 
ResultSet result = null;
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
/* abre la conexión 
conexion = DriverManager.getConnection(url, user, password);
/*construir la orden de llamada al procAlmacenado
String sql="{call emple_depar (?,?)}";
/* 1. asignar la llamada al procAlmacenado a una CallableStatement
CallableStatement procAlmacenado = conexion.prepareCall(sql);
/*2. establecer el valor de los parámetros del procedimiento almacenado
procAlmacenado.setInt(1, depar); //primer parámetro
/*3. registro del parámetro de salida OUT
procAlmacenado.registerOutParameter(2, Types.INTEGER);
/*4. ejecutar el procedimiento almacenado
procAlmacenado.execute();
/*5. Obtener el valor de los parámetros de salida
totEmple=procAlmacenado.getInt(2);
System.out.println("Total de empleados departamento "+ depar +" son: " + totEmple);
/*6 Obtener el ResultSet devuelto
result=procAlmacenado.getResultSet();
/*7. Procesar el resultset
System.out.println("\nNumEmp, apellido, oficio, salario ");
while (result.next()) {
System.out.printf("%4d %-15s %-15s %6.2f \n", result.getInt(1),
result.getString(2), result.getString(3) ,result.getFloat("salario"));
}
/*excepciones
} catch (Exception ex) {
ex.printStackTrace();
}finally{
/*librerar recursos
try {
conexion.close();
} catch (SQLException exq) {
exq.printStackTrace();
}
}
}
}
*/