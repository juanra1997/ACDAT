/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;

/**
 *
 * @author Juanra
 */
public class DesconversionXStream {
    
    private static XStream xstream;
    private static Class<?>[] classes = new Class[] {Departamento.class, Departamentos.class };
    
    public static void main(String[] args){
        
        xstream=new XStream(new DomDriver());
        
        xstream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        xstream.processAnnotations(Departamento.class);
        xstream.processAnnotations(Departamentos.class);
        xstream.addImplicitCollection(Departamentos.class, "lista");
        
        Departamentos d=(Departamentos) xstream.fromXML(new File("DepartamentosXStream.xml"));
        
        int cont=1;
        
        for(int i=0; i<d.getLista().size();i++){
            System.out.println("Departamento: " + cont
            + "\n\fID: " + d.getLista().get(i).getId() + "\n\fTipo: " + d.getLista().get(i).getTipo()
            + "\n\fNombre: " + d.getLista().get(i).getNombre() + "\n\fDomicilio: " + d.getLista().get(i).getDomicilio()
            + "\n\fCiudad: " + d.getLista().get(i).getCiudad() + "\n\fCP: " + d.getLista().get(i).getCp()
            + "\n\fProvincia: " + d.getLista().get(i).getProvincia() + "\n\fPais: " + d.getLista().get(i).getPais());
            cont++;
        }
    }
}
