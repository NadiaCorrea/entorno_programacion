package elementos;

import java.util.Random;

public class Jugador {
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType player;
	private Random r = new Random();

	public Jugador(PlayerType player) {
		super();
		this.player = player;
	}

	public String getNombre() {
		String result;
		result = this.player.name();
		return result;
	}

	public int getFuerzaParaLuchar() {
		int result;
		result = r.nextInt(this.getFuerza());
		return result;
	}

	private int getFuerza() {
		int result;
		result = this.player.getFuerza();
		return result;
	}

	private int getMagia() {
		int result;
		result = this.player.getMagia();
		return result;
	}

	public int getMagiaParaLuchar() {
		int result;
		result = r.nextInt(this.getMagia());
		return result;
	}

	private int getVelocidad() {
		int result;
		result = this.player.getVelocidad();
		return result;
	}

	public int getVelocidadParaLuchar() {
		int result;
		result = r.nextInt(this.getVelocidad() - 1) + 1;
		return result;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) throws JugadorException {
		if (dinero < 0) {
			throw new JugadorException("El dinero no puede ser menor que 0.");
		} else {
			this.dinero = dinero;
		}
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) throws JugadorException {
		if (pociones < 0) {
			throw new JugadorException("El número de pociones no puede ser menor que 0.");
		} else {
			this.pociones = pociones;
		}

	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) throws JugadorException {
		if (gemas < 0) {
			throw new JugadorException("El número de gemas no puede ser menor que 0.");
		} else {
			this.gemas = gemas;
		}
	}

	public String resumen() { // preguntar a Inma es en plan el to string con todos los datos?
		String result = "";
		return result;
	}

	public PlayerType getPlayer() {
		return player;
	}

	public int lucha(Jugador enemigo) {
		int result;

		return result;
	}

}
