import java.io.Serializable;

public class Casilla implements Serializable{

	private Alumno alumno;
	private Enemigo enemigo;
	private Bloque bloque;
	private Tienda tienda;

	public void setAlumno(Alumno alumno){
		this.alumno=alumno;
	}

	public Alumno getAlumno(){
		return alumno;
	}

	public void setEnemigo(Enemigo enemigo){
		this.enemigo=enemigo;
	}

	public Enemigo getEnemigo(){
		return enemigo;
	}

	public void setBloque(Bloque bloque){
		this.bloque=bloque;
	}

	public Bloque getBloque(){
		return bloque;
	}

	public void setTienda(Tienda tienda){
		this.tienda=tienda;
	}

	public Tienda getTienda(){
		return tienda;
	}

}