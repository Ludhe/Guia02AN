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
public class FalsaPosicion {
    
     DefaultTableModel modelo;

    public FalsaPosicion() {
    }
    
    
    
    public DefaultTableModel falsaPosicion(double x1, double xu, double cifras){
        
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "X1", "Xu","F(x1)","F(xu)", "Xr", "F(xr)", "F(x1)F(xr)","Error Aproximado"}, 0);
        double tolerancia;
        double xr=0, errorAproximado=1000;
        if(evaluarFuncion(x1)*evaluarFuncion(xu) < 0){
            int i=1;
            tolerancia= 0.5*Math.pow(10, (2-cifras));
            

            
            do {                
                
                xr=(xu-(((evaluarFuncion(xu))*(x1-xu))/((evaluarFuncion(x1)-evaluarFuncion(xu)))));
                
                
                if(i==1){
                modelo.addRow(new Object[]{i, x1, xu, evaluarFuncion(x1), evaluarFuncion(xu) ,xr , evaluarFuncion(xr) ,(evaluarFuncion(xr)*evaluarFuncion(x1)), "---------"});    
                }else{
                    errorAproximado = (xr-Double.parseDouble(String.valueOf(modelo.getValueAt(modelo.getRowCount()-1, 5))));
                    modelo.addRow(new Object[]{i, x1, xu, evaluarFuncion(x1), evaluarFuncion(xu) ,xr , evaluarFuncion(xr) ,(evaluarFuncion(xr)*evaluarFuncion(x1)), errorAproximado});    
                }
                
            
            if(evaluarFuncion(x1)*evaluarFuncion(xr) < 0){
                
                xu=xr;
                
            }else if(evaluarFuncion(x1)*evaluarFuncion(xr) > 0){
                
                 x1=xr;
                
            }else{
                
               return modelo;
                
            }
            
            i++;
                
            } while (Math.abs(errorAproximado)>tolerancia);
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No existe raíz en el intervalo");
            return null;
        }
        
        return modelo;
    }
    
    public double evaluarFuncion(double x){
      
        return (((Math.exp((x-1))))) - ((1.5*x));
        
        
    }
    
}
