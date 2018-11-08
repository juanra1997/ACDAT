/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
/**
 *
 * @author Juanra
 */
public class CrearHTML {
    
    public static void main(String[] args){
        
        try{
            TransformerFactory tff=TransformerFactory.newInstance();
            Transformer tf=tff.newTransformer(new StreamSource(new File("DepartamentosXSL.xsl")));
            StreamSource ss=new StreamSource(new File("DepartamentosXSL.xml"));
            StreamResult sr=new StreamResult(new File("DepartamentosHTML.html"));
            tf.transform(ss, sr);
        } catch(Exception e){
            
        }
    }
}
