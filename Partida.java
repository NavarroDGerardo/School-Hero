import java.io.Serializable;

public class Partida implements Serializable{
	private Alumno alumno;
	private Mapa mapa;

	public void setAlumno(Alumno alumno){
		this.alumno=alumno;
	} 

	public Alumno getAlumno(){
		return alumno;
	}

	public void setMapa(Mapa mapa){
		this.mapa=mapa;
	}

	public Mapa getMapa(){
		return mapa;
	}


}