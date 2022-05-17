package logicaJuego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;

public class JuegoTest {

	// Test ID:1 - Constructor con parámetros
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
		assertEquals("El próximo jugador no es correcto", PlayerType.OGRO.name(), juego.getNombreJuegadorQueJuega());
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

		assertTrue("El resultado de imprimir los nombres de los jugadores está vacío", result.length() > 0);
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

		assertTrue("El resultado los valores de los jugadores está vacío", result.length() > 0);
	}

	// Test ID:8 - Establecer próximo jugador
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

	// Test ID:9 - Establecer próximo jugador al último
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

		assertEquals("El nombre del ganador no es vacío", 0, jugador.length());
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

	// Test ID:12 - Obtener ganador por último jugador
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
}
