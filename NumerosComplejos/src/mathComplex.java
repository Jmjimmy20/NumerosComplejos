
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
    
    
    
    public static List SumaComplejos(List tupla1,List tupla2){
        List<Double> respuesta = new ArrayList<Double>();
        double valorReal1 = (Double) tupla1.get(0);
        double valorReal2 = (Double) tupla2.get(0);
        respuesta.add(valorReal1+valorReal2);
        double valorImaginario1 = (Double) tupla1.get(1);
        double valorImaginario2 = (Double) tupla2.get(1);     
        respuesta.add(valorImaginario1+valorImaginario2);
        System.out.println("El resultado de la suma es: " + respuesta.get(0).toString() + "+" + respuesta.get(1).toString()+ "i");
        return respuesta;
    }
    
    
    public static void ProductoComplejos (List tupla1,List tupla2){
        List<Double> respuesta = new ArrayList<Double>();
        double valorReal1 = (Double) tupla1.get(0);
        double valorReal2 = (Double) tupla2.get(0);
        double valorImaginario1 = (Double) tupla1.get(1);
        double valorImaginario2 = (Double) tupla2.get(1); 
        double parteReal = (valorReal1*valorReal2)+(valorImaginario1*valorImaginario2*-1);
        double parteImaginaria = (valorImaginario1*valorReal1)+(valorReal1*valorImaginario2);
        respuesta.add(parteReal);
        respuesta.add(parteImaginaria);
        System.out.println("El resultado del producto es: " + respuesta.get(0).toString() + "+(" + respuesta.get(1).toString()+ ")i");
    }
    
    
    public static List RestaComplejos(List tupla1,List tupla2){
        List<Double> respuesta = new ArrayList<Double>();
        double valorReal1 = (Double) tupla1.get(0);
        double valorReal2 = (Double) tupla2.get(0);
        respuesta.add(valorReal1-valorReal2);
        double valorImaginario1 = (Double) tupla1.get(1);
        double valorImaginario2 = (Double) tupla2.get(1);     
        respuesta.add(valorImaginario1 - valorImaginario2);
        System.out.println("El resultado de la resta es: " + respuesta.get(0).toString() + "+(" + respuesta.get(1).toString()+ ")i");
        return respuesta;
    }
    
    
}
