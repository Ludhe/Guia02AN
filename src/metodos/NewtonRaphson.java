/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author doratt
 */
public class NewtonRaphson extends Funciones{

    DefaultTableModel modelo;
    int funcion;

    public int getFuncion() {
        return funcion;
    }

    public void setFuncion(int funcion) {
        this.funcion = funcion;
    }
    
    public String derivar(String funcion){
       
        String derivada="";
        System.out.println(funcion);
        DJep Derivar = new DJep();
        System.out.println("Crea el DJEP");
        Derivar.addStandardFunctions();
        System.out.println("Añade funciones");
        Derivar.addStandardConstants();
        Derivar.addComplex();
        Derivar.setAllowUndeclared(true);
        Derivar.setAllowAssignment(true);
        Derivar.setImplicitMul(true);
        Derivar.addStandardDiffRules();
        System.out.println("antes del try");
        
        try {
            System.out.println("Entro al try");
            Node node = Derivar.parse(funcion);
            System.out.println("Parseo la funcion"+node.toString());
            Node diff = Derivar.differentiate(node, "x");
            Node sim = Derivar.simplify(diff);
            derivada = Derivar.toString(sim);
        } catch (ParseException e) {
         Derivar.getErrorInfo();
        }
        
        return derivada;
    }

    public DefaultTableModel newtonRaphson(double x0, int cifras) {
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "Xn", "Xi+1", "Error Aproximado" }, 0);
        double tolerancia, errorAproximado = 1000, xn;
        int i=1;
            double gx;
            tolerancia = 0.5 * Math.pow(10, (2 - cifras));
            do {      
                gx=x0-(evaluarFuncion(x0,getFuncion())/evaluarFuncionDerivada(x0,getFuncion()));
                errorAproximado=(((gx-x0)/gx))*100;
                modelo.addRow(new Object[]{i, x0, gx, errorAproximado});
                x0=gx;
                i++;
                
                
            } while (Math.abs(errorAproximado)>tolerancia);
            
        return modelo;
    }
    
}
