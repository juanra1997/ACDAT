/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearXML;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Juanra
 */
public class LeerBufferedReader {
    
    public static void main(String[] args){
        
        FileReader fe = null;
		try {
			fe = new FileReader("num.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try (BufferedReader bs = new BufferedReader(fe);){
			String lector=bs.readLine();
			while (lector != null) {
                            //int lectori=Integer.parseInt(lector);
				System.out.println(lector);
				lector=bs.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
		} catch (IOException e1) {
			System.out.println("Error en la lectura");
		}
    }
}
