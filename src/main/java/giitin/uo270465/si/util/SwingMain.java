package giitin.uo270465.si.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.controller.EntregarEnvioController;
import giitin.uo270465.si.controller.RealizarSeguimientoController;
import giitin.uo270465.si.controller.RegistrarEnvioController;
import giitin.uo270465.si.controller.RegistrarMovimientoController;
import net.miginfocom.swing.MigLayout;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las
 * pantallas de las aplicaciones de ejemplo y acciones de inicializacion de la
 * base de datos. No sigue MVC pues es solamente temporal para que durante el
 * desarrollo se tenga posibilidad de realizar acciones de inicializacion
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
		EventQueue.invokeLater(new Runnable() { // NOSONAR codigo autogenerado
			public void run() {
				try {
					new SwingMain();
				} catch (Exception e) {
					e.printStackTrace(); // NOSONAR codigo autogenerado
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
		panel.setLayout(new MigLayout("", "[grow][fill][grow]", "[grow][][][][][][][][][grow]"));

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

		JButton bRegistrarEnvio = new JButton("Registrar envío");
		panel.add(bRegistrarEnvio, "cell 1 5,grow");

		JButton bRegistrarMovimiento = new JButton("Registrar movimiento");
		panel.add(bRegistrarMovimiento, "cell 1 6");

		JButton bRealizarSeguimiento = new JButton("Realizar seguimiento");
		panel.add(bRealizarSeguimiento, "cell 1 7");

		JButton bEntregarEnvio = new JButton("Entregar envío");
		panel.add(bEntregarEnvio, "cell 1 8");

		View THIS = this;

		btnCargarDatosIniciales.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
			}
		});

		bRegistrarEnvio.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				RegistrarEnvioController controller = new RegistrarEnvioController(THIS, getFecha());
				controller.initController();
			}
		});

		bRegistrarMovimiento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarMovimientoController controller = new RegistrarMovimientoController(THIS, getFecha());
				controller.initController();

			}
		});
		bRealizarSeguimiento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RealizarSeguimientoController controller = new RealizarSeguimientoController(THIS, getFecha());
				controller.initController();

			}
		});

		bEntregarEnvio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EntregarEnvioController controller = new EntregarEnvioController(THIS, getFecha());
				controller.initController();
			}
		});

		this.initView();

	}

	public void initView() {
		JFrame fView = (JFrame) this;
		fView.validate();
		fView.pack();
		fView.setVisible(true);

		this.setSize(300, this.getHeight());
		// Poner Pantalla en el medio
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fView.setLocation(dim.width / 2 - fView.getSize().width / 2, dim.height / 2 - fView.getSize().height / 2);
	}

	public Date getFecha() {
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(dcFecha.getDate());
		Calendar fechaHMS = Calendar.getInstance();

		fechaHMS.set(Calendar.YEAR, fecha.get(Calendar.YEAR));
		fechaHMS.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
		fechaHMS.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));

		return fechaHMS.getTime();

	}

	public JFrame getFrame() {
		return this.frame;
	}

}
