/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiner;

import java.beans.*;
import java.io.Serializable;
import java.util.EventListener;
import java.util.EventObject;
import javafx.beans.value.ObservableValue;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Juanra
 */
public class ElSpiner extends JSpinner implements Serializable, ChangeListener {
    
    /*public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public ElSpiner() {
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
    
    int valorEvento;
    private MiEventoListener receptor;
    
    public ElSpiner(){
        setSize(100, 30);
        addChangeListener(this);
    }

    public int getValorEvento() {
        return valorEvento;
    }

    public void setValorEvento(int valorEvento) {
        this.valorEvento = valorEvento;
    }

    /*@Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public void stateChanged(ChangeEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if((int)getValue()==valorEvento){
            //JOptionPane.showMessageDialog(null, "Evento");
            receptor.capturarMiEvento(new MiEvento(this));
        }
    }
    public interface MiEventoListener extends EventListener{
        void capturarMiEvento(MiEvento ev);
    }
    public class MiEvento extends EventObject{

        public MiEvento(Object source) {
            super(source);
        }
        
    }
    public void addMiEventoListener(MiEventoListener receptor){
        this.receptor = receptor;
    }

    public void removeMiEventoListener(MiEventoListener receptor){
        this.receptor=null;
    }
}
