
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
public class ComplexVectorSpace {
    
    //Atributos
    List<ComplexNumber> ListVector = new ArrayList<ComplexNumber>();
    int size;
    
    public ComplexVectorSpace(int sizeN){
        size = sizeN;
    }
    
    public void AddValue(ComplexNumber CompNew){
        if(size < ListVector.size()){
            ListVector.add(CompNew);
        }
        
    }
    
    
    public int GetSize(){
        return size;
    }
    
    
    public ComplexNumber GetPosition(int pos){
        return ListVector.get(pos);
    }
    
    
    public ComplexVectorSpace Inverso(){
        ComplexVectorSpace listaN = new ComplexVectorSpace(size);
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
    
    
}
