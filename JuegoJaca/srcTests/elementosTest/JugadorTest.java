package elementosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logica.juego.Constantes;

public class JugadorTest {

	private static final String MENSAJE = "El resultado de la lucha no es válido";

	// Test ID:1 - Constructor con parámetros
	@Test
	void constructorConParametrosTest() {
		Jugador jugador = new Jugador(PlayerType.MAGO);

		assertEquals("Las pociones no son 0", 0, jugador.getPociones());
		assertEquals("El dinero no es 0", 0, jugador.getDinero());
		assertEquals("Las gemas no son 0", 0, jugador.getGemas());
		assertEquals("El tipo no es igual", PlayerType.MAGO, jugador.getPlayer());
	}

	// Test ID:2 - Obtener nombre
	@Test
	void obtenerNombreTest() {
		Jugador jugador = new Jugador(PlayerType.GUERRERO);

		assertEquals("El nomnbre no es igual", PlayerType.GUERRERO.name(), jugador.getNombre());
	}

	// Test ID:3 - Obtener fuerza para luchar
	@Test
	void obtenerFuerzaLucharTest() {
		Jugador jugador = new Jugador(PlayerType.ELFO);

		for (int i = 0; i < 100; i = i + 1) {
			int fuerza = jugador.getFuerzaParaLuchar();
			assertTrue("La fuerza no es correcta", (fuerza >= 0) && (fuerza < PlayerType.ELFO.getFuerza()));
		}
	}

	// Test ID:4 - Obtener velocidad para luchar
	@Test
	void obtenerVelocidadLucharTest() {
		Jugador jugador = new Jugador(PlayerType.MAGO);

		for (int i = 0; i < 100; i = i + 1) {
			int velocidad = jugador.getVelocidadParaLuchar();
			assertTrue("La velocidad no es correcta", (velocidad >= 1) && (velocidad < PlayerType.MAGO.getVelocidad()));
		}
	}

	// Test ID:5 - Obtener magia para luchar
	@Test
	void obtenerMagiaLucharTest() {
		Jugador jugador = new Jugador(PlayerType.OGRO);

		for (int i = 0; i < 100; i = i + 1) {
			int magia = jugador.getMagiaParaLuchar();
			assertTrue("La magia no es correcta", (magia >= 0) && (magia < PlayerType.OGRO.getMagia()));
		}
	}

