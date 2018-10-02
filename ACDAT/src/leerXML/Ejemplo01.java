/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerXML;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static java.util.stream.DoubleStream.builder;
import javax.xml.parsers.*;
//import org.xml.sax.SAXException;
import org.w3c.dom.*;;


/**
 *
 * @author Juanra
 */
public class Ejemplo01 {
    
    public static void main(String[] args) throws org.xml.sax.SAXException{
        
        try {
            
            File fileIn=new File("C:\\Users\\windiurno\\Desktop\\prueba.xml");
            //File fichBinario=new File("C:\\Users\\windiurno\\Desktop\\pruebabin.bin");
            //RandomAccessFile r=new RandomAccessFile(fichBinario,"rw");
            Document document;
            DocumentBuilder builder;
            NodeList numeros;
            Node num;
            //Para la creación del parser
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            
            //try {
                builder=factory.newDocumentBuilder();
                document=builder.parse(fileIn);
                document.getDocumentElement().normalize();
                System.out.println("Elemento raíz: "+document.getDocumentElement().getNodeName());
                numeros=document.getElementsByTagName("Numeros");
                for(int i=0; i<numeros.getLength(); i++){
                    num=numeros.item(i);
                    if(num.getNodeType()==Node.ELEMENT_NODE) {
                        //r.write(Integer.parseInt(num.getTextContent()));
                        Element elemento=(Element)num;
                        System.out.println("Numero: "+getNodo("Numeros", elemento));
                    }
                }
            } catch(ParserConfigurationException ex){
                
            } catch(IOException ex){
                
            }
        //} catch(FileNotFoundException ex){
            //Logger.getLogger(Ejemplo01.class.getName()).log(Level.SEVERE, null, ex);
            
        //}
    }
    
    private static String getNodo(String etiqueta, Element element){
        
        System.out.println("Entra");
        NodeList nodo=element.getElementsByTagName("Numero").item(0).getChildNodes();
        Node valorNodo=(Node)nodo.item(0);
        System.out.println(valorNodo.getNodeValue());
        return valorNodo.getNodeValue();
    }
}
