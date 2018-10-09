/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *
 * @author windiurno
 */
public class ValidacionInterna {
    
    public static void main(String[] args) {
        
        String rutaXML="Ah.xml";
        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            factory.setValidating(true);
            SAXParser parser=factory.newSAXParser();
            XMLReader reader=parser.getXMLReader();
            reader.setErrorHandler(new SimpleErrorHandler());
            reader.parse(new InputSource(rutaXML));
        }catch(ParserConfigurationException e) {
            System.out.println(e);
        }catch(SAXException e) {
            System.out.println(e);
        }catch(IOException e) {
            System.out.println(e) ;
        }
    }
}
