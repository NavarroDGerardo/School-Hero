public class Alumno{
	/*public String nombre;
	public int x;
	public int y;*/

	private String nombre;
	private int x;
	private int y;
	private int promedio;
	private int defensa;
	private int ataque;
	private int xP;

	public Alumno(String nombre, int x, int y, int promedio, int ataque, int defensa, int xP){
		this.nombre=nombre;
		this.x=x;
		this.y=y;
		this.promedio=promedio;
		this.defensa=defensa;
		this.ataque=ataque;
		this.xP=xP;
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

	/*Set y Get de promeido*/

	public void setPromedio(int promedio){
		this.promedio=promedio;
	}

	public int getPromedio(){
		return promedio;
	}

	/*Set y get de ataque*/

	public void setAtaque(int ataque){
		this.ataque=ataque;
	}

	public int getAtaque(){
		return ataque;
	}

	/*Set y Get de defensa*/

	public void setDefensa(int defensa){
		this.defensa=defensa;
	}

	public int getDefensa(){
		return defensa;
	}

	/*Set y Get de xP*/

	public void setXP(int defensa){
		this.xP=xP;
	}

	public int getXP(){
		return xP;
	}
}