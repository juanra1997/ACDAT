/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author windiurno
 */
public class Ejemplo{
    
    public static void main(String[] args){
        try {
            //Crear el procesador/analizador (el que lee el xml)
            XMLReader procesadorXML=XMLReaderFactory.createXMLReader();
            GestionContenido gestor=new GestionContenido();
            procesadorXML.setContentHandler(gestor);
            
            InputSource fileXML=new InputSource("Ah.xml");
            procesadorXML.parse(fileXML);
        } catch (SAXException ex) {
            //Logger.getLogger(Ejemplo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: SAX");
        } catch (IOException ex) {
            //Logger.getLogger(Ejemplo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: IO");
        }
    }
}
class GestionContenido extends DefaultHandler {
    
    public GestionContenido(){
        
        super();
    }
    
    @Override
    public void startDocument() throws SAXException {
 
        System.out.println("Comienzo del documento XML");
    }
    
    @Override
    public void endDocument() throws SAXException {
        
        System.out.println("Final del documento XML");
    }
    
    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) throws SAXException {
        
        System.out.println("\tPrincipio elemento: "+nombre);
    }
    
    @Override
    public void endElement(String uri, String nombre, String nombreC) throws SAXException {
        
        System.out.println("\tFin elemento: "+nombre);
    }
    
    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        
        String car=new String(ch, inicio, longitud);
        car=car.replaceAll("[\t\n]", "");//Quitamos los saltos de linea
        if(!car.isEmpty()){
            System.out.println("\tCaracteres: " + car);
        }
    }
}