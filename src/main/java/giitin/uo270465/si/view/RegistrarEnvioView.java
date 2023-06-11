package giitin.uo270465.si.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import net.miginfocom.swing.MigLayout;

public class RegistrarEnvioView extends View {
	private static final long serialVersionUID = 1L;
	private JToggleButton tbClienteExistenteRemitenteMode;
	private JToggleButton tbNuevoClienteRemitenteMode;
	private JTextField tfNombreRemitente;
	private JTextField tfEmailRemitente;
	private JTextField tfDireccionRemitente;
	private JLabel lblNewLabel_3;
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
	private SearchTableComponent<ClienteDTO> stcClientesRemitentes;
	private JToggleButton tbNuevoClienteDestinatarioMode;
	private JToggleButton tbClienteExistenteDestinatarioMode;
	private JTextField tfNombreDestinatario;
	private SearchTableComponent<ClienteDTO> stcClientesDestinatarios;
	private JTextField tfEmailDestinatario;
	private JTextField tfDireccionDestinatario;
	private JLabel lblNewLabel;
	private JLabel lblEstablezcaElDestinatario;
	private SearchTableComponent<AlmacenOficinaDTO> stcAlmacenOficinaOrigen;
	private JLabel lblNewLabel_4;
	private SearchTableComponent<AlmacenOficinaDTO> stcAlmacenOficinaDestino;
	private JCheckBox cbEnviarDestinatarioDestino;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JSpinner sAlturaPaquete;
	private JSpinner sAnturaXPaquete;
	private JSpinner sPesoPaquete;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JSpinner sAnchuraYPaquete;
	private JLabel lblNewLabel_13;
	private SearchTableComponent<TarifaDTO> stcTarifa;
	private JLabel lblNewLabel_6;

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
		
		lblNewLabel = new JLabel("Establezca el remitente del envío:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblNewLabel, "cell 0 0 3 1");

		tbNuevoClienteRemitenteMode = new JToggleButton("Nuevo cliente");
		panel_1.add(tbNuevoClienteRemitenteMode, "flowx,cell 0 1 2 1,growx");

		tbClienteExistenteRemitenteMode = new JToggleButton("Cliente Existente");
		panel_1.add(tbClienteExistenteRemitenteMode, "cell 2 1,growx");

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel_1.add(lblNewLabel_1, "cell 0 2,alignx trailing");

		tfNombreRemitente = new JTextField();
		tfNombreRemitente.setEnabled(false);
		panel_1.add(tfNombreRemitente, "cell 1 2,growx");
		tfNombreRemitente.setColumns(10);

		stcClientesRemitentes = new SearchTableComponent<>(ClienteDTO.class);
		panel_1.add(stcClientesRemitentes, "cell 2 2 1 4,grow");

		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		panel_1.add(lblNewLabel_1_1, "cell 0 3,alignx trailing");

		tfEmailRemitente = new JTextField();
		tfEmailRemitente.setEnabled(false);
		panel_1.add(tfEmailRemitente, "cell 1 3,growx");
		tfEmailRemitente.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
		panel_1.add(lblNewLabel_1_2, "cell 0 4,alignx trailing");

		tfDireccionRemitente = new JTextField();
		tfDireccionRemitente.setEnabled(false);
		panel_1.add(tfDireccionRemitente, "cell 1 4,growx");
		tfDireccionRemitente.setColumns(10);

		stcClientesRemitentes.setEnabled(false);

		// Tab: Destinatario

		scrollPane_2 = new JScrollPane();
		tpRegistrarEnvio.addTab("Destinatario", null, scrollPane_2, null);

		panel_2 = new JPanel();
		panel_2.setLayout(new MigLayout("", "[fill][grow][grow]", "[][][][][][]"));
		scrollPane_2.setViewportView(panel_2);
		
		lblEstablezcaElDestinatario = new JLabel("Establezca el destinatario del envío:");
		lblEstablezcaElDestinatario.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblEstablezcaElDestinatario, "cell 0 0 3 1");

