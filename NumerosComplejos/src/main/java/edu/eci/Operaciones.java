package main;

public class Operaciones {
	
	/***
	 * Conjugado de un complejo
	 * @param C1
	 * @return C1´
	 */
	public Complejo Conjugado(Complejo C1) {
		return new Complejo (C1.real, (-1)*C1.imag);
	}
	
	
	/***
	 * Modulo de un complejo
	 * @param C1
	 * @return double valor de modulo
	 */
	public double Modulo(Complejo C1) {
		return Math.sqrt((C1.real*C1.real) + (C1.imag*C1.imag));
	}
	
	
	/***
	 * Sumar 2 Complejos
	 * @param C1
	 * @param C2
	 * @return C1+C2
	 */
	public static Complejo Sum(Complejo C1, Complejo C2) {
		
		return new Complejo (C1.real + C2.real , C1.imag + C2.imag);
	}
	
	
	/***
	 * Restar 2 Complejos
	 * @param C1
	 * @param C2
	 * @return C1-C2
	 */
	public Complejo Resta (Complejo C1, Complejo C2) {
		
		return new Complejo (C1.real - C2.real , C1.imag - C2.imag);
	}
	
	/***
	 * Multiplicar 2 complejos
	 * en base a la formula z*w = (a+bi) * (c+di) = (a*c-b*d) + (a*d+b+c)i
	 * @param C1
	 * @param C2
	 * @return C1*C2
	 */
	public static Complejo Mult(Complejo C1, Complejo C2) {
		
		return new Complejo (((C1.real*C2.real) - (C1.imag * C2.imag)) , ((C1.real * C2.imag)+(C1.imag *C2.real)));
	}
	
	/***
	 * Divide 2 complejos, si devuelve 0 es por la inicializacion de las variables x , y
	 * @param C1
	 * @param C2
	 * @return C1/C2
	 */
	public Complejo Div(Complejo C1, Complejo C2) {
		double x = 0,y = 0;
		
		if(Modulo(C2) == 0) {
			//lanzamos un error de div por 0
		}else {
			double aux = ((C2.real * C2.real) + (C2.imag* C2.imag));
			x = (((C1.real*C2.real)+(C1.imag*C2.imag))/aux);
			y = (((C1.imag*C2.real)-(C1.real*C2.imag))/aux);
		}
		return new Complejo(x,y);
	}
	
	/***
	 * Pasar de numero complejo a polar
	 * @param C1
	 * @return polar
	 */
	public Complejo complejo_Polar(Complejo C1) {
		double valTeta = Math.atan(C1.imag/C1.real);
		double valorPfea = Math.sqrt(Math.pow(C1.real, 2) + Math.pow(C1.imag, 2));
		return new Complejo(valorPfea, valTeta);
	}
	
	/***
	 * Pasar de polar a complejo o cartesiano
	 * @param C1
	 * @return complejo
	 */
	public Complejo Polar_complejo(Complejo C1) {
		double A = (C1.real*(Math.cos(C1.imag)));
		double B = (C1.real*(Math.sin(C1.imag)));
		System.out.println(A);
        System.out.println(B);

		return new Complejo((C1.real*(Math.cos(C1.imag))),(C1.real*(Math.sin(C1.imag))));
	}
	
	
	/***
	 * Verifica si 2 numeros complejos son iguales
	 * @param C1
	 * @param C2
	 * @return true o false si es o no igual 
	 */
	public static boolean igualdadComplejos(Complejo C1, Complejo C2) {
		
		if(C1.real == C2.real && C1.imag == C2.imag) 
			return true;
		else
			return false;
	}
	

}
