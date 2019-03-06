/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci;

import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author jfmor
 */
public class TestExperimentoCuantico {
    
    
     @Test
     public void testMultiplicacionMatrizVectorFracciones() 
     {
        boolean flagEsperada = true;
        double[] valorEsperado = new double[4];
        valorEsperado[0] = 0;
        valorEsperado[1] = 1.0/2.0;
        valorEsperado[2] = 1.0/2.0;
        valorEsperado[3] = 0;
        double[][] matriz = new double[4][4];
        matriz[0][0] = 0;
        matriz[0][1] = 1.0/2.0;
        matriz[0][2] = 1.0/2.0;
        matriz[0][3] = 0;
        matriz[1][0] = 1.0/2.0;
        matriz[1][1] = 0;
        matriz[1][2] = 0;
        matriz[1][3] = 1.0/2.0;
        matriz[2][0] = 1.0/2.0;
        matriz[2][1] = 0;
        matriz[2][2] = 0;
        matriz[2][3] = 1.0/2.0;
        matriz[3][0] = 0;
        matriz[3][1] = 1.0/2.0;
        matriz[3][2] = 1.0/2.0;
        matriz[3][3] = 0;
        double[] vector = new double[4];
        vector[0] = 1;
        vector[1] = 0;
        vector[2] = 0;
        vector[3] = 0;
        double[] vectorFinal = ExperimentoCuantico.MultiplicacionMatrizVectorConMovimiento(matriz, vector, 1);
        boolean flag = ExperimentoCuantico.igualdadVectores(vectorFinal, valorEsperado);
        assertEquals(flagEsperada, flag);

     }
     
     @Test
     public void testMultiplicacionMatrizVectorFracciones2() 
     {
        boolean flagEsperada = true;
        double[] valorEsperado = new double[4];
        valorEsperado[0] = 1.0/2.0;
        valorEsperado[1] = 0;
        valorEsperado[2] = 0;
        valorEsperado[3] = 1.0/2.0;
        double[][] matriz = new double[4][4];
        matriz[0][0] = 0;
        matriz[0][1] = 1.0/2.0;
        matriz[0][2] = 1.0/2.0;
        matriz[0][3] = 0;
        matriz[1][0] = 1.0/2.0;
        matriz[1][1] = 0;
        matriz[1][2] = 0;
        matriz[1][3] = 1.0/2.0;
        matriz[2][0] = 1.0/2.0;
        matriz[2][1] = 0;
        matriz[2][2] = 0;
        matriz[2][3] = 1.0/2.0;
        matriz[3][0] = 0;
        matriz[3][1] = 1.0/2.0;
        matriz[3][2] = 1.0/2.0;
        matriz[3][3] = 0;
        double[] vector = new double[4];
        vector[0] = 1;
        vector[1] = 0;
        vector[2] = 0;
        vector[3] = 0;
        double[] vectorFinal = ExperimentoCuantico.MultiplicacionMatrizVectorConMovimiento(matriz, vector, 2);
        boolean flag = ExperimentoCuantico.igualdadVectores(vectorFinal, valorEsperado);
        assertEquals(flagEsperada, flag);
     }
     
