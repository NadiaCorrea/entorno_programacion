package elementos;

import java.util.Random;

import logicajuego.Constantes;

public class Jugador extends Element {
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType player;
	private Random r = new Random();

	public Jugador(PlayerType player) {
		super(ElementType.valueOf(player.name()));
		this.player = player;
		this.dinero = 0;
		this.pociones = 0;
		this.gemas = 0;
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
		return "Jugador: " + this.getNombre() + " Dinero: " + dinero + " Pociones: " + pociones + " Gemas: " + gemas;
	}

	public PlayerType getPlayer() {
		return player;
	}

	public int lucha(Jugador enemigo) throws JugadorException {
		int result = 0;
		int resultadoLucha = this.getFuerzaParaLuchar() - enemigo.getFuerzaParaLuchar();

		if (resultadoLucha == 0) {
			result = Constantes.EMPATE;
		} else if (resultadoLucha > 0) {
			if (enemigo.getDinero() > 0) {
				result = Constantes.GANA_DINERO;
				this.setDinero(this.getDinero() + enemigo.getDinero());
				enemigo.setDinero(0);
			} else {
				if (enemigo.getPociones() > 0) {
					enemigo.setPociones(enemigo.getPociones() - 1);
					result = Constantes.GANA_USA_POCIMA;
				} else {
					result = Constantes.GANA_MUERE;
				}
			}
		} else {
			if (this.getDinero() > 0) {
				result = Constantes.PIERDE_DINERO;
				enemigo.setDinero(enemigo.getDinero() + this.getDinero());
				this.setDinero(0);
			} else {
				if (this.getPociones() > 0) {
					this.setPociones(this.getPociones() - 1);
					result = Constantes.PIERDE_USA_POCIMA;
				} else {
					result = Constantes.PIERDE_MUERE;
				}
			}
		}
		return result;
	}

	public int encuentraRoca() throws JugadorException {
		int result;

		if (this.getGemas() > 0) {
			result = Constantes.ROMPE_ROCA_CON_GEMA;
			this.setGemas(this.getGemas() - 1);
		} else {
			if (this.getMagiaParaLuchar() > 4) {
				result = Constantes.GANA_A_LA_ROCA;
			} else {
				result = Constantes.PIERDE_A_LA_ROCA;
			}
		}
		return result;
	}

	public void encuentraDinero() {
		try {
			this.setDinero(this.getDinero() + 1);
		} catch (JugadorException e) {
			e.getMessage();
		}
	}

	public void encuentraPocion() {
		try {
			this.setPociones(this.getPociones() + 1);
		} catch (JugadorException e) {
			e.getMessage();
		}
	}

	public void encuentraGema() {
		try {
			this.setGemas(this.getGemas() + 1);
		} catch (JugadorException e) {
			e.getMessage();
		}
	}
}
