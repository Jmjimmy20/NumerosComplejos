
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
public class TestMatrizFIlasColumnas {
    
    @Test
    public void testInverso() {
        boolean flagEsperada = true;
        MatrizFilasColumnas valorEsperado = new MatrizFilasColumnas(2,2);
        ComplexNumber valor1 = new ComplexNumber(-1, 1);
        valorEsperado.AddInPosition(0,0,valor1);
        ComplexNumber valor2 = new ComplexNumber(-2, 2);
        valorEsperado.AddInPosition(0,1,valor2);
        ComplexNumber valor3 = new ComplexNumber(1, -1);
        valorEsperado.AddInPosition(1,0,valor3);
        ComplexNumber valor4 = new ComplexNumber(2, -2);
        valorEsperado.AddInPosition(1,1,valor4);
        MatrizFilasColumnas matriz1 = new MatrizFilasColumnas(2,2);
        valor1 = new ComplexNumber(1, -1);
        matriz1.AddInPosition(0,0,valor1);
        valor2 = new ComplexNumber(2, -2);
        matriz1.AddInPosition(0,1,valor2);
        valor3 = new ComplexNumber(-1, 1);
        matriz1.AddInPosition(1,0,valor3);
        valor4 = new ComplexNumber(-2, 2);
        matriz1.AddInPosition(1,1,valor4);
        MatrizFilasColumnas matrizFinal = matriz1.Inverso();
        boolean flag = mathMatriz.IgualMatricial(matrizFinal, valorEsperado);
        assertEquals(flagEsperada, flag);
    }
    
}
