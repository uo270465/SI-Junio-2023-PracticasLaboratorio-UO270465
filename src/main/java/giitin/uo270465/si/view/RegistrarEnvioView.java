package giitin.uo270465.si.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.abs.View;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;

public class RegistrarEnvioView extends View {
	private static final long serialVersionUID = 1L;
	private JTable tClientes;
	private JToggleButton tbClienteExistenteRemitenteMode;
	private JToggleButton tbNuevoClienteRemitenteMode;
	private JTextField tfNombreNuevoCliente;
	private JTextField tfEmailNuevoCliente;
	private JTextField tfDireccionNuevoCliente;
	private JScrollPane spTClientes;
	private JTextField tfFiltroClienteRemitenteExistente;
	private JButton bBuscarClienteRemitenteExistente;
	private JButton bMostrarTodosClienteExistente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JScrollPane spTAlmacenesOficinasOrigen;
	private JTable tAlmacenesOficinasOrigen;
	private JTabbedPane tpRegistrarEnvio;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JScrollPane scrollPane_2;
	private JPanel panel_2;
	private JScrollPane scrollPane_3;
	private JPanel panel_3;
	private JScrollPane scrollPane_4;
	private JPanel panel_4;
	private JScrollPane scrollPane_5;
	private JPanel panel_5;
	private JScrollPane scrollPane_6;
	private JPanel panel_6;
	private JScrollPane scrollPane_7;
	private JPanel panel_7;

	public RegistrarEnvioView() {
		setTitle("Registrar envío");
		getContentPane().setLayout(new BorderLayout(0, 0));

		tpRegistrarEnvio = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tpRegistrarEnvio, BorderLayout.NORTH);

		// Tab: Remitente

		scrollPane_1 = new JScrollPane();
		tpRegistrarEnvio.addTab("Remitente", null, scrollPane_1, null);

		panel_1 = new JPanel();
		panel_1.setLayout(new MigLayout("", "[fill][grow][fill][grow][fill][fill]", "[][][][][][]"));
		scrollPane_1.setViewportView(panel_1);

		JLabel lblNewLabel = new JLabel("Seleccione una opción:");
		panel_1.add(lblNewLabel, "cell 0 0 6 1");

		tbNuevoClienteRemitenteMode = new JToggleButton("Nuevo cliente");
		tbNuevoClienteRemitenteMode.setSelected(true);
		panel_1.add(tbNuevoClienteRemitenteMode, "flowx,cell 0 1 2 1,growx");

		tbClienteExistenteRemitenteMode = new JToggleButton("Cliente Existente");
		panel_1.add(tbClienteExistenteRemitenteMode, "cell 2 1 4 1,growx");
				
						JLabel lblNewLabel_1 = new JLabel("Nombre:");
						panel_1.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
				tfNombreNuevoCliente = new JTextField();
				panel_1.add(tfNombreNuevoCliente, "cell 1 2,growx");
				tfNombreNuevoCliente.setColumns(10);

		lblNewLabel_2 = new JLabel("Buscar clientes:");
		panel_1.add(lblNewLabel_2, "cell 2 2,alignx trailing");

		tfFiltroClienteRemitenteExistente = new JTextField();
		tfFiltroClienteRemitenteExistente.setToolTipText("Introduzca un nombre, email o dirección");
		panel_1.add(tfFiltroClienteRemitenteExistente, "cell 3 2,growx");
		tfFiltroClienteRemitenteExistente.setColumns(10);

		bBuscarClienteRemitenteExistente = new JButton("Buscar");
		panel_1.add(bBuscarClienteRemitenteExistente, "cell 4 2,growx");

		bMostrarTodosClienteExistente = new JButton("Mostrar todos");
		panel_1.add(bMostrarTodosClienteExistente, "cell 5 2,growx");
				
						JLabel lblNewLabel_1_1 = new JLabel("Email:");
						panel_1.add(lblNewLabel_1_1, "cell 0 3,alignx trailing");
		
				tfEmailNuevoCliente = new JTextField();
				panel_1.add(tfEmailNuevoCliente, "cell 1 3,growx");
				tfEmailNuevoCliente.setColumns(10);

		spTClientes = new JScrollPane();

		panel_1.add(spTClientes, "cell 2 3 4 3,grow");

