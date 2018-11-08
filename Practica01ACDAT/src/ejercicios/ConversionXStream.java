/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanra
 */
public class ConversionXStream {

    private static ObjectInputStream fs;
    private static Departamentos d;
    private static XStream xstream;

    public static void main(String[] args) {

        xstream = new XStream(new DomDriver());
        File archivo = new File("Departamentos.dat");
        d = new Departamentos();

        xstream.processAnnotations(Departamento.class);
        xstream.processAnnotations(Departamentos.class);
        xstream.addImplicitCollection(Departamentos.class, "lista");

        if (archivo.length() != 0) {
            try {

                fs = new ObjectInputStream(new FileInputStream(archivo));
                Departamento leido = new Departamento();
                leido = (Departamento) fs.readObject();
                do {
                    d.add(leido);
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
        }

        try {
            FileOutputStream fs = new FileOutputStream("DepartamentosXStream.xml");
            xstream.toXML(d, fs);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
