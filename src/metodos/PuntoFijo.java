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
public class PuntoFijo {

    DefaultTableModel modelo;

    public DefaultTableModel puntoFijo(double x0, int cifras) {
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "Xn", "G(xn)", "Error Aproximado" }, 0);
        double tolerancia, errorAproximado = 1000, xn;
        
        if(evaluarFuncionDerivada(x0)<1){
            int i=1;
            tolerancia = 0.5 * Math.pow(10, (2 - cifras));
            do {         
                errorAproximado=((evaluarFuncion(x0)-x0)/evaluarFuncion(x0))*100;
                modelo.addRow(new Object[]{i, x0, evaluarFuncion(x0), errorAproximado});
                x0=evaluarFuncion(x0);
                i++;
                
                
            } while (Math.abs(errorAproximado)>tolerancia);
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No existe raíz");
        }
        
        
        return modelo;
    }

    public double evaluarFuncion(double x) {

        return ((Math.exp(x - 1)) / 1.5);

    }

    public double evaluarFuncionDerivada(double x) {

        return ((Math.exp(x - 1)) / 1.5);

    }

}
