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

    public double evaluarFuncion(double x, int funcion) {
        switch (funcion) {
            case 0:
                return (Math.exp(x - 1)) - (1.5 * x);
            case 1:
                return (2 * Math.sin(x)) - x;
            case 2:
                return Math.exp(x) - 4;
            case 3:
                return ((Math.exp(-(x - 1))) * Math.sin(x)) - 1;
            case 4:
                return (4 * Math.sin(x)) - Math.exp(x);
            default:
                return 0.0;
        }

    }

    public double evaluarFuncionDespejada(double x, int funcion) {
        switch (funcion) {
            case 0:
                return ((Math.exp(x - 1)) / 1.5);
            case 1:
                return Math.asin(x/2);
            case 2:
                return Math.log(4);
            case 3:
                return Math.asin(1/(Math.exp(1-x)));
            case 4:
                return Math.asin((Math.exp(x))/4);
            default:
                return 0.0;
        }
    }
    
    public double evaluarFuncionDespejadaDerivada(double x, int funcion) {
        switch (funcion) {
            case 0:
                return ((Math.exp(x - 1)) / 1.5);
            case 1:
                return (1/(Math.sqrt(4-Math.pow(x, 2))));
            case 2:
                return 0;
            case 3:
                return 1/Math.sqrt((Math.exp(2-(2*x)))-1);
            case 4:
                return Math.exp(x)/Math.sqrt(16-Math.exp(2*x));
            default:
                return 0.0;
        }
    }
    
    public double evaluarFuncionDerivada(double x, int funcion) {
        switch (funcion) {
            case 0:
                return ((Math.exp(x - 1)) - 1.5);
            case 1:
                return (2*Math.cos(x))-1;
            case 2:
                return Math.exp(x);
            case 3:
                return (Math.exp(1-x)*Math.cos(x))-(Math.exp(1-x)*Math.sin(x));
            case 4:
                return (4*Math.cos(x))-Math.exp(x);
            default:
                return 0.0;
        }
    }

}
