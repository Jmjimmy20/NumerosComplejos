package edu.eci;

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
    
    public static VectorFilasColumna SumaMatricesFilasColumna(VectorFilasColumna matriz1, VectorFilasColumna matriz2){
        
        int size1 = matriz1.GetSize();
        int size2 = matriz2.GetSize();
        if (size1 == size2){
            VectorFilasColumna listaNueva = new VectorFilasColumna(size1);
            for(int i = 0; i < size1; i++){
                listaNueva.AddValue(mathComplex.SumaComplejos(matriz1.GetPosition(i), matriz2.GetPosition(i)));
            }
            return listaNueva;
        }
        else{
            return null;
        }
        
        
    }  
    
    
    public static VectorFilasColumna MultiplicacionScalarMatriz(ComplexNumber complejo1, VectorFilasColumna lista1){
        int size = lista1.GetSize();
        VectorFilasColumna listaN = new VectorFilasColumna(size);
        for(int i = 0; i < size; i++){
           ComplexNumber numeroN = mathComplex.ProductoComplejos(complejo1, lista1.GetPosition(i));
           listaN.AddValue(numeroN);
        }
        return listaN;
    }
    
    
    public static boolean IgualdadVectores(VectorFilasColumna matriz1, VectorFilasColumna matriz2){
        int tamanio = matriz1.GetSize();
        boolean iguales = true;
        for (int i = 0; i < tamanio; i++){
            System.out.println("vector1 " + matriz1.GetPosition(i).GetReal() +" " + matriz1.GetPosition(i).Getimaginario() + " vector2 " + matriz2.GetPosition(i).GetReal() + " " + matriz2.GetPosition(i).Getimaginario());
            if(!mathComplex.igualdadComplejos(matriz1.GetPosition(i), matriz2.GetPosition(i))){
                System.out.println("Entre aqui");
                iguales = false;
            }
        }
        return iguales;
    }
    
    
    public static ComplexNumber InnerProduct(ComplexVectorSpace vector1, ComplexVectorSpace vector2){
        ComplexNumber n = new ComplexNumber(0,0);
        for(int i = 0; i < vector1.GetSize(); i++){
            ComplexNumber ComplejoN = mathComplex.ProductoComplejos(vector1.GetPosition(i).Conjugado(), vector2.GetPosition(i));
            n = mathComplex.SumaComplejos(n, ComplejoN);
            System.out.println(n.GetReal()+" "+n.Getimaginario());
        }
        return n;
    }
    
    public static double NormComplejos(ComplexVectorSpace vector1){
        double numeroN = 0;
        for(int i = 0; i < vector1.GetSize(); i++){
            ComplexNumber ComplejoN = mathComplex.ProductoComplejos(vector1.GetPosition(i).Conjugado(), vector1.GetPosition(i));
            numeroN = ComplejoN.GetReal() + numeroN;
        }
        double retorno = Math.round(Math.sqrt(numeroN) * 10000) / 10000d;
        return retorno;
    }
    
    public static double DistanceComplejos(ComplexVectorSpace vector1, ComplexVectorSpace vector2){
        if (vector1.GetSize() == vector2.GetSize()){
            ComplexVectorSpace vectorN = new ComplexVectorSpace(vector1.GetSize());
            for(int i = 0; i < vector1.GetSize(); i++){
                ComplexNumber numeroN = mathComplex.RestaComplejos(vector1.GetPosition(i), vector2.GetPosition(i));
                vectorN.AddValue(numeroN);
            }
            return NormComplejos(vectorN);
        }
        else{
            System.out.println("El tamaño de alguno de los dos vectores es mayor al otro, el valor de respuesta sera cero");
            return 0;
        }
        
    }
    
    public static boolean IsHermitian(MatrizFilasColumnas matriz1){
        if (matriz1.sizeFilas == matriz1.sizeColumnas){
            MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
            MatrizFilasColumnas matrizFinal = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
            for(int i = 0; i < matriz1.sizeFilas; i++){
                for(int a = 0; a < matriz1.sizeColumnas; a++){
                    matrizN.AddInPosition(i, a, matriz1.GetPosition(i, a).Conjugado());
                    matrizFinal.AddInPosition(a, i, matrizN.GetPosition(i, a));
                }
            }
            return IgualdadMatricial(matriz1, matrizFinal);
        }
        else{
            return false;
        }
    }
    
//    public static ComplexVectorSpace BraVector(ComplexVectorSpace vector){
//        return mathComplexVectorSpace.
//    }
    
    
    
    public static boolean IgualdadMatricial(MatrizFilasColumnas matriz1,MatrizFilasColumnas matriz2){
        boolean valorRetorno = true;
        if ((matriz1.sizeColumnas != matriz2.sizeColumnas) || (matriz1.sizeFilas != matriz2.sizeFilas)){
            return false;
        }
        else{
            for(int i = 0; i < matriz1.sizeFilas; i++){
                for (int a = 0; a < matriz1.sizeColumnas; a++){
                    if(!mathComplex.igualdadComplejos(matriz1.GetPosition(i, a), matriz2.GetPosition(i, a))){
                        return false;
                    }
                }
            }
            
            return valorRetorno;
        }
        
    }
    
    
//    public static ComplexVectorSpace BraVector(ComplexVectorSpace ket){
//        return AdjuntaVector(ket);
//    }
    
    
//    public static ComplexVectorSpace AdjuntaVector(ComplexVectorSpace vector){
//        return conjugadaVector(transpuestaVector(vector));
//    }
//
//    private static ComplexVectorSpace transpuestaVector(ComplexVectorSpace vector) {
//
//    }
//    
//    public ComplexVectorSpace conjugadaVector(ComplexVectorSpace vector) {
// 
//    }
    
    
    public static ComplexNumber AmplitudTransicion(ComplexVectorSpace ket1, ComplexVectorSpace ket2){
        return InnerProduct(ket1, ket2);
    }
    
   
            
}
