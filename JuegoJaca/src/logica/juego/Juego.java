package logica.juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega

	private Random random = new Random();

	public Juego(PlayerType[] jugadores) {
		super();
		crearTablero();
		this.coordenadaJugadores = new ArrayList<>();
		for (PlayerType tipoJugador : jugadores) {
			crearJugador(tipoJugador);
		}
		this.jugadorJuega = 0;
		this.dado = 0;
	}

	private void crearTablero() {
		this.tablero = new HashMap<>();
		this.crearRocas();
		this.crearGemas();
		this.crearDinero();
		this.crearPociones();
	}

	private boolean crearJugador(PlayerType tipo) {
		boolean result = false;
		Jugador jugador1 = new Jugador(tipo);
		Coordenada coordenada1 = new Coordenada();
		while (this.tablero.containsKey(coordenada1)) {
			coordenada1 = new Coordenada();
		}
		result = this.coordenadaJugadores.add(coordenada1);
		this.tablero.put(coordenada1, jugador1);

		return result;
	}

	private void crearRocas() {

		for (int i = 0; i < Constantes.NUM_ROCAS; i = i + 1) {
			Coordenada coordenada1 = new Coordenada();
			while (this.tablero.containsKey(coordenada1)) {
				coordenada1 = new Coordenada();
			}
			this.tablero.put(coordenada1, new Element(ElementType.ROCA));
		}
	}

	private void crearGemas() {
		for (int i = 0; i < Constantes.NUM_GEMAS; i = i + 1) {
			Coordenada coordenada1 = new Coordenada();
			while (this.tablero.containsKey(coordenada1)) {
				coordenada1 = new Coordenada();
			}
			this.tablero.put(coordenada1, new Element(ElementType.GEMA));
		}
	}

	private void crearPociones() {
		for (int i = 0; i < Constantes.NUM_POCIONES; i = i + 1) {
			Coordenada coordenada1 = new Coordenada();
			while (this.tablero.containsKey(coordenada1)) {
				coordenada1 = new Coordenada();
			}
			this.tablero.put(coordenada1, new Element(ElementType.POCION));
		}
	}

	private void crearDinero() {
		for (int i = 0; i < Constantes.NUM_DINERO; i = i + 1) {
			Coordenada coordenada1 = new Coordenada();
			while (this.tablero.containsKey(coordenada1)) {
				coordenada1 = new Coordenada();
			}
			this.tablero.put(coordenada1, new Element(ElementType.DINERO));
		}
	}

	/**
	 * Escribe el tablero en formato no gráfico. Devuelve el string con la
	 * información
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	public boolean isTerminado() {
		boolean result = false;

		boolean todoElDinero = false;
		Iterator<Coordenada> iterador = this.coordenadaJugadores.iterator();
		while (iterador.hasNext() && !todoElDinero) {
			Coordenada iCoordenada = iterador.next();
			Jugador jugador = (Jugador) this.tablero.get(iCoordenada);
			if (jugador.getDinero() == Constantes.NUM_DINERO) {
				todoElDinero = true;
			}
		}

		if (this.coordenadaJugadores.size() == 1 || todoElDinero) {
			result = true;
		}

		return result;
	}

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}

	public String imprimeNombreJugadores() {
		StringBuilder result = new StringBuilder();

		int i = 1;
		for (Coordenada coordenada : this.coordenadaJugadores) {
			Jugador jugador = (Jugador) this.tablero.get(coordenada);
			result.append("El jugador " + i + " es un " + jugador.getNombre() + "\n");
			i = i + 1;
		}

		return result.toString();
	}

	public String imprimeValoreJugadores() {
		StringBuilder result = new StringBuilder();

		for (Coordenada coordenada : this.coordenadaJugadores) {
			Jugador jugador = (Jugador) this.tablero.get(coordenada);
			result.append(jugador.resumen() + "\n");
		}

		return result.toString();
	}

	private void eliminarJugador(Coordenada coordenada) {
		this.tablero.remove(coordenada);
		this.coordenadaJugadores.remove(coordenada);
	}

	private Coordenada getNextPosition(char letra) throws JuegoException {
		Coordenada result = null;

		Coordenada coordenada = obtenerCoordenadaJugadorJuega();
		try {
			result = (Coordenada) coordenada.clone();

			switch (letra) {
			case 'N':
				result.goUp();
				break;
			case 'S':
				result.goDown();
				break;
			case 'E':
				result.goRight();
				break;
			case 'O':
				result.goLeft();
				break;
			default:
				throw new JuegoException("No es una direcci�n v�lida");
			}
		} catch (CloneNotSupportedException e) {
			throw new JuegoException(e.getMessage());
		}

		return result;
	}

	private void cambiaJugadorAPosicion(Coordenada coordenada) {
		Coordenada coordenadaActual = obtenerCoordenadaJugadorJuega();
		Jugador jugador = (Jugador) obtenerElementoTablero(coordenadaActual);

		this.coordenadaJugadores.set(this.jugadorJuega, coordenada);
		this.tablero.put(coordenada, jugador);
		this.tablero.remove(coordenadaActual);
	}

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una dirección válida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una p�cima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Después de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

	public void proximoJugador() {
		this.jugadorJuega = this.jugadorJuega + 1;
		if (this.jugadorJuega == this.coordenadaJugadores.size()) {
			this.jugadorJuega = 0;
		}
	}

	public String getGanador() {
		String result = "";

		if (this.coordenadaJugadores.size() == 1) {
			Coordenada coordenada = this.coordenadaJugadores.get(0);
			Jugador jugador = (Jugador) this.tablero.get(coordenada);
			result = jugador.getNombre();
		} else {
			boolean encontrado = false;
			Iterator<Coordenada> iterador = this.coordenadaJugadores.iterator();
			while (iterador.hasNext() && !encontrado) {
				Coordenada iCoordenada = iterador.next();
				Jugador jugador = (Jugador) this.tablero.get(iCoordenada);
				if (jugador.getDinero() == Constantes.NUM_DINERO) {
					result = jugador.getNombre();
					encontrado = true;
				}
			}
		}

		return result;
	}

	public String getNombreJuegadorQueJuega() {
		String result = "";

		Coordenada coordenada = obtenerCoordenadaJugadorJuega();
		Jugador jugador = (Jugador) this.tablero.get(coordenada);
		result = jugador.getNombre();

		return result;
	}

	public int getMovimientoJugador() {
		int result = 0;

		Coordenada coordenada = obtenerCoordenadaJugadorJuega();
		Jugador jugador = (Jugador) this.tablero.get(coordenada);
		result = jugador.getVelocidadParaLuchar();

		return result;
	}

	public int getValorDado() {
		return this.dado;
	}

	public void decrementaDado() {
		if (this.dado > 0) {
			this.dado = this.dado - 1;
		}
	}

	public void setDado() {
		this.dado = this.random.nextInt(6) + 1;
	}

	public Element obtenerElementoTablero(Coordenada coordenada) {
		return this.tablero.get(coordenada);
	}

	public Coordenada obtenerCoordenadaJugadorJuega() {
		return this.coordenadaJugadores.get(this.jugadorJuega);
	}
}