	// Test ID:6 - Obtener dinero
	@Test
	void obtenerDineroTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.GUERRERO);
		jugador.setDinero(3);

		assertEquals("El dinero no es igual", 3, jugador.getDinero());
	}

	// Test ID:7 - Establecer dinero válido
	@Test
	void establecerDineroValidoTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.OGRO);

		jugador.setDinero(2);

		assertEquals("El dinero no es igual", 2, jugador.getDinero());
	}

	// Test ID:8 - Establecer dinero no válido
	@Test
	void establecerDineroNoValidoTest() {
		Jugador jugador = new Jugador(PlayerType.ELFO);

		try {
			jugador.setDinero(-1);
			fail("No debe establecerse el dinero");
		} catch (JugadorException e) {

		}
	}

	// Test ID:9 - Obtener pociones
	@Test
	void obtenerPocionesTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.MAGO);
		jugador.setPociones(1);

		assertEquals("Las pociones no son iguales", 1, jugador.getPociones());
	}

	// Test ID:10 - Establecer pociones válido
	@Test
	void establecerPocionesValidoTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.ELFO);

		jugador.setPociones(4);

		assertEquals("Las pociones no son iguales", 4, jugador.getPociones());
	}

	// Test ID:11 - Establecer pociones no válido
	@Test
	void establecerPocionesNoValidoTest() {
		Jugador jugador = new Jugador(PlayerType.ELFO);

		try {
			jugador.setPociones(-2);
			fail("No deben establecerse las pociones");
		} catch (JugadorException e) {

		}
	}

	// Test ID:12 - Obtener gemas
	@Test
	void obtenerGemasTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.GUERRERO);
		jugador.setGemas(2);

		assertEquals("Las gemas no son iguales", 2, jugador.getGemas());
	}

	// Test ID:13 - Establecer gemas válido
	@Test
	void establecerGemasValidoTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.OGRO);

		jugador.setGemas(1);

		assertEquals("Las gemas no son iguales", 1, jugador.getGemas());
	}

	// Test ID:14 - Establecer gemas no válido
	@Test
	void establecerGemasNoValidoTest() {
		Jugador jugador = new Jugador(PlayerType.GUERRERO);

		try {
			jugador.setDinero(-2);
			fail("No deben establecerse las gemas");
		} catch (JugadorException e) {

		}
	}

	// Test ID:15 - Obtener resumen
	@Test
	void obtenerResumenTest() {
		Jugador jugador = new Jugador(PlayerType.MAGO);

		String resumen = jugador.resumen();

		assertTrue("El resumen no tiene contenido", resumen.length() > 0);
	}

	// Test ID:16 - Obtener jugador
	@Test
	void obtenerJugadorTest() {
		Jugador jugador = new Jugador(PlayerType.ELFO);

		assertEquals("El tipo de jugador no es igual", PlayerType.ELFO, jugador.getPlayer());
	}

	// Test ID:17 - Lucha muere
	@Test
	void luchaMuereTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.OGRO);
		Jugador enemigo = new Jugador(PlayerType.MAGO);

		for (int i = 0; i < 100; i = i + 1) {
			int result = jugador.lucha(enemigo);
			assertTrue(MENSAJE, (result == Constantes.EMPATE) || (result == Constantes.GANA_MUERE)
					|| (result == Constantes.PIERDE_MUERE));
		}
	}

	// Test ID:18 - Lucha dinero
	@Test
	void luchaDineroTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.OGRO);
		jugador.setDinero(1);
		Jugador enemigo = new Jugador(PlayerType.MAGO);
		enemigo.setDinero(2);

		for (int i = 0; i < 100; i = i + 1) {
			int result = jugador.lucha(enemigo);
			assertTrue(MENSAJE, (result == Constantes.EMPATE) || (result == Constantes.GANA_DINERO)
					|| (result == Constantes.PIERDE_DINERO));
			assertTrue("El dinero no es correcto",
					(jugador.getDinero() == 1 && enemigo.getDinero() == 2)
							|| (jugador.getDinero() == 3 && enemigo.getDinero() == 0)
							|| (jugador.getDinero() == 0 && enemigo.getDinero() == 3));

			jugador.setDinero(1);
			enemigo.setDinero(2);
		}
	}

	// Test ID:19 - Lucha poción
	@Test
	void luchaPocionTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.OGRO);
		jugador.setPociones(3);
		Jugador enemigo = new Jugador(PlayerType.MAGO);
		enemigo.setPociones(2);

		for (int i = 0; i < 100; i = i + 1) {
			int result = jugador.lucha(enemigo);
			assertTrue(MENSAJE, (result == Constantes.EMPATE) || (result == Constantes.GANA_USA_POCIMA)
					|| (result == Constantes.PIERDE_USA_POCIMA));
			assertTrue("Las pociones no son correctas",
					(jugador.getPociones() == 3 && enemigo.getPociones() == 2)
							|| (jugador.getPociones() == 3 && enemigo.getPociones() == 1)
							|| (jugador.getPociones() == 2 && enemigo.getPociones() == 2));

			jugador.setPociones(3);
			enemigo.setPociones(2);
		}
	}

	// Test ID:20 - Encontrar roca con gema
	@Test
	void encontrarRocaGemaTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.GUERRERO);
		jugador.setGemas(2);

		int result = jugador.encuentraRoca();

		assertEquals("El resultado no es correcto", Constantes.ROMPE_ROCA_CON_GEMA, result);
		assertEquals("Las gemas son incorrectas", 1, jugador.getGemas());
	}

	// Test ID:21 - Encontrar roca sin gemas
	@Test
	void encontrarRocaSinGemasTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.ELFO);

		int result = jugador.encuentraRoca();

		assertTrue("El resultado no es correcto",
				(result == Constantes.GANA_A_LA_ROCA) || (result == Constantes.PIERDE_A_LA_ROCA));
	}

	// Test ID:22 - Encontrar dinero
	@Test
	void encontrarDineroTest() {
		Jugador jugador = new Jugador(PlayerType.OGRO);

		jugador.encuentraDinero();

		assertEquals("El dinero es incorrecto", 1, jugador.getDinero());
	}

	// Test ID: 23 - Encontrar poción
	@Test
	void encontrarPocionTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.MAGO);
		jugador.setPociones(2);

		jugador.encuentraPocion();

		assertEquals("Las pociones no son correctas", 3, jugador.getPociones());
	}

	// Test ID: 24 - Encontrar gema
	@Test
	void encontrarGemaTest() throws JugadorException {
		Jugador jugador = new Jugador(PlayerType.GUERRERO);
		jugador.setGemas(1);

		jugador.encuentraGema();

		assertEquals("Las gemas no son correctas", 2, jugador.getGemas());
	}

}
