/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juanra
 */
public class Prueba {
    
    public static void main(String[] args){
        
        Session sesion=null;
        //sesion=sfactory.openSession();
        Transaction tx=sesion.beginTransaction();
        System.out.println();
    }
}
