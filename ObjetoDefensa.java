public class ObjetoDefensa extends Item{
	private int defensa;

	public ObjetoDefensa(int precio, int numeroDeItems, int defensa){
		super(precio, numeroDeItems);
		this.defensa=defensa;
	}

	public void setDefensa(int defensa){
		this.defensa=defensa;
	}

	public int getDefensa(){
		return defensa;
	}
}