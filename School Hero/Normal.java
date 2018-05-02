public class Normal extends Alumno{
	
	public Normal(String nombre, int x, int y, int promedio, int ataque, int defensa, int xP, int numeroDeMobsAsesinados){
		super(nombre, x, y, promedio, ataque, defensa, xP, numeroDeMobsAsesinados);
	}

	public void atacar(Mob mob){
		if(mob.getDefensa()>0){
			mob.setDefensa(mob.getDefensa()- getAtaque());
			if(getDefensa()<0){
				setDefensa(0);
			}
		}else{
			mob.setPromedio(mob.getPromedio()- getAtaque());
		}
	}
}