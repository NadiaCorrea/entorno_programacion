package elementosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;

class ElementTest {

	// Test ID:1 - Constructor con parámetro
	@Test
	void ConstructorTest() {
		Element prueba = new Element(ElementType.OGRO);
		ElementType actual = prueba.getType();

		assertEquals("Constructor: El valor esperado no es igual al valor dado", ElementType.OGRO, actual);
	}

	// Test ID:2 - Element a cadena de texto
	@Test
	void ElementToStringTest() {
		Element prueba = new Element(ElementType.ELFO);
		String actual = prueba.toString();
		String expected = "Element [type=" + prueba.getType() + "]";

		assertEquals("ElementToString no son iguales", expected, actual);
	}

	// Test ID:3 - Obtener Element type
	@Test
	void getElementTest() {
		Element prueba = new Element(ElementType.ROCA);
		ElementType actual = prueba.getType();

		assertEquals("El valor esperado del ElementType no es igual al valor dado", ElementType.ROCA, actual);
	}

	// Test ID:4 - Element Equals mismo objeto
	@Test
	void EqualsMismoTest() {
		Element prueba = new Element(ElementType.DINERO);

		assertTrue("No son iguales", prueba.equals(prueba));
	}

	// Test ID:5 - Element Equals objeto nulo

	@Test
	void EqualsNullTest() {
		Element prueba = new Element(ElementType.GEMA);

		assertFalse("Error en equalsNull", prueba.equals(null));
	}

	// Test ID:6 - Element Equals objeto de otra clase

	@Test
	void EqualsOtherClassTest() {
		Element prueba = new Element(ElementType.POCION);
		Coordenada coordenada1 = new Coordenada(1, 3);

		assertFalse("Error en equalsNull", prueba.equals(coordenada1));
	}

	// Test ID:7 - Element Equals objeto de la misma clase pero de distinto tipo

	@Test
	void EqualsSameClassTest() {
		Element prueba = new Element(ElementType.MAGO);
		Element actual = new Element(ElementType.OGRO);

		assertFalse("Error en equalsSameClass", prueba.equals(actual));
	}

	// Test ID:8 - Element Equals objeto de la misma clase y mismo tipo

	@Test
	void EqualsSameTypeTest() {
		Element prueba = new Element(ElementType.GUERRERO);
		Element actual = new Element(ElementType.GUERRERO);

		assertTrue("Error en equalsSameType", prueba.equals(actual));
	}
}
