public class Mapa{
	
	/*public Casilla[][] casillas;*/
	private Casilla[][] casillas;

	public Mapa(int rows, int cols){
		casillas= new Casilla[rows][cols];
	}

	public Casilla[][] getCasillas(){
		return casillas;
	}
}