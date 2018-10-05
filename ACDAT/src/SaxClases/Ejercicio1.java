/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaxClases;

import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Juanra
 */
public class Ejercicio1 {
    
    static ArrayList<Libro> array=new ArrayList<>();
    
    public static void main(String[] args){
        try {
            
            XMLReader procesadorXML=XMLReaderFactory.createXMLReader();
            GestionContenido1 gestor=new GestionContenido1();
            procesadorXML.setContentHandler(gestor);
            
            InputSource fileXML=new InputSource("xmlLibros.xml");
            procesadorXML.parse(fileXML);   
            
            array=GestionContenido1.getArray();
            
            System.out.println("Ejercicio 1: ISBN Impares\n");
            
            for(int i=0; i<array.size(); i++){
                
                if(Integer.parseInt(array.get(i).getISBN())%2!=0){
                    System.out.println("Libro: "+(i+1));
                    System.out.println("Titulo: "+array.get(i).getTitulo());
                    System.out.println("ISBN: "+array.get(i).getISBN());
                    System.out.println();
                }
            }  
        } catch (SAXException ex) {
            
            System.out.println("ERROR: SAX");  
        } catch (IOException ex) {
            
            System.out.println("ERROR: IO");
        }
    }
}
class GestionContenido1 extends DefaultHandler {
    
    private String titulo, editorial, ISBN, pag;
    private int cont=0;
    static ArrayList<Libro> array=new ArrayList<>();
    
    public GestionContenido1(){
        
        super();
    }
    
    @Override
    public void startDocument() throws SAXException {

    }
    
    @Override
    public void endDocument() throws SAXException {

    }
    
    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) throws SAXException {
        
        for(int i=0;i<atts.getLength();i++){  
            if(cont==1){
                ISBN=atts.getValue(i);
            } 
        }
        cont++;
    }
    
    @Override
    public void endElement(String uri, String nombre, String nombreC) throws SAXException {
        
        if(cont==5){
            array.add(new Libro(titulo, ISBN, pag, editorial));
            cont=1;
        }
    }
    
    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        
        String car=new String(ch, inicio, longitud);
        car=car.replaceAll("[\t\n]", "");//Quitamos los saltos de linea
        //car=car.replaceAll(" ", "");//Quitamos espacios en blanco
        if(!car.isEmpty()){
            if(cont==3){
                titulo=car;
            }
            if(cont==4){
                car=car.replaceAll(" ", "");//Quitamos espacios en blanco
                pag=car;
            }
            if(cont==5){
                car=car.replaceAll(" ", "");//Quitamos espacios en blanco
                editorial=car;
            }
        }  
    }

    public static ArrayList<Libro> getArray() {
        return array;
    }
}

class Libro {
    
    private String titulo, editorial, pag, ISBN;
    
    public Libro(String titulo, String ISBN, String pag, String editorial){
        
        this.titulo=titulo;
        this.ISBN=ISBN;
        this.pag=pag;
        this.editorial=editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPag() {
        return pag;
    }

    public void setPag(String pag) {
        this.pag = pag;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
