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
public class PuntoFijo extends Funciones{

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
    
    public DefaultTableModel puntoFijo(double x0, int cifras) {
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "Xn", "G(xn)", "Error Aproximado" }, 0);
        double tolerancia, errorAproximado = 1000, xn;
        
        if(evaluarFuncionDerivada(x0,getFuncion())<1){
            int i=1;
            tolerancia = 0.5 * Math.pow(10, (2 - cifras));
            do {         
                errorAproximado=((evaluarFuncionDespejada(x0,getFuncion())-x0)/evaluarFuncionDespejada(x0,getFuncion()))*100;
                System.out.println(errorAproximado);
                modelo.addRow(new Object[]{i, x0, evaluarFuncionDespejada(x0,getFuncion()), errorAproximado});
                x0=evaluarFuncionDespejada(x0,getFuncion());
                i++;
                
                
            } while (Math.abs(errorAproximado)>tolerancia);
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No existe raíz");
        }
        
        
        return modelo;
    }
}
