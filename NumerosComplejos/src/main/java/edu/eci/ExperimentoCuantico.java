/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci;

/**
 *
 * @author jfmor
 */
public class ExperimentoCuantico {
    
    public static double[] MultiplicacionMatrizVectorConMovimiento(double[][] matriz, double[] vector, int movimientos){
        double[] vectorN = new double[vector.length];
        double[][] matrizActual = matriz; 
        for (int a = 0; a < movimientos; a++){
            double resultMultiplicacion;
            double resultSuma;
            for(int i = 0; i < matriz.length; i++){
                resultSuma = 0;
                for(int o = 0; o < matriz[i].length; o++){
                    resultMultiplicacion = vector[o] * matrizActual[i][o];
                    resultSuma = resultMultiplicacion + resultSuma;
                }
                vectorN[i] = resultSuma;
                //System.out.println("La bolsa de canicas " + i + " en el paso " + (a+1) + " tendra " + complejoSuma.GetReal());
                
            }  
            
            if (a+1 < movimientos){
                    matrizActual = MultiplicacionMatricial(matrizActual, matriz);
                    vectorN = new double[matriz.length];
            }
        }
        return  vectorN;
    }
    
    
    
    public static double[][] MultiplicacionMatricial(double[][] matriz1, double[][] matriz2){
        if ((matriz1.length == matriz2.length) && (matriz1[0].length == matriz2[0].length)){
            double[][] matrizN = new double[matriz1.length][matriz1[0].length];
            for(int i = 0; i < matriz1.length; i++){
                
                MultiplicacionMatrizVector(i,matriz1,matriz2,matrizN);
            }
            return matrizN;
        }
        else{
            System.out.println("Las matrices no son del mismo tamanio, la operacion entregara un valor null");
            return null;
        }
    }
    
    public static void MultiplicacionMatrizVector(int valorFila, double[][] matriz1, double[][] matriz2, double[][] matrizRespuesta){
        double resultMultiplicacion; 
        double resultSuma;
        for(int a = 0; a < matriz2.length; a++){
            resultSuma = 0;
            for(int b = 0; b < matriz2[a].length; b++){
                resultMultiplicacion = matriz1[valorFila][b] * matriz2[b][a];
                resultSuma = resultMultiplicacion + resultSuma;
            }
            matrizRespuesta[valorFila][a] = resultSuma; 
        }
    }
    
    public static double[] MultiplicacionMatrizVector(double[][] matriz, double[] vector){
        double[] vectorRespuesta = new double[vector.length];
        double resultMultiplicacion; 
        double resultSuma;
        for(int a = 0; a < matriz.length; a++){
            resultSuma = 0;
            for(int b = 0; b < matriz[a].length; b++){
                resultMultiplicacion = matriz[a][b] * vector[b];
                resultSuma = resultMultiplicacion + resultSuma;
            }
            vectorRespuesta[a] = resultSuma; 
        }
        return vectorRespuesta;
    }
    
    public static boolean igualdadVectores(double[] vector1, double[] vector2){
        boolean respuesta = true;
        for (int i = 0; i < vector1.length; i++){
            if(vector1[i] != vector2[i]){
                respuesta = false;
            }
        }
        
        return respuesta;
    }
    
    
    public static double[][] CreacionMatrizConSlitsTargets(int slits, int targets, double[][] probabilidades){
        double[][] matrizRespuesta = new double[slits+targets+1][probabilidades[0].length];
        for(int a = 0; a < probabilidades[0].length; a++){
            matrizRespuesta[0][a] = 0;
        }
        for(int i = 1; i < (slits+1); i++){
            matrizRespuesta[i][0] = 1/((double)slits);
            for(int f = 1; f < (probabilidades[0].length-1); f++){
                matrizRespuesta[i][f] = 0;
            }
        }
        int cont = 0;
        for(int b = slits+1; b < slits+targets+1; b++){
            matrizRespuesta[b] = probabilidades[cont];
            matrizRespuesta[b][b] = 1;
            cont +=1;
        }
        return matrizRespuesta;
    }
    
    
    public static boolean IgualMatricial(double[][] matriz1, double[][] matriz2){
        boolean bandera = true;
        for (int i = 0; i < matriz1.length; i++){
            for(int o = 0; o < matriz1[i].length; o++){
                if(matriz1[i][o]!= matriz2[i][o]){
                    bandera = false;
                }
            }
        }
        return bandera;
    }
}
