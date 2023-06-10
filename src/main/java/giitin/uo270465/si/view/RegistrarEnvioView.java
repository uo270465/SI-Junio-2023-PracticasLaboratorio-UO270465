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

public class RegistrarEnvioView extends View {
	private static final long serialVersionUID = 1L;
	private JTable tClientes;

	public RegistrarEnvioView() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow][grow]", "[][][grow]"));

		JLabel lblNewLabel = new JLabel("Seleccione una opción:");
		panel.add(lblNewLabel, "cell 0 0 2 1");

		JToggleButton tglbtnNewToggleButton = new JToggleButton("Nuevo cliente");
		panel.add(tglbtnNewToggleButton, "flowx,cell 0 1,growx");

		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Cliente Existente");
		panel.add(tglbtnNewToggleButton_1, "cell 1 1,growx");

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 2,grow");

		tClientes = new JTable();
		tClientes.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Nombre", "Email", "Direcci\u00F3n" }));
		tClientes.getColumnModel().getColumn(0).setPreferredWidth(51);
		tClientes.getColumnModel().getColumn(1).setPreferredWidth(40);
		tClientes.getColumnModel().getColumn(2).setPreferredWidth(58);
		scrollPane.setViewportView(tClientes);
	}

	public JTable getTClientes() {
		return tClientes;
	}
}