		tClientes = new JTable();
		tClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Email", "Direcci\u00F3n" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tClientes.getColumnModel().getColumn(0).setPreferredWidth(51);
		tClientes.getColumnModel().getColumn(1).setPreferredWidth(40);
		tClientes.getColumnModel().getColumn(2).setPreferredWidth(58);
		spTClientes.setViewportView(tClientes);
		spTClientes.setSize(spTClientes.getWidth(), 100);
				
						JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
						panel_1.add(lblNewLabel_1_2, "cell 0 4,alignx trailing");
		
				tfDireccionNuevoCliente = new JTextField();
				panel_1.add(tfDireccionNuevoCliente, "cell 1 4,growx");
				tfDireccionNuevoCliente.setColumns(10);

		// Tab: Destinatario
		
		scrollPane_2 = new JScrollPane();
		tpRegistrarEnvio.addTab("Destinatario", null, scrollPane_2, null);

		panel_2 = new JPanel();
		panel_2.setLayout(new MigLayout());
		scrollPane_2.setViewportView(panel_2);

		// Tab: Origen

		scrollPane_3 = new JScrollPane();
		tpRegistrarEnvio.addTab("Origen", null, scrollPane_3, null);

		panel_3 = new JPanel();
		panel_3.setLayout(new MigLayout("", "[]", "[][]"));
		scrollPane_3.setViewportView(panel_3);
		
		lblNewLabel_3 = new JLabel("Seleccione almacen u oficina de origen:");
		panel_3.add(lblNewLabel_3, "cell 0 0 2 1");

		spTAlmacenesOficinasOrigen = new JScrollPane();
		panel_3.add(spTAlmacenesOficinasOrigen, "cell 0 1 2 1,grow");

		tAlmacenesOficinasOrigen = new JTable();
		tAlmacenesOficinasOrigen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tAlmacenesOficinasOrigen.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Direcci\u00F3n", "Ciudad" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		spTAlmacenesOficinasOrigen.setViewportView(tAlmacenesOficinasOrigen);

		// Tab: Destino

		scrollPane_4 = new JScrollPane();
		tpRegistrarEnvio.addTab("Destino", null, scrollPane_4, null);

		panel_4 = new JPanel();
		panel_4.setLayout(new MigLayout());
		scrollPane_4.setViewportView(panel_4);

		// Tab: Detalles

		scrollPane_5 = new JScrollPane();
		tpRegistrarEnvio.addTab("Detalles", null, scrollPane_5, null);

		panel_5 = new JPanel();
		panel_5.setLayout(new MigLayout());
		scrollPane_5.setViewportView(panel_5);

		// Tab: Transporte

		scrollPane_6 = new JScrollPane();
		tpRegistrarEnvio.addTab("Transporte", null, scrollPane_6, null);

		panel_6 = new JPanel();
		panel_6.setLayout(new MigLayout());
		scrollPane_6.setViewportView(panel_6);

		// Tab: Confirmación

		scrollPane_7 = new JScrollPane();
		tpRegistrarEnvio.addTab("Confirmación", null, scrollPane_7, null);

		panel_7 = new JPanel();
		panel_7.setLayout(new MigLayout());
		scrollPane_7.setViewportView(panel_7);

	}

	public JTable getTClientes() {
		return tClientes;
	}

	public JToggleButton getTbClienteExistenteMode() {
		return tbClienteExistenteRemitenteMode;
	}

	public JToggleButton getTbNievoClienteMode() {
		return tbNuevoClienteRemitenteMode;
	}

	public JScrollPane getSpTClientes() {
		return spTClientes;
	}

	public JTextField getTfNombreNuevoCliente() {
		return tfNombreNuevoCliente;
	}

	public JTextField getTfEmailNuevoCliente() {
		return tfEmailNuevoCliente;
	}

	public JTextField getTfDireccionNuevoCliente() {
		return tfDireccionNuevoCliente;
	}

	public JTextField getTfFiltroClienteExistente() {
		return tfFiltroClienteRemitenteExistente;
	}

	public JButton getBBuscarClienteExistente() {
		return bBuscarClienteRemitenteExistente;
	}

	public JButton getBMostrarTodosClienteExistente() {
		return bMostrarTodosClienteExistente;
	}

	public JScrollPane getSpTAlmacenesOficinasOrigen() {
		return spTAlmacenesOficinasOrigen;
	}

	public JTable getTAlmacenesOficinasOrigen() {
		return tAlmacenesOficinasOrigen;
	}

	public JTabbedPane getTpRegistrarEnvio() {
		return tpRegistrarEnvio;
	}
}
