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
public class Ejercicio2 {
    
    //static ArrayList<Libro1> array=new ArrayList<>();
    
    public static void main(String[] args){
        try {
            
            System.out.println("Ejercicio 2: Libros con mas de 150 paginas\n");
            
            XMLReader procesadorXML=XMLReaderFactory.createXMLReader();
            GestionContenido gestor=new GestionContenido();
            procesadorXML.setContentHandler(gestor);
            
            InputSource fileXML=new InputSource("xmlLibros.xml");
            procesadorXML.parse(fileXML);   
            
            //array=GestionContenido.getArray();

            //System.out.println("Ejercicio 2: Libros con mas de 150 paginas\n");
            
            /*for(int i=0; i<array.size(); i++){
                
                if(Integer.parseInt(array.get(i).getPag())>150){
                    System.out.println("Libro: "+(i+1));
                    System.out.println("Titulo: "+array.get(i).getTitulo());
                    System.out.println("ISBN: "+array.get(i).getISBN());
                    System.out.println("PAGINAS: "+array.get(i).getPag());
                    System.out.println("EDITORIAL: "+array.get(i).getEditorial());
                    System.out.println();
                }
            }*/
            
        } catch (SAXException ex) {
            
            System.out.println("ERROR: SAX");  
        } catch (IOException ex) {
            
            System.out.println("ERROR: IO");
        }
    }
}
class GestionContenido extends DefaultHandler {
    
    private String titulo, editorial, ISBN, pag, etiqueta;
    //static ArrayList<Libro1> array=new ArrayList<>();
    
    public GestionContenido(){
        
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
        
        etiqueta=nombre;
        if(etiqueta.equals("Libro")){
            for(int i=0;i<atts.getLength();i++){  
                if(atts.getQName(0).equals("ISBN")){
                    ISBN=atts.getValue(0);
                }
            }   
        }
    }
    
    @Override
    public void endElement(String uri, String nombre, String nombreC) throws SAXException {
        
        /*if(nombre.equals("Libro")){
            array.add(new Libro1(titulo, ISBN, pag, editorial));
        }*/
        
    }
    
    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        
        String car=new String(ch, inicio, longitud);
        car=car.replaceAll("[\t\n]", "");//Quitamos los saltos de linea
        if(!car.isEmpty()){
            
            switch(etiqueta){
                case "Titulo":
                    titulo=car;
                    break;
                case "Editorial":
                    editorial=car;
                    if(Integer.parseInt(pag)>150){
                        System.out.println("Titulo: "+titulo);
                        System.out.println("ISBN: "+ISBN);
                        System.out.println("PAGINAS: "+pag);
                        System.out.println("EDITORIAL: "+editorial);
                        System.out.println();
                    }
                    break;
                case "Paginas":
                    pag=car;
                    break;
            }
        }  
    }

    /*public static ArrayList<Libro1> getArray() {
        return array;
    }*/
}

/*class Libro1 {
    
    private String titulo, editorial, pag, ISBN;
    
    public Libro1(String titulo, String ISBN, String pag, String editorial){
        
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
}*/
