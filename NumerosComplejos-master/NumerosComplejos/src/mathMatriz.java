
import com.sun.org.apache.bcel.internal.generic.AALOAD;

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
            MatrizFilasColumnas matrizN = new MatrizFilasColumnas(matriz1.sizeFilas, matriz1.sizeColumnas);
            System.out.println("mathMatriz.multiplicacionMatricial()" + matriz1.sizeFilas);
            for(int i = 0; i < matriz1.sizeFilas; i++){
                System.out.println(i);
                MultiplicacionMatrizVector(i,matriz1,matriz2,matrizN);
            }
            return matrizN;
        }
        else{
            System.out.println("Las matrices no son del mismo tamanio, la operacion entregara un valor null");
            return null;
        }
    }
    
    private static void MultiplicacionMatrizVector(int i, MatrizFilasColumnas matriz1, MatrizFilasColumnas matriz2, MatrizFilasColumnas N){
        ComplexNumber complejoN; 
        ComplexNumber complejoSuma;
        for(int a = 0; a < matriz2.sizeFilas; a++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int b = 0; b < matriz2.sizeColumnas; b++){
                complejoN = mathComplex.ProductoComplejos(matriz1.GetPosition(i, b), matriz2.GetPosition(b, a));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            N.AddInPosition(i, a, complejoSuma);
        }
        
    }
    
    
    public static VectorFilasColumna MultiplicacionVectorMatriz(VectorFilasColumna vector, MatrizFilasColumnas matriz){
        VectorFilasColumna vectorN = new VectorFilasColumna(matriz.sizeColumnas);
        ComplexNumber complejoN;
        ComplexNumber complejoSuma;
        for(int i = 0; i < matriz.sizeColumnas; i++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int o = 0; o < matriz.sizeFilas; o++){
                complejoN = mathComplex.ProductoComplejos(vector.GetPosition(o), matriz.GetPosition(o, i));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            vectorN.AddValue(complejoSuma);
        }
        return  vectorN;
    }
    
    public static VectorFilasColumna MultiplicacionMatrizVector(MatrizFilasColumnas matriz, VectorFilasColumna vector){
        VectorFilasColumna vectorN = new VectorFilasColumna(matriz.sizeFilas);
        ComplexNumber complejoN;
        ComplexNumber complejoSuma;
        for(int i = 0; i < matriz.sizeFilas; i++){
            complejoSuma = new ComplexNumber(0, 0);
            for(int o = 0; o < matriz.sizeColumnas; o++){
                complejoN = mathComplex.ProductoComplejos(vector.GetPosition(o), matriz.GetPosition(i, o));
                complejoSuma = mathComplex.SumaComplejos(complejoN, complejoSuma);
            }
            vectorN.AddValue(complejoSuma);
        }
        return  vectorN;
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
