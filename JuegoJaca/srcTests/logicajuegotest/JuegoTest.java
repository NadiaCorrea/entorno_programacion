package logicajuegotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicajuego.Constantes;
import logicajuego.Juego;
import logicajuego.JuegoException;

public class JuegoTest {

	// Test ID:1 - Constructor con parï¿½metros
	@Test
	void constructorConParametrosTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		String result = juego.toString();

		assertTrue("El juego no tiene contenido", result.length() > 0);
		assertEquals("El prï¿½ximo jugador no es correcto", PlayerType.OGRO.name(), juego.getNombreJuegadorQueJuega());
		assertEquals("El valor del dado no es correcto", 0, juego.getValorDado());
	}

	// Test ID:2 - toString
	@Test
	void toStringTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		String result = juego.toString();

		assertTrue("El juego no tiene contenido", result.length() > 0);
	}

	// Test ID:3 - Juego no terminado
	@Test
	void juegoNoTerminadoTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		assertFalse("El juego ha terminado", juego.isTerminado());
	}

	// Test ID:4 - Juego terminado por dinero
	@Test
	void juegoTerminadoDineroTest() throws JugadorException {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);
		juego.proximoJugador();
		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = (Jugador) juego.obtenerElementoTablero(coordenada);
		jugador.setDinero(Constantes.NUM_DINERO);

		assertTrue("El juego no ha terminado", juego.isTerminado());
	}

	// Test ID:5 - Juego terminado por jugador
	@Test
	void juegoTerminadoJugadorTest() {
		PlayerType[] jugadores = new PlayerType[1];
		jugadores[0] = PlayerType.OGRO;
		Juego juego = new Juego(jugadores);

		assertTrue("El juego no ha terminado", juego.isTerminado());
	}

	// Test ID:6 - Imprimir nombre jugadores
	@Test
	void imprimirNombreJugadoresTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		String result = juego.imprimeNombreJugadores();

		assertTrue("El resultado de imprimir los nombres de los jugadores estï¿½ vacï¿½o", result.length() > 0);
	}

	// Test ID:7 - Imprimir valores jugadores
	@Test
	void imprimirValoresJugadoresTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		String result = juego.imprimeValoreJugadores();

		assertTrue("El resultado los valores de los jugadores estï¿½ vacï¿½o", result.length() > 0);
	}

	// Test ID:8 - Establecer prï¿½ximo jugador
	@Test
	void establecerProximoJugadorTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		juego.proximoJugador();

		String jugador = juego.getNombreJuegadorQueJuega();

		assertEquals("El nombre del jugador no es el esperado", PlayerType.GUERRERO.name(), jugador);
	}

	// Test ID:9 - Establecer prï¿½ximo jugador al ï¿½ltimo
	@Test
	void establecerProximoJugadorUltimoTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);
		juego.proximoJugador();
		juego.proximoJugador();
		juego.proximoJugador();

		juego.proximoJugador();

		String jugador = juego.getNombreJuegadorQueJuega();

		assertEquals("El nombre del jugador no es el esperado", PlayerType.OGRO.name(), jugador);
	}

	// Test ID:10 - Obtener ganador sin ganador
	@Test
	void obtenerGanadorSinGanadorTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		String jugador = juego.getGanador();

		assertEquals("El nombre del ganador no es vacï¿½o", 0, jugador.length());
	}

	// Test ID:11 - Obtener ganador por dinero
	@Test
	void obtenerGanadorDineroTest() throws JugadorException {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);
		juego.proximoJugador();
		juego.proximoJugador();
		juego.proximoJugador();
		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = (Jugador) juego.obtenerElementoTablero(coordenada);
		jugador.setDinero(Constantes.NUM_DINERO);

		String ganador = juego.getGanador();

		assertEquals("El nombre del ganador no es correcto", PlayerType.MAGO.name(), ganador);
	}

	// Test ID:12 - Obtener ganador por ï¿½ltimo jugador
	@Test
	void obtenerGanadorUltimoJugadorTest() {
		PlayerType[] jugadores = new PlayerType[1];
		jugadores[0] = PlayerType.ELFO;
		Juego juego = new Juego(jugadores);

		String ganador = juego.getGanador();

		assertEquals("El nombre del ganador no es correcto", PlayerType.ELFO.name(), ganador);
	}

	// Test ID:13 - Obtener nombre jugador que juega
	@Test
	void obtenerNombreJugadorJuegaTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		String jugador = juego.getNombreJuegadorQueJuega();

		assertEquals("El nombre del jugador que juega no es correcto", PlayerType.OGRO.name(), jugador);
	}

	// Test ID:14 - Obtener movimiento jugador
	@Test
	void obtenerMovimientoJugadorTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		for (int i = 0; i < 100; i = i + 1) {
			int movimiento = juego.getMovimientoJugador();
			assertTrue("El movimiento no es correcto",
					(movimiento >= 1) && (movimiento < PlayerType.OGRO.getVelocidad()));
		}
	}

	// Test ID:15 - Obtener valor dado
	@Test
	void obtenerValorDadoTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		for (int i = 0; i < 100; i = i + 1) {
			juego.setDado();
			assertTrue("El valor del dado no es correcto", (juego.getValorDado() >= 1) && (juego.getValorDado() <= 6));
		}
	}

	// Test ID:16 - Decrementar dado
	@Test
	void decrementarDadoTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);
		juego.setDado();

		int valorInicial = juego.getValorDado();
		juego.decrementaDado();
		int valorFinal = juego.getValorDado();
		int valorEsperado = valorInicial - 1;

		assertEquals("El valor del dado no se ha decrementado", valorEsperado, valorFinal);
	}

	// Test ID:17 - Decrementar dado con valor 0
	@Test
	void decrementarDadoCeroTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		juego.decrementaDado();

		assertEquals("El valor del dado no es 0", 0, juego.getValorDado());
	}

	// Test ID:18 - Establecer dado
	@Test
	void establecerDado() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		juego.setDado();

		int valorDado = juego.getValorDado();

		assertTrue("El valor del dado no es correcto", (valorDado >= 1) && (valorDado <= 6));
	}

	// Test ID:19 - Obtener elemento tablero
	@Test
	void obtenerElementoTablero() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		for (int i = 0; i < 100; i = i + 1) {
			Coordenada coordenada = new Coordenada();
			Element elemento = juego.obtenerElementoTablero(coordenada);
			assertTrue("El elemento no es correcto", (elemento == null)
					|| (elemento.getType().equals(ElementType.DINERO)) || (elemento.getType().equals(ElementType.ELFO))
					|| (elemento.getType().equals(ElementType.GEMA))
					|| (elemento.getType().equals(ElementType.GUERRERO))
					|| (elemento.getType().equals(ElementType.MAGO)) || (elemento.getType().equals(ElementType.OGRO))
					|| (elemento.getType().equals(ElementType.POCION))
					|| (elemento.getType().equals(ElementType.ROCA)));
		}
	}

	// Test ID:20 - Obtener coordenada jugador juega
	@Test
	void obtenerCoordenadaJugadorJuegaTest() {
		PlayerType[] jugadores = new PlayerType[4];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.ELFO;
		jugadores[3] = PlayerType.MAGO;
		Juego juego = new Juego(jugadores);

		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();

		assertNotNull("La coordenada del jugador es nula", coordenada);
	}

	// Test ID:21 - Mover jugador a una dirección no válida
	@Test
	void movePlayerNoValidoTest() {
		PlayerType[] jugadores = new PlayerType[1];
		jugadores[0] = PlayerType.OGRO;

		Juego juego = new Juego(jugadores);
		try {
			juego.movePlayer('d');
			fail("No se se ha lanzado la excepción esperada.");
		} catch (Exception e) {

		}
	}

	/*
	 * Test ID:22 - Mover jugador al norte: si después de moverlo el juego ha
	 * terminado es que ha muerto, si la posición es la misma que la posición actual
	 * es que no se ha movido y si cambia de posición debe disminuir la coordenada Y
	 */
	@Test
	void movePlayerNorteTest() throws JuegoException, JugadorException {

		PlayerType[] jugadores = new PlayerType[2];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;

		Juego juego = new Juego(jugadores);

		Coordenada posicionActual = juego.obtenerCoordenadaJugadorJuega();
		Coordenada posicionFinal = new Coordenada(posicionActual.getX(), posicionActual.getY() - 1);

		juego.movePlayer('N');

		assertTrue("Movimiento incorrecto.",
				juego.isTerminado() || juego.obtenerCoordenadaJugadorJuega().equals(posicionActual)
						|| juego.obtenerCoordenadaJugadorJuega().equals(posicionFinal));

	}

	/*
	 * Test ID:23 - Mover jugador al sur: si después de moverlo el juego ha
	 * terminado es que ha muerto, si la posición es la misma que la posición actual
	 * es que no se ha movido y si cambia de posición debe aumentar la coordenada Y
	 */
	@Test
	void movePlayerSurTest() throws JuegoException, JugadorException {

		PlayerType[] jugadores = new PlayerType[2];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;

		Juego juego = new Juego(jugadores);

		Coordenada posicionActual = juego.obtenerCoordenadaJugadorJuega();
		Coordenada posicionFinal = new Coordenada(posicionActual.getX(), posicionActual.getY() + 1);

		juego.movePlayer('S');

		assertTrue("Movimiento incorrecto.",
				juego.isTerminado() || juego.obtenerCoordenadaJugadorJuega().equals(posicionActual)
						|| juego.obtenerCoordenadaJugadorJuega().equals(posicionFinal));

	}
	/*
	 * Test ID:24 - Mover jugador al este: si después de moverlo el juego ha
	 * terminado es que ha muerto, si la posición es la misma que la posición actual
	 * es que no se ha movido y si cambia de posición debe aumentar la coordenada X
	 */

	@Test
	void movePlayerEsteTest() throws JuegoException, JugadorException {

		PlayerType[] jugadores = new PlayerType[2];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;

		Juego juego = new Juego(jugadores);

		Coordenada posicionActual = juego.obtenerCoordenadaJugadorJuega();
		Coordenada posicionFinal = new Coordenada(posicionActual.getX() + 1, posicionActual.getY());

		juego.movePlayer('E');

		assertTrue("Movimiento incorrecto.",
				juego.isTerminado() || juego.obtenerCoordenadaJugadorJuega().equals(posicionActual)
						|| juego.obtenerCoordenadaJugadorJuega().equals(posicionFinal));

	}

	/*
	 * Test ID:25 - Mover jugador al oeste: si después de moverlo el juego ha
	 * terminado es que ha muerto, si la posición es la misma que la posición actual
	 * es que no se ha movido y si cambia de posición debe disminuir la coordenada X
	 */
	@Test
	void movePlayerOesteTest() throws JuegoException, JugadorException {

		PlayerType[] jugadores = new PlayerType[2];
		jugadores[0] = PlayerType.OGRO;
		jugadores[1] = PlayerType.GUERRERO;

		Juego juego = new Juego(jugadores);

		Coordenada posicionActual = juego.obtenerCoordenadaJugadorJuega();
		Coordenada posicionFinal = new Coordenada(posicionActual.getX() - 1, posicionActual.getY());

		juego.movePlayer('O');

		assertTrue("Movimiento incorrecto.",
				juego.isTerminado() || juego.obtenerCoordenadaJugadorJuega().equals(posicionActual)
						|| juego.obtenerCoordenadaJugadorJuega().equals(posicionFinal));

	}

}
