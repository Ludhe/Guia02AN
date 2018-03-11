/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author villa
 */
public class Funciones {

    public Funciones() {
    }
    
    public double evaluarFuncion(double x, int funcion){
        switch(funcion){
            case 0:
                return (Math.exp(x - 1)) - (1.5 * x);
            case 1:
                return (2*Math.sin(x)) - x;
            case 2:
                return Math.exp(x)-4;
            case 3:
                return ((Math.exp(-(x-1)))*Math.sin(x))-1;
            case 4:
                return (4*Math.sin(x)) - Math.exp(x);
            default:
                return 0.0;
        }
        
    }
    
}
