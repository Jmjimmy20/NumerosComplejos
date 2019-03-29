package edu.eci;

import java.awt.List;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124203
 */
public class mathMatriz {
    
    
    
    
    public static MatrizFilasColumnas SumaMatricial(MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2){
        if ((matriz1.sizeFilas == matriz2.sizeFilas) && (matriz1.sizeColumnas == matriz2.sizeColumnas)){
            ComplexNumber complejoN; 
            MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
            for(int i = 0; i < matriz1.sizeFilas; i ++){
                for(int o = 0; o < matriz1.sizeColumnas; o ++){
                    complejoN = mathComplex.SumaComplejos(matriz1.GetPosition(i, o), matriz2.GetPosition(i, o));
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
    
    public static MatrizFilasColumnas RestaMatricial(MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2){
        if ((matriz1.sizeFilas == matriz2.sizeFilas) && (matriz1.sizeColumnas == matriz2.sizeColumnas)){
            ComplexNumber complejoN; 
            MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
            for(int i = 0; i < matriz1.sizeFilas; i ++){
                for(int o = 0; o < matriz1.sizeColumnas; o ++){
                    complejoN = mathComplex.RestaComplejos(matriz1.GetPosition(i, o), matriz2.GetPosition(i, o));
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
    
    
    
    public static MatrizFilasColumnas MultiplicacionScalarMatriz(MatrizFilasColumnas matriz1, ComplexNumber complejo1){
        ComplexNumber complejoN; 
        MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
        for(int i = 0; i < matriz1.sizeFilas; i ++){
            for(int o = 0; o < matriz1.sizeColumnas; o ++){
                complejoN = mathComplex.ProductoComplejos(matriz1.GetPosition(i, o), complejo1);
                matrizN.AddInPosition(i, o, complejoN);
            }
        }
        return matrizN;
    }
    
    
    public static MatrizFilasColumnas multiplicacionMatricial(MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2){
        if ((matriz1.sizeFilas == matriz2.sizeFilas) && (matriz1.sizeColumnas == matriz2.sizeColumnas)){
            MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
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
    
    private static void MultiplicacionMatrizVector(int i, MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2, MatrizFilasColumnas N){
        ComplexNumber complejoN; 
        ComplexNumber complejoSuma;
        for(int a = 0; a < matriz2.sizeFilas; a++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int b = 0; b < matriz2.sizeColumnas; b++){
                complejoN = mathComplex.ProductoComplejos(matriz1.GetPosition(i, b), matriz2.GetPosition(b, a));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            N.AddInPosition(i, a, complejoSuma);
        }
        
    }
    
    
    public static VectorFilasColumna MultiplicacionVectorMatriz(VectorFilasColumna vector, MatrizFilasColumnas matriz){
        VectorFilasColumna vectorN = new VectorFilasColumna(matriz.sizeColumnas);
        ComplexNumber complejoN;
        ComplexNumber complejoSuma;
        for(int i = 0; i < matriz.sizeColumnas; i++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int o = 0; o < matriz.sizeFilas; o++){
                complejoN = mathComplex.ProductoComplejos(vector.GetPosition(o), matriz.GetPosition(o, i));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            vectorN.AddValue(complejoSuma);
        }
        return  vectorN;
    }
    
    
    
    
    public static VectorFilasColumna MultiplicacionMatrizVector(MatrizFilasColumnas matriz, VectorFilasColumna vector){
        VectorFilasColumna vectorN = new VectorFilasColumna(matriz.sizeFilas);
        ComplexNumber complejoN;
        ComplexNumber complejoSuma;
        for(int i = 0; i < matriz.sizeFilas; i++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int o = 0; o < matriz.sizeColumnas; o++){
                complejoN = mathComplex.ProductoComplejos(vector.GetPosition(o), matriz.GetPosition(i, o));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            vectorN.AddValue(complejoSuma);
        }
        return  vectorN;
    }
    
    
    
    public static ComplexVectorSpace MultiplicacionMatrizVector(MatrizFilasColumnas matriz, ComplexVectorSpace vector){
        ComplexVectorSpace vectorN = new ComplexVectorSpace(matriz.sizeFilas);
        ComplexNumber complejoN;
        ComplexNumber complejoSuma;
        for(int i = 0; i < matriz.sizeFilas; i++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int o = 0; o < matriz.sizeColumnas; o++){
                complejoN = mathComplex.ProductoComplejos(matriz.GetPosition(i, o),vector.GetPosition(o));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            vectorN.AddValue(complejoSuma);
        }
        return  vectorN;
    }
    
    
    
    public static VectorFilasColumna MultiplicacionMatrizVectorConMovimiento(MatrizFilasColumnas matriz, VectorFilasColumna vector, int movimientos){
        VectorFilasColumna vectorN = new VectorFilasColumna(matriz.sizeFilas);
        MatrizFilasColumnas matrizActual = matriz; 
        for (int a = 0; a < movimientos; a++){
            ComplexNumber complejoN;
            ComplexNumber complejoSuma;
            for(int i = 0; i < matriz.sizeFilas; i++){
                complejoSuma = new ComplexNumber(0, 0);
                for(int o = 0; o < matriz.sizeColumnas; o++){
                    complejoN = mathComplex.ProductoComplejos(vector.GetPosition(o), matrizActual.GetPosition(i, o));
                    complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
                }
                vectorN.AddValue(complejoSuma);
                System.out.println("La bolsa de canicas " + i + " en el paso " + (a+1) + " tendra " + complejoSuma.GetReal());
                
            }  
            
            if (a+1 < movimientos){
                    matrizActual = multiplicacionMatricial(matrizActual, matriz);
                    vectorN = new VectorFilasColumna(matriz.sizeFilas);
            }
        }
        return  vectorN;
    }
    
    
    public static ComplexVectorSpace CalcularStateVector(ArrayList<MatrizFilasColumnas> listaMatrices, ComplexVectorSpace ket){
        ComplexVectorSpace ketRespuesta = ket;
        for(int i = 0; i < listaMatrices.size(); i++){
            MatrizFilasColumnas m = listaMatrices.get(i);
            ketRespuesta = MultiplicacionMatrizVector(m, ketRespuesta);
        }
        return ketRespuesta;
    }
    
    
    
    public static MatrizFilasColumnas ProductoTensor(MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2){
        int contadorFilas = 0;
        int contadorColumnas = 0;
        MatrizFilasColumnas matrizN = new MatrizFilasColumnas((matriz1.sizeFilas * matriz2.sizeFilas), (matriz1.sizeColumnas * matriz2.sizeColumnas));
        for (int i = 0; i < matriz1.sizeFilas; i ++){
            for(int a = 0; a < matriz1.sizeColumnas; a++){
                AnadirPosicion(matriz1.GetPosition(i, a), contadorFilas, contadorColumnas, matrizN,matriz2);
                contadorColumnas += (matriz2.sizeColumnas);
            }
            contadorColumnas = 0;
            contadorFilas += matriz2.sizeFilas;
        }
        return matrizN;
    }
    
    
    public static double Varianza(MatrizFilasColumnas matriz, ComplexVectorSpace ket){
        double varianza = 0;
        for(int i = 0; i < matriz.sizeFilas; i++){
            varianza += ket.GetPosition(i).Modulus() * matriz.GetPosition(i, i).GetReal();
        }
        return varianza;
    }
    
    private static void AnadirPosicion(ComplexNumber valor1, int Contadorfilas, int contadorColumna, MatrizFilasColumnas matrizN, MatrizFilasColumnas matriz2){
        for(int i = 0; i < matriz2.sizeFilas; i++){
            for(int a = 0; a < matriz2.sizeColumnas; a++){
                matrizN.AddInPosition(i+Contadorfilas, a+contadorColumna, mathComplex.ProductoComplejos(valor1, matriz2.GetPosition(i, a)));
            }
        }
        
        
    }
    
    
    public static boolean IgualMatricial(MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2){
        boolean bandera = true;
        for (int i = 0; i < matriz1.sizeFilas; i++){
            for(int o = 0; o < matriz1.sizeColumnas; o++){
                if(!mathComplex.igualdadComplejos(matriz1.GetPosition(i, o), matriz2.GetPosition(i, o))){
                    bandera = false;
                }
            }
        }
        return bandera;
    }
    
    
    public static double ValorMedio(MatrizFilasColumnas matriz, ComplexVectorSpace ket){
        if (mathComplexVectorSpace.IsHermitian(matriz)){
            ComplexVectorSpace vectorResultante = MultiplicacionMatrizVector(matriz, ket);
            ComplexVectorSpace bra = mathComplexVectorSpace.BraVector(vectorResultante);
            return mathComplexVectorSpace.ScalarProduct(bra, ket).GetReal();
        }
        else{
            System.out.println("La matriz dada no es hermitiana el valor a retornar es cero pero no tiene"
                    + "que ver con la respuesta real.");
            return 0;
        }
        
    }
    
    
    
    
    
    //para el ejercicio de 4.3 usar matriz trivialmente hermitian que es que la diagonal es la que tiene los valores y el resto de valores seran iguales a cero
    
}
