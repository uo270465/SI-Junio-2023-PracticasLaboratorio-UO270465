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

public class RegistrarEnvioView extends View {
	private static final long serialVersionUID = 1L;
	private JTable tClientes;
	private JToggleButton tbClienteExistenteMode;
	private JToggleButton tbNievoClienteMode;
	private JTextField tfNombreNuevoCliente;
	private JTextField tfEmailNuevoCliente;
	private JTextField tfDireccionNuevoCliente;
	private JScrollPane spTClientes;
	private Component verticalStrut;
	private JTextField tfFiltroClienteExistente;
	private JButton bBuscarClienteExistente;
	private JButton bMostrarTodosClienteExistente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JScrollPane spTAlmacenesOficinasOrigen;
	private JTable tAlmacenesOficinasOrigen;
	private JButton bNuevoEnvio;

	public RegistrarEnvioView() {
		setTitle("Registrar envío");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[fill][grow][fill][grow][fill][fill]", "[][][][][][][][][][fill]"));

		JLabel lblNewLabel = new JLabel("Seleccione una opción:");
		panel.add(lblNewLabel, "cell 0 0 6 1");

		tbNievoClienteMode = new JToggleButton("Nuevo cliente");
		tbNievoClienteMode.setSelected(true);
		panel.add(tbNievoClienteMode, "flowx,cell 0 1 2 1,growx");

		tbClienteExistenteMode = new JToggleButton("Cliente Existente");
		panel.add(tbClienteExistenteMode, "cell 2 1 4 1,growx");

		verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, "cell 1 2");

		lblNewLabel_2 = new JLabel("Buscar clientes:");
		panel.add(lblNewLabel_2, "cell 2 2,alignx trailing");

		tfFiltroClienteExistente = new JTextField();
		tfFiltroClienteExistente.setToolTipText("Introduzca un nombre, email o dirección");
		panel.add(tfFiltroClienteExistente, "cell 3 2,growx");
		tfFiltroClienteExistente.setColumns(10);

		bBuscarClienteExistente = new JButton("Buscar");
		panel.add(bBuscarClienteExistente, "cell 4 2,growx");

		bMostrarTodosClienteExistente = new JButton("Mostrar todos");
		panel.add(bMostrarTodosClienteExistente, "cell 5 2,growx");

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel.add(lblNewLabel_1, "cell 0 3,alignx trailing");

		tfNombreNuevoCliente = new JTextField();
		panel.add(tfNombreNuevoCliente, "cell 1 3,growx");
		tfNombreNuevoCliente.setColumns(10);

		spTClientes = new JScrollPane();

		panel.add(spTClientes, "cell 2 3 4 4,grow");

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

		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		panel.add(lblNewLabel_1_1, "cell 0 4,alignx trailing");

		tfEmailNuevoCliente = new JTextField();
		panel.add(tfEmailNuevoCliente, "cell 1 4,growx");
		tfEmailNuevoCliente.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
		panel.add(lblNewLabel_1_2, "cell 0 5,alignx trailing");

		tfDireccionNuevoCliente = new JTextField();
		panel.add(tfDireccionNuevoCliente, "cell 1 5,growx");
		tfDireccionNuevoCliente.setColumns(10);

		lblNewLabel_3 = new JLabel("Seleccione almacen u oficina de origen:");
		panel.add(lblNewLabel_3, "cell 0 7 2 1");

		spTAlmacenesOficinasOrigen = new JScrollPane();
		panel.add(spTAlmacenesOficinasOrigen, "cell 0 8 2 1,grow");

		tAlmacenesOficinasOrigen = new JTable();
		tAlmacenesOficinasOrigen.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Direcci\u00F3n", "Ciudad" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		spTAlmacenesOficinasOrigen.setViewportView(tAlmacenesOficinasOrigen);

		bNuevoEnvio = new JButton("Crear nuevo envío");
		panel.add(bNuevoEnvio, "cell 0 9 6 1,growx");
		
		
		int preferredTableHeight = this.getTfNombreNuevoCliente().getHeight() * 10;
		

	}

	public JTable getTClientes() {
		return tClientes;
	}

	public JToggleButton getTbClienteExistenteMode() {
		return tbClienteExistenteMode;
	}

	public JToggleButton getTbNievoClienteMode() {
		return tbNievoClienteMode;
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
		return tfFiltroClienteExistente;
	}

	public JButton getBBuscarClienteExistente() {
		return bBuscarClienteExistente;
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

	public JButton getBNuevoEnvio() {
		return bNuevoEnvio;
	}
}
