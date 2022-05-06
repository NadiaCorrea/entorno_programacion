package elementos;

import java.util.Random;

import logicaJuego.Constantes;

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

	public String resumen() {
		return "Jugador [dinero=" + dinero + ", pociones=" + pociones + ", gemas=" + gemas + "]";
	}

	public PlayerType getPlayer() {
		return player;
	}

	
	/*0: EMPATE: Hay empate ninguno de los dos gana la lucha 
	 * 1:GANA_USA_POCIMA: Gana el jugador y se utiliza pocima del enemigo para que no muera 
	 * 2: GANA_DINERO: Gana el jugador y se lleva todo el dinero del enemigo 
	 * 3: GANA_MUERE; Gana el jugador y el enemigo muere 
	 * 4: PIERDE_USA_POCIMA: Gana el enemigo y se utiliza pocima del jugador para que no muera 
	 * 5: PIERDE_DINERO: Gana el enemigo y se lleva todo el dinero del jugador 
	 * 6: PIERDE_MUERE: Gana el enemigo y el jugador muere*/
	
	public int lucha(Jugador enemigo) {
		int result= 0;
		int resultadoLucha = this.getFuerzaParaLuchar() - enemigo.getFuerzaParaLuchar();
		
		if(resultadoLucha == 0) {
			result = Constantes.EMPATE;
		}
		

		return result;
	}

}
