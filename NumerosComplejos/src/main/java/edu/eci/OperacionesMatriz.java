package main;

import java.awt.List;
import java.util.ArrayList;

public class OperacionesMatriz {
	
	public static Matriz SumaMatricial(Matriz matriz1, Matriz matriz2){
        if ((matriz1.sizeFilas == matriz2.sizeFilas) && (matriz1.sizeColumnas == matriz2.sizeColumnas)){
            Complejo complejoN; 
            Matriz matrizN = new Matriz(matriz1.sizeFilas, matriz1.sizeColumnas);
            for(int i = 0; i < matriz1.sizeFilas; i ++){
                for(int o = 0; o < matriz1.sizeColumnas; o ++){
                    complejoN = Operaciones.Sum(matriz1.GetPosition(i, o), matriz2.GetPosition(i, o));
                    matrizN.AddInPosition(i, o, complejoN);
                }
            }
            return matrizN;
        }
        else{
            System.out.println("Las matrices no son del mismo tamanio, la operacion entregara un valor null");
            return null;
        }
        
    }
	
	
	public static Matriz MultiplicacionScalarMatriz(Matriz matriz1, Complejo complejo1){
        Complejo complejoN; 
        Matriz matrizN = new Matriz(matriz1.sizeFilas, matriz1.sizeColumnas);
        for(int i = 0; i < matriz1.sizeFilas; i ++){
            for(int o = 0; o < matriz1.sizeColumnas; o ++){
                complejoN = Operaciones.Mult(matriz1.GetPosition(i, o), complejo1);
                matrizN.AddInPosition(i, o, complejoN);
            }
        }
        return matrizN;
    }
	
	
	
	public static Matriz multiplicacionMatricial(Matriz matriz1, Matriz matriz2){
        if ((matriz1.sizeFilas == matriz2.sizeFilas) && (matriz1.sizeColumnas == matriz2.sizeColumnas)){
            Matriz matrizN = new Matriz(matriz1.sizeFilas, matriz1.sizeColumnas);
            for(int i = 0; i < matriz1.sizeFilas; i++){
                MultiplicacionMatrizVector(i,matriz1,matriz2,matrizN);
            }
            return matrizN;
        }
        else{
            System.out.println("Las matrices no son del mismo tamanio, la operacion entregara un valor null");
            return null;
        }
    }
	
	
	private static void MultiplicacionMatrizVector(int i, Matriz matriz1, Matriz matriz2, Matriz N){
        Complejo complejoN; 
        Complejo complejoSuma;
        for(int a = 0; a < matriz2.sizeFilas; a++){
            complejoSuma = new Complejo(0, 0);
            for(int b = 0; b < matriz2.sizeColumnas; b++){
                complejoN = Operaciones.Mult(matriz1.GetPosition(i, b), matriz2.GetPosition(b, a));
                complejoSuma = Operaciones.Sum(complejoN, complejoSuma);
            }
            N.AddInPosition(i, a, complejoSuma);
        }
        
    }

}
