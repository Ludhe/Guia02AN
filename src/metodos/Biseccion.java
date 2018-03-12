/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author doratt
 */
public class Biseccion extends Funciones{

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
        Derivar.addStandardFunctions();
        Derivar.addStandardConstants();
        Derivar.addComplex();
        Derivar.setAllowUndeclared(true);
        Derivar.setAllowAssignment(true);
        Derivar.setImplicitMul(true);
        Derivar.addStandardDiffRules();
        
        try {
            Node node = Derivar.parse(funcion);
            Node diff = Derivar.differentiate(node, "x");
            Node sim = Derivar.simplify(diff);
            derivada = Derivar.toString(sim);
        } catch (ParseException e) {
         Derivar.getErrorInfo();
        }
        
        return derivada;
    }

    public DefaultTableModel biseccion(double x1, double xu, double cifras) {
        
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "X1", "Xu", "Xr", "F(x1)", "F(xr)", "F(x1)F(xr)", "Error Aproximado"}, 0);
        double tolerancia;
        double xr = 0, errorAproximado = 1000;
        if (evaluarFuncion(x1,getFuncion()) * evaluarFuncion(xu,getFuncion()) < 0) {
            int i = 1;
            tolerancia = 0.5 * Math.pow(10, (2 - cifras));

            do {

                xr = ((x1 + xu) / 2);

                if (i == 1) {
                    modelo.addRow(new Object[]{i, x1, xu, xr, evaluarFuncion(x1,getFuncion()), evaluarFuncion(xr,getFuncion()), (evaluarFuncion(xr,getFuncion()) * evaluarFuncion(x1,getFuncion())), "---------"});
                } else {
                    errorAproximado = (xr - Double.parseDouble(String.valueOf(modelo.getValueAt(modelo.getRowCount() - 1, 3))));
                    modelo.addRow(new Object[]{i + 1, x1, xu, xr, evaluarFuncion(x1,getFuncion()), evaluarFuncion(xr,getFuncion()), (evaluarFuncion(xr,getFuncion()) * evaluarFuncion(x1,getFuncion())), errorAproximado});
                }

                if (evaluarFuncion(x1,getFuncion()) * evaluarFuncion(xr,getFuncion()) < 0) {
                    xu = xr;
                } else if (evaluarFuncion(x1,getFuncion()) * evaluarFuncion(xr,getFuncion()) > 0) {
                    x1 = xr;
                } else {
                    return modelo;
                }
                i++;
            } while (Math.abs(errorAproximado) > tolerancia);

        } else {
            JOptionPane.showMessageDialog(null, "No existe raíz en el intervalo");
            return modelo;
        }

        return modelo;
    }

//    public double evaluarFuncion(double x) {
//
//        return (((Math.exp((x - 1))))) - ((1.5 * x));
//
//    }

}
