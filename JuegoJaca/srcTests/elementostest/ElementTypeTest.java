package elementostest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import elementos.ElementType;
import logicajuego.Constantes;

class ElementTypeTest {

	// Test ID:1 - Obtener el tipo del enumerado ElementType
	@Test
	void getTipotest() {
		int actual = ElementType.OGRO.getType();

		assertEquals("Los tipos no son iguales", Constantes.OGRO, actual);
	}

	// Test ID:2 - Obtener el s�mbolo del enumerado ElementType
	@Test
	void getSymbolTest() {
		char actual = ElementType.GEMA.getSymbol();

		assertEquals("Los s�mbolos no son iguales", 'Y', actual);
	}

	// Test ID:3 - Obtener en formato cadena la imagen del enumerado ElementType
	@Test
	void getImageToStringTest() {
		String actual = ElementType.ROCA.getImage();

		assertEquals("Las cadenas no son iguales", "roca.png", actual);
	}

}
