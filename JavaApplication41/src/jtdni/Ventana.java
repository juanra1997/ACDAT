/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtdni;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JFrame;

/**
 *
 * @author Juanra
 */
public class Ventana extends JFrame{
    
    public Ventana(){
        
        setLayout(null);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTDNI prueba=new JTDNI();
        
        prueba.setLocation(10, 10);
        add(prueba);
        
        ElSpiner spiner=new ElSpiner();
        
        spiner.setLocation(50, 50);
        add(spiner);
        
        Texto texto=new Texto();
        
        texto.setLocation(80, 80);
        add(texto);
    }
}
