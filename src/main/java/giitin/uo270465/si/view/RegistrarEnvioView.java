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
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;

	public RegistrarEnvioView() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[fill][grow][fill][grow][fill][fill]", "[][][][][][][][grow]"));

		JLabel lblNewLabel = new JLabel("Seleccione una opción:");
		panel.add(lblNewLabel, "cell 0 0 6 1");

		tbNievoClienteMode = new JToggleButton("Nuevo cliente");
		panel.add(tbNievoClienteMode, "flowx,cell 0 1 2 1,growx");

		tbClienteExistenteMode = new JToggleButton("Cliente Existente");
		panel.add(tbClienteExistenteMode, "cell 2 1 4 1,growx");
				
				verticalStrut = Box.createVerticalStrut(20);
				panel.add(verticalStrut, "cell 1 2");
				
				lblNewLabel_2 = new JLabel("Buscar clientes:");
				panel.add(lblNewLabel_2, "cell 2 2,alignx trailing");
				
				textField = new JTextField();
				panel.add(textField, "cell 3 2,growx");
				textField.setColumns(10);
				
				btnNewButton = new JButton("Buscar");
				panel.add(btnNewButton, "cell 4 2,growx");
				
				btnNewButton_1 = new JButton("Mostrar todos");
				panel.add(btnNewButton_1, "cell 5 2,growx");
				
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				panel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
				
				tfNombreNuevoCliente = new JTextField();
				panel.add(tfNombreNuevoCliente, "cell 1 3,growx");
				tfNombreNuevoCliente.setColumns(10);
		
				spTClientes = new JScrollPane();
				
				panel.add(spTClientes, "cell 2 3 4 4,grow");
				
						tClientes = new JTable();
						tClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						tClientes.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nombre", "Email", "Direcci\u00F3n"
							}
						) {
							boolean[] columnEditables = new boolean[] {
								false, false, false
							};
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
}
