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
        File ficheroIn=new File("num.txt");
        File ficheroOut=new File("prueba.xml");
        
        //RandomAccessFile file=new RandomAccessFile(ficheroIn, "r");//Fichero de accesso aleatorio
        
        Source source;//Fuente para la transformación del XML
        Result result;//Resultado de la transformación XML
        
        int id,salario, posicion;
        String apellido = new String(), departamento;
        
        //Para la creación del parser
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try{
            //builder=factory.newDocumentBuilder();
            RandomAccessFile file=new RandomAccessFile(ficheroIn, "r");//Fichero de accesso aleatorio
            //Obtenemos un procesador o parser XML
            DocumentBuilder builder=factory.newDocumentBuilder();
            //Implementacion para Dom
            DOMImplementation implementation = builder.getDOMImplementation();
            
            //Creacion del dcumento
            Document document = implementation.createDocument(null, "Numeros", null);
            document.setXmlVersion("1.0");
            
            //------------------------------------------------------------------
            //Element raiz = document.createElement("Numero");
            //document.getDocumentElement().appendChild(raiz);
            //CrearElemento("id", Integer.toString(id), raiz, document);
            //------------------------------------------------------------------
            //Posicion para comienzo de lectura
            posicion = 0;
            
            while(posicion < file.length()){
                //Nos posicionamos
                file.seek(posicion);
                //Obtener id empleado
                id = file.readInt();
                //Lectura del apellido
                apellido = file.readUTF();
                //Lectura de departamento
                departamento = file.readUTF();
                //Lectura departamente
                salario = file.readInt();
                
                if(id > 0){
                    //Creacion de un elemento que hace de raiz
                    Element raiz = document.createElement("Empleado");
                    //Posicionamiento de la raiz
                    document.getDocumentElement().appendChild(raiz);
                    //Añadimos sub elementos y sus valores
                    //Creacion del elemento id
                    CrearElemento("id", Integer.toString(id), raiz, document);
                    //Creacion del elemento apellido
                    CrearElemento("apellido", apellido, raiz, document);
                    //Creacion del elemento departamento
                    CrearElemento("departamento", departamento, raiz, document);
                    //Creacion del elemto Salario
                    CrearElemento("salario", Integer.toString(salario), raiz, document);
                }
                //Cambio de la posicion
                posicion = posicion + 122;
            }
            
            //Una vez creada la estructura
            //Creacion del fichero de salida
            source = new DOMSource(document);
            result = new StreamResult(ficheroOut);
            
            //Objeto para realizar la transformacion
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            file.close();
        }catch(IOException io){
            System.out.println("error de lectura escritura");
            io.printStackTrace();
        }catch(Exception ex){
            System.out.println("error");
            ex.printStackTrace();
        }
    }
    /**
     * metodo que introduce los valores de los elementos hoja
     * @param dato
     * @param valor
     * @param raiz
     * @param document 
     */
    private static void CrearElemento(String dato,String valor,Element raiz, Document document){
        //Creacion del hijo
        Element elem = document.createElement(dato);
        //Damos valor
        Text text = document.createTextNode(valor);
        //Pegamos el element hijo a la raiz
        raiz.appendChild(elem);
        //Pegamos el valor
        elem.appendChild(text);
    }
}