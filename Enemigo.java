public abstract class Enemigo extends Mob{

	private int x;
	private int y;

	public Enemigo(int x, int y, int promedio, int ataque, int defensa){
		super(promedio, ataque, defensa);
		this.x=x;
		this.y=y;
	}

	public void setX(int x){
		this.x=x;
	}

	public int getX(){
		return x;
	}

	public void setY(int y){
		this.y=y;
	}

	public int getY(){
		return y;
	}

	public abstract void atacar(Mob mob);
}