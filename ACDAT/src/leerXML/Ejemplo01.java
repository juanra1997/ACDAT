/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerXML;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import javax.xml.parsers.*;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.*;;


/**
 *
 * @author Juanra
 */
public class Ejemplo01 {
    
    public static void main(String[] args) throws org.xml.sax.SAXException{
        
        File fileIn=new File("D:\\2º DAM\\CURSO\\ACDAT\\Ficheros\\prueba.xml");
        Document document;
        DocumentBuilder builder;
        NodeList numeros;
        Node num;
        //Para la creación del parser
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        
        try {
            builder=factory.newDocumentBuilder();
            document=builder.parse(fileIn);
            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz: "+document.getDocumentElement().getNodeName());
            numeros=document.getElementsByTagName("Numeros");
            for(int i=0; i<numeros.getLength(); i++){
                num=numeros.item(i);
                if(num.getNodeType()==Node.ELEMENT_NODE) {
                    Element elemento=(Element)num;
                    System.out.println("Numero: "+getNodo("Numeros", elemento));
                }
            }
        } catch(ParserConfigurationException ex){
            
        } catch(IOException ex){
            
        }
    }
    
    private static String getNodo(String etiqueta, Element element){
        
        NodeList nodo=element.getElementsByTagName("Numero").item(0).getChildNodes();
        Node valorNodo=(Node)nodo.item(0);
        return valorNodo.getNodeValue();
    }
}
