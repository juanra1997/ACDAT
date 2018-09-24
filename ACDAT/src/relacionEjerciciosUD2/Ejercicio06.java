/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Juanra
 */
public class Ejercicio06 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero con su extension");
        String ruta=sc.nextLine();
        File archivo=new File(ruta);
        System.out.println("Introduce el texto a escribir en el fichero");
        String escritura=sc.nextLine();
        escribir(escritura, archivo);
        leer(archivo);
        sc.close();
    }
    
    public static void leer(File archivo){
        try (FileReader fs = new FileReader(archivo);){
            int lector=fs.read(); 
            while(lector != -1) {
                if(Character.isAlphabetic((char)lector)){
                    if(Character.isUpperCase((char)lector)){
                        System.out.print(Character.toLowerCase((char)lector));
                    } else {
                        System.out.print(Character.toUpperCase((char)lector));
                    }
                } else {
                    System.out.print((char)lector);
                }
                lector=fs.read();
            }
        } catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
        } catch (IOException e1) {
			System.out.println("Error de escritura");
        }
    }
    
    public static void escribir(String escritura, File archivo) {
        
        try (FileWriter fs = new FileWriter(archivo);){
            fs.write(escritura);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
	} catch (IOException e1) {
            System.out.println("Error de escritura");
	}
    }
}

//C:\Users\Juanra\Desktop\prueba.txt