/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanra
 */
public class Ejercicio04 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat formater=new SimpleDateFormat("dd/MM/yyyy");
        Date inicio=new Date();
        Date fin=new Date();
        System.out.println("Introduce la fecha de inicio en formato dd/mm/aaaa")
            ;
        String fechaInicio=sc.nextLine();
        try {
            inicio = formater.parse(fechaInicio);
        } catch (ParseException ex) {
            /*Logger.getLogger(Ejercicio04.class.getName()).log(Level.SEVERE,
            null, ex);*/
        }
        System.out.println("Introduce la fecha de fin en formato dd/mm/aaaa");
        String fechaFin=sc.nextLine();
        try {
            fin = formater.parse(fechaFin);
        } catch (ParseException ex) {
            /*Logger.getLogger(Ejercicio04.class.getName()).log(Level.SEVERE,
            null, ex);*/
        }
        System.out.println("Introduce el directorio de los ficheros modificados"
            );
        String ruta=sc.nextLine();
        File archivo=new File(ruta);
        String[] prueba=archivo.list();
        System.out.println("***************************************************"
            +"\nEstos archivos han sido modificados entre las fechas indicada"
                + "s:");
        for(int i=0; i<prueba.length; i++){
        File temp=new File(ruta+"\\"+prueba[i]);
        if(temp.lastModified()>inicio.getTime()&&temp.lastModified()
            <fin.getTime()&&temp.isFile()){
        System.out.println(temp.getName());
            }
        }
        System.out.println("*************************************************"
            + "**");
        sc.close();
    }
}
