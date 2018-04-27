public class Mapa{
	
	private Casilla[][] casillas;

	public Mapa(int rows, int cols){
		casillas= new Casilla[rows][cols];
	}

	public Casilla[][] getCasillas(){
		return casillas;
	}
}