		tbNuevoClienteDestinatarioMode = new JToggleButton("Nuevo cliente");
		panel_2.add(tbNuevoClienteDestinatarioMode, "flowx,cell 0 1 2 1,growx");

		tbClienteExistenteDestinatarioMode = new JToggleButton("Cliente Existente");
		panel_2.add(tbClienteExistenteDestinatarioMode, "cell 2 1,growx");

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		panel_2.add(lblNewLabel_2, "cell 0 2,alignx trailing");

		tfNombreDestinatario = new JTextField();
		tfNombreDestinatario.setEnabled(false);
		panel_2.add(tfNombreDestinatario, "cell 1 2,growx");
		tfNombreDestinatario.setColumns(10);

		stcClientesDestinatarios = new SearchTableComponent<>(ClienteDTO.class);
		panel_2.add(stcClientesDestinatarios, "cell 2 2 1 4,growx");

		JLabel lblNewLabel_2_1 = new JLabel("Email:");
		panel_2.add(lblNewLabel_2_1, "cell 0 3,alignx trailing");

		tfEmailDestinatario = new JTextField();
		tfEmailDestinatario.setEnabled(false);
		panel_2.add(tfEmailDestinatario, "cell 1 3,growx");
		tfEmailDestinatario.setColumns(10);

		JLabel lblNewLabel_2_2 = new JLabel("Dirección:");
		panel_2.add(lblNewLabel_2_2, "cell 0 4,alignx trailing");

		tfDireccionDestinatario = new JTextField();
		tfDireccionDestinatario.setEnabled(false);
		panel_2.add(tfDireccionDestinatario, "cell 1 4,growx");
		tfDireccionDestinatario.setColumns(10);

		stcClientesDestinatarios.setEnabled(false);

		// Tab: Origen

		scrollPane_3 = new JScrollPane();
		tpRegistrarEnvio.addTab("Origen", null, scrollPane_3, null);

		panel_3 = new JPanel();
		panel_3.setLayout(new MigLayout("", "[grow]", "[][]"));
		scrollPane_3.setViewportView(panel_3);

