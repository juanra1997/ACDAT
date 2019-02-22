/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtdni;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Juanra
 */
public class JTDNI extends JTextField implements Serializable, KeyListener{
    
    /*public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public JTDNI() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }*/
    
    public JTDNI(){
        setSize(100, 30);
        addKeyListener(this);
        setHorizontalAlignment(JTextField.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(getText().length()>=8||!Character.isDigit(e.getKeyChar())){
            e.consume();
        }
        if(e.getKeyChar()==KeyEvent.VK_ENTER){
            if(getText().length()!=8){
                JOptionPane.showMessageDialog(null, "Introduce los 8 digitos del DNI");
            }else{
                String letras="TRWAGMYFPDXBNJZSQVHLCKE";
                int modulo= Integer.parseInt(getText()) % 23;
                JOptionPane.showMessageDialog(null, "La letra de su DNI es: "+letras.charAt(modulo));
                setText(getText()+letras.charAt(modulo));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
