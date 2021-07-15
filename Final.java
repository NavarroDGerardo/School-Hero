import java.io.Serializable;

public class Final extends Enemigo implements Serializable{

	public Final(int x, int y, int promedio, int ataque, int defensa){
		super(x, y, promedio, ataque, defensa);
	}

	public void atacar(Mob mob){
		if(mob.getDefensa()>0){
			mob.setDefensa(mob.getDefensa()- getAtaque());
		}else{
			mob.setPromedio(mob.getPromedio()- getAtaque());
		}
	}
}