		lblNewLabel_3 = new JLabel("Seleccione un almacen/oficina de origen:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_3, "cell 0 0");
		
		stcAlmacenOficinaOrigen = new SearchTableComponent<>(AlmacenOficinaDTO.class);
		panel_3.add(stcAlmacenOficinaOrigen, "cell 0 1,growx");

		// Tab: Destino

		scrollPane_4 = new JScrollPane();
		tpRegistrarEnvio.addTab("Destino", null, scrollPane_4, null);

		panel_4 = new JPanel();
		panel_4.setLayout(new MigLayout("", "[grow][grow]", "[][]"));
		scrollPane_4.setViewportView(panel_4);
		
		lblNewLabel_4 = new JLabel("Seleccione un destino para el envío:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_4, "cell 0 0");
		
		cbEnviarDestinatarioDestino = new JCheckBox("Enviar a la dirección del destinatario");
		panel_4.add(cbEnviarDestinatarioDestino, "cell 1 0,alignx right");
		
		stcAlmacenOficinaDestino = new SearchTableComponent<>(AlmacenOficinaDTO.class);
		panel_4.add(stcAlmacenOficinaDestino, "cell 0 1 2 1,growx");

		// Tab: Detalles

		scrollPane_5 = new JScrollPane();
		tpRegistrarEnvio.addTab("Detalles", null, scrollPane_5, null);

		panel_5 = new JPanel();
		panel_5.setLayout(new MigLayout("", "[][100px:n][][100px:n][][grow]", "[][][][][][][]"));
		scrollPane_5.setViewportView(panel_5);
		
		lblNewLabel_5 = new JLabel("Detalles del envío:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblNewLabel_5, "cell 0 0 5 1");
		
		lblNewLabel_7 = new JLabel("Altura del paquete: ");
		panel_5.add(lblNewLabel_7, "cell 0 1,alignx trailing");
		
		sAlturaPaquete = new JSpinner();
		panel_5.add(sAlturaPaquete, "cell 1 1,growx");
		
		lblNewLabel_10 = new JLabel(" centimetros");
		panel_5.add(lblNewLabel_10, "cell 2 1 3 1");
		
		lblNewLabel_8 = new JLabel("Anchura del paquete: ");
		panel_5.add(lblNewLabel_8, "cell 0 2,alignx trailing");
		
		sAnturaXPaquete = new JSpinner();
		panel_5.add(sAnturaXPaquete, "cell 1 2,growx");
		
		lblNewLabel_11 = new JLabel(" centimetros   X  ");
		panel_5.add(lblNewLabel_11, "cell 2 2");
		
		sAnchuraYPaquete = new JSpinner();
		panel_5.add(sAnchuraYPaquete, "cell 3 2,growx");
		
		lblNewLabel_13 = new JLabel(" centimetros ");
		panel_5.add(lblNewLabel_13, "cell 4 2");
		
		lblNewLabel_9 = new JLabel("Peso: ");
		panel_5.add(lblNewLabel_9, "cell 0 3,alignx trailing");
		
		sPesoPaquete = new JSpinner();
		panel_5.add(sPesoPaquete, "cell 1 3,growx");
		
		lblNewLabel_12 = new JLabel(" gramos ");
		panel_5.add(lblNewLabel_12, "cell 2 3 3 1");
		
		lblNewLabel_6 = new JLabel("Selecciona una o varias tarifas para el envío:");
		panel_5.add(lblNewLabel_6, "cell 0 5 6 1");
		
		stcTarifa = new SearchTableComponent<>(TarifaDTO.class);
		panel_5.add(stcTarifa, "cell 0 6 6 1,growx");
		stcTarifa.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

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

		this.dispose();
	}

	public JTabbedPane getTpRegistrarEnvio() {
		return tpRegistrarEnvio;
	}

	public JToggleButton getTbClienteExistenteRemitenteMode() {
		return tbClienteExistenteRemitenteMode;
	}

	public JToggleButton getTbNuevoClienteRemitenteMode() {
		return tbNuevoClienteRemitenteMode;
	}

	public SearchTableComponent<ClienteDTO> getStcClientesRemitentes() {
		return stcClientesRemitentes;
	}

	public JTextField getTfNombreRemitente() {
		return tfNombreRemitente;
	}

	public JTextField getTfEmailRemitente() {
		return tfEmailRemitente;
	}

	public JTextField getTfDireccionRemitente() {
		return tfDireccionRemitente;
	}

	public JToggleButton getTbClienteExistenteDestinatarioMode() {
		return tbClienteExistenteDestinatarioMode;
	}

	public JToggleButton getTbNuevoClienteDestinatarioMode() {
		return tbNuevoClienteDestinatarioMode;
	}

	public SearchTableComponent<ClienteDTO> getStcClientesDestinatarios() {
		return stcClientesDestinatarios;
	}

	public JTextField getTfNombreDestinatario() {
		return tfNombreDestinatario;
	}

	public JTextField getTfEmailDestinatario() {
		return tfEmailDestinatario;
	}

	public JTextField getTfDireccionDestinatario() {
		return tfDireccionDestinatario;
	}

	public SearchTableComponent<AlmacenOficinaDTO> getStcAlmacenOficinaOrigen() {
		return stcAlmacenOficinaOrigen;
	}
	
	public SearchTableComponent<AlmacenOficinaDTO> getStcAlmacenOficinaDestino() {
		return stcAlmacenOficinaDestino;
	}
	public JCheckBox getCbEnviarDestinatarioDestino() {
		return cbEnviarDestinatarioDestino;
	}
	public JSpinner getSPesoPaquete() {
		return sPesoPaquete;
	}
	public JSpinner getSAnturaXPaquete() {
		return sAnturaXPaquete;
	}
	public JSpinner getSAnchuraYPaquete() {
		return sAnchuraYPaquete;
	}
	public JSpinner getSAlturaPaquete() {
		return sAlturaPaquete;
	}
	public SearchTableComponent<TarifaDTO> getStcTarifa() {
		return stcTarifa;
	}
}
