/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class CrearNumeros {
    
    public static void main(String[] args){
        
        File archivo=new File("num.txt");
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                //Logger.getLogger(CrearNumeros.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se ha podido crear el archivo");
            }
        }
        FileWriter fs = null;
        try {
            fs = new FileWriter(archivo);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }	
        try (BufferedWriter bs = new BufferedWriter(fs);){
            //bs.write("Texto de prueba con Buffer de escritura");
           for(int i=1; i<11; i++){
               bs.write(String.valueOf(i));
               bs.newLine();
           }
           bs.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e1) {
            System.out.println("Error de escritura");
        }
    }    
}
