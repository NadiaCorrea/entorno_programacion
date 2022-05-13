package elementosTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import elementos.PlayerType;
import logicaJuego.Constantes;

class PlayerTypeTest {

	// Test ID:1 - Get Fuerza
	@Test
	void testGetFuerza() {
		PlayerType typeGuerrero = PlayerType.GUERRERO;

		assertEquals("La fuerza no es igual", Constantes.GUERRERO_FUERZA, typeGuerrero.getFuerza());
	}

	// Test ID:2 - Get Magia
	@Test
	void testGetMagia() {
		PlayerType typeMago = PlayerType.MAGO;

		assertEquals("La magia no es igual", Constantes.MAGO_MAGIA, typeMago.getMagia());
	}

	// Test ID:3 - Get Velocidad
	@Test
	void testGetVelocidad() {
		PlayerType typeElfo = PlayerType.ELFO;

		assertEquals("La velocidad no es igual", Constantes.ELFO_VELOCIDAD, typeElfo.getVelocidad());
	}

}
