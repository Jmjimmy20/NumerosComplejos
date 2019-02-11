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
    int sizeFilas;
    int sizeColumnas;
    int conteoAnadidos;
    ComplexNumber [][] matriz;
    
    
    public MatrizFilasColumnas(int tamFilas, int tamColumnas){
        sizeFilas = tamFilas;
        sizeColumnas = tamColumnas;
        matriz = new ComplexNumber[sizeFilas][sizeColumnas];
    }
    
    
    public void AddInPosition(int posFila, int posColumna, ComplexNumber valor){
        matriz[posFila][posColumna] = valor;
    }
    
    public ComplexNumber GetPosition(int posFila, int posColumna){
        return matriz[posFila][posColumna];
    }
    
   
    public MatrizFilasColumnas Inverso(){
        double valorReal;
        double valorImaginario;
        ComplexNumber complejoN;
        MatrizFilasColumnas matrizNueva = new MatrizFilasColumnas(sizeFilas, sizeColumnas);
        for (int i = 0; i < sizeFilas; i++){
            for(int o = 0; o < sizeColumnas; o++){
                valorReal = (matriz[i][o].GetReal() * -1);
                valorImaginario = (matriz[i][o].Getimaginario() * -1);
                complejoN  = new ComplexNumber(valorReal, valorImaginario);
                matrizNueva.AddInPosition(i, o, complejoN);
            }
        }
        return matrizNueva;
    }
}
