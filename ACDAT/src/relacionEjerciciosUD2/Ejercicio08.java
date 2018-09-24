/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Juanra
 */
public class Ejercicio08 {
    
    public static void main(String[] args) throws FileNotFoundException{
        
        boolean encontrado=false;
        
        Scanner sc=new Scanner(System.in);
        char resp='S';
        File archivo=new File("AleatorioEmple.dat");
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                
            }
        }
        RandomAccessFile archivor=new RandomAccessFile(archivo, "rw");
        System.out.println("¿Quieres introducir datos? S/N");
        resp=Character.toUpperCase(sc.next().charAt(0));
        while(resp=='S'){
            String apellido, dept;
            double sal;
            sc=new Scanner(System.in);
            System.out.println("Introduce el apellido");
            apellido=sc.nextLine();
            System.out.println("Introduce el departamento");
            dept=sc.nextLine();
            System.out.println("Introduce el salario");
            sal=sc.nextDouble();
            try {
                archivor.seek(archivor.length());
            } catch (IOException ex) {
            }
            Empleado add=new Empleado(apellido, dept, sal);
            try {
                archivor.writeUTF(add.getApellido());
                archivor.writeUTF(add.getDep());
                archivor.writeDouble(add.getSalario());
            } catch (IOException ex) {
            }
            System.out.println("¿Quieres introducir mas datos? S/N");
            resp=Character.toUpperCase(sc.next().charAt(0));
        }
        System.out.println("¿Quieres consultar si existe algun empleado? S/N");
        resp=Character.toUpperCase(sc.next().charAt(0));
        if(resp=='S'){
            sc=new Scanner(System.in);
            System.out.println("Introduce el apellido");
            String nom=sc.nextLine();
            try {
                archivor.seek(0);
            } catch (IOException ex) {
            }
            try {
                while(true){
                    String apell=archivor.readUTF();
                    String depl=archivor.readUTF();
                    double sall=archivor.readDouble();
                    Empleado leido=new Empleado(apell, depl, sall);
                    if(leido.getApellido().toUpperCase().equals(nom.toUpperCase())){
                       System.out.println(leido.toString());
                        encontrado=true;
                    }
                }
            } catch (EOFException ex) {
                if(!encontrado){
                    System.out.println("No existe esa persona");
                }
            } catch (IOException exf){
            }
        }
        sc.close();
    }
    
}

/*class Empleado{
    
    private String apellido;
    private String dep;
    private double salario;
    
    public Empleado(String apel, String dept, double sal){
        
        this.apellido=apel;
        this.dep=dept;
        this.salario=sal;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDep() {
        return dep;
    }

    public double getSalario() {
        return salario;
    }
    
    @Override
    public String toString(){
        
        return "Apellido: "+this.apellido+"\nDepartamento: "+this.dep+
                "\nSalario: "+this.salario;
    }
}*/