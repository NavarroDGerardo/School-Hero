import java.io.Serializable;

public class Tienda implements Serializable{
	private int x;
	private int y;

	public Tienda(int x, int y){
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
}