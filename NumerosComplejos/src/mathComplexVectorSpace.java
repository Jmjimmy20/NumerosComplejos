/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124203
 */
public class mathComplexVectorSpace {
    
    public static ComplexVectorSpace SumaMatricesVectores(ComplexVectorSpace matriz1, ComplexVectorSpace matriz2){
        
        int size1 = matriz1.GetSize();
        int size2 = matriz2.GetSize();
        if (size1 == size2){
            ComplexVectorSpace listaNueva = new ComplexVectorSpace(size1);
            for(int i = 0; i < size1; i++){
                listaNueva.AddValue(mathComplex.SumaComplejos(matriz1.GetPosition(i), matriz2.GetPosition(i)));
            }
            return listaNueva;
        }
        else{
            return null;
        }
        
        
    }  
    
    
    public static ComplexVectorSpace MultiplicacionScalarMatriz(ComplexNumber complejo1, ComplexVectorSpace lista1){
        int size = lista1.GetSize();
        ComplexVectorSpace listaN = new ComplexVectorSpace(size);
        for(int i = 0; i < size; i++){
           ComplexNumber numeroN = mathComplex.ProductoComplejos(complejo1, lista1.GetPosition(i));
           listaN.AddValue(numeroN);
        }
        return listaN;
    }
    
    
}
