import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ventana extends JFrame{

	/*Variables initComponentsPantallaInicio*/
	private JPanel panelPrincipal;
	private JLabel labelPresentacion, labelNombreJuego;
	private JButton buttonInicioJuego;

	/*Variables initComponentsPantallaPrincipal*/
	private JPanel panelHistoria, panelMapa, panelBotones, panelStats, panelContenedorMapa;
	private JButton bFlechaArriba, bFlechaDerecha, bFlechaIzquierda, bFlechaAbajo, bInventario;
	private JLabel lExperience, lPromedio, lDefensa, lAtaque, lNumeroDeMobsAsesinados;
	private Mapa mapa;
	private Alumno alumno;

	/*Variables label para los stats*/
	private JLabel labelNombre, labelPromedio, labelAtaque, labelDefensa, labelXP, labelNumeroDeMobsAsesinados;

	public Ventana(){
		super("VideoGame");
		mapa= new Mapa(20,20);
		/*nombre, x, y, promedio, ataque, defensa, xP, numero de mobs asesinados*/
		alumno= new Alumno("Gerardo", 5, 5, 100, 10, 1, 1, 1);
		crearMapa();
		initComponentsPantallaInicio();
		setLayout(new GridLayout(2,2));
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

	public void initComponentsPantallaPrincipal(){
		panelContenedorMapa= new JPanel();
		panelContenedorMapa.setLayout(new FlowLayout());
		add(panelContenedorMapa);
		pintarMapa();

		panelHistoria= new JPanel();
		add(panelHistoria);

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

		
		add(panelBotones);

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
		labelNombre.setText(alumno.getNombre());
		panelStats.add(labelNombre);
		panelStats.add(new JLabel(""));
		panelStats.add(new JLabel(""));

		lPromedio=new JLabel("Promedio: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lPromedio);
		panelStats.add(new JLabel(""));
		String promedioStr = String.valueOf(alumno.getPromedio());
		labelPromedio.setText(promedioStr);
		panelStats.add(labelPromedio);
		panelStats.add(new JLabel(""));

		lAtaque=new JLabel("Ataque: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lAtaque);
		panelStats.add(new JLabel(""));
		String ataqueStr = String.valueOf(alumno.getAtaque());
		labelAtaque.setText(ataqueStr);
		panelStats.add(labelAtaque);
		panelStats.add(new JLabel(""));

		lDefensa=new JLabel("Defensa: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lDefensa);
		panelStats.add(new JLabel(""));
		String defensaStr = String.valueOf(alumno.getDefensa());
		labelDefensa.setText(defensaStr);
		panelStats.add(labelDefensa);
		panelStats.add(new JLabel(""));

		lExperience=new JLabel("XP: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lExperience);
		panelStats.add(new JLabel(""));
		String xPStr = String.valueOf(alumno.getXP());
		labelXP.setText(xPStr);
		panelStats.add(labelXP);
		panelStats.add(new JLabel(""));

		lNumeroDeMobsAsesinados=new JLabel("# de tareas cumplidas: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lNumeroDeMobsAsesinados);
		panelStats.add(new JLabel(""));
		String numeroStr = String.valueOf(alumno.getNumeroDeMobsAsesinados());
		labelNumeroDeMobsAsesinados.setText(numeroStr);
		panelStats.add(labelNumeroDeMobsAsesinados);
		panelStats.add(new JLabel(""));




		add(panelStats);
	}

	public void crearMapa(){
		for(int i=0;i<mapa.getCasillas().length;i++){
			for(int j=0;j<mapa.getCasillas()[i].length;j++){
				mapa.getCasillas()[i][j]= new Casilla();
			}
		}
		mapa.getCasillas()[5][5].setAlumno(alumno);
	}

	public void pintarMapa(){
		panelMapa= new JPanel();
		panelMapa.setLayout(new GridLayout(mapa.getCasillas().length,mapa.getCasillas()[0].length));
		for(int i=0;i<mapa.getCasillas().length;i++){
			for(int j=0;j<mapa.getCasillas()[i].length;j++){
				if(mapa.getCasillas()[i][j].getAlumno()==null){
					panelMapa.add(new JLabel("*"));
				}else{
					panelMapa.add(new JLabel("Alumno"));
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
				panelContenedorMapa.remove(panelMapa);
				panelContenedorMapa.revalidate();
				panelContenedorMapa.repaint();
				pintarMapa();
			}else{
				System.out.println("Ya no se puede subir mas");
			}
		}
	}

	public class BotonIzquierdaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getY()>=1){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setY(alumno.getY()-1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				panelContenedorMapa.remove(panelMapa);
				panelContenedorMapa.revalidate();
				panelContenedorMapa.repaint();
				pintarMapa();
			}else{
				System.out.println("Ya no se puede ir mas para la Izquierda");
			}
		}
	}

	public class BotonAbajoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getX()<=18){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setX(alumno.getX()+1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				panelContenedorMapa.remove(panelMapa);
				panelContenedorMapa.revalidate();
				panelContenedorMapa.repaint();
				pintarMapa();
			}else{
				System.out.println("Ya no se puede bajar mas");
			}
		}
	}

	public class BotonDerechaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getY()<=18){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setY(alumno.getY()+1);

				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
				panelContenedorMapa.remove(panelMapa);
				panelContenedorMapa.revalidate();
				panelContenedorMapa.repaint();
				pintarMapa();
			}else{
				System.out.println("Ya no se puede ir mas para la derecha");
			}
		}
	}

	public class BotonInventarioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

		}
	}

}