
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124203
 */
public class VectorFilasColumna {
    
    //Atributos
    List<ComplexNumber> ListVector = new ArrayList<ComplexNumber>();
    int size;
    
    public VectorFilasColumna(int sizeN){
        size = sizeN;
    }
    
    public void AddValue(ComplexNumber CompNew){
        if(ListVector.size() < size){
            ListVector.add(CompNew);
        }
        
    }
    
    
    public int GetSize(){
        return size;
    }
    
    
    public ComplexNumber GetPosition(int pos){
        return ListVector.get(pos);
    }
    
    
    public VectorFilasColumna Inverso(){
        VectorFilasColumna listaN = new VectorFilasColumna(size);
        for(int i = 0; i < size; i++){
            ComplexNumber complejoRespaldo;
            complejoRespaldo = ListVector.get(i);
            double realN = (complejoRespaldo.GetReal() * -1);
            double imaginarioN = (complejoRespaldo.Getimaginario()* -1);
            complejoRespaldo = new ComplexNumber(realN, imaginarioN);
            listaN.AddValue(complejoRespaldo);
        }
        return listaN;
    }
    
    
    public void Print(){
        for(int i = 0; i < size; i++){
            System.out.println(this.GetPosition(i).GetReal() + " " +this.GetPosition(i).Getimaginario());
        }
            System.out.println("");
    }
    
    
}
