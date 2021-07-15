public class ObjetoArma extends Item{
	private int ataque;
	

	public ObjetoArma(int precio, int numeroDeItems, int ataque){
		super(precio, numeroDeItems);
		this.ataque=ataque;
	}

	public void setAtaque(int ataque){
		this.ataque=ataque;
	}

	public int getAtaque(){
		return ataque;
	}
	
}