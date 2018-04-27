public abstract class Mob implements ActionMob{
	
	private int promedio;
	private int defensa;
	private int ataque;

	public Mob(int promedio, int ataque, int defensa){
		this.promedio=promedio;
		this.defensa=defensa;
		this.ataque=ataque;
	}

	public void setPromedio(int promedio){
		this.promedio=promedio;
	}

	public int getPromedio(){
			return promedio;
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
}