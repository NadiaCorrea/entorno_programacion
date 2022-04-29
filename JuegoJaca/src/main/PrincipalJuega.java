package main;

import elementos.Coordenada;
import elementos.Jugador;

public class PrincipalJuega {

	public static void main(String[] args) {
		
		Coordenada c1= new Coordenada(0,1);
		System.out.println(c1);
		
		c1.goDown();
		System.out.println(c1.toString());
		
		
		Coordenada c2= new Coordenada(0,9);
		System.out.println(c2);
		
		c2.goDown();
		System.out.println(c2.toString());
	}

}
