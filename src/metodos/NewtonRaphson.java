/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author doratt
 */
public class NewtonRaphson {

    DefaultTableModel modelo;
    
    public double evaluarFuncion(double x) {
        
        return (((Math.exp((x - 1))))) - ((1.5 * x));
        
    }
    
    public double evaluarFuncionDerivada(double x) {
        
        return (((Math.exp((x - 1))))) - ((1.5));
        
    }

    public DefaultTableModel newtonRaphson(double x0, int cifras) {
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "Xn", "Xi+1", "Error Aproximado" }, 0);
        double tolerancia, errorAproximado = 1000, xn;
        int i=1;
            double gx;
            tolerancia = 0.5 * Math.pow(10, (2 - cifras));
            do {      
                gx=x0-(evaluarFuncion(x0)/evaluarFuncionDerivada(x0));
                errorAproximado=(((gx-x0)/gx))*100;
                modelo.addRow(new Object[]{i, x0, gx, errorAproximado});
                x0=gx;
                i++;
                
                
            } while (Math.abs(errorAproximado)>tolerancia);
            
        return modelo;
    }
    
}
