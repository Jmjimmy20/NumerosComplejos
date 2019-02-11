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
