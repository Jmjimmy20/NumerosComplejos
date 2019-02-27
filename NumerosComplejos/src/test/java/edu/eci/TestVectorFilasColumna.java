package edu.eci;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124203
 */
public class TestVectorFilasColumna {
    @Test
    public void testCalcularSumaVectores() {
        boolean flagEsperada = true;
        VectorFilasColumna valorEsperado = new VectorFilasColumna(4);
        ComplexNumber valor1 = new ComplexNumber(22, -1.7);
        valorEsperado.AddValue(valor1);
        ComplexNumber valor2 = new ComplexNumber(7, -4);
        valorEsperado.AddValue(valor2);
        ComplexNumber valor3 = new ComplexNumber(10.2, -8.1);
        valorEsperado.AddValue(valor3);
        ComplexNumber valor4 = new ComplexNumber(0, -7);
        valorEsperado.AddValue(valor4);
        VectorFilasColumna vector1 = new VectorFilasColumna(4);
        valor1 = new ComplexNumber(6, -4);
        vector1.AddValue(valor1);
        valor2 = new ComplexNumber(7, 3);
        vector1.AddValue(valor2);
        valor3 = new ComplexNumber(4.2, -8.1);
        vector1.AddValue(valor3);
        valor4 = new ComplexNumber(0, -3);
        vector1.AddValue(valor4);
        VectorFilasColumna vector2 = new VectorFilasColumna(4);
        valor1 = new ComplexNumber(16, 2.3);
        vector2.AddValue(valor1);
        valor2 = new ComplexNumber(0, -7);
        vector2.AddValue(valor2);
        valor3 = new ComplexNumber(6, 0);
        vector2.AddValue(valor3);
        valor4 = new ComplexNumber(0, -4);
        vector2.AddValue(valor4);
        VectorFilasColumna valorRespuesta = mathComplexVectorSpace.SumaMatricesFilasColumna(vector1, vector2);
        boolean flag = mathComplexVectorSpace.IgualdadVectores(valorRespuesta, valorEsperado);
        assertEquals(flagEsperada, flag);
    }
    
    
    @Test
    public void testInverso(){
        boolean flagEsperada = true;
        VectorFilasColumna valorEsperado = new VectorFilasColumna(4);
        ComplexNumber valor1 = new ComplexNumber(-6, -3);
        valorEsperado.AddValue(valor1);
        ComplexNumber valor2 = new ComplexNumber(-2, 2);
        valorEsperado.AddValue(valor2);
        ComplexNumber valor3 = new ComplexNumber(-5, 1);
        valorEsperado.AddValue(valor3);
        ComplexNumber valor4 = new ComplexNumber(12, 0);
        valorEsperado.AddValue(valor4);
        VectorFilasColumna vector2 = new VectorFilasColumna(4);
        valor1 = new ComplexNumber(6, 3);
        vector2.AddValue(valor1);
        valor2 = new ComplexNumber(2, -2);
        vector2.AddValue(valor2);
        valor3 = new ComplexNumber(5, -1);
        vector2.AddValue(valor3);
        valor4 = new ComplexNumber(-12, 0);
        vector2.AddValue(valor4);
        VectorFilasColumna valorRespuesta = vector2.Inverso();
        boolean flag = mathComplexVectorSpace.IgualdadVectores(valorRespuesta, valorEsperado);
        assertEquals(flagEsperada, flag);
    }
    
    @Test
    public void testMultiplicacionScalar(){
        boolean flagEsperada = true;
        VectorFilasColumna valorEsperado = new VectorFilasColumna(4);
        ComplexNumber valor1 = new ComplexNumber(12, 21);
        valorEsperado.AddValue(valor1);
        ComplexNumber valor2 = new ComplexNumber(0, 0);
        valorEsperado.AddValue(valor2);
        ComplexNumber valor3 = new ComplexNumber(13, 13);
        valorEsperado.AddValue(valor3);
        ComplexNumber valor4 = new ComplexNumber(12, 8);
        valorEsperado.AddValue(valor4);
        ComplexNumber valorcomplejo = new ComplexNumber(3, 2);
        VectorFilasColumna vector2 = new VectorFilasColumna(4);
        valor1 = new ComplexNumber(6, 3);
        vector2.AddValue(valor1);
        valor2 = new ComplexNumber(0, 0);
        vector2.AddValue(valor2);
        valor3 = new ComplexNumber(5, 1);
        vector2.AddValue(valor3);
        valor4 = new ComplexNumber(4, 0);
        vector2.AddValue(valor4);
        VectorFilasColumna valorRespuesta = mathComplexVectorSpace.MultiplicacionScalarMatriz(valorcomplejo, vector2);
        boolean flag = mathComplexVectorSpace.IgualdadVectores(valorRespuesta, valorEsperado);
        assertEquals(flagEsperada, flag);
    }
}
