package giitin.uo270465.si.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.controller.RegistrarEnvioController;
import net.miginfocom.swing.MigLayout;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain extends View {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JDateChooser dcFecha;
	private final JLabel lblNewLabel = new JLabel("Fecha: ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					new SwingMain();
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Gestor de envíos");
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		this.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow][fill][grow]", "[grow][][][][][][grow]"));
		
		dcFecha = new JDateChooser();
		dcFecha.setDate(new Date());
		panel.add(dcFecha, "cell 1 1,alignx center,aligny center");
		dcFecha.add(lblNewLabel, BorderLayout.WEST);
		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		panel.add(btnInicializarBaseDeDatos, "flowy,cell 1 2,grow");
		
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		panel.add(btnCargarDatosIniciales, "flowy,cell 1 3,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Funcionalidades:");
		panel.add(lblNewLabel_1, "cell 1 4,grow");
		
		JButton btnEjecutarTkrun = new JButton("Registrar envío");
		panel.add(btnEjecutarTkrun, "cell 1 5,grow");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				RegistrarEnvioController controller = new RegistrarEnvioController(dcFecha.getDate());
				controller.initController();
			}
		});
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		this.initView();

	}
	
	public void initView() {
		JFrame fView = (JFrame)this;
		fView.validate();
		fView.pack();
		fView.setVisible(true);
		
		this.setSize(300, this.getHeight());
		// Poner Pantalla en el medio
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fView.setLocation(dim.width/2-fView.getSize().width/2, dim.height/2-fView.getSize().height/2);
	}


	
	public JFrame getFrame() { return this.frame; }
	
}
