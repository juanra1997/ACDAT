/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.BufferedWriter;
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
public class Ejercicio05 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero a copiar con su "
                + "extension");
        String ruta=sc.nextLine();
        File archivo=new File(ruta);
        System.out.println("Introduce la ruta del fichero donde copiar con su "
                + "extension");
        String ruta1=sc.nextLine();
        File copia=new File(ruta1);
        leer(archivo, copia);
        sc.close();
    }
    
    static int cont=0;
    
    public static void leer(File archivo, File copia){
        try (FileReader fs = new FileReader(archivo);){
            int lector=fs.read(); 
            while(lector != -1) {
                try (FileWriter fs1 = new FileWriter(copia, true);){
                    if(cont==0){
                        try (BufferedWriter bw = new BufferedWriter(fs1)) {
                            bw.newLine();
                        } catch(Exception e4){
                            System.out.println("Error");
                        }
                        cont++;
                    }
                    fs1.write((char)lector);
                    lector=fs.read();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: Archivo no encontrado");
                } catch (IOException e1) {
                    System.out.println("Copiado con exito");
                }
            }
        } catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
        } catch (IOException e1) {
			System.out.println("Error de escritura");
        }
    }
}

//C:\Users\Juanra\Desktop\annade.txt
//C:\Users\Juanra\Desktop\prueba.txt
