/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionEjerciciosUD2;

/**
 *
 * @author Juanra
 */
public class Empleado{
    
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

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
    
    @Override
    public String toString(){
        
        return "Apellido: "+this.apellido+"\nDepartamento: "+this.dep+
                "\nSalario: "+this.salario;
    }
}