     @Test
     public void PruebaSlitsTargetsFracciones(){
        boolean flagEsperada = true;
        double unTercio = (double)1/(double)3;
        double unNoveno = (double)1/(double)9;
        double dosNovenos = (double)2/(double)9;
        double[][] matrizEsperadaSinAplicarEstado = {
            {0,0,0,0,0,0,0,0,0,0,0},
            {unTercio,0,0,0,0,0,0,0,0,0,0},
            {unTercio,0,0,0,0,0,0,0,0,0,0},
            {unTercio,0,0,0,0,0,0,0,0,0,0},
            {0,unTercio,0,0,1,0,0,0,0,0,0},
            {0,unTercio,0,0,0,1,0,0,0,0,0},
            {0,unTercio,unTercio,0,0,0,1,0,0,0,0},
            {0,0,unTercio,0,0,0,0,1,0,0,0},
            {0,0,unTercio,unTercio,0,0,0,0,1,0,0},
            {0,0,0,unTercio,0,0,0,0,0,1,0},
            {0,0,0,unTercio,0,0,0,0,0,0,1}
        };
        
        double[][] matrizEsperadaConClick = {
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {unNoveno,unTercio,0,0,1,0,0,0,0,0,0},
            {unNoveno,unTercio,0,0,0,1,0,0,0,0,0},
            {dosNovenos,unTercio,unTercio,0,0,0,1,0,0,0,0},
            {unNoveno,0,unTercio,0,0,0,0,1,0,0,0},
            {dosNovenos,0,unTercio,unTercio,0,0,0,0,1,0,0},
            {unNoveno,0,0,unTercio,0,0,0,0,0,1,0},
            {unNoveno,0,0,unTercio,0,0,0,0,0,0,1}
        };
        
        double[] productoMatrizConClickVector = {0,0,0,0,unNoveno,unNoveno,dosNovenos,unNoveno,dosNovenos,unNoveno,unNoveno};
        
        double[] vector = {1,0,0,0,0,0,0,0,0,0,0};
        
        double[][] probabilidades = {
        {0,unTercio,0,0,0,0,0,0,0,0,0},
        {0,unTercio,0,0,0,0,0,0,0,0,0},
        {0,unTercio,unTercio,0,0,0,0,0,0,0,0},
        {0,0,unTercio,0,0,0,0,0,0,0,0},
        {0,0,unTercio,unTercio,0,0,0,0,0,0,0},
        {0,0,0,unTercio,0,0,0,0,0,0,0},
        {0,0,0,unTercio,0,0,0,0,0,0,0}
        };
        
        double[][] matrizConstruida = ExperimentoCuantico.CreacionMatrizConSlitsTargets(3,7,probabilidades);
        boolean flag = ExperimentoCuantico.IgualMatricial(matrizConstruida, matrizEsperadaSinAplicarEstado);
        if(!flag){
            assertEquals(flagEsperada, flag);
        }
        double[][] matrizConClick = ExperimentoCuantico.MultiplicacionMatricial(matrizConstruida, matrizConstruida);
        flag = ExperimentoCuantico.IgualMatricial(matrizConClick, matrizEsperadaConClick);
        if(!flag){
            assertEquals(flagEsperada, flag);
        }
        
        double[] vectorConClickMultiplicado = ExperimentoCuantico.MultiplicacionMatrizVector(matrizConClick, vector);
        flag = ExperimentoCuantico.igualdadVectores(vectorConClickMultiplicado, productoMatrizConClickVector);
        assertEquals(flagEsperada, flag);
     }
     
     @Test
     public void PruebaMultiplicacionMatrizVectorComplejos(){
         boolean flagEsperada = true;
        VectorFilasColumna valorEsperado = new VectorFilasColumna(3);
        valorEsperado.AddValue(new ComplexNumber(Math.round((Math.sqrt(5.0)/Math.sqrt(30.0)) * 100) / 100d, Math.round((2.0/Math.sqrt(30.0)) * 100) / 100d));
        valorEsperado.AddValue(new ComplexNumber(Math.round((-2.0/Math.sqrt(30.0)) * 100) / 100d,Math.round(-(Math.sqrt(5.0))/Math.sqrt(30.0) * 100)/100d));
        valorEsperado.AddValue(new ComplexNumber(0, Math.round((Math.sqrt(2.0/5.0)) * 100) / 100d));
        MatrizFilasColumnas matriz = new MatrizFilasColumnas(3, 3);
        matriz.AddInPosition(0, 0, new ComplexNumber(1.0/Math.sqrt(2.0), 0));
        matriz.AddInPosition(0, 1, new ComplexNumber(1.0/Math.sqrt(2.0), 0));
        matriz.AddInPosition(0, 2, new ComplexNumber(0, 0));
        matriz.AddInPosition(1, 0, new ComplexNumber(0, -1.0/Math.sqrt(2.0)));
        matriz.AddInPosition(1, 1, new ComplexNumber(0, 1.0/Math.sqrt(2.0)));
        matriz.AddInPosition(1, 2, new ComplexNumber(0, 0));
        matriz.AddInPosition(2, 0, new ComplexNumber(0, 0));
        matriz.AddInPosition(2, 1, new ComplexNumber(0, 0));
        matriz.AddInPosition(2, 2, new ComplexNumber(0, 1.0/Math.sqrt(2.0)));
        VectorFilasColumna vector = new VectorFilasColumna(3);
        vector.AddValue(new ComplexNumber(1.0/Math.sqrt(3.0), 0));
        vector.AddValue(new ComplexNumber(0, 2.0/Math.sqrt(15.0)));
        vector.AddValue(new ComplexNumber(2.0/Math.sqrt(5.0), 0));
        VectorFilasColumna vectorFinal = mathMatriz.MultiplicacionMatrizVectorConMovimiento(matriz, vector, 1);
        boolean flag = mathComplexVectorSpace.IgualdadVectores(vectorFinal, valorEsperado);
        assertEquals(flagEsperada, flag);
     }
     
     
     
     
     
}
