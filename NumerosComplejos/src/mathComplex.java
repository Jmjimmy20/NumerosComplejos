
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124203
 */
public class mathComplex {
    
    
    
    public static ComplexNumber SumaComplejos(ComplexNumber tupla1,ComplexNumber tupla2){
        ComplexNumber numeroCNuevo;
        double valorReal1 = tupla1.GetReal();
        double valorReal2 = tupla2.GetReal();
        double realNuevo = valorReal1+valorReal2;
        double valorImaginario1 = tupla1.Getimaginario();
        double valorImaginario2 = tupla2.Getimaginario();     
        double imaginarioNuevo = valorImaginario1+valorImaginario2;
        numeroCNuevo = new ComplexNumber(realNuevo, imaginarioNuevo);
        System.out.println("El resultado de la suma es: " + realNuevo + "+(" + imaginarioNuevo + ")i");
        return numeroCNuevo;
    }
    
    
    public static ComplexNumber ProductoComplejos (ComplexNumber tupla1,ComplexNumber tupla2){
        ComplexNumber numeroCNuevo;
        double valorReal1 = tupla1.GetReal();
        double valorReal2 = tupla2.GetReal();
        double valorImaginario1 = tupla1.Getimaginario();
        double valorImaginario2 = tupla2.Getimaginario(); 
        double parteReal = (valorReal1*valorReal2)+(valorImaginario1*valorImaginario2*-1);
        double parteImaginaria = (valorImaginario1*valorReal1)+(valorReal1*valorImaginario2);
        numeroCNuevo = new ComplexNumber(parteReal, parteImaginaria);
        System.out.println("El resultado del producto es: " + parteReal + "+(" + parteImaginaria + ")i");
        return numeroCNuevo;
    }
    
    
    public static ComplexNumber RestaComplejos(ComplexNumber tupla1,ComplexNumber tupla2){
        ComplexNumber numeroCNuevo;
        double valorReal1 = tupla1.GetReal();
        double valorReal2 = tupla2.GetReal();
        double realNuevo = valorReal1-valorReal2;
        double valorImaginario1 = tupla1.Getimaginario();
        double valorImaginario2 = tupla2.Getimaginario();     
        double imaginarioNuevo = valorImaginario1-valorImaginario2;
        numeroCNuevo = new ComplexNumber(realNuevo, imaginarioNuevo);
        System.out.println("El resultado de la suma es: " + realNuevo + "+(" + imaginarioNuevo + ")i");
        return numeroCNuevo;
    }
    
    public static ComplexNumber DivisionCompleja(ComplexNumber tupla1,ComplexNumber tupla2){
        ComplexNumber numeroCNuevo;
        double valorReal1 = tupla1.GetReal();
        double valorReal2 = tupla2.GetReal();
        double valorImaginario1 = tupla1.Getimaginario();
        double valorImaginario2 = tupla2.Getimaginario(); 
        double xNumerador = (valorReal1*valorReal2)+(valorImaginario1*valorImaginario2);
        double yNumerador = (valorReal2*valorImaginario1) - (valorReal1*valorImaginario2);
        double Denominador = Math.pow(valorReal2, 2) + Math.pow(valorImaginario2, 2);
        double valorReal = xNumerador/Denominador;
        double valorImaginario = yNumerador/Denominador;
        numeroCNuevo = new ComplexNumber(valorReal, valorImaginario);
        System.out.println("El resultado de la division es: " + valorReal + "+(" + valorImaginario + ")i");
        return numeroCNuevo;
    }
    
    
    
}
