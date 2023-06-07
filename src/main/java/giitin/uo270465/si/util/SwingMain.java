package giitin.uo270465.si.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

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
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 244, 257);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow,fill]", "[grow][grow][grow][grow,fill][grow]"));
		
		dcFecha = new JDateChooser();
		panel.add(dcFecha, "cell 0 0,grow");
		dcFecha.add(lblNewLabel, BorderLayout.WEST);
		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		panel.add(btnInicializarBaseDeDatos, "flowy,cell 0 1,grow");
		
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		panel.add(btnCargarDatosIniciales, "flowy,cell 0 2,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Funcionalidades:");
		panel.add(lblNewLabel_1, "cell 0 3,grow");
		
		JButton btnEjecutarTkrun = new JButton("Ejecutar giis.demo.tkrun");
		panel.add(btnEjecutarTkrun, "cell 0 4,grow");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				//CarrerasController controller=new CarrerasController(new CarrerasModel(), new CarrerasView());
				//controller.initController();
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
	}

	public JFrame getFrame() { return this.frame; }
	
}
