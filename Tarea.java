public class Tarea extends Enemigo{

	public Tarea(int promedio, int defensa, int ataque){
		super(promedio, defensa, ataque);
	}

	public void atacar(Mob mob){
		if(mob.getDefensa()>0){
			mob.setDefensa(mob.getDefensa()- getAtaque());
		}else{
			mob.setPromedio(mob.getPromedio()- getAtaque());
		}
	}
}