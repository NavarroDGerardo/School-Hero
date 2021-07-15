import java.io.Serializable;

public class Normal extends Alumno implements Serializable{
	
	public Normal(String nombre, int x, int y, int promedio, int ataque, int defensa, int xP, int numeroDeMobsAsesinados){
		super(nombre, x, y, promedio, ataque, defensa, xP, numeroDeMobsAsesinados);
	}

	public void atacar(Mob mob){
		if(mob.getDefensa()>0){
			mob.setDefensa(mob.getDefensa()- getAtaque());
		}else{
			mob.setPromedio(mob.getPromedio()- getAtaque());
		}
	}
}