public abstract class Item{
	private int precio;
	private int numeroDeItems;

	public Item(int precio, int numeroDeItems){
		this.precio=precio;
		this.numeroDeItems=numeroDeItems;
	}

	public void setPrecio(int precio){
		this.precio=precio;
	}

	public int getPrecio(){
		return precio;
	}

	public void setNumeroDeItems(int numeroDeItems){
		this.numeroDeItems=numeroDeItems;
	}

	public int getNumeroDeItems(){
		return numeroDeItems;
	}
}