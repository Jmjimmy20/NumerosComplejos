/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author jfmor
 */
public class TestMathComplexVectorSpace {
    


     @Test
     public void TestInnerProduct()
     {
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(82,-40);
        ComplexVectorSpace vector1 = new ComplexVectorSpace(3);
        ComplexNumber valor1 = new ComplexNumber(5, 4);
        vector1.AddValue(valor1);
        ComplexNumber valor2 = new ComplexNumber(3, 2);
        vector1.AddValue(valor2);
        ComplexNumber valor3 = new ComplexNumber(-7, 4);
        vector1.AddValue(valor3);
        ComplexVectorSpace vector2 = new ComplexVectorSpace(3);
        valor1 = new ComplexNumber(6, 3);
        vector2.AddValue(valor1);
        valor2 = new ComplexNumber(2, 5);
        vector2.AddValue(valor2);
        valor3 = new ComplexNumber(0, 6);
        vector2.AddValue(valor3);
        ComplexNumber matrizFinal = mathComplexVectorSpace.InnerProduct(vector1, vector2);
        boolean flag = mathComplex.igualdadComplejos(matrizFinal, valorEsperado);
        assertEquals(flagEsperada, flag);
     }
     
     @Test
     public void TestNormVectoresComplejos()
     {
        boolean flagEsperada = true;
        double valorEsperado = ((double) Math.sqrt(439));
        ComplexVectorSpace vector1 = new ComplexVectorSpace(4);
        ComplexNumber valor1 = new ComplexNumber(4, 3);
        vector1.AddValue(valor1);
        ComplexNumber valor2 = new ComplexNumber(6, -4);
        vector1.AddValue(valor2);
        ComplexNumber valor3 = new ComplexNumber(12, -7);
        vector1.AddValue(valor3);
        ComplexNumber valor4 = new ComplexNumber(0, 13);
        vector1.AddValue(valor4);
        double valorFinal = mathComplexVectorSpace.NormComplejos(vector1);
        boolean flag = false;
        if(valorFinal == valorEsperado){
            flag = true;
        }
        
        assertEquals(flagEsperada, flag);
     }
     
    @Test
     public void TestDistanciaVectoresComplejos()
     {
        boolean flagEsperada = true;
        double valorEsperado = ((double) Math.sqrt(439));
        ComplexVectorSpace vector1 = new ComplexVectorSpace(4);
        ComplexNumber valor1 = new ComplexNumber(6, 6);
        vector1.AddValue(valor1);
        ComplexNumber valor2 = new ComplexNumber(8, -8);
        vector1.AddValue(valor2);
        ComplexNumber valor3 = new ComplexNumber(24, -5);
        vector1.AddValue(valor3);
        ComplexNumber valor4 = new ComplexNumber(0, 10);
        vector1.AddValue(valor4);
        ComplexVectorSpace vector2 = new ComplexVectorSpace(4);
        valor1 = new ComplexNumber(2, 3);
        vector2.AddValue(valor1);
        valor2 = new ComplexNumber(2, -4);
        vector2.AddValue(valor2);
        valor3 = new ComplexNumber(12, 2);
        vector2.AddValue(valor3);
        valor4 = new ComplexNumber(0, -3);
        vector2.AddValue(valor4);
        double valorFinal = mathComplexVectorSpace.DistanceComplejos(vector1, vector2);
        boolean flag = false;
        if(valorFinal == valorEsperado){
            flag = true;
        }
        
        assertEquals(flagEsperada, flag);
     }
     
    @Test
     public void TestHermitianMatriz()
     {
        boolean flagEsperada = true;
        MatrizFilasColumnas matriz1 = new MatrizFilasColumnas(3,3);
        ComplexNumber valor1 = new ComplexNumber(5, 0);
        matriz1.AddInPosition(0,0,valor1);
        ComplexNumber valor2 = new ComplexNumber(4, 5);
        matriz1.AddInPosition(0,1,valor2);
        ComplexNumber valor3 = new ComplexNumber(6, -16);
        matriz1.AddInPosition(0,2,valor3);
        ComplexNumber valor4 = new ComplexNumber(4, -5);
        matriz1.AddInPosition(1,0,valor4);
        ComplexNumber valor5 = new ComplexNumber(13, 0);
        matriz1.AddInPosition(1,1,valor5);
        ComplexNumber valor6 = new ComplexNumber(7, 0);
        matriz1.AddInPosition(1,2,valor6);
        ComplexNumber valor7 = new ComplexNumber(6, 16);
        matriz1.AddInPosition(2,0,valor7);
        ComplexNumber valor8 = new ComplexNumber(7, 0);
        matriz1.AddInPosition(2,1,valor8);
        ComplexNumber valor9 = new ComplexNumber(-2.1, 0);
        matriz1.AddInPosition(2,2,valor9);        
        boolean flag = mathComplexVectorSpace.IsHermitian(matriz1);
        assertEquals(flagEsperada, flag);
     }  
     
    
     
}
