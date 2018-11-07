/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanra
 */
@XStreamAlias("Departamentos")
public class Departamentos {

    private List<Departamento> lista;

    public Departamentos() {

        lista = new ArrayList<Departamento>();
    }

    public void add(Departamento d) {

        lista.add(d);
    }
}
