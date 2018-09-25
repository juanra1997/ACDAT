/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearXML;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
/**
 *
 * @author windiurno
 */
public class Ejemplo01 {
    
    public static void main(String[] args) throws IOException {
        //Rutas de los ficheros en disco origen y destino
        File ficheroIn=new File("AleatorioEmple.dat");
        File ficheroOut=new File("Empleados.xml");
        
        RandomAccessFile file=new RandomAccessFile(ficheroIn, "r");//Fichero de accesso aleatorio
        
        Source source;//Fuente para la transformación del XML
        Result result;//Resultado de la transformación XML
        
        int id, dep, posicion;
        double salario;
        char apellido[]=new char[10], aux;
        
        //Para la creación del parser
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try{
            //Obtenemos un procesador o parser XML
            DocumentBuilder builder=factory.newDocumentBuilder();
            //Obtenemos una implementación para DOM
            //Creamos un documento vacío con el nodo raíz de nombre Empleados
            //Doc-----------------------------------------------------------------------------------------
        } catch(Exception ex){//Captura de las diferentes excepciones que se pueden originar
            System.err.println("Error: "+ex);
        }
    }
}
