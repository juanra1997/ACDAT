/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXB_ALBARAN;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import jaxb.albaran.Direccion;
import jaxb.albaran.PedidoType;

/**
 *
 * @author windiurno
 */
public class ModificaAlbaPed {
    
    public static void main(String[] args){
        
        try{
        JAXBContext jaxbContext=JAXBContext.newInstance("jaxb.albaran");
        Unmarshaller u=jaxbContext.createUnmarshaller();
        JAXBElement jaxbElement=(JAXBElement)u.unmarshal(new FileInputStream("albaran.xml"));
        PedidoType pedidoType=(PedidoType)jaxbElement.getValue();
        Direccion direccion=pedidoType.getFacturarA();
        direccion.setNombre("Juan Raul");
        direccion.setCalle("Zafiro 3");
        direccion.setCiudad("Almeria");
        direccion.setCodigoPostal(new BigDecimal("30500"));
        Marshaller m=jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(jaxbElement, System.out);
        } catch(JAXBException je) {
            System.out.println(je.getCause());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
