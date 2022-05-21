package elementos;

import java.util.Objects;
import java.util.Random;

import logicajuego.Constantes;

public class Coordenada {

	private int x;
	private int y;

	public Coordenada() {
		super();
		Random r = new Random();
		this.x = r.nextInt(Constantes.TAMANNO);
		this.y = r.nextInt(Constantes.TAMANNO);

	}

	// sustitución del clone()

	public Coordenada(Coordenada coordenada) {
		this.x = coordenada.getX();
		this.y = coordenada.getY();
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

		if (x < 0 || x >= Constantes.TAMANNO) {
			this.x = 0;
		} else {
			this.x = x;
		}

	}

	public int getY() {
		return y;
	}

	private void setY(int y) {

		if (y < 0 || y >= Constantes.TAMANNO) {
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

		if (this.x + 1 < Constantes.TAMANNO) {
			this.x += 1;
			result = true;
		}

		return result;
	}

	public boolean goLeft() {
		boolean result = false;

		if (this.x - 1 >= 0) {
			this.x -= 1;
			result = true;
		}

		return result;
	}

	public boolean goUp() {
		boolean result = false;
		if (this.y - 1 >= 0) {
			this.y -= 1;
			result = true;
		}

		return result;
	}

	public boolean goDown() {
		boolean result = false;

		if (this.y + 1 < Constantes.TAMANNO) {
			this.y += 1;
			result = true;
		}
		return result;
	}

	

}
