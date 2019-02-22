/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtdni;

import java.awt.Component;
import java.beans.*;

/**
 *
 * @author Juanra
 */
/*public class TextoPropertyEditor extends PropertyEditorSupport {
    
 public TextoPropertyEditor() {
 }
    
 }*/
public class TextoPropertyEditor extends PropertyEditorSupport {
//su único atributo es un EditorTipoPanel

    private EditorTipoPanel editor = null;

    public TextoPropertyEditor() {
        this.editor = new EditorTipoPanel();
    }
//Para indicar que existe un editor personalizado

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
//Obtiene el editor personalizado

    @Override
    public Component getCustomEditor() {
        return editor;
    }
//El constructor de beans solicita el valor del objeto para almacenar la
    //propiedad, llamando al método getValue () .
//Obtiene el valor del Editor y lo devuelve a la hoja de propiedades

    @Override
    public Object getValue() {
        if (super.getValue() == null) {
            setValue(null);
        }
        String ret = (String) super.getValue();
        ret = editor.cbTipo.getSelectedItem().toString();
        return ret;
    }
 //El constructor de beans le dice al editor de propiedades el valor actual
    //de la propiedad llamando al método setValue ()
//Asigna el valor en la hoja de propiedades

    @Override
    public void setValue(Object value) {
        if (value == null) {
            value = new String();
        }
        super.setValue(value);
    }
//Permite definir la lista en la hoja de propiedades, establece los valores
//posible para la propiedad en la hoja de propiedades.

    @Override
    public String[] getTags() {
        String[] tags = {"Entero", "Texto", "Real"};
        return tags;
    }
//Cuando el usuario cambia el valor de Cadena , el constructor de bean le dice a
    //la propiedad el nuevo valor llamando al método setAsText () .
    //Asigna el valor definido en la hoja de propiedades a través del getTags o escrito a mano
    //Además asigna como item seleccionado en el editor al valor seleccionado del tag
//establece el valor seleccionado en el editor de propiedades en el editor

    @Override
    public void setAsText(String text) {
        editor.cbTipo.setSelectedItem(text);
        super.setAsText(text);
    }
//Devuelve en la hoja de propiedades el valor establecido en el Editor
//Devuelve el valor de la propiedad como texto

    @Override
    public String getAsText() {
        String ret = (String) super.getAsText();
        ret = editor.cbTipo.getSelectedItem().toString();
        return ret;
    }
 ///El constructor de beans solicita el código que inicializará la propiedad
    //llamando a getJavaInitializationString ()
    //Define como se tratará el elemento seleccionado en el editor.
    //Sobreescritura del método que devuelve el valor del componente en la clase
    //correspondiente al editor de propiedades del componente (tipoPropertyEditor):
 /*La función ?getJavaInitializationString() tiene que devolver sí o sí una cadena.
     Java, luego elimina las comillas dobles de la cadena y coloca el valor devuelto en el código.
     Por ejemplo, en el componente de texto se envía la cadena "[cadena_de_texto]"
     porque el componente requiere una cadena para el tipo.*/
 //idem
 /*@Override
     public String getJavaInitializationString() {
     return "\"" + editor.cmbTipo.getSelectedItem() + "\"";
     }*/

    @Override
    public String getJavaInitializationString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append((String) editor.cbTipo.getSelectedItem());
        sb.append("\"");
        String retorno = new String(sb);
        return retorno;
    }
}
