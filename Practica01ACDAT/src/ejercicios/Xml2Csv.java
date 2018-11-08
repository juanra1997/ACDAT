/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

/**
 *
 * @author Juanra
 */

public class Xml2Csv {

    public static void main(String args[]) throws Exception {
        File ficheroXSL = new File("DepartamentosXSL.xsl");
        File FicheroXML = new File("DepartamentosDOM.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(FicheroXML);

        StreamSource streamSource = new StreamSource(ficheroXSL);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(streamSource);
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File("DepartamentosCSV.csv"));
        transformer.transform(source, result);
    }
}