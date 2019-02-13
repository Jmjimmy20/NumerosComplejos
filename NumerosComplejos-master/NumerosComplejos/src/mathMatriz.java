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
            int contador = 1;
            ComplexNumber complejoN; 
            ComplexNumber complejoSumador;
            MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
            for(int i = 0; i < matriz1.sizeFilas; i ++){
                System.out.println(i);
                complejoSumador = new ComplexNumber(0, 0);
                for(int o = 0; o < matriz1.sizeColumnas; o ++){
                    complejoN = mathComplex.ProductoComplejos(matriz1.GetPosition(i, o), matriz2.GetPosition(o, (contador-1)));
                    complejoSumador = mathComplex.SumaComplejos(complejoN, complejoSumador);
                }
                if (contador != matriz1.sizeColumnas){
                    matrizN.AddInPosition(i, contador, complejoSumador);
                    contador++;
                    System.out.println(contador);
                    i-=1;
                }
                else{
                    matrizN.AddInPosition(i, contador, complejoSumador);
                    contador = 1;
                    System.out.println(i);
                }
                
                
            }
            return matrizN;
        }
        else{
            System.out.println("Las matrices no son del mismo tamanio, la operacion entregara un valor null");
            return null;
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
    
    
    
    
    
}
