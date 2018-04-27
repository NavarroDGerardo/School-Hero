public abstract class Enemigo extends Mob{

	public Enemigo(int promedio, int ataque, int defensa){
		super(promedio, ataque, defensa);
	}

	public abstract void atacar(Mob mob);
}