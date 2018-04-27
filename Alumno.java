public abstract class Alumno extends Mob{

	private String nombre;
	private int x;
	private int y;
	private int xP;
	private int numeroDeMobsAsesinados;

	public Alumno(String nombre, int x, int y, int promedio, int ataque, int defensa, int xP, int numeroDeMobsAsesinados){
		super(promedio, ataque, defensa);
		this.nombre=nombre;
		this.x=x;
		this.y=y;
		this.xP=xP;
		this.numeroDeMobsAsesinados=numeroDeMobsAsesinados;
	}

	/*Set y Get de Nombre*/

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getNombre(){
		return nombre;
	}

	/*Set y Get de x*/

	public void setX(int x){
		this.x=x;
	}

	public int getX(){
		return x;
	}

	/*Set y Get de y*/

	public void setY(int y){
		this.y=y;
	}

	public int getY(){
		return y;
	}

	/*Set y Get de xP*/

	public void setXP(int defensa){
		this.xP=xP;
	}

	public int getXP(){
		return xP;
	}

	/*set y get de numeroDeMobsAsesinados*/

	public void setNumeroDeMobsAsesinados(int numeroDeMobsAsesinados){
		this.numeroDeMobsAsesinados=numeroDeMobsAsesinados;
	}

	public int getNumeroDeMobsAsesinados(){
		return numeroDeMobsAsesinados;
	}

	public abstract void atacar(Mob mob);
}