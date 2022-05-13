package elementosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class CoordenadaTest {

	// Test ID:1 - Constructor sin parámetros
	@Test
	void constructorNoParamTest() {
		Coordenada prueba = new Coordenada();
		int actualX = prueba.getX();
		int actualY = prueba.getY();

		assertTrue("Constructor sin parámetros", actualX >= 0 && actualX <= 9);
		assertTrue("Constructor sin parámetros", actualY >= 0 && actualY <= 9);
	}

	// Test ID:2 - Constructor con parámetros válidos
	@Test
	void constructorConParamTest() {
		Coordenada prueba = new Coordenada(1, 9);
		int actualX = prueba.getX();
		int actualY = prueba.getY();

		assertEquals("El valor esperado de X no es igual al valor dado", 1, actualX);
		assertEquals("El valor esperado de Y no es igual al valor dado", 9, actualY);
	}

	// Test ID:3 - Constructor con parámetros no válidos
	@Test
	void constructParamNoValidTest() {
		Coordenada prueba = new Coordenada(-1, 10);
		int actualX = prueba.getX();
		int actualY = prueba.getY();
		int expectedX = 0;
		int expectedY = 0;

		assertEquals("El valor esperado de X no es igual al valor dado", expectedX, actualX);
		assertEquals("El valor esperado de Y no es igual al valor dado", expectedY, actualY);
	}

	// Test ID:4 - Constructor con parámetro X no válido
	@Test
	void constructorXNoValidTest() {
		Coordenada prueba = new Coordenada(-1, 9);
		int actualX = prueba.getX();
		int actualY = prueba.getY();
		int expectedX = 0;
		int expectedY = 9;

		assertEquals("El valor esperado de X no es igual al valor dado", expectedX, actualX);
		assertEquals("El valor esperado de Y no es igual al valor dado", expectedY, actualY);
	}

	// Test ID:5 - Constructor con parámetro Y no válido
	@Test
	void constructorYNoValidTest() {
		Coordenada prueba = new Coordenada(3, 11);
		int actualX = prueba.getX();
		int actualY = prueba.getY();
		int expectedX = 3;
		int expectedY = 0;

		assertEquals("El valor esperado de X no es igual al valor dado", expectedX, actualX);
		assertEquals("El valor esperado de Y no es igual al valor dado", expectedY, actualY);
	}

	// Test ID:6 - Obtener valor X
	@Test
	void getXTest() {
		Coordenada prueba = new Coordenada(0, 6);
		int actualX = prueba.getX();
		int expectedX = 0;

		assertEquals("El valor esperado de X no es igual al valor dado", expectedX, actualX);
	}

	// Test ID:7 - Obtener valor Y
	@Test
	void getYTest() {
		Coordenada prueba = new Coordenada(0, 6);
		int actualY = prueba.getY();
		int expectedY = 6;

		assertEquals("El valor esperado de Y no es igual al valor dado", expectedY, actualY);
	}

	// Test ID:8 - Equals con mismo objeto
	@Test
	void equalsMismoTest() {

		Coordenada original = new Coordenada(0, 6);

		assertTrue("No son iguales", original.equals(original));
	}

	// Test ID:9 - Equals con null
	@Test
	void equalsNullTest() {
		Coordenada original = new Coordenada(0, 6);

		assertFalse("Error en equalsNull", original.equals(null));
	}

	// Test ID:10 - Equals con otro objeto
	@Test
	void equalsOtherTest() {
		Coordenada original = new Coordenada(0, 6);

		assertFalse("Error en equalsOther", original.equals("original"));
	}

	// Test ID:11 - Equals en una coordenada
	@Test
	void equalsOneCoordTest() {
		Coordenada original = new Coordenada(0, 6);
		Coordenada other = new Coordenada(3, 6);

		assertFalse("Error en equalsOnecoord", original.equals(other));
	}

	// Test ID:12 - Equals en ambas coordenada
	@Test
	void equalsTwoCoordTest() {
		Coordenada original = new Coordenada(3, 6);
		Coordenada other = new Coordenada(3, 6);

		assertTrue("No tienen las mismas coordenadas", original.equals(other));
	}

	// Test ID:13 - Coordenada a cadena
	@Test
	void coordenadaToStringTest() {
		Coordenada original = new Coordenada(3, 6);
		String expected = "Coordenada [x=" + original.getX() + ", y=" + original.getY() + "]";

		assertEquals("CoordToString no son iguales", expected, original.toString());

	}

	// Test ID:14 - go right true
	@Test
	void goRightTrueTest() {
		Coordenada original = new Coordenada(3, 6);
		boolean actual = original.goRight();

		assertTrue("goRigth es falso", actual);
		assertEquals("No aumentó en valor", 4, original.getX());
	}

	// Test ID:15 - go right false
	@Test
	void goRightFalseTest() {
		Coordenada original = new Coordenada(9, 6);
		boolean actual = original.goRight();

		assertFalse("goRight es verdadero", actual);
		assertEquals("Aumentó en valor", 9, original.getX());
	}

	// Test ID:16 - go left true
	@Test
	void goLeftTrueTest() {
		Coordenada original = new Coordenada(3, 6);
		boolean actual = original.goLeft();

		assertTrue("goLeft es falso", actual);
		assertEquals("No disminuyó en valor", 2, original.getX());
	}

	// Test ID:17 - go left false
	@Test
	void goLeftFalseTest() {
		Coordenada original = new Coordenada(0, 6);
		boolean actual = original.goLeft();

		assertFalse("goLeft es verdadero", actual);
		assertEquals("Disminuyó en valor", 0, original.getX());
	}

	// Test ID:18 - go up true
	@Test
	void goUpTrueTest() {
		Coordenada original = new Coordenada(3, 6);
		boolean actual = original.goUp();

		assertTrue("goUp es falso", actual);
		assertEquals("No disminuyó en valor", 5, original.getY());
	}

	// Test ID:19 - go up false
	@Test
	void goUpFalseTest() {
		Coordenada original = new Coordenada(3, 0);
		boolean actual = original.goUp();

		assertFalse("goUp es verdadero", actual);
		assertEquals("Disminuyó en valor", 0, original.getY());
	}

	// Test ID:20 - go down true
	@Test
	void goDownTrueTest() {
		Coordenada original = new Coordenada(3, 8);
		boolean actual = original.goDown();

		assertTrue("goDown es falso", actual);
		assertEquals("No disminuyó en valor", 9, original.getY());
	}

	// Test ID:21 - go down false
	@Test
	void goDownFalseTest() {
		Coordenada original = new Coordenada(3, 9);
		boolean actual = original.goDown();

		assertFalse("goDown es verdadero", actual);
		assertEquals("Disminuyó en valor", 9, original.getY());
	}

	// Test ID:22 - objeto clonado
	@Test
	void objetoClonadoTest() throws CloneNotSupportedException {
		Coordenada original = new Coordenada(7, 8);
		Coordenada clon = (Coordenada) original.clone();

		assertEquals("La coordenada X del clon no es igual", original.getX(), clon.getX());
		assertEquals("La coordenada Y del clon no es igual", original.getY(), clon.getY());
	}

	// Test ID:23 - hashCode
	@Test
	void hashCodeTest() {
		Coordenada original = new Coordenada(3, 9);
		Coordenada copia = new Coordenada(3, 9);

		assertTrue("No tienen el mismo hashCode", original.hashCode() == copia.hashCode());
	}

}
