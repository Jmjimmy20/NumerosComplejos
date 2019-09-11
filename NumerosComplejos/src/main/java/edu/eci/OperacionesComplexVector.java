package main;

public class OperacionesComplexVector {
	
	
public static ComplexVector SumaMatricesFilasColumna(ComplexVector matriz1, ComplexVector matriz2){
        
        int size1 = matriz1.GetSize();
        int size2 = matriz2.GetSize();
        if (size1 == size2){
        	ComplexVector listaNueva = new ComplexVector(size1);
            for(int i = 0; i < size1; i++){
                listaNueva.AddValue(Operaciones.Sum(matriz1.GetPosition(i),matriz2.GetPosition(i)));
            }
            return listaNueva;
        }
        else{
            return null;
        }
        
        
    }

	public static ComplexVector MultiplicacionScalarMatriz(Complejo complejo1, ComplexVector lista1){
	    int size = lista1.GetSize();
	    ComplexVector listaN = new ComplexVector(size);
	    for(int i = 0; i < size; i++){
	       Complejo numeroN = Operaciones.Mult(complejo1, lista1.GetPosition(i));
	       listaN.AddValue(numeroN);
	    }
	    return listaN;
	}

	
	public static boolean IgualdadVectores(ComplexVector matriz1, ComplexVector matriz2){
        int tamanio = matriz1.GetSize();
        boolean iguales = true;
        for (int i = 0; i < tamanio; i++){
            System.out.println("vector1 " + matriz1.GetPosition(i).real +" " + matriz1.GetPosition(i).imag + " vector2 " + matriz2.GetPosition(i).real + " " + matriz2.GetPosition(i).imag);
            if(!Operaciones.igualdadComplejos(matriz1.GetPosition(i), matriz2.GetPosition(i))){
                System.out.println("Entre aqui");
                iguales = false;
            }
        }
        return iguales;
    }
	
	public static Complejo InnerProduct(ComplexVector vector1, ComplexVector vector2){
		Complejo n = new Complejo(0,0);
        for(int i = 0; i < vector1.GetSize(); i++){
            System.out.println("Estos seran los imaginarios a multiplicar " + vector1.GetPosition(i).Conjugado().imag + " " + vector2.GetPosition(i).imag);
            Complejo ComplejoN = Operaciones.Mult(vector1.GetPosition(i).Conjugado(), vector2.GetPosition(i));
            
            n = Operaciones.Sum(n, ComplejoN);
            System.out.println(n.real+" "+n.imag);
        }
        return n;
    }
	
	public static Complejo ScalarProduct(ComplexVector vector1, ComplexVector vector2){
		Complejo n = new Complejo(0,0);
        for(int i = 0; i < vector1.GetSize(); i++){
        	Complejo ComplejoN = Operaciones.Mult(vector1.GetPosition(i), vector2.GetPosition(i));
            
            n = Operaciones.Sum(n, ComplejoN);
            System.out.println(n.real+" "+n.imag);
        }
        return n;
    }
	
	
	


}
