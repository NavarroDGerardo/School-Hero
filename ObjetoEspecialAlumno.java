public class ObjetoEspecialAlumno extends Item{
	private int defensa;
	private int ataque;
	private int promedio;

	public ObjetoEspecialAlumno(int precio, int numeroDeItems, int defensa, int ataque, int promedio){
		super(precio, numeroDeItems);
		this.defensa=defensa;
		this.ataque=ataque;
		this.promedio=promedio;
	}

	public void setDefensa(int defensa){
		this.defensa=defensa;
	}

	public int getDefensa(){
		return defensa;
	}

	public void setAtaque(int ataque){
		this.ataque=ataque;
	}

	public int getAtaque(){
		return ataque;
	}

	public void setPromedio(int Promedio){
		this.promedio=promedio;
	}

	public int getPromedio(){
		return promedio;
	}
}