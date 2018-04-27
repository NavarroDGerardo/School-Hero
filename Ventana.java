import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ventana extends JFrame{

	/*Panel de los niveles y pelea*/
	private JPanel panelNivel1, panelNivel2, panelNivel3, panelPelea;

	/*Variables initComponentsPantallaInicio*/
	private JPanel panelPrincipal;
	private JLabel labelPresentacion, labelNombreJuego;
	private JButton buttonInicioJuego;

	/*Variables initComponentsPantallaPrincipal*/
	private JPanel panelHistoria, panelMapa, panelBotones, panelStats, panelContenedorMapa;
	private JButton bFlechaArriba, bFlechaDerecha, bFlechaIzquierda, bFlechaAbajo, bInventario;
	private JLabel lExperience, lPromedio, lDefensa, lAtaque, lNumeroDeMobsAsesinados;
	
	/*Varibales de Ventana()*/
	private Mapa mapa;
	private Alumno alumno;
	private Enemigo enemigo;

	/*Variables label para los stats*/
	private JLabel labelNombre, labelPromedio, labelAtaque, labelDefensa, labelXP, labelNumeroDeMobsAsesinados;

	/*Variables initComponentsPelea*/
	private JPanel pAlumnoStats, pEnemigoStats, pBotonesPelea, pHistoriaPelea, pContenedorBotonesInventario;
	private JLabel lPromedioEnemigo, lDefensaEnemigo, lAtaqueEnemigo, labelPromedioEnemigo, labelAtaqueEnemigo, labelDefensaEnemigo;
	private JButton botonAtacar, botonInventario;

	public Ventana(){
		super("VideoGame");
		mapa= new Mapa(20,20);
		/*nombre, x, y, promedio, ataque, defensa, xP, numero de mobs asesinados*/
		alumno=new Normal("Genos", 5, 5, 100, 10, 1, 1, 1);
		enemigo=new Tarea(20, 10, 5);
		crearMapa();
		initComponentsPantallaInicio();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1500,1500);
		setVisible(true);
	}

	public void initComponentsPantallaInicio(){
		panelPrincipal=new JPanel();
		panelPrincipal.setLayout(new GridLayout(3,1));

		Font titulo = new Font("Serif", Font.BOLD, 24);
		Font newTitulo = titulo.deriveFont(30F);

		labelPresentacion=new JLabel("Bienvenido");
		labelPresentacion.setFont(newTitulo);
		panelPrincipal.add(labelPresentacion);

		Font subtitulo = new Font("Serif", Font.ITALIC | Font.BOLD, 14);
		Font newSubtitulo = subtitulo.deriveFont(25F);

		labelNombreJuego=new JLabel("School Hero");
		labelNombreJuego.setFont(newSubtitulo);
		panelPrincipal.add(labelNombreJuego);

		buttonInicioJuego=new JButton("Inicio");
		buttonInicioJuego.addActionListener(new BotonInicioListener());
		panelPrincipal.add(buttonInicioJuego);

		add(panelPrincipal);

	}

	public void initComponentsPelea(){
		panelPelea=new JPanel();
		panelPelea.setLayout(new GridLayout(2,2));

		pAlumnoStats=new JPanel();
		imprimirStatsAlumno();
		panelPelea.add(pAlumnoStats);

		pEnemigoStats=new JPanel();
		imprimirStatsEnemigo();
		panelPelea.add(pEnemigoStats);

		pBotonesPelea=new JPanel();
		pBotonesPelea.setLayout(new GridLayout(2,1));
		botonAtacar=new JButton("Atacar");
		botonAtacar.addActionListener(new BotonAtacarListener());
		pBotonesPelea.add(botonAtacar);

		botonInventario= new JButton("Inventario");
		botonInventario.addActionListener(new BotonIListener());
		pBotonesPelea.add(botonInventario);

		panelPelea.add(pBotonesPelea);

		pHistoriaPelea=new JPanel();
		panelPelea.add(pHistoriaPelea);

		add(panelPelea);
	}

	public void initComponentsPantallaPrincipal(){
		panelNivel1= new JPanel();
		panelNivel1.setLayout(new GridLayout(2,2));

		panelContenedorMapa= new JPanel();
		panelContenedorMapa.setLayout(new FlowLayout());
		panelNivel1.add(panelContenedorMapa);
		pintarMapa();

		panelHistoria= new JPanel();
		panelNivel1.add(panelHistoria);

		panelBotones=new JPanel();
		panelBotones.setLayout(new GridLayout(3,3));

		bFlechaArriba= new JButton("Arriba");
		bFlechaArriba.addActionListener(new BotonArribaListener());
		panelBotones.add(new JLabel(""));
		panelBotones.add(bFlechaArriba);
		panelBotones.add(new JLabel(""));
		bFlechaIzquierda=new JButton("Izquierda");
		bFlechaIzquierda.addActionListener(new BotonIzquierdaListener());
		panelBotones.add(bFlechaIzquierda);
		bInventario=new JButton("Inventario");
		bInventario.addActionListener(new BotonInventarioListener());
		panelBotones.add(bInventario);
		bFlechaDerecha= new JButton("Derecha");
		bFlechaDerecha.addActionListener(new BotonDerechaListener());
		panelBotones.add(bFlechaDerecha);
		bFlechaAbajo=new JButton("Abajo");
		bFlechaAbajo.addActionListener(new BotonAbajoListener());
		panelBotones.add(new JLabel(""));
		panelBotones.add(bFlechaAbajo);
		panelBotones.add(new JLabel(""));

		
		panelNivel1.add(panelBotones);

		labelNombre= new JLabel();
		labelPromedio= new JLabel();
		labelAtaque= new JLabel();
		labelDefensa= new JLabel();
		labelXP= new JLabel();
		labelNumeroDeMobsAsesinados=new JLabel();

		panelStats=new JPanel();
		panelStats.setLayout(new GridLayout(7,5));
		
		panelStats.add(new JLabel(""));
		panelStats.add(new JLabel(""));
		imprimeNombre();
		panelStats.add(labelNombre);
		panelStats.add(new JLabel(""));
		panelStats.add(new JLabel(""));

		lPromedio=new JLabel("Promedio: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lPromedio);
		panelStats.add(new JLabel(""));
		imprimePromedio();
		panelStats.add(labelPromedio);
		panelStats.add(new JLabel(""));

		lAtaque=new JLabel("Ataque: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lAtaque);
		panelStats.add(new JLabel(""));
		imrpimeAtaque();
		panelStats.add(labelAtaque);
		panelStats.add(new JLabel(""));

		lDefensa=new JLabel("Defensa: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lDefensa);
		panelStats.add(new JLabel(""));
		imprimeDefensa();
		panelStats.add(labelDefensa);
		panelStats.add(new JLabel(""));

		lExperience=new JLabel("XP: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lExperience);
		panelStats.add(new JLabel(""));
		imprimeXP();
		panelStats.add(labelXP);
		panelStats.add(new JLabel(""));

		lNumeroDeMobsAsesinados=new JLabel("# de tareas cumplidas: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lNumeroDeMobsAsesinados);
		panelStats.add(new JLabel(""));
		imprimeNumeroDeMobsAsesinados();
		panelStats.add(labelNumeroDeMobsAsesinados);
		panelStats.add(new JLabel(""));

		panelNivel1.add(panelStats);
		add(panelNivel1);
	}

	public void crearMapa(){
		for(int i=0;i<mapa.getCasillas().length;i++){
			for(int j=0;j<mapa.getCasillas()[i].length;j++){
				mapa.getCasillas()[i][j]= new Casilla();
			}
		}
		mapa.getCasillas()[5][5].setAlumno(alumno);
		mapa.getCasillas()[7][10].setEnemigo(enemigo);
	}

	public void pintarMapa(){
		panelMapa= new JPanel();
		panelMapa.setLayout(new GridLayout(mapa.getCasillas().length,mapa.getCasillas()[0].length));
		for(int i=0;i<mapa.getCasillas().length;i++){
			for(int j=0;j<mapa.getCasillas()[i].length;j++){
				if(mapa.getCasillas()[i][j].getAlumno()==null && mapa.getCasillas()[i][j].getEnemigo()==null){
					panelMapa.add(new JLabel("*"));
				}
				if(mapa.getCasillas()[i][j].getAlumno()!=null){
					panelMapa.add(new JLabel(alumno.getNombre()));
				}
				if(mapa.getCasillas()[i][j].getEnemigo()!=null){
					panelMapa.add(new JLabel("E"));
				}
			}
		}

		panelContenedorMapa.add(panelMapa);
		panelContenedorMapa.revalidate();
		panelContenedorMapa.repaint();
	}

	public class BotonInicioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(panelPrincipal);
			initComponentsPantallaPrincipal();
			revalidate();
			repaint();
		}
	}

	public class BotonArribaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getX()>=1){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setX(alumno.getX()-1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				checarCasilla();
			}
			/*else{
				System.out.println("Ya no se puede subir mas");
			}*/
		}
	}

	public class BotonIzquierdaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getY()>=1){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setY(alumno.getY()-1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				checarCasilla();
			}
			/*else{
				System.out.println("Ya no se puede ir mas para la Izquierda");
			}*/
		}
	}

	public class BotonAbajoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getX()<=18){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setX(alumno.getX()+1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				checarCasilla();
			}
			/*else{
				System.out.println("Ya no se puede bajar mas");
			}*/
		}
	}

	public class BotonDerechaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getY()<=18){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setY(alumno.getY()+1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				checarCasilla();
			}
			/*else{
				System.out.println("Ya no se puede ir mas para la derecha");
			}*/
		}
	}

	public class BotonInventarioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

		}
	}

	public void checarCasilla(){
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo()!=null){
			remove(panelNivel1);
			initComponentsPelea();
			revalidate();
			repaint();
		}else{
			panelContenedorMapa.remove(panelMapa);
			panelContenedorMapa.revalidate();
			panelContenedorMapa.repaint();
			pintarMapa();
		}
	}

	public void imprimeNombre(){
		labelNombre.setText(alumno.getNombre());
	}

	public void imprimePromedio(){
		String promedioStr = String.valueOf(alumno.getPromedio());
		labelPromedio.setText(promedioStr);
	}

	public void imrpimeAtaque(){
		String ataqueStr = String.valueOf(alumno.getAtaque());
		labelAtaque.setText(ataqueStr);
	}

	public void imprimeDefensa(){
		String defensaStr = String.valueOf(alumno.getDefensa());
		labelDefensa.setText(defensaStr);
	}

	public void imprimeXP(){
		String xPStr = String.valueOf(alumno.getXP());
		labelXP.setText(xPStr);
	}

	public void imprimeNumeroDeMobsAsesinados(){
		String numeroStr = String.valueOf(alumno.getNumeroDeMobsAsesinados());
		labelNumeroDeMobsAsesinados.setText(numeroStr);
	}

	public void imprimirStatsAlumno(){
		pAlumnoStats.setLayout(new GridLayout(7,5));

		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(new JLabel(""));
		imprimeNombre();
		pAlumnoStats.add(labelNombre);
		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(new JLabel(""));

		lPromedio=new JLabel("Promedio: ");
		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(lPromedio);
		pAlumnoStats.add(new JLabel(""));
		imprimePromedio();
		pAlumnoStats.add(labelPromedio);
		pAlumnoStats.add(new JLabel(""));

		lAtaque=new JLabel("Ataque: ");
		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(lAtaque);
		pAlumnoStats.add(new JLabel(""));
		imrpimeAtaque();
		pAlumnoStats.add(labelAtaque);
		pAlumnoStats.add(new JLabel(""));

		lDefensa=new JLabel("Defensa: ");
		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(lDefensa);
		pAlumnoStats.add(new JLabel(""));
		imprimeDefensa();
		pAlumnoStats.add(labelDefensa);
		pAlumnoStats.add(new JLabel(""));

		lExperience=new JLabel("XP: ");
		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(lExperience);
		pAlumnoStats.add(new JLabel(""));
		imprimeXP();
		pAlumnoStats.add(labelXP);
		pAlumnoStats.add(new JLabel(""));

		lNumeroDeMobsAsesinados=new JLabel("# de tareas cumplidas: ");
		pAlumnoStats.add(new JLabel(""));
		pAlumnoStats.add(lNumeroDeMobsAsesinados);
		pAlumnoStats.add(new JLabel(""));
		imprimeNumeroDeMobsAsesinados();
		pAlumnoStats.add(labelNumeroDeMobsAsesinados);
		pAlumnoStats.add(new JLabel(""));
	}

	public void imprimirStatsEnemigo(){
		pEnemigoStats.setLayout(new GridLayout(5,5));

		lPromedioEnemigo= new JLabel();
		lAtaqueEnemigo=new JLabel();
		lDefensaEnemigo=new JLabel();

		labelPromedioEnemigo= new JLabel("Promedio Enemigo: ");
		pEnemigoStats.add(labelPromedioEnemigo);
		imprimePromedioEnemigo();
		pEnemigoStats.add(lPromedioEnemigo);

		labelAtaqueEnemigo=new JLabel("Ataque Enemigo: ");
		pEnemigoStats.add(labelAtaqueEnemigo);
		imprimeAtaqueEnemigo();
		pEnemigoStats.add(lAtaqueEnemigo);

		labelDefensaEnemigo=new JLabel("Defensa Enemigo: ");
		pEnemigoStats.add(labelDefensaEnemigo);
		imprimeDefensaEnemigo();
		pEnemigoStats.add(lDefensaEnemigo);
	}

	public void imprimePromedioEnemigo(){
		String promedioEnemigoStr = String.valueOf(enemigo.getPromedio());
		lPromedioEnemigo.setText(promedioEnemigoStr);
	}

	public void imprimeAtaqueEnemigo(){
		String ataqueEnemigoStr = String.valueOf(enemigo.getAtaque());
		lAtaqueEnemigo.setText(ataqueEnemigoStr);
	}

	public void imprimeDefensaEnemigo(){
		String defensaEnemigoStr = String.valueOf(enemigo.getDefensa());
		lDefensaEnemigo.setText(defensaEnemigoStr);
	}

	public class BotonAtacarListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

		}
	}

	public class BotonIListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

		}
	}
}