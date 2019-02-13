/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2124203
 */
public class TestMath {
    
    @Test
    public void testCalcularSuma() {
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(8, 11);
        ComplexNumber valor1 = new ComplexNumber(5, 3);
        ComplexNumber valor2 = new ComplexNumber(3, 8);
        ComplexNumber valorRespuesta = mathComplex.SumaComplejos(valor1, valor2);
        boolean flag = mathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
    
    
    @Test
    public void testCalcularResta(){
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(4, 12);
        ComplexNumber valor1 = new ComplexNumber(8, 20);
        ComplexNumber valor2 = new ComplexNumber(4, 8);
        ComplexNumber valorRespuesta = mathComplex.RestaComplejos(valor1, valor2);
        boolean flag = mathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
    
    @Test
    public void testCalcularMultiplicacion(){
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(7, 4);
        ComplexNumber valor1 = new ComplexNumber(4, 0);
        ComplexNumber valor2 = new ComplexNumber(4, 2);
        System.out.println("hola 2");
        ComplexNumber valorRespuesta = mathComplex.ProductoComplejos(valor1, valor2);
        System.out.println("hola 1");
        boolean flag = mathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
    
    @Test
    public void testCalcularDivision(){
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(0, 1);
        ComplexNumber valor1 = new ComplexNumber(-2, 1);
        ComplexNumber valor2 = new ComplexNumber(1, 2);
        ComplexNumber valorRespuesta = mathComplex.DivisionCompleja(valor1, valor2);
        boolean flag = mathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
    
    @Test
    public void testCartesianoAPolar(){
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(1.4142135623730951,0.7853981633974483);
        ComplexNumber valor1 = new ComplexNumber(1, 1);
        ComplexNumber valorRespuesta = mathComplex.CartesianoAPolar(valor1);
        boolean flag = mathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
    
    @Test
    public void testPolarACartesiano(){
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(1,1);
        ComplexNumber valor1 = new ComplexNumber(1.4142135623730951, 0.7853981633974483);
        ComplexNumber valorRespuesta = mathComplex.PolarACartesiano(valor1);
        boolean flag = mathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
}
