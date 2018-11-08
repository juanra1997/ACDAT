package ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juanra
 */
public class ConversionDOM {

    private static ObjectInputStream fs;

    public static void main(String[] args) {
        File ficheroIn = new File("Departamentos.dat");
        File ficheroOut = new File("DepartamentosDOM.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Source source = null;
        Result result = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Departamentos", null);
            document.setXmlVersion("1.0");
            Element raiz = document.getDocumentElement();
            try {
                fs = new ObjectInputStream(new FileInputStream(ficheroIn));
                Departamento leido = new Departamento();
                leido = (Departamento) fs.readObject();
                do {
                    Element itemNode = document.createElement("Departamento");
                    //itemNode.setAttribute("ID", leido.getId());

                    Element id = document.createElement("ID");
                    Text valorid = document.createTextNode(leido.getId());
                    id.appendChild(valorid);
                    itemNode.appendChild(id);
                    
                    Element tipo = document.createElement("Tipo");
                    Text valortipo = document.createTextNode(leido.getTipo());
                    tipo.appendChild(valortipo);
                    itemNode.appendChild(tipo);

                    Element nombre = document.createElement("Nombre");
                    Text valornombre = document.createTextNode(leido.getNombre());
                    nombre.appendChild(valornombre);
                    itemNode.appendChild(nombre);

                    Element domicilio = document.createElement("Domicilio");
                    Text valordomicilio = document.createTextNode(leido.getDomicilio());
                    domicilio.appendChild(valordomicilio);
                    itemNode.appendChild(domicilio);

                    Element ciudad = document.createElement("Ciudad");
                    Text valorciudad = document.createTextNode(leido.getCiudad());
                    ciudad.appendChild(valorciudad);
                    itemNode.appendChild(ciudad);

                    Element cp = document.createElement("CP");
                    Text valorcp = document.createTextNode(leido.getCp());
                    cp.appendChild(valorcp);
                    itemNode.appendChild(cp);

                    Element provincia = document.createElement("Provincia");
                    Text valorprovincia = document.createTextNode(leido.getProvincia());
                    provincia.appendChild(valorprovincia);
                    itemNode.appendChild(provincia);

                    Element pais = document.createElement("Pais");
                    Text valorpais = document.createTextNode(leido.getPais());
                    pais.appendChild(valorpais);
                    itemNode.appendChild(pais);

                    raiz.appendChild(itemNode);

                    source = new DOMSource(document);
                    result = new StreamResult(ficheroOut);

                    leido = (Departamento) fs.readObject();
                } while (true);
            } catch (EOFException eof) {
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: Problema al leer objeto");
            } catch (FileNotFoundException e1) {
                System.out.println("ERROR: Archivo no encontrado");
            } catch (IOException e1) {
                System.out.println("ERROR: Problema en la lectura");
            } finally {
                try {
                    fs.close();
                } catch (IOException e) {

                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
    }
}
