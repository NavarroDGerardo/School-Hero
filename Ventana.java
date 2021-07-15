import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Ventana extends JFrame{

	/*Variables especiales*/
	private JFileChooser fileChooser;
	private int ataqueTotalInicial = 10;
	private int NumeorDePantalla = 0;
	private int enseniarInventario = 0;
	private int mostrarPelea = 0;

	/*Panel de los niveles y pelea*/
	private JPanel panelNivel1, panelNivel2, panelNivel3, panelPelea;

	/*Variables initComponentsPantallaInicio*/
	private JPanel panelPrincipal;
	private JLabel labelPresentacion, labelNombreJuego;
	private JButton buttonInicioJuego, buttonCargarJuego;

	/*Variables initComponentsPantallaPrincipal*/
	private JPanel panelMapa, panelBotones, panelStats, panelContenedorMapa, panelContenedorBotonesEInventario, panelInventario;
	private JButton bFlechaArriba, bFlechaDerecha, bFlechaIzquierda, bFlechaAbajo, bInventario;
	private JLabel lExperience, lPromedio, lDefensa, lAtaque, lNumeroDeMobsAsesinados, lArma, lEscudo, lObjetoEspecial;
	private JTextArea historiaPrincipal;
	private JScrollPane scrollPaneHistoriaPrincipal;

	/*Variables inventario*/
	private JLabel labelInventario, labelObjetosArmas, labelObjetosDefensa, labelObjetosEspeciales;
	private JButton botonCuaderno, botonCarpeta, botonLonchera, botonMochila;
	private JButton botonLapiz, botonPluma, botonPlumaFuente, botonRegla, botonPlumon;
	private JButton botonCafe, botonTrabajoExtra, botonAcordeon, botonTrabajoComprado, botonVeladora, botonAmigo, botonRegresar, botonGuardarPartida;
	
	/*Varibales de Ventana()*/
	private Mapa mapa;
	private Alumno alumno;
	private Enemigo enemigo, enemigo2, enemigo3, enemigo4, enemigo5, enemigo6, enemigo7, enemigo8, parcial1;
	private Bloque bloque;
	private	ObjetoArma lapiz, pluma, plumaFuente, plumon, regla;
	private ObjetoDefensa cuaderno, carpeta, lonchera, mochila;
	private ObjetoEspecialAlumno cafe, trabajoExtra, veladora, amigo, trabajoComprado, acordeon;
	private Tienda tienda;
	private Partida partida;

	/*Variables label para los stats*/
	private JLabel labelNombre, labelPromedio, labelAtaque, labelDefensa, labelXP, labelNumeroDeMobsAsesinados, labelArma, labelEscudo, labelObjetoEspecial;

	/*Variables initComponentsPelea*/
	private JPanel pAlumnoStats, pEnemigoStats, pBotonesPelea, pContenedorBotonesInventario, pContenedorAlumnoStats, pContenedor;
	private JLabel lPromedioEnemigo, lDefensaEnemigo, lAtaqueEnemigo, labelPromedioEnemigo, labelAtaqueEnemigo, labelDefensaEnemigo;
	private JButton botonAtacar, botonInventario;
	private JTextArea historiaPelea;
	private JScrollPane scrollPaneHistoriaPelea;

	/*Variables initTienda*/
	private JPanel panelInventarioTienda, panelTienda, panelContenedorInventario, panelContenedorStatsJugador;
	private JButton bTiendaLapiz, bTiendaPluma, bTiendaPlumaFuente, bTiendaPlumon, bTiendaRegla;
	private JButton bTiendaCuaderno, bTiendaCarpeta, bTiendaLonchera, bTiendaMochila, bTerminarCompra;
	private JLabel lTiendaLapiz, lTiendaPluma, lTiendaPlumaFuente, lTiendaPlumon, lTiendaRegla;
	private JLabel lTiendaCuaderno, lTiendaCarpeta, lTiendaLonchera, lTiendaMochila, lTienda, lTiendaArma, lTiendaEscudo, lTiendaEspecial;
	private JButton bTiendaVeladora, bTiendaAmigo, bTiendaCafe, bTiendatrabajoExtra, bTiendaTrabajoComprado, bTiendaAcordeon;
	private JLabel lTiendaVeladora, lTiendaAmigo, lTiendaCafe, lTiendatrabajoExtra, lTiendaTrabajoComprado, lTiendaAcordeon;
	private JScrollPane scrollPaneHistoriaTienda;
	private JTextArea historiaTienda;

	/*Variables initComponentsPantallaSeleccion*/
	private JPanel panelImagenJugador, panelClases, panelContenedorComponentesPantallaSeleccion;
	private JTextField nombreJugador;
	private JButton bClaseNomral, bClaseAplicado, bClaseCheater;
	private JLabel lCaracteristicasNormal, lCaracteristicasAplicado, lCaracteristicasCheater, lIndicacionNombre;

	/*Variables initComponentsGameOver*/
	private JPanel panelGameOver;
	private JButton bMainPanel;
	private JLabel lGameOver;


	public Ventana(){
		super("VideoGame");
		mapa= new Mapa(20,20);
		/*nombre, x, y, promedio, ataque, defensa, xP, numero de mobs asesinados*/
		/*alumno=new Normal("", 5, 5, 100, 10, 20, 0, 0);*/

		/*int x, int y, int promedio, int ataque, int defensa*/
		enemigo=new Tarea(7, 10, 20, 10, 30);
		enemigo2=new Tarea(2, 5, 10, 5, 25);
		enemigo3=new Tarea(17, 9, 15, 15, 10);
		enemigo4=new Tarea(5, 12, 12, 10, 22);
		enemigo5=new Tarea(18, 2, 15, 7, 20);
		enemigo6=new Tarea(12, 3, 20, 12, 15);
		enemigo7=new Tarea(16, 12, 25, 16, 20);
		enemigo8=new Tarea(1, 18, 18, 18, 30);

		parcial1=new Parcial(19, 19, 200, 50, 100);

		bloque=new Bloque(0, 0);
		tienda=new Tienda(10, 15);

		/*Objetos Arma*/
		/*precio, numeor de Items, ataque*/
		lapiz= new Lapiz(25, 0, 7);
		pluma= new Pluma(30, 0, 12);
		plumaFuente= new PlumaFuente(45, 0, 17);
		plumon= new Plumon(50, 0, 22);
		regla= new Regla(60, 0, 30);

		/*Objetos Defensa*/
		cuaderno = new Cuaderno(15, 2, 5);
		carpeta= new Carpeta(20, 0, 10);
		lonchera= new Lonchera(25, 0, 15);
		mochila= new Mochila(30, 0, 20);

		/*Objetos especiales Aplicado*/
		/*int precio, int numeroDeItems, int defensa, int ataque, int promedio*/
		cafe= new Cafe(45, 2, 20, 5, 0);
		trabajoExtra= new TrabajoExtra(60, 2, 5, 0, 10);

		/*Objetos especiales Normal*/
		/*int precio, int numeroDeItems, int defensa, int ataque, int promedio*/
		veladora=new Veladora(45, 3, 15, 10, 0);
		amigo=new Amigo(55, 2, 10, 20, 0);

		/*Objetos especiales Cheater*/
		/*int precio, int numeroDeItems, int defensa, int ataque, int promedio*/
		trabajoComprado=new TrabajoComprado(50, 2, 0, 0, 15);
		acordeon=new Acordeon(60, 2, 15, 15, 0);

		crearMapa();
		initComponentsPantallaInicio();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1500,1500);
		setVisible(true);
	}

	public void initComponentsPantallaInicio(){
		panelPrincipal=new JPanel();
		panelPrincipal.setLayout(new GridLayout(7,3));

		Font titulo = new Font("Serif", Font.BOLD, 24);
		Font newTitulo = titulo.deriveFont(30F);

		labelPresentacion=new JLabel("Bienvenido");
		labelPresentacion.setFont(newTitulo);
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(labelPresentacion);
		panelPrincipal.add(new JLabel(""));

		Font subtitulo = new Font("Serif", Font.ITALIC | Font.BOLD, 14);
		Font newSubtitulo = subtitulo.deriveFont(25F);

		labelNombreJuego=new JLabel("School Hero");
		labelNombreJuego.setFont(newSubtitulo);
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(labelNombreJuego);
		panelPrincipal.add(new JLabel(""));

		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(new JLabel(""));

		buttonInicioJuego=new JButton("Nueva partida");
		buttonInicioJuego.addActionListener(new BotonInicioListener());
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(buttonInicioJuego);
		panelPrincipal.add(new JLabel(""));

		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(new JLabel(""));

		buttonCargarJuego=new JButton("Cargar partida");
		buttonCargarJuego.addActionListener(new BotonCargarPartidaListener());
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(buttonCargarJuego);
		panelPrincipal.add(new JLabel(""));

		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(new JLabel(""));
		panelPrincipal.add(new JLabel(""));

		add(panelPrincipal);
	}


	/*Estos son los componentes de la pantalla donde se selecciona las clases del personje*/
	public void initComponentsPantallaSeleccion(){
		panelContenedorComponentesPantallaSeleccion=new JPanel();
		panelContenedorComponentesPantallaSeleccion.setLayout(new GridLayout(1,1));

		panelClases=new JPanel();
		panelClases.setLayout(new GridLayout(12, 3));
		/*Este panel es donde van a estar los botones de seleciión de las clases*/
		panelClases.add(new JLabel(""));
		lIndicacionNombre=new JLabel("Ingresa el nomrbe del jugador");
		panelClases.add(lIndicacionNombre);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		nombreJugador=new JTextField();
		panelClases.add(nombreJugador);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		bClaseNomral=new JButton("Alumno Normal");
		bClaseNomral.addActionListener(new BotonClaseNormalistener());
		panelClases.add(bClaseNomral);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		lCaracteristicasNormal=new JLabel("Promedio Final mayor a 80");
		panelClases.add(lCaracteristicasNormal);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		bClaseAplicado=new JButton("Alumno Aplicado");
		bClaseAplicado.addActionListener(new BotonClaseAplicadoListener());
		panelClases.add(bClaseAplicado);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		lCaracteristicasAplicado=new JLabel("Promedio Final mayor a 90");
		panelClases.add(lCaracteristicasAplicado);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		bClaseCheater=new JButton("Alumno Tramposo");
		bClaseCheater.addActionListener(new BotonClaseCheaterListener());
		panelClases.add(bClaseCheater);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		lCaracteristicasCheater=new JLabel("Promedio Final mayor a 70");
		panelClases.add(lCaracteristicasCheater);
		panelClases.add(new JLabel(""));

		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));
		panelClases.add(new JLabel(""));

		panelContenedorComponentesPantallaSeleccion.add(panelClases);
		add(panelContenedorComponentesPantallaSeleccion);
	}

	public void initComponentsPelea(){
		panelPelea=new JPanel();
		panelPelea.setLayout(new GridLayout(2,2));

		panelStats=new JPanel();
		imprimirStatsAlumno();
		panelPelea.add(panelStats);

		pEnemigoStats=new JPanel();
		imprimirStatsEnemigo();
		panelPelea.add(pEnemigoStats);

		panelContenedorBotonesEInventario= new JPanel();
		panelContenedorBotonesEInventario.setLayout(new GridLayout(1,1));

		panelBotones=new JPanel();
		panelBotones.setLayout(new GridLayout(2,1));

		botonAtacar=new JButton("Atacar");
		botonAtacar.addActionListener(new BotonAtacarListener());
		panelBotones.add(botonAtacar);
		
		bInventario=new JButton("Inventario");
		bInventario.addActionListener(new BotonInventarioListener());
		panelBotones.add(bInventario);

		ImprimirInventario();

		panelContenedorBotonesEInventario.add(panelBotones);
		panelPelea.add(panelContenedorBotonesEInventario);

		historiaPrincipal = new JTextArea();
		scrollPaneHistoriaPrincipal= new JScrollPane(historiaPrincipal);
		panelPelea.add(scrollPaneHistoriaPrincipal);

		add(panelPelea);
	}

	public void initComponentsTienda(){
		NumeorDePantalla = 1;
		String claseJugador= alumno.getClass().getSimpleName();

		panelTienda=new JPanel();
		panelTienda.setLayout(new GridLayout(2,2));

		panelContenedorInventario=new JPanel();
		panelContenedorInventario.setLayout(new GridLayout(1,1));

		ImprimirInventario();
		panelInventario.remove(botonRegresar);
		panelContenedorInventario.add(panelInventario);

		panelTienda.add(panelContenedorInventario);

		panelInventarioTienda=new JPanel();
		panelInventarioTienda.setLayout(new GridLayout(7, 6));

		lTienda=new JLabel("Tienda");
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(lTienda);
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(new JLabel(""));

		lTiendaArma=new JLabel("Arma");
		lTiendaEscudo=new JLabel("Escudo");
		lTiendaEspecial=new JLabel("Especial");
		panelInventarioTienda.add(lTiendaArma);
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(lTiendaEscudo);
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(lTiendaEspecial);
		panelInventarioTienda.add(new JLabel(""));

		bTiendaLapiz=new JButton("Lapiz");
		bTiendaLapiz.addActionListener(new BotonTiendaLapizListener());
		panelInventarioTienda.add(bTiendaLapiz);
		String precioLapizStr = String.valueOf(lapiz.getPrecio());
		lTiendaLapiz=new JLabel(" = $" + precioLapizStr);
		panelInventarioTienda.add(lTiendaLapiz);
		bTiendaCuaderno=new JButton("Cuaderno");
		bTiendaCuaderno.addActionListener(new BotonTiendaCuadernoListener());
		panelInventarioTienda.add(bTiendaCuaderno);
		String precioCuadernoStr = String.valueOf(cuaderno.getPrecio());
		lTiendaCuaderno=new JLabel(" = $" + precioCuadernoStr);
		panelInventarioTienda.add(lTiendaCuaderno);
		
		if(claseJugador=="Normal"){
			bTiendaVeladora=new JButton("Veladora");
			bTiendaVeladora.addActionListener(new BotonTiendaEspecialUnoListener());
			panelInventarioTienda.add(bTiendaVeladora);
			String precioVeladoraStr = String.valueOf(veladora.getPrecio());
			lTiendaVeladora=new JLabel(" = $" + precioVeladoraStr);
			panelInventarioTienda.add(lTiendaVeladora);
		}
		if(claseJugador=="Aplicado"){
			bTiendaCafe=new JButton("CAFE!!!!");
			bTiendaCafe.addActionListener(new BotonTiendaEspecialUnoListener());
			panelInventarioTienda.add(bTiendaCafe);
			String precioCafeStr = String.valueOf(cafe.getPrecio());
			lTiendaCafe=new JLabel(" = $" + precioCafeStr);
			panelInventarioTienda.add(lTiendaCafe);
		}
		if(claseJugador=="Cheater"){
			bTiendaAcordeon=new JButton("Acordeon");
			bTiendaAcordeon.addActionListener(new BotonTiendaEspecialUnoListener());
			panelInventarioTienda.add(bTiendaAcordeon);
			String precioEspecialStr = String.valueOf(acordeon.getPrecio());
			lTiendaAcordeon=new JLabel(" = $" + precioEspecialStr);
			panelInventarioTienda.add(lTiendaAcordeon);
		}


		bTiendaPluma=new JButton("Pluma");
		bTiendaPluma.addActionListener(new BotonTiendaPlumaListener());
		panelInventarioTienda.add(bTiendaPluma);

		lTiendaPluma=new JLabel(" = $30");
		panelInventarioTienda.add(lTiendaPluma);
		bTiendaCarpeta=new JButton("Carpeta");
		bTiendaCarpeta.addActionListener(new BotonTiendaCarpetaListener());
		panelInventarioTienda.add(bTiendaCarpeta);
		lTiendaCarpeta=new JLabel(" = $20");
		panelInventarioTienda.add(lTiendaCarpeta);
		
		if(claseJugador=="Normal"){
			bTiendaAmigo=new JButton("Llamar a un amigo");
			bTiendaAmigo.addActionListener(new BotonTiendaEspecialDosListener());
			panelInventarioTienda.add(bTiendaAmigo);
			String precioAmigoStr = String.valueOf(amigo.getPrecio());
			lTiendaAmigo=new JLabel(" = $" + precioAmigoStr);
			panelInventarioTienda.add(lTiendaAmigo);
			
		}
		if(claseJugador=="Aplicado"){
			bTiendatrabajoExtra=new JButton("Trabajo Extra");
			bTiendatrabajoExtra.addActionListener(new BotonTiendaEspecialDosListener());
			panelInventarioTienda.add(bTiendatrabajoExtra);
			String precioEspecialStr = String.valueOf(trabajoExtra.getPrecio());
			lTiendatrabajoExtra=new JLabel(" = $" + precioEspecialStr);
			panelInventarioTienda.add(lTiendatrabajoExtra);
		}
		if(claseJugador=="Cheater"){
			bTiendaTrabajoComprado=new JButton("Trabajo Comprado");
			bTiendaTrabajoComprado.addActionListener(new BotonTiendaEspecialDosListener());
			panelInventarioTienda.add(bTiendaTrabajoComprado);
			String precioEspecialStr = String.valueOf(trabajoComprado.getPrecio());
			lTiendaTrabajoComprado=new JLabel(" = $" + precioEspecialStr);
			panelInventarioTienda.add(lTiendaTrabajoComprado);
		}
	

		bTiendaPlumaFuente=new JButton("Pluma Fuente");
		bTiendaPlumaFuente.addActionListener(new BotonTiendaPlumaFuenteListener());
		lTiendaPlumaFuente=new JLabel(" = $45");
		bTiendaLonchera=new JButton("Lonchera");
		bTiendaLonchera.addActionListener(new BotonTiendaLoncheraListener());
		lTiendaLonchera=new JLabel(" = $25");
		panelInventarioTienda.add(bTiendaPlumaFuente);
		panelInventarioTienda.add(lTiendaPlumaFuente);
		panelInventarioTienda.add(bTiendaLonchera);
		panelInventarioTienda.add(lTiendaLonchera);
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(new JLabel(""));

		bTiendaPlumon=new JButton("Plumon");
		bTiendaPlumon.addActionListener(new BotonTiendaPlumonListener());
		lTiendaPlumon=new JLabel(" = $50");
		bTiendaMochila=new JButton("Mochila");
		bTiendaMochila.addActionListener(new BotonTiendaMochilaListener());
		lTiendaMochila=new JLabel(" = $30");
		panelInventarioTienda.add(bTiendaPlumon);
		panelInventarioTienda.add(lTiendaPlumon);
		panelInventarioTienda.add(bTiendaMochila);
		panelInventarioTienda.add(lTiendaMochila);
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(new JLabel(""));

		bTiendaRegla=new JButton("Regla");
		bTiendaRegla.addActionListener(new BototnTiendaReglaListener());
		lTiendaRegla=new JLabel(" = $60");
		panelInventarioTienda.add(bTiendaRegla);
		panelInventarioTienda.add(lTiendaRegla);
		panelInventarioTienda.add(new JLabel(""));
		panelInventarioTienda.add(new JLabel(""));
		bTerminarCompra=new JButton("Terminar Compra");
		bTerminarCompra.addActionListener(new BotonTerminarCompraListener());
		panelInventarioTienda.add(bTerminarCompra);
		panelInventarioTienda.add(new JLabel(""));

		panelTienda.add(panelInventarioTienda);

		panelContenedorStatsJugador=new JPanel();
		panelContenedorStatsJugador.setLayout(new GridLayout(1,1));
			imprimirStatsJugador();
		panelContenedorStatsJugador.add(panelStats);
		panelTienda.add(panelContenedorStatsJugador);

		historiaTienda = new JTextArea();
		historiaTienda.setText("\nBienvenido a la tienda " + alumno.getNombre() + "\n");
		historiaTienda.setText(historiaTienda.getText() + "\nEn este lugar podras comprar diferentes tipos de items que te seran de utilidad para pasar el semestre\n");
		historiaTienda.setText(historiaTienda.getText() + "\nLos items Armas aumentaran tu poder de ataque, cada item Arma sube un los puntos de ataque de manera diferente\n entre mas cueste un ARMA mayor seran los puntos de ataque que aumentara tu poder de ataque\n");
		historiaTienda.setText(historiaTienda.getText() + "\nLos items Escudo aumentaran tu poder de ataque, cada item Escudo sube un los puntos de defensa de manera diferente\n entre mas cueste un ESCUDO mayor seran los puntos de defensa que aumentara tu poder de defensa\n");
		historiaTienda.setText(historiaTienda.getText() + "\nCada clase del juego tiene diferentes tipos de Items ESPECIALES como tu eres un alumno " + claseJugador + " solo tienes estos objetos especiales disponibles\n");
		scrollPaneHistoriaTienda= new JScrollPane(historiaTienda);
		panelTienda.add(scrollPaneHistoriaTienda);

		add(panelTienda);
	}

	public void initComponentsPantallaPrincipal(){
		partida=new Partida();

		String claseJugador= alumno.getClass().getSimpleName();
		NumeorDePantalla = 0;
		panelNivel1= new JPanel();
		panelNivel1.setLayout(new GridLayout(2,2));

		panelContenedorMapa= new JPanel();
		panelContenedorMapa.setLayout(new FlowLayout());
		panelNivel1.add(panelContenedorMapa);
		pintarMapa();

		historiaPrincipal = new JTextArea();
		historiaPrincipal.setText("\nBienvenido " + alumno.getNombre() + " a este nuevo semestre\n");
		contarHistoriaPrincipal();
		scrollPaneHistoriaPrincipal= new JScrollPane(historiaPrincipal);
		panelNivel1.add(scrollPaneHistoriaPrincipal);

		panelContenedorBotonesEInventario= new JPanel();
		panelContenedorBotonesEInventario.setLayout(new GridLayout(1,1));

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

		panelContenedorBotonesEInventario.add(panelBotones);

		ImprimirInventario();
		panelNivel1.add(panelContenedorBotonesEInventario);

		labelNombre= new JLabel();
		labelPromedio= new JLabel();
		labelAtaque= new JLabel();
		labelDefensa= new JLabel();
		labelXP= new JLabel();
		labelNumeroDeMobsAsesinados=new JLabel();

		panelStats=new JPanel();
		panelStats.setLayout(new GridLayout(10,5));
		
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

		lArma=new JLabel("Arma: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lArma);
		panelStats.add(new JLabel(""));
		labelArma=new JLabel("Ninguna");
		imprimeObjetoAtaque();
		panelStats.add(labelArma);
		panelStats.add(new JLabel(""));

		lDefensa=new JLabel("Defensa: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lDefensa);
		panelStats.add(new JLabel(""));
		imprimeDefensa();
		panelStats.add(labelDefensa);
		panelStats.add(new JLabel(""));

		lEscudo=new JLabel("Escudo: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lEscudo);
		panelStats.add(new JLabel(""));
		labelEscudo=new JLabel("Ninguna");
		imprimeObjetoDefensa();
		panelStats.add(labelEscudo);
		panelStats.add(new JLabel(""));

		lObjetoEspecial=new JLabel("Objeto especial: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lObjetoEspecial);
		panelStats.add(new JLabel(""));
		labelObjetoEspecial=new JLabel("Ninguna");
		panelStats.add(labelObjetoEspecial);
		panelStats.add(new JLabel(""));

		lExperience=new JLabel("Dinero: ");
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

	public void initComponentsGameOver(){
		panelGameOver=new JPanel();
		panelGameOver.setLayout(new GridLayout(8,3));

		Font titulo = new Font("Serif", Font.BOLD, 24);
		Font newTitulo = titulo.deriveFont(30F);

		lGameOver=new JLabel("GAME OVER");
		lGameOver.setFont(newTitulo);
		
		buttonCargarJuego=new JButton("Cargar partida");
		buttonCargarJuego.addActionListener(new BotonCargarPartidaListener());	

		bMainPanel = new JButton("Pantalla principal");
		bMainPanel.addActionListener(new BotonPantallaInicialListener());

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(lGameOver);
		panelGameOver.add(new JLabel(""));

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(bMainPanel);
		panelGameOver.add(new JLabel(""));

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(buttonCargarJuego);
		panelGameOver.add(new JLabel(""));

		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));
		panelGameOver.add(new JLabel(""));

		add(panelGameOver);
	}

	public void crearMapa(){
		for(int i=0;i<mapa.getCasillas().length;i++){
			for(int j=0;j<mapa.getCasillas()[i].length;j++){
				mapa.getCasillas()[i][j]= new Casilla();
			}
		}
		mapa.getCasillas()[5][5].setAlumno(alumno);
		mapa.getCasillas()[enemigo.getX()][enemigo.getY()].setEnemigo(enemigo);
		mapa.getCasillas()[enemigo2.getX()][enemigo2.getY()].setEnemigo(enemigo2);
		mapa.getCasillas()[enemigo3.getX()][enemigo3.getY()].setEnemigo(enemigo3);
		mapa.getCasillas()[enemigo4.getX()][enemigo4.getY()].setEnemigo(enemigo4);
		mapa.getCasillas()[enemigo5.getX()][enemigo5.getY()].setEnemigo(enemigo5);
		mapa.getCasillas()[enemigo6.getX()][enemigo6.getY()].setEnemigo(enemigo6);
		mapa.getCasillas()[enemigo7.getX()][enemigo7.getY()].setEnemigo(enemigo7);
		mapa.getCasillas()[enemigo8.getX()][enemigo8.getY()].setEnemigo(enemigo8);
		mapa.getCasillas()[bloque.getX()][bloque.getY()].setBloque(bloque);
		mapa.getCasillas()[tienda.getX()][tienda.getY()].setTienda(tienda);
		mapa.getCasillas()[parcial1.getX()][parcial1.getY()].setEnemigo(parcial1);

		/*for(int i=0; i<mapa.getCasillas().length;i++){
			mapa.getCasillas()[i][0].setBloque(bloque);
		}
		*/
	}

	public void pintarMapa(){
		String claseEnemigo = enemigo.getClass().getSimpleName();
		String claseParcial = parcial1.getClass().getSimpleName();
		panelMapa= new JPanel();
		panelMapa.setLayout(new GridLayout(mapa.getCasillas().length,mapa.getCasillas()[0].length));
		for(int i=0;i<mapa.getCasillas().length;i++){
			for(int j=0;j<mapa.getCasillas()[i].length;j++){
				if(mapa.getCasillas()[i][j].getAlumno()==null && mapa.getCasillas()[i][j].getEnemigo()==null && mapa.getCasillas()[i][j].getBloque()==null && mapa.getCasillas()[i][j].getTienda()==null){
					panelMapa.add(new JLabel("*"));
				}
				if(mapa.getCasillas()[i][j].getAlumno()!=null){
					String nombreJugadorStr = nombreJugador.getText();
					alumno.setNombre(nombreJugadorStr);
					panelMapa.add(new JLabel(alumno.getNombre()));
				}
				if(mapa.getCasillas()[i][j].getEnemigo()!=null){
					if(mapa.getCasillas()[i][j].getEnemigo() == enemigo || mapa.getCasillas()[i][j].getEnemigo() == enemigo2 || mapa.getCasillas()[i][j].getEnemigo() == enemigo3 || mapa.getCasillas()[i][j].getEnemigo() == enemigo4 || mapa.getCasillas()[i][j].getEnemigo() == enemigo5 || mapa.getCasillas()[i][j].getEnemigo() == enemigo6 || mapa.getCasillas()[i][j].getEnemigo() == enemigo7 || mapa.getCasillas()[i][j].getEnemigo() == enemigo8){
						panelMapa.add(new JLabel(claseEnemigo));
					}
					if(mapa.getCasillas()[i][j].getEnemigo() == parcial1){
						panelMapa.add(new JLabel(claseParcial));
					}
				}
				if(mapa.getCasillas()[i][j].getBloque()!=null){
					panelMapa.add(new JLabel("Blo"));
				}
				if(mapa.getCasillas()[i][j].getTienda()!=null){
					panelMapa.add(new JLabel("Tienda"));
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
			initComponentsPantallaSeleccion();
			revalidate();
			repaint();
		}
	}

	public class BotonArribaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getX()>=1){
				mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(null);
				alumno.setX(alumno.getX()-1);
				if(alumno.getY() == bloque.getY() && alumno.getX() == bloque.getX()){
					alumno.setX(alumno.getX()+1);
				}else{
					mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
					checarCasilla();
				}
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
				if(alumno.getY() == bloque.getY() && alumno.getX() == bloque.getX()){
					alumno.setY(alumno.getY()+1);
				}else{
					mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
					checarCasilla();
				}
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
				if(alumno.getY() == bloque.getY() && alumno.getX() == bloque.getX()){
					alumno.setX(alumno.getX()-1);
				}else{
					mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
					checarCasilla();
				}
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
				if(alumno.getY() == bloque.getY() && alumno.getX() == bloque.getX()){
					alumno.setY(alumno.getY()-1);
				}else{
					mapa.getCasillas()[alumno.getX()][alumno.getY()].setAlumno(alumno);
					checarCasilla();
				}
			}
			/*else{
				System.out.println("Ya no se puede ir mas para la derecha");
			}*/
		}
	}

	public class BotonInventarioListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			panelContenedorBotonesEInventario.remove(panelBotones);
			panelContenedorBotonesEInventario.add(panelInventario);

			if(enseniarInventario == 0){
				contarHistoriaPrincipal();
				historiaPrincipal.setText(historiaPrincipal.getText() + "\nEste es tu inventario\n");
				historiaPrincipal.setText(historiaPrincipal.getText() + "\nEl inventario esta organizado para que tengas todos los ITEMS que compres de la tienda en orden\n");
				historiaPrincipal.setText(historiaPrincipal.getText() + "\nEn la primera linea del inventario se encuentran las armas, las cuales te daran más puntos de ataque de los que ya tienes\nCada arma te dara una cantidad diferente de puntos");
				historiaPrincipal.setText(historiaPrincipal.getText() + "\nEn la segunda linea del inventario se encuentran los escudos, las cuales te daran más puntos de defensa de los que ya tienes\nCada escudo te dara una cantidad diferente de puntos");
				historiaPrincipal.setText(historiaPrincipal.getText() + "\nEn la tercera linea del inventario se encuentran los objetos especiales. Estos objetos cambian dependiendo el tipo de alumno que seas \nEstos objetos pueden darte puntos de defensa de ataque y de promedio\n");
				historiaPrincipal.setText(historiaPrincipal.getText() + "\nPor ultimo se encuentra el boton regresar el cual te permitira regresar a los botones de movimiento\n");
				enseniarInventario = enseniarInventario + 1;
			}

			revalidate();
			repaint();
		}
	}

	public class BotonRegresarListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			panelContenedorBotonesEInventario.remove(panelInventario);
			panelContenedorBotonesEInventario.add(panelBotones);
			revalidate();
			repaint();
		}
	}

	public void imprimeObjetoDefensa(){
		String escudo=labelEscudo.getText();
		labelEscudo.setText(escudo);
	}

	public void imprimeObjetoAtaque(){
		String arma=labelArma.getText();
		labelArma.setText(arma);
	}

	public class BotonCuadernoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(cuaderno.getNumeroDeItems() >= 1){
				labelEscudo.setText("Cuaderno");
				int defensaTotal = (alumno.getDefensa() + cuaderno.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(cuaderno.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				cuaderno.setNumeroDeItems(cuaderno.getNumeroDeItems()-1);
				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonCarpetaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(carpeta.getNumeroDeItems()>=1){
				labelEscudo.setText("Carpeta");
				int defensaTotal = (alumno.getDefensa() + carpeta.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(carpeta.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				carpeta.setNumeroDeItems(carpeta.getNumeroDeItems()-1);
				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonLoncheraListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(lonchera.getNumeroDeItems()>=1){
				labelEscudo.setText("Lonchera");
				int defensaTotal = (alumno.getDefensa() + lonchera.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(lonchera.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				lonchera.setNumeroDeItems(lonchera.getNumeroDeItems()-1);
				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonMochilaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(mochila.getNumeroDeItems()>=1){
				labelEscudo.setText("Mochila");
				int defensaTotal = (alumno.getDefensa() + mochila.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(mochila.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				mochila.setNumeroDeItems(mochila.getNumeroDeItems()-1);
				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	/*Listener objetos especiales del invnetario*/

	public class BotonVeladoraListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(veladora.getNumeroDeItems()>=1){
				labelObjetoEspecial.setText("Veladora");
				int defensaTotal = (alumno.getDefensa() + veladora.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(veladora.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				veladora.setNumeroDeItems(veladora.getNumeroDeItems()-1);

				String ataqueStr = String.valueOf(alumno.getAtaque());
				String ataqueArmaStr = String.valueOf(veladora.getAtaque());
				
				ataqueTotalInicial=(alumno.getAtaque()+veladora.getAtaque());
				String ataqueTotalStri= String.valueOf(ataqueTotalInicial);
				alumno.setAtaque(ataqueTotalInicial);
				labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);

				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonAmigoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(amigo.getNumeroDeItems()>=1){
				labelObjetoEspecial.setText("LLamar amigo");
				int defensaTotal = (alumno.getDefensa() + amigo.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(amigo.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				amigo.setNumeroDeItems(amigo.getNumeroDeItems()-1);

				String ataqueStr = String.valueOf(alumno.getAtaque());
				String ataqueArmaStr = String.valueOf(amigo.getAtaque());
				ataqueTotalInicial=(alumno.getAtaque()+amigo.getAtaque());
				String ataqueTotalStri= String.valueOf(ataqueTotalInicial);
				alumno.setAtaque(ataqueTotalInicial);
				labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);

				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonCafeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(cafe.getNumeroDeItems()>=1){
				labelObjetoEspecial.setText("CAFEE!!!!!!!");
				int defensaTotal = (alumno.getDefensa() + cafe.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(cafe.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				cafe.setNumeroDeItems(cafe.getNumeroDeItems()-1);

				String ataqueStr = String.valueOf(alumno.getAtaque());
				String ataqueArmaStr = String.valueOf(cafe.getAtaque());
				ataqueTotalInicial=(alumno.getAtaque()+cafe.getAtaque());
				String ataqueTotalStri= String.valueOf(ataqueTotalInicial);
				alumno.setAtaque(ataqueTotalInicial);
				labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);

				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonTrabajoExtraListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(trabajoExtra.getNumeroDeItems()>=1){
				labelObjetoEspecial.setText("Trabajo Extra");
				int defensaTotal = (alumno.getDefensa() + trabajoExtra.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(trabajoExtra.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);

				int promedioTotal = (alumno.getPromedio() + trabajoExtra.getPromedio());
				String promedioStr= String.valueOf(alumno.getPromedio());
				if(promedioTotal > 100){
					alumno.setPromedio(100);
				}else{
					alumno.setPromedio(promedioTotal);
				}
				String promedioObjetoEspecialStr = String.valueOf(trabajoExtra.getPromedio());
				String promedioTotalStr = String.valueOf(alumno.getPromedio());
				labelPromedio.setText(promedioStr+" + "+ promedioObjetoEspecialStr + " = " + promedioTotalStr);
				trabajoExtra.setNumeroDeItems(trabajoExtra.getNumeroDeItems()-1);

				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonAcordeonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(acordeon.getNumeroDeItems()>=1){
				labelObjetoEspecial.setText("Acordeon");
				int defensaTotal = (alumno.getDefensa() + acordeon.getDefensa());
				String defensaStr = String.valueOf(alumno.getDefensa());
				alumno.setDefensa(defensaTotal);
				String defensaEscudoStr = String.valueOf(acordeon.getDefensa());
				String defensaTotalStri = String.valueOf(defensaTotal);
				labelDefensa.setText(defensaStr+" + "+ defensaEscudoStr + " = " + defensaTotalStri);
				acordeon.setNumeroDeItems(acordeon.getNumeroDeItems()-1);

				String ataqueStr = String.valueOf(alumno.getAtaque());
				String ataqueArmaStr = String.valueOf(acordeon.getAtaque());
				ataqueTotalInicial=(alumno.getAtaque()+acordeon.getAtaque());
				String ataqueTotalStri= String.valueOf(ataqueTotalInicial);
				alumno.setAtaque(ataqueTotalInicial);
				labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);

				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonTrabajoCompradoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(trabajoComprado.getNumeroDeItems()>=1){
				labelObjetoEspecial.setText("Trabajo Comprado");
				int promedioTotal = (alumno.getPromedio() + trabajoComprado.getPromedio());
				String promedioStr= String.valueOf(alumno.getPromedio());
				if(promedioTotal > 100){
					alumno.setPromedio(100);
				}else{
					alumno.setPromedio(promedioTotal);
				}
				String promedioObjetoEspecialStr = String.valueOf(trabajoComprado.getPromedio());
				String promedioTotalStr = String.valueOf(alumno.getPromedio());
				labelPromedio.setText(promedioStr+" + "+ promedioObjetoEspecialStr + " = " + promedioTotalStr);
				trabajoComprado.setNumeroDeItems(trabajoComprado.getNumeroDeItems()-1);

				if(NumeorDePantalla == 0){
					panelContenedorBotonesEInventario.remove(panelInventario);
					ImprimirInventario();
					panelContenedorBotonesEInventario.add(panelInventario);
					revalidate();
					repaint();
				}
				if(NumeorDePantalla == 1){
					panelContenedorInventario.remove(panelInventario);
					ImprimirInventario();
					panelInventario.remove(botonRegresar);
					panelContenedorInventario.add(panelInventario);
					revalidate();
					repaint();

				}
			}
		}
	}

	public class BotonLapizListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			labelArma.setText("Lapiz");
			alumno.setAtaque(ataqueTotalInicial);
			int ataqueTotal = (alumno.getAtaque() + lapiz.getAtaque());
			String ataqueStr = String.valueOf(alumno.getAtaque());
			alumno.setAtaque(ataqueTotal);
			String ataqueArmaStr = String.valueOf(lapiz.getAtaque());
			String ataqueTotalStri = String.valueOf(ataqueTotal);
			labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);
		}
	}

	public class BotonPlumaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			labelArma.setText("Pluma");
			alumno.setAtaque(ataqueTotalInicial);
			int ataqueTotal = (alumno.getAtaque() + pluma.getAtaque());
			String ataqueStr = String.valueOf(alumno.getAtaque());
			alumno.setAtaque(ataqueTotal);
			String ataqueArmaStr = String.valueOf(pluma.getAtaque());
			String ataqueTotalStri = String.valueOf(ataqueTotal);
			labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);
		}
	}

	public class BotonPlumaFuenteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			labelArma.setText("Pluma fuente");
			alumno.setAtaque(ataqueTotalInicial);
			int ataqueTotal = (alumno.getAtaque() + plumaFuente.getAtaque());
			String ataqueStr = String.valueOf(alumno.getAtaque());
			alumno.setAtaque(ataqueTotal);
			String ataqueArmaStr = String.valueOf(plumaFuente.getAtaque());
			String ataqueTotalStri = String.valueOf(ataqueTotal);
			labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);
		}
	}

	public class BotonPlumonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			labelArma.setText("Plumon");
			alumno.setAtaque(ataqueTotalInicial);
			int ataqueTotal = (alumno.getAtaque() + plumon.getAtaque());
			String ataqueStr = String.valueOf(alumno.getAtaque());
			alumno.setAtaque(ataqueTotal);
			String ataqueArmaStr = String.valueOf(plumon.getAtaque());
			String ataqueTotalStri = String.valueOf(ataqueTotal);
			labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);
		}
	}

	public class BotonReglaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			labelArma.setText("Regla");
			alumno.setAtaque(ataqueTotalInicial);
			int ataqueTotal = (alumno.getAtaque() + regla.getAtaque());
			String ataqueStr = String.valueOf(alumno.getAtaque());
			alumno.setAtaque(ataqueTotal);
			String ataqueArmaStr = String.valueOf(regla.getAtaque());
			String ataqueTotalStri = String.valueOf(ataqueTotal);
			labelAtaque.setText(ataqueStr+" + "+ ataqueArmaStr + " = " + ataqueTotalStri);
		}
	}


	public void checarCasilla(){
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo()==null && mapa.getCasillas()[alumno.getX()][alumno.getY()].getTienda()==null){
			panelContenedorMapa.remove(panelMapa);
			panelContenedorMapa.revalidate();
			panelContenedorMapa.repaint();
			pintarMapa();
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			if(alumno.getNumeroDeMobsAsesinados() >= 6){
				remove(panelNivel1);
				initComponentsPelea();
				imprimirSucesosPelea();
				revalidate();
				repaint();
			}else{
				historiaPrincipal.setText(historiaPrincipal.getText() +"\nTodavia tienes tareas que terminar antes de enfrentarte al parcial\n");
			}
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo()!=null && mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo()!=parcial1){
			remove(panelNivel1);
			initComponentsPelea();
			imprimirSucesosPelea();
			revalidate();
			repaint();
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getTienda()!=null){
			remove(panelNivel1);
			initComponentsTienda();
			revalidate();
			repaint();
		}
	}

	public void imprimeNombre(){
		String claseJugador= alumno.getClass().getSimpleName();
		labelNombre.setText(alumno.getNombre() + " (" + claseJugador + ")");
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
		labelNombre= new JLabel();
		labelPromedio= new JLabel();
		labelAtaque= new JLabel();
		labelDefensa= new JLabel();
		labelXP= new JLabel();
		labelNumeroDeMobsAsesinados=new JLabel();

		panelStats=new JPanel();
		panelStats.setLayout(new GridLayout(10,5));
		
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

		lArma=new JLabel("Arma: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lArma);
		panelStats.add(new JLabel(""));
		labelArma=new JLabel("Ninguna");
		panelStats.add(labelArma);
		panelStats.add(new JLabel(""));

		lDefensa=new JLabel("Defensa: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lDefensa);
		panelStats.add(new JLabel(""));
		imprimeDefensa();
		panelStats.add(labelDefensa);
		panelStats.add(new JLabel(""));

		lEscudo=new JLabel("Escudo: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lEscudo);
		panelStats.add(new JLabel(""));
		labelEscudo=new JLabel("Ninguna");
		panelStats.add(labelEscudo);
		panelStats.add(new JLabel(""));

		lObjetoEspecial=new JLabel("Objeto especial: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lObjetoEspecial);
		panelStats.add(new JLabel(""));
		labelObjetoEspecial=new JLabel("Ninguna");
		panelStats.add(labelObjetoEspecial);
		panelStats.add(new JLabel(""));

		lExperience=new JLabel("Dinero: ");
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
	}

	public void imprimirStatsEnemigo(){
		pEnemigoStats.setLayout(new GridLayout(5,5));

		lPromedioEnemigo= new JLabel();
		lAtaqueEnemigo=new JLabel();
		lDefensaEnemigo=new JLabel();

		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
			String claseEnemigo = enemigo.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
			String claseEnemigo = enemigo2.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
			String claseEnemigo = enemigo3.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
			String claseEnemigo = enemigo4.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
			String claseEnemigo = enemigo5.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
			String claseEnemigo = enemigo6.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
			String claseEnemigo = enemigo7.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
			String claseEnemigo = enemigo8.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			String claseEnemigo = parcial1.getClass().getSimpleName();
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(claseEnemigo));
			pEnemigoStats.add(new JLabel(""));
			pEnemigoStats.add(new JLabel(""));
		}


		pEnemigoStats.add(new JLabel(""));
		labelPromedioEnemigo= new JLabel("Promedio Enemigo: ");
		pEnemigoStats.add(labelPromedioEnemigo);
		imprimePromedioEnemigo();
		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(lPromedioEnemigo);
		pEnemigoStats.add(new JLabel(""));

		pEnemigoStats.add(new JLabel(""));
		labelAtaqueEnemigo=new JLabel("Ataque Enemigo: ");
		pEnemigoStats.add(labelAtaqueEnemigo);
		imprimeAtaqueEnemigo();
		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(lAtaqueEnemigo);
		pEnemigoStats.add(new JLabel(""));

		pEnemigoStats.add(new JLabel(""));
		labelDefensaEnemigo=new JLabel("Defensa Enemigo: ");
		pEnemigoStats.add(labelDefensaEnemigo);
		imprimeDefensaEnemigo();
		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(lDefensaEnemigo);
		pEnemigoStats.add(new JLabel(""));

		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(new JLabel(""));
		pEnemigoStats.add(new JLabel(""));
	}

	public void imprimePromedioEnemigo(){
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
			String promedioEnemigoStr = String.valueOf(enemigo.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
			String promedioEnemigoStr = String.valueOf(enemigo2.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
			String promedioEnemigoStr = String.valueOf(enemigo3.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
			String promedioEnemigoStr = String.valueOf(enemigo4.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
			String promedioEnemigoStr = String.valueOf(enemigo5.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
			String promedioEnemigoStr = String.valueOf(enemigo6.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
			String promedioEnemigoStr = String.valueOf(enemigo7.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
			String promedioEnemigoStr = String.valueOf(enemigo8.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			String promedioEnemigoStr = String.valueOf(parcial1.getPromedio());
			lPromedioEnemigo.setText(promedioEnemigoStr);
		}
	}

	public void imprimeAtaqueEnemigo(){
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
			String ataqueEnemigoStr = String.valueOf(enemigo.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
			String ataqueEnemigoStr = String.valueOf(enemigo2.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
			String ataqueEnemigoStr = String.valueOf(enemigo3.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
			String ataqueEnemigoStr = String.valueOf(enemigo4.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
			String ataqueEnemigoStr = String.valueOf(enemigo5.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
			String ataqueEnemigoStr = String.valueOf(enemigo6.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
			String ataqueEnemigoStr = String.valueOf(enemigo7.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
			String ataqueEnemigoStr = String.valueOf(enemigo8.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			String ataqueEnemigoStr = String.valueOf(parcial1.getAtaque());
			lAtaqueEnemigo.setText(ataqueEnemigoStr);
		}
	}

	public void imprimeDefensaEnemigo(){
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
			String defensaEnemigoStr = String.valueOf(enemigo.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
			String defensaEnemigoStr = String.valueOf(enemigo2.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
			String defensaEnemigoStr = String.valueOf(enemigo3.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
			String defensaEnemigoStr = String.valueOf(enemigo4.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
			String defensaEnemigoStr = String.valueOf(enemigo5.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
			String defensaEnemigoStr = String.valueOf(enemigo6.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
			String defensaEnemigoStr = String.valueOf(enemigo7.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
			String defensaEnemigoStr = String.valueOf(enemigo8.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			String defensaEnemigoStr = String.valueOf(parcial1.getDefensa());
			lDefensaEnemigo.setText(defensaEnemigoStr);
		}
	}

	public class BotonAtacarListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			/*String claseEnemigo = enemigo.getClass().getSimpleName();
			String claseParcial = parcial1.getClass().getSimpleName();*/
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
				alumno.atacar(enemigo);
				enemigo.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo.getDefensa()<0){
					enemigo.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo.getX()][enemigo.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
				alumno.atacar(enemigo2);
				enemigo2.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo2.getDefensa()<0){
					enemigo2.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo2.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo2.getX()][enemigo2.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
				alumno.atacar(enemigo3);
				enemigo3.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo3.getDefensa()<0){
					enemigo3.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo3.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo3.getX()][enemigo3.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
				alumno.atacar(enemigo4);
				enemigo4.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo4.getDefensa()<0){
					enemigo4.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo4.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo4.getX()][enemigo4.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
				alumno.atacar(enemigo5);
				enemigo5.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo5.getDefensa()<0){
					enemigo5.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo5.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo5.getX()][enemigo5.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
				alumno.atacar(enemigo6);
				enemigo6.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo6.getDefensa()<0){
					enemigo6.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo6.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo6.getX()][enemigo6.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
				alumno.atacar(enemigo7);
				enemigo7.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo7.getDefensa()<0){
					enemigo7.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo7.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo7.getX()][enemigo7.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
				alumno.atacar(enemigo8);
				enemigo8.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(enemigo8.getDefensa()<0){
					enemigo8.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(enemigo8.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[enemigo8.getX()][enemigo8.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+1);
					alumno.setXP(alumno.getXP()+10);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
				alumno.atacar(parcial1);
				parcial1.atacar(alumno);
				imprimirAccionesPelea();
				if(alumno.getDefensa()<0){
					alumno.setDefensa(0);
				}
				if(parcial1.getDefensa()<0){
					parcial1.setDefensa(0);
				}
				/*imprimir stats alumno*/
				imprimePromedio();
				imprimeDefensa();
				/*imprimir stats enemigo*/
				imprimePromedioEnemigo();
				imprimeDefensaEnemigo();

				if(alumno.getPromedio()<=0){
					remove(panelPelea);
					initComponentsGameOver();
					revalidate();
					repaint();
				}
				if(parcial1.getPromedio()<=0){
					historiaPrincipal.setText("");
					mapa.getCasillas()[parcial1.getX()][parcial1.getY()].setEnemigo(null);
					remove(panelPelea);
					alumno.setNumeroDeMobsAsesinados(alumno.getNumeroDeMobsAsesinados()+8);
					alumno.setXP(alumno.getXP()+1);
					initComponentsPantallaPrincipal();
					revalidate();
					repaint();
				}
			}
			
		}
	}

	public void ImprimirInventario(){
		panelInventario=new JPanel();
		panelInventario.setLayout(new GridLayout(8, 5));

		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		labelInventario= new JLabel("Inventario");
		panelInventario.add(labelInventario);
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));

		labelObjetosArmas= new JLabel("Armas");
		panelInventario.add(labelObjetosArmas);
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));

		if(lapiz.getNumeroDeItems() == 1){
			botonLapiz=new JButton("Lapiz");
			botonLapiz.addActionListener(new BotonLapizListener());
		}else{
			botonLapiz=new JButton("no item");
		}
		panelInventario.add(botonLapiz);
		if(pluma.getNumeroDeItems() == 1){
			botonPluma=new JButton("Pluma");
			botonPluma.addActionListener(new BotonPlumaListener());
		}else{
			botonPluma=new JButton("no item");
		}
		panelInventario.add(botonPluma);
		if(plumaFuente.getNumeroDeItems()==1){
			botonPlumaFuente=new JButton("Pluma Fuente");
			botonPlumaFuente.addActionListener(new BotonPlumaFuenteListener());
		}else{
			botonPlumaFuente=new JButton("no item");
		}
		panelInventario.add(botonPlumaFuente);
		if(plumon.getNumeroDeItems()==1){
			botonPlumon=new JButton("plumon");
			botonPlumon.addActionListener(new BotonPlumonListener());
		}else{
			botonPlumon=new JButton("no item");
		}
		panelInventario.add(botonPlumon);
		if(regla.getNumeroDeItems()==1){
			botonRegla=new JButton("Regla");
			botonRegla.addActionListener(new BotonReglaListener());
		}else{
			botonRegla=new JButton("no item");
		}
		panelInventario.add(botonRegla);

		labelObjetosDefensa=new  JLabel("Escudos");
		panelInventario.add(labelObjetosDefensa);
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));

		if(cuaderno.getNumeroDeItems()>=1){
			String cuadernoStr = String.valueOf(cuaderno.getNumeroDeItems());
			botonCuaderno=new JButton("cuaderno" + " * " + cuadernoStr);
			botonCuaderno.addActionListener(new BotonCuadernoListener());
		}else{
			botonCuaderno=new JButton("no item");
		}
		panelInventario.add(botonCuaderno);
		if(carpeta.getNumeroDeItems()>=1){
			String carpetaStr = String.valueOf(carpeta.getNumeroDeItems());
			botonCarpeta=new JButton("carpeta" + " * " + carpetaStr);
			botonCarpeta.addActionListener(new BotonCarpetaListener());
		}else{
			botonCarpeta=new JButton("no item");
		}
		panelInventario.add(botonCarpeta);
		if(lonchera.getNumeroDeItems() >= 1){
			String loncheraStr = String.valueOf(lonchera.getNumeroDeItems());
			botonLonchera=new JButton("lonchera" + " * " + loncheraStr);
			botonLonchera.addActionListener(new BotonLoncheraListener());
		}else{
			botonLonchera=new JButton("no item");
		}
		panelInventario.add(botonLonchera);
		if(mochila.getNumeroDeItems() >= 1){
			String mochilaStr = String.valueOf(mochila.getNumeroDeItems());
			botonMochila=new JButton("Mochila" + " * " + mochilaStr);
			botonMochila.addActionListener(new BotonMochilaListener());
		}else{
			botonMochila=new JButton("no item");
		}
		panelInventario.add(botonMochila);
		panelInventario.add(new JLabel(""));

		labelObjetosEspeciales=new JLabel("Especiales");
		panelInventario.add(labelObjetosEspeciales);
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));

		String claseJugador= alumno.getClass().getSimpleName();

		panelInventario.add(new JLabel(""));

		if(claseJugador=="Normal"){
			if(veladora.getNumeroDeItems() >= 1){
				String veladoraStr =String.valueOf(veladora.getNumeroDeItems());
				botonVeladora=new JButton("Veladoras" + " * " + veladoraStr);
				botonVeladora.addActionListener(new BotonVeladoraListener());
			}else{
				botonVeladora=new JButton("no item");
			}
			panelInventario.add(botonVeladora);

			panelInventario.add(new JLabel(""));

			if(amigo.getNumeroDeItems() >= 1){
				String amigoStr=String.valueOf(amigo.getNumeroDeItems());
				botonAmigo=new JButton("LLamar a un cuate" + " * " + amigoStr);
				botonAmigo.addActionListener(new BotonAmigoListener());
			}else{
				botonAmigo=new JButton("no item");
			}
			panelInventario.add(botonAmigo);
		}
		if(claseJugador=="Aplicado"){
			if(cafe.getNumeroDeItems() >= 1){
				String cafeStr =String.valueOf(cafe.getNumeroDeItems());
				botonCafe=new JButton("CAFE!!!!!!!!!" + " * " + cafeStr);
				botonCafe.addActionListener(new BotonCafeListener());
			}else{
				botonCafe=new JButton("no item");
			}
			panelInventario.add(botonCafe);

			panelInventario.add(new JLabel(""));

			if(trabajoExtra.getNumeroDeItems() >= 1){
				String trabajoExtraStr=String.valueOf(trabajoExtra.getNumeroDeItems());
				botonTrabajoExtra=new JButton("Trabajo Extra" + " * " + trabajoExtraStr);
				botonTrabajoExtra.addActionListener(new BotonTrabajoExtraListener());
			}else{
				botonTrabajoExtra=new JButton("no item");
			}
			panelInventario.add(botonTrabajoExtra);
		}
		if(claseJugador=="Cheater"){
			if(acordeon.getNumeroDeItems() >= 1){
				String acordeonStr =String.valueOf(acordeon.getNumeroDeItems());
				botonAcordeon=new JButton("Acordeon jiji" + " * " + acordeonStr);
				botonAcordeon.addActionListener(new BotonAcordeonListener());
			}else{
				botonAcordeon=new JButton("no item");
			}
			panelInventario.add(botonAcordeon);

			panelInventario.add(new JLabel(""));

			if(trabajoComprado.getNumeroDeItems() >= 1){
				String trabajoCompradoStr=String.valueOf(trabajoComprado.getNumeroDeItems());
				botonTrabajoComprado=new JButton("Trabajo comprado" + " * " + trabajoCompradoStr);
				botonTrabajoComprado.addActionListener(new BotonTrabajoCompradoListener());
			}else{
				botonTrabajoComprado=new JButton("no item");
			}
			panelInventario.add(botonTrabajoComprado);
		}

		panelInventario.add(new JLabel(""));

		botonGuardarPartida= new JButton("Gurdar Partida");
		botonGuardarPartida.addActionListener(new BotonGuardarListener());
		panelInventario.add(botonGuardarPartida);
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		panelInventario.add(new JLabel(""));
		botonRegresar=new JButton("Regresar");
		botonRegresar.addActionListener(new BotonRegresarListener());
		panelInventario.add(botonRegresar);
	}

	public class BotonTiendaEspecialUnoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String claseJugador= alumno.getClass().getSimpleName();
			if(claseJugador == "Normal"){
				if(alumno.getXP() < veladora.getPrecio()){
					historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + veladora.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
				}else{
					historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una veladora de la virgencita\nEste item te otorga el poder divino subiendote tu poder de ataque y defensa\n");
					historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + veladora.getPrecio() + " = ");
					alumno.setXP(alumno.getXP() - veladora.getPrecio());
					historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

					veladora.setNumeroDeItems(veladora.getNumeroDeItems()+1);
					panelContenedorInventario.remove(panelInventario);
					panelContenedorStatsJugador.remove(panelStats);
					imprimirStatsJugador();
					panelContenedorStatsJugador.add(panelStats);
					ImprimirInventario();
					panelContenedorInventario.add(panelInventario);
					panelInventario.remove(botonRegresar);
					revalidate();
					repaint();
				}
			}
			if(claseJugador == "Aplicado"){
				if(alumno.getXP() < cafe.getPrecio()){
					historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + cafe.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
				}else{
					historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado un CAFE!!!, este item te ayuda a mantenerte despierto y alerta para los examenes, otorgandote poder de defensa y de ataque\n");
					historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + cafe.getPrecio() + " = ");
					alumno.setXP(alumno.getXP() - cafe.getPrecio());
					historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

					cafe.setNumeroDeItems(cafe.getNumeroDeItems()+1);
					panelContenedorInventario.remove(panelInventario);
					panelContenedorStatsJugador.remove(panelStats);
					imprimirStatsJugador();
					panelContenedorStatsJugador.add(panelStats);
					ImprimirInventario();
					panelContenedorInventario.add(panelInventario);
					panelInventario.remove(botonRegresar);
					revalidate();
					repaint();
				}
			}
			if(claseJugador == "Cheater"){
				if(alumno.getXP() < acordeon.getPrecio()){
					historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + acordeon.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
				}else{
					historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado un acordeon, lo que te da más poder de ataque y defensa al momento de realizar tareas, proyectos o el examen final\n");
					historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + acordeon.getPrecio() + " = ");
					alumno.setXP(alumno.getXP() - acordeon.getPrecio());
					historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

					acordeon.setNumeroDeItems(acordeon.getNumeroDeItems()+1);
					panelContenedorInventario.remove(panelInventario);
					panelContenedorStatsJugador.remove(panelStats);
					imprimirStatsJugador();
					panelContenedorStatsJugador.add(panelStats);
					ImprimirInventario();
					panelContenedorInventario.add(panelInventario);
					panelInventario.remove(botonRegresar);
					revalidate();
					repaint();
				}
			}
		}
	}

	public class BotonTiendaEspecialDosListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String claseJugador= alumno.getClass().getSimpleName();
			if(claseJugador == "Normal"){
				if(alumno.getXP() < amigo.getPrecio()){
					historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + amigo.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
				}else{
					historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado el poder de llamar a un amigo para estudiar con el y subir tus puntos de ataque y defensa\n");
					historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + amigo.getPrecio() + " = ");
					alumno.setXP(alumno.getXP() - amigo.getPrecio());
					historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

					amigo.setNumeroDeItems(amigo.getNumeroDeItems()+1);
					panelContenedorInventario.remove(panelInventario);
					panelContenedorStatsJugador.remove(panelStats);
					imprimirStatsJugador();
					panelContenedorStatsJugador.add(panelStats);
					ImprimirInventario();
					panelContenedorInventario.add(panelInventario);
					panelInventario.remove(botonRegresar);
					revalidate();
					repaint();
				}
			}
			if(claseJugador == "Aplicado"){
				if(alumno.getXP() < trabajoExtra.getPrecio()){
					historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + trabajoExtra.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
				}else{
					historiaTienda.setText(historiaTienda.getText() + "\nLe haz rogado al profe suficiente para que te asignara un trabajo extra con lo que puedes subir tus puntos de promedio y puntos de defensa\n");
					historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + trabajoExtra.getPrecio() + " = ");
					alumno.setXP(alumno.getXP() - trabajoExtra.getPrecio());
					historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

					trabajoExtra.setNumeroDeItems(trabajoExtra.getNumeroDeItems()+1);
					panelContenedorInventario.remove(panelInventario);
					panelContenedorStatsJugador.remove(panelStats);
					imprimirStatsJugador();
					panelContenedorStatsJugador.add(panelStats);
					ImprimirInventario();
					panelContenedorInventario.add(panelInventario);
					panelInventario.remove(botonRegresar);
					revalidate();
					repaint();
				}
			}
			if(claseJugador == "Cheater"){
				if(alumno.getXP() < trabajoComprado.getPrecio()){
					historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + trabajoComprado.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
				}else{
					historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una tarea por internet, este objeto te puede subir tu promedio pero no aprendes nada\n");
					historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + trabajoComprado.getPrecio() + " = ");
					alumno.setXP(alumno.getXP() - trabajoComprado.getPrecio());
					historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

					trabajoComprado.setNumeroDeItems(trabajoComprado.getNumeroDeItems()+1);
					panelContenedorInventario.remove(panelInventario);
					panelContenedorStatsJugador.remove(panelStats);
					imprimirStatsJugador();
					panelContenedorStatsJugador.add(panelStats);
					ImprimirInventario();
					panelContenedorInventario.add(panelInventario);
					panelInventario.remove(botonRegresar);
					revalidate();
					repaint();
				}
			}
		}
	}

	public class BotonTiendaLapizListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(lapiz.getNumeroDeItems()!=0){
				historiaTienda.setText(historiaTienda.getText() + "\nYa haz comprado este ITEM, por lo que no puedes volverlo a comprar\n");
			}
			if(alumno.getXP() < lapiz.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + lapiz.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}
			if(lapiz.getNumeroDeItems()==0 && alumno.getXP() >= lapiz.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado un lapiz, este objeto te otorga " + lapiz.getAtaque() + " puntos de ataque, pero solo los puedes conseguir si te equipas el ITEM\n");
				lTiendaLapiz.setText("Comprado");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + lapiz.getPrecio() + " = ");
				alumno.setXP(alumno.getXP()-lapiz.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

				lapiz.setNumeroDeItems(1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaPlumaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(pluma.getNumeroDeItems()!=0){
				historiaTienda.setText(historiaTienda.getText() + "\nYa haz comprado este ITEM, por lo que no puedes volverlo a comprar\n");
			}
			if(alumno.getXP() < pluma.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + pluma.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}
			if(pluma.getNumeroDeItems()==0 && alumno.getXP() >= pluma.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una pluma, este objeto te otorga " + pluma.getAtaque() + " puntos de ataque, pero solo los puedes conseguir si te equipas el ITEM\n");
				lTiendaPluma.setText("Comprado");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + pluma.getPrecio() + " = ");
				alumno.setXP(alumno.getXP()-pluma.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

				pluma.setNumeroDeItems(1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaPlumaFuenteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(plumaFuente.getNumeroDeItems()!=0){
				historiaTienda.setText(historiaTienda.getText() + "\nYa haz comprado este ITEM, por lo que no puedes volverlo a comprar\n");
			}
			if(alumno.getXP() < plumaFuente.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + plumaFuente.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}
			if(plumaFuente.getNumeroDeItems()==0 && alumno.getXP() >= plumaFuente.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una plumaFuente, este objeto te otorga " + plumaFuente.getAtaque() + " puntos de ataque, pero solo los puedes conseguir si te equipas el ITEM\n");
				lTiendaPlumaFuente.setText("Comprado");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + plumaFuente.getPrecio() + " = ");
				alumno.setXP(alumno.getXP()-plumaFuente.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

				plumaFuente.setNumeroDeItems(1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaPlumonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(plumon.getNumeroDeItems()!=0){
				historiaTienda.setText(historiaTienda.getText() + "\nYa haz comprado este ITEM, por lo que no puedes volverlo a comprar\n");
			}
			if(alumno.getXP() < plumon.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + plumon.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}
			if(plumon.getNumeroDeItems()==0 && alumno.getXP() >= plumon.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado un plumon, este objeto te otorga " + plumon.getAtaque() + " puntos de ataque, pero solo los puedes conseguir si te equipas el ITEM\n");
				lTiendaPlumon.setText("Comprado");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + plumon.getPrecio() + " = ");
				alumno.setXP(alumno.getXP()-plumon.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

				plumon.setNumeroDeItems(1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BototnTiendaReglaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(regla.getNumeroDeItems()!=0){
				historiaTienda.setText(historiaTienda.getText() + "\nYa haz comprado este ITEM, por lo que no puedes volverlo a comprar\n");
			}
			if(alumno.getXP() < regla.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + regla.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}
			if(regla.getNumeroDeItems()==0 && alumno.getXP() >= regla.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una regla, este objeto te otorga " + regla.getAtaque() + " puntos de ataque, pero solo los puedes conseguir si te equipas el ITEM\n");
				lTiendaRegla.setText("Comprado");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + regla.getPrecio() + " = ");
				alumno.setXP(alumno.getXP()-regla.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");

				regla.setNumeroDeItems(1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaCuadernoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getXP() < cuaderno.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + cuaderno.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}else{
				/*lTiendaCuaderno.setText("comprado");*/
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado un cuaderno\n");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + cuaderno.getPrecio() + " = ");
				alumno.setXP(alumno.getXP() - cuaderno.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");
				cuaderno.setNumeroDeItems(cuaderno.getNumeroDeItems()+1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaCarpetaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getXP() < carpeta.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + carpeta.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}else{
				/*lTiendaCarpeta.setText("comprado");*/
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una carpeta\n");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + carpeta.getPrecio() + " = ");
				alumno.setXP(alumno.getXP() - carpeta.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");
				carpeta.setNumeroDeItems(carpeta.getNumeroDeItems()+1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaLoncheraListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getXP() < lonchera.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + lonchera.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}else{
				/*lTiendalonchera.setText("comprado");*/
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado una lonchera\n");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + lonchera.getPrecio() + " = ");
				alumno.setXP(alumno.getXP() - lonchera.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");
				lonchera.setNumeroDeItems(lonchera.getNumeroDeItems()+1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTiendaMochilaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alumno.getXP() < mochila.getPrecio()){
				historiaTienda.setText(historiaTienda.getText() + "\nLo sentimos, pero parece que no tienes dinero suficiente para comprar este articulo\n" + "Este articulo cuesta " + mochila.getPrecio() + " y tu tienes " + alumno.getXP() + " pesos\n");
			}else{
				/*lTiendamochila.setText("comprado");*/
				historiaTienda.setText(historiaTienda.getText() + "\nHaz comprado un mochila\n");
				historiaTienda.setText(historiaTienda.getText() + "dinero: " + alumno.getXP() + " - " + mochila.getPrecio() + " = ");
				alumno.setXP(alumno.getXP() - mochila.getPrecio());
				historiaTienda.setText(historiaTienda.getText() + alumno.getXP() + "\n");
				mochila.setNumeroDeItems(mochila.getNumeroDeItems()+1);
				panelContenedorInventario.remove(panelInventario);
				panelContenedorStatsJugador.remove(panelStats);
				imprimirStatsJugador();
				panelContenedorStatsJugador.add(panelStats);
				ImprimirInventario();
				panelContenedorInventario.add(panelInventario);
				panelInventario.remove(botonRegresar);
				revalidate();
				repaint();
			}
		}
	}

	public class BotonTerminarCompraListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(panelTienda);
			initComponentsPantallaPrincipal();
			revalidate();
			repaint();
		}
	}

	public void imprimirStatsJugador(){
		labelNombre= new JLabel();
		labelPromedio= new JLabel();
		labelAtaque= new JLabel();
		labelDefensa= new JLabel();
		labelXP= new JLabel();
		labelNumeroDeMobsAsesinados=new JLabel();

		panelStats=new JPanel();
		panelStats.setLayout(new GridLayout(10,5));
		
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

		lArma=new JLabel("Arma: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lArma);
		panelStats.add(new JLabel(""));
		labelArma=new JLabel("Ninguna");
		imprimeObjetoAtaque();
		panelStats.add(labelArma);
		panelStats.add(new JLabel(""));

		lDefensa=new JLabel("Defensa: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lDefensa);
		panelStats.add(new JLabel(""));
		imprimeDefensa();
		panelStats.add(labelDefensa);
		panelStats.add(new JLabel(""));

		lEscudo=new JLabel("Escudo: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lEscudo);
		panelStats.add(new JLabel(""));
		labelEscudo=new JLabel("Ninguna");
		imprimeObjetoDefensa();
		panelStats.add(labelEscudo);
		panelStats.add(new JLabel(""));

		lObjetoEspecial=new JLabel("Objeto especial: ");
		panelStats.add(new JLabel(""));
		panelStats.add(lObjetoEspecial);
		panelStats.add(new JLabel(""));
		labelObjetoEspecial=new JLabel("Ninguna");
		panelStats.add(labelObjetoEspecial);
		panelStats.add(new JLabel(""));

		lExperience=new JLabel("Dinero: ");
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
	}

	public class BotonGuardarListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			/*Hero, mapa inventario*/
			partida.setMapa(mapa);
			partida.setAlumno(alumno);
			try{
				JOptionPane pane= new JOptionPane();
				String fileName=pane.showInputDialog("¿Cuál es el nombre del archivo?");
				FileOutputStream fout = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(partida);
				oos.close();
			}catch(FileNotFoundException ex){
				ex.printStackTrace();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}

	public class BotonCargarPartidaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fileChooser= new JFileChooser();
			fileChooser.showOpenDialog(null);
			try{
				File archivoSeleccionado = fileChooser.getSelectedFile();
				FileInputStream fin =new FileInputStream(archivoSeleccionado);
				ObjectInputStream ois=new ObjectInputStream(fin);
				partida=(Partida)ois.readObject();
				remove(panelPrincipal);
				remove(panelGameOver);
				initComponentsPantallaPrincipal();
				revalidate();
				repaint();
			}catch(FileNotFoundException ex){
				System.out.println("no se encuentan los archivos");
			}catch(IOException ex){
				ex.printStackTrace();
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}
		}
	}

	public class BotonClaseNormalistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String nombreJugadorStr = nombreJugador.getText();
			if(nombreJugadorStr.length()>=1 && nombreJugadorStr.length()<7){
				/*nombre, x, y, promedio, ataque, defensa, xP, numero de mobs asesinados*/
				alumno=new Normal(nombreJugadorStr, 5, 5, 100, 10, 20, 200, 0);
				remove(panelContenedorComponentesPantallaSeleccion);
				initComponentsPantallaPrincipal();
				revalidate();
				repaint();
			}else{
				lIndicacionNombre.setText("Su nombre es muy largo o nulo");
			}
		}
	}

	public class BotonClaseAplicadoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String nombreJugadorStr = nombreJugador.getText();
			if(nombreJugadorStr.length()>=1 && nombreJugadorStr.length()<7){
				/*nombre, x, y, promedio, ataque, defensa, xP, numero de mobs asesinados*/
				alumno=new Aplicado(nombreJugadorStr, 5, 5, 100, 10, 20, 200, 0);
				remove(panelContenedorComponentesPantallaSeleccion);
				initComponentsPantallaPrincipal();
				revalidate();
				repaint();
			}else{
				lIndicacionNombre.setText("Su nombre es muy largo o nulo");
			}
		}
	}

	public class BotonClaseCheaterListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String nombreJugadorStr = nombreJugador.getText();
			if(nombreJugadorStr.length()>=1 && nombreJugadorStr.length()<7){
				/*nombre, x, y, promedio, ataque, defensa, xP, numero de mobs asesinados*/
				alumno=new Cheater(nombreJugadorStr, 5, 5, 100, 10, 20, 200, 0);
				remove(panelContenedorComponentesPantallaSeleccion);
				initComponentsPantallaPrincipal();
				revalidate();
				repaint();
			}else{
				lIndicacionNombre.setText("Su nombre es muy largo o nulo");
			}
		}
	}

	public void contarHistoriaPrincipal(){
		String claseJugador= alumno.getClass().getSimpleName();
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nYo sere tu guia en esta travesia y te estare ayudando a lo largo del semestre(juego)\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nVeo que eres un alumno " + claseJugador + " por lo que tu objetivo es acabar este semestre con un promedio igual o mayor a ");
		if(claseJugador == "Normal"){
			historiaPrincipal.setText(historiaPrincipal.getText() + "80\n");
		}
		if(claseJugador == "Cheater"){
			historiaPrincipal.setText(historiaPrincipal.getText() + "70(un promedio mediocre)\n");
		}
		if(claseJugador == "Aplicado"){
			historiaPrincipal.setText(historiaPrincipal.getText() + "90\n");	
		}
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nSi tu promedio no cumple con este requisito, no podras pasar el juego\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nBueno, deberas de estar pensando '¿Donde estoy?'. Este lugar es donde se desarrollara todo el semestre\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "Este lugar, el cual llamaremos pantalla principal esta dividida en 4 sectores\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "El primer sector es el mapa, en el cual te podras mover he interactuar con los objetos que aparecen en el\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "el segundo sector es por donde te estoy hablando, en este sector te podre dar consejos he informacion acerca del juego\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "el tercer sector es el area de botones los cuales te ayudaran para moverte por el mapa y poder interactuar con el entorno que te rodea\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "el ultimo sector son tus Stats, los cuales se iran modificando conforme avance el juego\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nOtro punto importante: \n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "En el semestre hay objetos que te ayudaran a hacer de este semestre una tarea mas facil\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nEstos objetos los podras comprar de la tienda y los podras equipar desde tu inventario\n");
		historiaPrincipal.setText(historiaPrincipal.getText() + "\nPara abir el inventario pica al boton grande que dice inventario, el cual se encuentra ubicado en la parte inferior Izquierda de tu pantalla\n");
	}

	public void imprimirSucesosPelea(){
		contarHistoriaPrincipal();
		
		/*String claseEnemigo = enemigo.getClass().getSimpleName();
		String claseParcial = parcial1.getClass().getSimpleName();*/
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
			String claseEnemigo = enemigo.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
			String claseEnemigo = enemigo2.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
			String claseEnemigo = enemigo3.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
			String claseEnemigo = enemigo4.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
			String claseEnemigo = enemigo5.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
			String claseEnemigo = enemigo6.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
			String claseEnemigo = enemigo7.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
			String claseEnemigo = enemigo8.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			String claseEnemigo = parcial1.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n\n\n " + " ------------------------Pelea----------------------"+ "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "¡Oh no!, el profesor a dejado una " + claseEnemigo + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nParece que no tenemos escapatoria mas que pelear\n");
		}

		if(mostrarPelea == 0){
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nComo esta es tu primera vez haciendo una tarea te enseniare a como resolverla para que te quite el menor promedio posible\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\nEn esta nueva pantalla tenemos diferentes secciones en la que se despliegan diferentes cosas\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "La primera seccion se encuentra ubicada en la parte superior Izquierda de tu pantalla, en esta seccion se muestran tus stats\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "La segunda seccion se encuentra ubicada en la parte superior derecha de tu pantalla, en esta seccion se muestran los stats del enemigo (tarea, proyecto o final)\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "La tercera seccion se encuentra ubicada en la parte inferior Izquierda de tu pantalla, en esta seccion se encuentran los botones atacar e inventario\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "     La funcionalidad del boton pelea que se encuentra en la tercera seccion es la de inciar el enfrentamiento entre tu y la tarea\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "     Cada vez que le piques a ese boton la tarea atacara al igual que tu y el combate termina hasta que alguno de los dos ya no tenga puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n     En este panel tambien se encuentra el boton de inventario, en el cual podras equiparte armas, escudos y utilizar objetos especiales\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "La ultima seccion de esta pantalla es esta, en la cual estare relatando los acontecimientos de la pelea\n");
			historiaPrincipal.setText(historiaPrincipal.getText() + "\n ahora si, a trabajar\n");
		}
	}

	public void imprimirAccionesPelea(){
		/*String claseEnemigo = enemigo.getClass().getSimpleName();
		String claseParcial = parcial1.getClass().getSimpleName();*/
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo){
			String claseEnemigo= enemigo.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo2){
			String claseEnemigo= enemigo2.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo2.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo2.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo2.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo3){
			String claseEnemigo= enemigo3.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo3.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo3.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo3.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo4){
			String claseEnemigo= enemigo4.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo4.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo4.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo4.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo5){
			String claseEnemigo= enemigo5.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo5.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo5.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo5.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo6){
			String claseEnemigo= enemigo6.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo6.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo6.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo6.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo7){
			String claseEnemigo= enemigo7.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo7.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo7.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo7.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == enemigo8){
			String claseEnemigo= enemigo8.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al enemigo con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo8.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El enemigo ahora tiene: " + enemigo8.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + enemigo8.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
		if(mapa.getCasillas()[alumno.getX()][alumno.getY()].getEnemigo() == parcial1){
			String claseEnemigo= parcial1.getClass().getSimpleName();
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nHaz atacado al parcial1 con: " + alumno.getAtaque() + " puntos de ataque \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El parcial1 ahora tiene: " + parcial1.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"El parcial1 ahora tiene: " + parcial1.getDefensa() + " puntos de defensa\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"\nLa " + claseEnemigo + " te ha atacado con" + parcial1.getAtaque() + "\n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getPromedio() + " puntos de promedio \n");
			historiaPrincipal.setText(historiaPrincipal.getText() +"Ahora tienes: " + alumno.getDefensa() + " puntos de defensa\n");
		}
	}

	public class BotonPantallaInicialListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(panelGameOver);
			initComponentsPantallaInicio();
			revalidate();
			repaint();
		}
	}
}