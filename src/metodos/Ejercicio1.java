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
public class Ejercicio1 {
    
     DefaultTableModel modelo;

    public Ejercicio1() {
    }
    
    public DefaultTableModel biseccion(long x1, long xu, int cifras){
        
        modelo = new DefaultTableModel(new Object[]{"Iteracion", "X1", "Xu", "Xr", "F(x1)", "F(xr)", "F(x1)F(xr)","Error Aproximado"}, 0);
        
        double tolerancia;
        long xr=0, errorAproximado;
        if((((Math.exp(xu-1))-(1.5*xu)) * ((Math.exp(x1-1))-(1.5*x1))) < 0){
            
            int i=0;
            tolerancia= 0.5*Math.pow(10, 2-cifras);
            
            do {                
                
                xr=((x1+xu)/2);
                
                
            
            if((((Math.exp(x1-1))-(1.5*x1)) * ((Math.exp(xr-1))-(1.5*xr))) < 0){
                
                xu=xr;
                
            }else if((((Math.exp(xu-1))-(1.5*xu)) * ((Math.exp(x1-1))-(1.5*x1))) > 0){
                
                 x1=xr;
                
            }else{
                
               return null;
                
            }
            
//            errorAproximado = 
                
            } while (Math.abs(errorAproximado)<tolerancia);
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No existe raíz en el intervalo");
            return null;
        }
        
        return null;
    }
    
    
    
    
}
