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
     
     
//     @Test
//     public void PruebaSlitsTargetsFraccionesComplejos(){
//        boolean flagEsperada = true;
////        double unTercio = (double)1/(double)3;
////        double unNoveno = (double)1/(double)9;
////        double dosNovenos = (double)2/(double)9;
//        MatrizFilasColumnas matrizEsperadaSinAplicarEstado = new MatrizFilasColumnas(11, 11);
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,0,new ComplexNumber(Math.round((1./Math.sqrt(3.0)) * 100) / 100d,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,0,new ComplexNumber(Math.round((1./Math.sqrt(3.0)) * 100) / 100d,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,0,new ComplexNumber(Math.round((1./Math.sqrt(3.0)) * 100) / 100d,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,0,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,0,new ComplexNumber(0,0));
//        
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,1,new ComplexNumber(Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,1,new ComplexNumber(Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,1,new ComplexNumber(Math.round((1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,1,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,1,new ComplexNumber(0,0));
//
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,2,new ComplexNumber(Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,2,new ComplexNumber(Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,2,new ComplexNumber(Math.round((1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,2,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,2,new ComplexNumber(0,0));
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,3,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,3,new ComplexNumber(Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,3,new ComplexNumber(Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,3,new ComplexNumber(Math.round((1.0/Math.sqrt(6.0)) * 100) / 100d, Math.round((-1.0/Math.sqrt(6.0)) * 100) / 100d));
//        
//
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,4,new ComplexNumber(1,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,4,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,4,new ComplexNumber(0,0));
//        
//
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,5,new ComplexNumber(5,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,5,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,5,new ComplexNumber(0,0));
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,6,new ComplexNumber(1,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,6,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,6,new ComplexNumber(0,0));
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,7,new ComplexNumber(1,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,7,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,7,new ComplexNumber(0,0));
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,8,new ComplexNumber(1,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,8,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,8,new ComplexNumber(0,0));
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,9,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,9,new ComplexNumber(1,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,9,new ComplexNumber(0,0));
//        
//        matrizEsperadaSinAplicarEstado.AddInPosition(0,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(1,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(2,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(3,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(4,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(5,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(6,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(7,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(8,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(9,10,new ComplexNumber(0,0));
//        matrizEsperadaSinAplicarEstado.AddInPosition(10,10,new ComplexNumber(1,0));
//
//
//        MatrizFilasColumnas matrizEsperadaConClick = new MatrizFilasColumnas(11, 11);
//        
//        matrizEsperadaConClick.AddInPosition(0,0,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,0,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,0,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,0,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,0,new ComplexNumber(1.0/9.0,0));
//        matrizEsperadaConClick.AddInPosition(5,0,new ComplexNumber(1.0/9.0,0));
//        matrizEsperadaConClick.AddInPosition(6,0,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,0,new ComplexNumber(1.0/9.0,0));
//        matrizEsperadaConClick.AddInPosition(8,0,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,0,new ComplexNumber(1.0/9.0,0));
//        matrizEsperadaConClick.AddInPosition(10,0,new ComplexNumber(1.0/9.0,0));
//        
//        
//        matrizEsperadaConClick.AddInPosition(0,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,1,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(5,1,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(6,1,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(7,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,1,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,1,new ComplexNumber(0,0));
//
//        matrizEsperadaConClick.AddInPosition(0,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,2,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(7,2,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(8,2,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(9,2,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,2,new ComplexNumber(0,0));
//        
//        matrizEsperadaConClick.AddInPosition(0,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,3,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,3,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(9,3,new ComplexNumber(1.0/3.0, 0));
//        matrizEsperadaConClick.AddInPosition(10,3,new ComplexNumber(1.0/3.0, 0));
//        
//
//        matrizEsperadaConClick.AddInPosition(0,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,4,new ComplexNumber(1,0));
//        matrizEsperadaConClick.AddInPosition(5,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,4,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,4,new ComplexNumber(0,0));
//        
//
//        matrizEsperadaConClick.AddInPosition(0,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,5,new ComplexNumber(5,0));
//        matrizEsperadaConClick.AddInPosition(6,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,5,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,5,new ComplexNumber(0,0));
//        
//        matrizEsperadaConClick.AddInPosition(0,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,6,new ComplexNumber(1,0));
//        matrizEsperadaConClick.AddInPosition(7,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,6,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,6,new ComplexNumber(0,0));
//        
//        matrizEsperadaConClick.AddInPosition(0,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,7,new ComplexNumber(1,0));
//        matrizEsperadaConClick.AddInPosition(8,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,7,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,7,new ComplexNumber(0,0));
//        
//        matrizEsperadaConClick.AddInPosition(0,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,8,new ComplexNumber(1,0));
//        matrizEsperadaConClick.AddInPosition(9,8,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,8,new ComplexNumber(0,0));
//        
//        matrizEsperadaConClick.AddInPosition(0,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,9,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,9,new ComplexNumber(1,0));
//        matrizEsperadaConClick.AddInPosition(10,9,new ComplexNumber(0,0));
//        
//        matrizEsperadaConClick.AddInPosition(0,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(1,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(2,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(3,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(4,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(5,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(6,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(7,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(8,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(9,10,new ComplexNumber(0,0));
//        matrizEsperadaConClick.AddInPosition(10,10,new ComplexNumber(1,0));
//        
//        
//        VectorFilasColumna productoMatrizConClickVector = new VectorFilasColumna(11);
//        
//        productoMatrizConClickVector.AddValue(new );
//        double[] productoMatrizConClickVector = {0,0,0,0,1.0/9.0,1.0/9.0,0,1.0/9.0,0,1.0/9.0,1.0/9.0};
//        
//        double[] vector = {1,0,0,0,0,0,0,0,0,0,0};
//        
//        double[][] probabilidades = {
//        {0,unTercio,0,0,0,0,0,0,0,0,0},
//        {0,unTercio,0,0,0,0,0,0,0,0,0},
//        {0,unTercio,unTercio,0,0,0,0,0,0,0,0},
//        {0,0,unTercio,0,0,0,0,0,0,0,0},
//        {0,0,unTercio,unTercio,0,0,0,0,0,0,0},
//        {0,0,0,unTercio,0,0,0,0,0,0,0},
//        {0,0,0,unTercio,0,0,0,0,0,0,0}
//        };
//        
//        double[][] matrizConstruida = ExperimentoCuantico.CreacionMatrizConSlitsTargets(3,7,probabilidades);
//        boolean flag = ExperimentoCuantico.IgualMatricial(matrizConstruida, matrizEsperadaSinAplicarEstado);
//        if(!flag){
//            assertEquals(flagEsperada, flag);
//        }
//        double[][] matrizConClick = ExperimentoCuantico.MultiplicacionMatricial(matrizConstruida, matrizConstruida);
//        flag = ExperimentoCuantico.IgualMatricial(matrizConClick, matrizEsperadaConClick);
//        if(!flag){
//            assertEquals(flagEsperada, flag);
//        }
//        
//        double[] vectorConClickMultiplicado = ExperimentoCuantico.MultiplicacionMatrizVector(matrizConClick, vector);
//        flag = ExperimentoCuantico.igualdadVectores(vectorConClickMultiplicado, productoMatrizConClickVector);
//        assertEquals(flagEsperada, flag);
//     }
     
     
   @Test
     public void testEncontrarProbabilidadDeUnPunto() 
     {
        boolean flagEsperada = true;
        VectorFilasColumna valorEsperado = new VectorFilasColumna(4);
        valorEsperado.AddValue(new ComplexNumber(0.5263155343491542, 0));
        valorEsperado.AddValue(new ComplexNumber(0.21052621373966163, 0));
        valorEsperado.AddValue(new ComplexNumber(0.05263155343491541, 0));
        valorEsperado.AddValue(new ComplexNumber(0.21052621373966163, 0));
        
        int cantidadPuntos = 4;
        ComplexVectorSpace ket = new ComplexVectorSpace(cantidadPuntos);
        ket.AddValue(new ComplexNumber(-3, -1));
        ket.AddValue(new ComplexNumber(0, -2));
        ket.AddValue(new ComplexNumber(0, 1));
        ket.AddValue(new ComplexNumber(2, 0));
        int puntoBuscar = 3;
        double probabilidad = ExperimentoCuantico.ProbabilidadPunto(ket.GetPosition(puntoBuscar),ket);
         System.out.println("probabilidad " + probabilidad);
        boolean flag = ExperimentoCuantico.IgualdadValores(probabilidad, valorEsperado.GetPosition(puntoBuscar).GetReal());
        assertEquals(flagEsperada, flag);

     }  
     
     
    @Test
     public void testTrancitarEntreDosKets() 
     {
        boolean flagEsperada = true;
         ComplexNumber valorEsperado = new ComplexNumber(0, -2);
        
        ComplexVectorSpace ket1 = new ComplexVectorSpace(2);
        ket1.AddValue(new ComplexNumber(0, -1));
        ket1.AddValue(new ComplexNumber(1, 0));
        
        ComplexVectorSpace ket2 = new ComplexVectorSpace(2);
        ket2.AddValue(new ComplexNumber(1, 0));
        ket2.AddValue(new ComplexNumber(0, -1));

        ComplexNumber respuesta = mathComplexVectorSpace.AmplitudTransicion(ket1, ket2);
        boolean flag = mathComplex.igualdadComplejos(respuesta, valorEsperado);
        assertEquals(flagEsperada, flag);

//        double val1 = Math.sqrt(2)/2;
//
//        ket2 = new ComplexVectorSpace(2);
//        ket2.AddValue(new ComplexNumber(0, val1));
//        ket2.AddValue(new ComplexNumber(val1, 0));
//        
//         ket1 = new ComplexVectorSpace(2);
//        ket1.AddValue(new ComplexNumber(val1, 0));
//        ket1.AddValue(new ComplexNumber(0, val1));
//        
//        ComplexNumber respuesta2 = mathComplexVectorSpace.AmplitudTransicion(ket1, ket2);
//         System.out.println("real " + respuesta2.GetReal() + " imaginario" + respuesta2.Getimaginario());
//        boolean flag2 = mathComplex.igualdadComplejos(respuesta2, valorEsperado);
//        assertEquals(flag, flag2);
     } 
     
     
}
