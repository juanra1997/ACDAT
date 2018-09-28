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
import org.w3c.dom.*;;

/**
 *
 * @author Juanra
 */
public class Ejemplo02 {
    
    public static void main(String[] args){
        
        File ficheroIn=new File("D:\\2º DAM\\CURSO\\ACDAT\\Ficheros\\num.txt");
        File ficheroOut=new File("D:\\2º DAM\\CURSO\\ACDAT\\Ficheros\\prueba.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        Source source;
        Result result;
        //String id;
        try{
            RandomAccessFile file=new RandomAccessFile(ficheroIn, "r");
            DocumentBuilder builder=factory.newDocumentBuilder();
            DOMImplementation implementation=builder.getDOMImplementation();
            Document document=implementation.createDocument(null, "Numeros", null);
            document.setXmlVersion("1.0");
            
            try(BufferedReader fSalida=new BufferedReader(new FileReader(ficheroIn))){
                String lector;
                while((lector=fSalida.readLine())!=null){
                    Element numero=document.createElement("numero");
                    document.getDocumentElement().appendChild(numero);
                    Text valor=document.createTextNode(lector);
                    numero.appendChild(valor);
                }
            }
                
            source = new DOMSource(document);
            result = new StreamResult(ficheroOut);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            file.close();
        } catch(Exception e){
            
        }
    }
    
    public static void CrearElemento(String nombre, String valor, Document documento){
        
        Element raiz=documento.createElement(nombre);
        documento.getDocumentElement().appendChild(raiz);
        Text text=documento.createTextNode(valor);
        raiz.appendChild(text);
    }
}
