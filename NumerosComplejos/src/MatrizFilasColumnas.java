/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124203
 */
public class MatrizFilasColumnas {
    //Atributos 
    int sizeM;
    int sizeN;
    int conteoAnadidos;
    ComplexNumber [][] matriz;
    
    
    public MatrizFilasColumnas(int tamM, int tamN){
        sizeM = tamM;
        sizeN = tamN;
        matriz = new ComplexNumber[sizeM][sizeN];
    }
    
    
    public void AddInPosition(int posX, int posY, ComplexNumber valor){
        
    }
    
}
