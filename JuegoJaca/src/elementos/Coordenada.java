package elementos;

import java.util.Objects;

import logicaJuego.Constantes;

public class Coordenada {

	private int x; 
	private int y;
	
	public Coordenada() {
		super();
		this.x = (int) (Math.random() * Constantes.TAMANNO);
		this.y = (int) (Math.random() * Constantes.TAMANNO);
		
	}

	public Coordenada(int x, int y) {
		super();
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		
		if(x < 0 || x >= Constantes.TAMANNO ) {
			this.x = 0;
		} else {
			this.x = x;
		}
		
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		
		if(y < 0 || y <= Constantes.TAMANNO) {
			this.y = 0;
		} else {
			this.y = y;
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	} 
	
	public boolean goRight() {
		boolean result = false; 
		
		return result;
	}
	
	public boolean goLeft() {
		boolean result = false; 
		
		return result;
	}
	
	public boolean goUp() {
		boolean result = false; 
		
		return result;
	}
	
	public boolean goDown() {
		boolean result = false; 
		
		return result;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	//a ver si va 
	
	
}
