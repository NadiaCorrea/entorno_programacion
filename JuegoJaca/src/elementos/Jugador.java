package elementos;

public class Jugador {
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType player;
	
	
	
	
	public String getNombre() {
		String result; 
		result = this.player.name();
		return result;
	}
	
	public int getFuerzaParaLuchar() {
		int result;
		result = (int) (Math.random() * this.player.getFuerza());
		return result;		
	}
	
	public int getFuerza() {
		int result;
		result = this.player.getFuerza();
		return result; 
	}
	
	public int getDinero() {
		return dinero;
	}


	public void setDinero(int dinero) {
		this.dinero = dinero;
	}


	public int getPociones() {
		return pociones;
	}


	public void setPociones(int pociones) {
		this.pociones = pociones;
	}


	public int getGemas() {
		return gemas;
	}


	public void setGemas(int gemas) {
		this.gemas = gemas;
	}


	public PlayerType getPlayer() {
		return player;
	}


	public Jugador(PlayerType player) {
		super();
		this.player = player;
	}
	
	
	
}
