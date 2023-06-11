package giitin.uo270465.si.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.ClienteDTO;
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
	private JToggleButton tbClienteExistenteRemitenteMode;
	private JToggleButton tbNuevoClienteRemitenteMode;
	private JTextField tfNombreNuevoCliente;
	private JTextField tfEmailNuevoCliente;
	private JTextField tfDireccionNuevoCliente;
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
	private SearchTableComponent<ClienteDTO> stcClientesDestinatario;
	private SearchTableComponent stcClientesRemitentes;

	public RegistrarEnvioView() {
		setTitle("Registrar envío");
		getContentPane().setLayout(new BorderLayout(0, 0));

		tpRegistrarEnvio = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tpRegistrarEnvio, BorderLayout.NORTH);

		// Tab: Remitente

		scrollPane_1 = new JScrollPane();
		tpRegistrarEnvio.addTab("Remitente", null, scrollPane_1, null);

		panel_1 = new JPanel();
		panel_1.setLayout(new MigLayout("", "[fill][grow][grow]", "[][][][][][]"));
		scrollPane_1.setViewportView(panel_1);

		JLabel lblNewLabel = new JLabel("Seleccione una opción:");
		panel_1.add(lblNewLabel, "cell 0 0 3 1");

		tbNuevoClienteRemitenteMode = new JToggleButton("Nuevo cliente");
		tbNuevoClienteRemitenteMode.setSelected(true);
		panel_1.add(tbNuevoClienteRemitenteMode, "flowx,cell 0 1 2 1,growx");

		tbClienteExistenteRemitenteMode = new JToggleButton("Cliente Existente");
		panel_1.add(tbClienteExistenteRemitenteMode, "cell 2 1,growx");
				
						JLabel lblNewLabel_1 = new JLabel("Nombre:");
						panel_1.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
				tfNombreNuevoCliente = new JTextField();
				panel_1.add(tfNombreNuevoCliente, "cell 1 2,growx");
				tfNombreNuevoCliente.setColumns(10);
						
						stcClientesRemitentes = new SearchTableComponent();
						panel_1.add(stcClientesRemitentes, "cell 2 2 1 4,growx");
				
						JLabel lblNewLabel_1_1 = new JLabel("Email:");
						panel_1.add(lblNewLabel_1_1, "cell 0 3,alignx trailing");
		
				tfEmailNuevoCliente = new JTextField();
				panel_1.add(tfEmailNuevoCliente, "cell 1 3,growx");
				tfEmailNuevoCliente.setColumns(10);
				
						JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
						panel_1.add(lblNewLabel_1_2, "cell 0 4,alignx trailing");
		
				tfDireccionNuevoCliente = new JTextField();
				panel_1.add(tfDireccionNuevoCliente, "cell 1 4,growx");
				tfDireccionNuevoCliente.setColumns(10);

		// Tab: Destinatario
		
		scrollPane_2 = new JScrollPane();
		tpRegistrarEnvio.addTab("Destinatario", null, scrollPane_2, null);

		panel_2 = new JPanel();
		panel_2.setLayout(new MigLayout("", "[grow]", "[]"));
		scrollPane_2.setViewportView(panel_2);
		
		
		
		stcClientesDestinatario = new SearchTableComponent<ClienteDTO>();
		panel_2.add(stcClientesDestinatario, "cell 0 0,grow");

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



	public JToggleButton getTbClienteExistenteMode() {
		return tbClienteExistenteRemitenteMode;
	}

	public JToggleButton getTbNievoClienteMode() {
		return tbNuevoClienteRemitenteMode;
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

	public JScrollPane getSpTAlmacenesOficinasOrigen() {
		return spTAlmacenesOficinasOrigen;
	}

	public JTable getTAlmacenesOficinasOrigen() {
		return tAlmacenesOficinasOrigen;
	}

	public JTabbedPane getTpRegistrarEnvio() {
		return tpRegistrarEnvio;
	}
	public SearchTableComponent<ClienteDTO> getStcClientesDestinatario() {
		return stcClientesDestinatario;
	}
	public SearchTableComponent getStcClientesRemitentes() {
		return stcClientesRemitentes;
	}
}
