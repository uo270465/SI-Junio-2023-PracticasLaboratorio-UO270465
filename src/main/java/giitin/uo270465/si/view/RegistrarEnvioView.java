package giitin.uo270465.si.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.dto.TransportistaVechiculoDTO;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

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
	private JSpinner sAnchuraXPaquete;
	private JSpinner sPesoPaquete;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JSpinner sAnchuraYPaquete;
	private JLabel lblNewLabel_13;
	private SearchTableComponent<TarifaDTO> stcTarifa;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_14;
	private SearchTableComponent<TransportistaVechiculoDTO> stcTransportistaVehiculo;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lConfEstadoNombreRemitente;
	private JLabel lConfDatosNombreRemitente;
	private JLabel lblNewLabel_20;
	private JLabel lConfDatosTipoRemitente;
	private JLabel lConfEstadoTipoRemitente;
	private JLabel lblNewLabel_23;
	private JLabel lConfDatosEmailRemitente;
	private JLabel lConfEstadoEmailRemitente;
	private JLabel lblNewLabel_26;
	private JLabel lConfDatosDireccionRemitente;
	private JLabel lMensajeErrorConfirmacion;
	private JLabel lConfEstadoDireccionRemitente;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lConfDatosTipoDestinatario;
	private JLabel lConfDatosNombreDestinatario;
	private JLabel lConfDatosEmailDestinatario;
	private JLabel lConfDatosDireccionDestinatario;
	private JLabel lConfEstadoTipoDestinatario;
	private JLabel lConfEstadoNombreDestinatario;
	private JLabel lConfEstadoEmailDestinatario;
	private JLabel lConfEstadoDireccionDestinatario;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_33;
	private JLabel lConfDatosNombreOrigen;
	private JLabel lConfDatosDireccionOrigen;
	private JLabel lConfDatosCiudadOrigen;
	private JLabel lConfDatosNombreDestino;
	private JLabel lConfDatosDireccionDestino;
	private JLabel lConfDatosCiudadDestino;
	private JLabel lConfEstadoNombreOrigen;
	private JLabel lConfEstadoDireccionOrigen;
	private JLabel lConfEstadoCiudadOrigen;
	private JLabel lConfEstadoNombreDestino;
	private JLabel lConfEstadoDireccionDestino;
	private JLabel lConfEstadoCiudadDestino;
	private JLabel lblNewLabel_34;
	private JLabel lblNewLabel_35;
	private Component verticalStrut_2;
	private JLabel lblNewLabel_36;
	private JLabel lblNewLabel_37;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	private JLabel lConfDatosAltura;
	private JLabel lConfDatosAnchuraX;
	private JLabel lConfDatosAnchuraY;
	private JLabel lConfDatosPeso;
	private JLabel lblNewLabel_44;
	private JLabel lblNewLabel_45;
	private JLabel lblNewLabel_46;
	private JLabel lblNewLabel_47;
	private JLabel lConfEstadoAltura;
	private JLabel lConfEstadoAnchuraX;
	private JLabel lConfEstadoAnchuraY;
	private JLabel lConfEstadoPeso;
	private JLabel lblNewLabel_40;
	private JLabel lConfEstadoTarifas;
	private JScrollPane scrollPane;
	private JTable tTarifasSeleccionadas;
	private JLabel lConfDatosTarifas;
	private JLabel lblNewLabel_41;
	private JLabel lblNewLabel_42;
	private JLabel lPrecioTarifas;
	private JLabel lblNewLabel_43;
	private JLabel lblNewLabel_48;
	private JLabel lblNewLabel_49;
	private JLabel lblNewLabel_50;
	private JLabel lConfDatosNombreTransportista;
	private JLabel lConfDatosEmailTransportista;
	private JLabel lConfDatosTipoVehiculoTransportista;
	private JLabel lConfDatosCapacidadVehiculoTransportista;
	private JLabel lConfEstadoNombreTransportista;
	private JLabel lConfEstadoEmailTransportista;
	private JLabel lConfEstadoTipoVehiculoTransportista;
	private JLabel lConfEstadoCapacidadVehiculoTransportista;
	private JButton bRegistrarEnvio;

	public RegistrarEnvioView() {
		super();
		setTitle("Registrar envío");
		getContentPane().setLayout(new BorderLayout(0, 0));

		tpRegistrarEnvio = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tpRegistrarEnvio, BorderLayout.CENTER);

		// Tab: Remitente

		scrollPane_1 = new JScrollPane();
		tpRegistrarEnvio.addTab("Remitente", null, scrollPane_1, null);

		panel_1 = new JPanel();
		panel_1.setLayout(new MigLayout("", "[fill][grow][grow]", "[][][][][][grow]"));
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
		panel_2.setLayout(new MigLayout("", "[fill][grow][grow]", "[][][][][][grow]"));
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
		panel_2.add(stcClientesDestinatarios, "cell 2 2 1 4,grow");

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
		panel_3.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		scrollPane_3.setViewportView(panel_3);

		lblNewLabel_3 = new JLabel("Seleccione un almacen/oficina de origen:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_3, "cell 0 0");
		
		stcAlmacenOficinaOrigen = new SearchTableComponent<>(AlmacenOficinaDTO.class);
		panel_3.add(stcAlmacenOficinaOrigen, "cell 0 1,grow");

		// Tab: Destino

		scrollPane_4 = new JScrollPane();
		tpRegistrarEnvio.addTab("Destino", null, scrollPane_4, null);

		panel_4 = new JPanel();
		panel_4.setLayout(new MigLayout("", "[grow][grow]", "[][grow,fill]"));
		scrollPane_4.setViewportView(panel_4);
		
		lblNewLabel_4 = new JLabel("Seleccione un destino para el envío:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_4, "cell 0 0");
		
		cbEnviarDestinatarioDestino = new JCheckBox("Enviar a la dirección del destinatario");
		panel_4.add(cbEnviarDestinatarioDestino, "cell 1 0,alignx right");
		
		stcAlmacenOficinaDestino = new SearchTableComponent<>(AlmacenOficinaDTO.class);
		panel_4.add(stcAlmacenOficinaDestino, "cell 0 1 2 1,grow");

		// Tab: Detalles

		scrollPane_5 = new JScrollPane();
		tpRegistrarEnvio.addTab("Detalles", null, scrollPane_5, null);

		panel_5 = new JPanel();
		panel_5.setLayout(new MigLayout("", "[][100px:n][][100px:n][][grow]", "[][][][][][][grow]"));
		scrollPane_5.setViewportView(panel_5);
		
		lblNewLabel_5 = new JLabel("Detalles del envío:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblNewLabel_5, "cell 0 0 5 1");
		
		lblNewLabel_7 = new JLabel("Altura paquete: ");
		panel_5.add(lblNewLabel_7, "cell 0 1,alignx trailing");
		
		sAlturaPaquete = new JSpinner();
		panel_5.add(sAlturaPaquete, "cell 1 1,growx");
		
		lblNewLabel_10 = new JLabel(" centimetros");
		panel_5.add(lblNewLabel_10, "cell 2 1 3 1");
		
		lblNewLabel_8 = new JLabel("Anchura paquete: ");
		panel_5.add(lblNewLabel_8, "cell 0 2,alignx trailing");
		
		sAnchuraXPaquete = new JSpinner();
		panel_5.add(sAnchuraXPaquete, "cell 1 2,growx");
		
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
		panel_6.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		scrollPane_6.setViewportView(panel_6);
		
		lblNewLabel_14 = new JLabel("Seleccione un transportista para el envío:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_6.add(lblNewLabel_14, "cell 0 0");
		
		stcTransportistaVehiculo = new SearchTableComponent<>(TransportistaVechiculoDTO.class);
		panel_6.add(stcTransportistaVehiculo, "cell 0 1,grow");

		// Tab: Confirmación

		scrollPane_7 = new JScrollPane();
		tpRegistrarEnvio.addTab("Confirmación", null, scrollPane_7, null);

		panel_7 = new JPanel();
		panel_7.setLayout(new MigLayout("", "[grow][][][][::40px][grow][][][][grow]", "[][][][][][][][][][][][][][][][][][][][::80px][][]"));
		scrollPane_7.setViewportView(panel_7);
		
		lMensajeErrorConfirmacion = new JLabel("<html><center>Se han detectado errores en uno o varios campos introducidos.<br>Pase el ratón por encima de los campos que contengan el texto 'INVÁLIDO' para obtener mas información acerca de los errores.</center></html>");
		lMensajeErrorConfirmacion.setForeground(Color.RED);
		lMensajeErrorConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_7.add(lMensajeErrorConfirmacion, "cell 0 0 10 1,alignx center");
		
		verticalStrut = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut, "cell 5 1");
		
		lblNewLabel_15 = new JLabel("Datos del remitente:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_15, "cell 1 2 4 1");
		
		lblNewLabel_16 = new JLabel("Datos del destinatario:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_16, "cell 6 2");
		
		lblNewLabel_20 = new JLabel("Tipo: ");
		panel_7.add(lblNewLabel_20, "cell 1 3,alignx right");
		
		lConfDatosTipoRemitente = new JLabel("tipo");
		panel_7.add(lConfDatosTipoRemitente, "cell 2 3 2 1");
		
		lConfEstadoTipoRemitente = new JLabel("estado");

		panel_7.add(lConfEstadoTipoRemitente, "cell 4 3");
		
		lblNewLabel_18 = new JLabel("Tipo: ");
		panel_7.add(lblNewLabel_18, "cell 6 3,alignx right");
		
		lConfDatosTipoDestinatario = new JLabel("tipo");
		panel_7.add(lConfDatosTipoDestinatario, "cell 7 3");
		
		lConfEstadoTipoDestinatario = new JLabel("estado");
		panel_7.add(lConfEstadoTipoDestinatario, "cell 8 3");
		
		lblNewLabel_17 = new JLabel("Nombre: ");
		panel_7.add(lblNewLabel_17, "cell 1 4,alignx right");
		
		lConfDatosNombreRemitente = new JLabel("nombre");
		panel_7.add(lConfDatosNombreRemitente, "cell 2 4 2 1");
		
		lConfEstadoNombreRemitente = new JLabel("Válido");
		lConfEstadoNombreRemitente.setForeground(Color.BLUE);
		panel_7.add(lConfEstadoNombreRemitente, "cell 4 4");
		
		lblNewLabel_19 = new JLabel("Nombre: ");
		panel_7.add(lblNewLabel_19, "cell 6 4,alignx right");
		
		lConfDatosNombreDestinatario = new JLabel("nombre");
		panel_7.add(lConfDatosNombreDestinatario, "cell 7 4");
		
		lConfEstadoNombreDestinatario = new JLabel("Válido");
		lConfEstadoNombreDestinatario.setForeground(Color.BLUE);
		panel_7.add(lConfEstadoNombreDestinatario, "cell 8 4");
		
		lblNewLabel_23 = new JLabel("Email: ");
		panel_7.add(lblNewLabel_23, "cell 1 5,alignx right");
		
		lConfDatosEmailRemitente = new JLabel("email");
		panel_7.add(lConfDatosEmailRemitente, "cell 2 5 2 1");
		
		lConfEstadoEmailRemitente = new JLabel("Válido");
		lConfEstadoEmailRemitente.setForeground(Color.BLUE);
		panel_7.add(lConfEstadoEmailRemitente, "cell 4 5");
		
		lblNewLabel_21 = new JLabel("Email: ");
		panel_7.add(lblNewLabel_21, "cell 6 5,alignx right");
		
		lConfDatosEmailDestinatario = new JLabel("email");
		panel_7.add(lConfDatosEmailDestinatario, "cell 7 5");
		
		lConfEstadoEmailDestinatario = new JLabel("Válido");
		lConfEstadoEmailDestinatario.setForeground(Color.BLUE);
		panel_7.add(lConfEstadoEmailDestinatario, "cell 8 5");
		
		lblNewLabel_26 = new JLabel("Dirección: ");
		panel_7.add(lblNewLabel_26, "cell 1 6,alignx right");
		
		lConfDatosDireccionRemitente = new JLabel("dirección");
		panel_7.add(lConfDatosDireccionRemitente, "cell 2 6 2 1");
		
		lConfEstadoDireccionRemitente = new JLabel("Válido");
		lConfEstadoDireccionRemitente.setForeground(Color.BLUE);
		panel_7.add(lConfEstadoDireccionRemitente, "cell 4 6");
		
		lblNewLabel_22 = new JLabel("Dirección: ");
		panel_7.add(lblNewLabel_22, "cell 6 6,alignx right");
		
		lConfDatosDireccionDestinatario = new JLabel("dirección");
		panel_7.add(lConfDatosDireccionDestinatario, "cell 7 6");
		
		lConfEstadoDireccionDestinatario = new JLabel("Válido");
		lConfEstadoDireccionDestinatario.setForeground(Color.BLUE);
		panel_7.add(lConfEstadoDireccionDestinatario, "cell 8 6");
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_1, "cell 5 7");
		
		lblNewLabel_24 = new JLabel("Datos de origen:");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_24, "cell 1 8 4 1");
		
		lblNewLabel_25 = new JLabel("Datos de destino");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_25, "cell 6 8 3 1");
		
		lblNewLabel_27 = new JLabel("Nombre: ");
		panel_7.add(lblNewLabel_27, "cell 1 9,alignx right");
		
		lConfDatosNombreOrigen = new JLabel("nombre");
		panel_7.add(lConfDatosNombreOrigen, "cell 2 9 2 1");
		
		lConfEstadoNombreOrigen = new JLabel("estado");
		panel_7.add(lConfEstadoNombreOrigen, "cell 4 9,aligny top");
		
		lblNewLabel_31 = new JLabel("Nombre: ");
		panel_7.add(lblNewLabel_31, "cell 6 9,alignx right");
		
		lConfDatosNombreDestino = new JLabel("nombre");
		panel_7.add(lConfDatosNombreDestino, "cell 7 9");
		
		lConfEstadoNombreDestino = new JLabel("estado");
		panel_7.add(lConfEstadoNombreDestino, "cell 8 9");
		
		lblNewLabel_29 = new JLabel("Dirección: ");
		panel_7.add(lblNewLabel_29, "cell 1 10,alignx right");
		
		lConfDatosDireccionOrigen = new JLabel("dirección");
		panel_7.add(lConfDatosDireccionOrigen, "cell 2 10 2 1");
		
		lConfEstadoDireccionOrigen = new JLabel("estado");
		panel_7.add(lConfEstadoDireccionOrigen, "cell 4 10");
		
		lblNewLabel_32 = new JLabel("Dirección: ");
		panel_7.add(lblNewLabel_32, "cell 6 10,alignx right");
		
		lConfDatosDireccionDestino = new JLabel("dirección");
		panel_7.add(lConfDatosDireccionDestino, "cell 7 10");
		
		lConfEstadoDireccionDestino = new JLabel("estado");
		panel_7.add(lConfEstadoDireccionDestino, "cell 8 10");
		
		lblNewLabel_30 = new JLabel("Ciudad: ");
		panel_7.add(lblNewLabel_30, "cell 1 11,alignx right");
		
		lConfDatosCiudadOrigen = new JLabel("ciudad");
		panel_7.add(lConfDatosCiudadOrigen, "cell 2 11 2 1");
		
		lConfEstadoCiudadOrigen = new JLabel("estado");
		panel_7.add(lConfEstadoCiudadOrigen, "cell 4 11");
		
		lblNewLabel_33 = new JLabel("Ciudad: ");
		panel_7.add(lblNewLabel_33, "cell 6 11,alignx right");
		
		lConfDatosCiudadDestino = new JLabel("ciudad");
		panel_7.add(lConfDatosCiudadDestino, "cell 7 11");
		
		lConfEstadoCiudadDestino = new JLabel("estado");
		panel_7.add(lConfEstadoCiudadDestino, "cell 8 11");
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_2, "cell 5 12");
		
		lblNewLabel_34 = new JLabel("Detalles:");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_34, "cell 1 13 4 1");
		
		lblNewLabel_35 = new JLabel("Transporte:");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_35, "cell 6 13");
		
		lblNewLabel_36 = new JLabel("Altura paquete: ");
		panel_7.add(lblNewLabel_36, "cell 1 14,alignx right");
		
		lConfDatosAltura = new JLabel("10000");
		panel_7.add(lConfDatosAltura, "cell 2 14");
		
		lblNewLabel_44 = new JLabel("cm");
		panel_7.add(lblNewLabel_44, "cell 3 14");
		
		lConfEstadoAltura = new JLabel("estado");
		panel_7.add(lConfEstadoAltura, "cell 4 14");
		
		lblNewLabel_43 = new JLabel("Nombre: ");
		panel_7.add(lblNewLabel_43, "cell 6 14,alignx right");
		
		lConfDatosNombreTransportista = new JLabel("nombre");
		panel_7.add(lConfDatosNombreTransportista, "cell 7 14");
		
		lConfEstadoNombreTransportista = new JLabel("estado");
		panel_7.add(lConfEstadoNombreTransportista, "cell 8 14");
		
		lblNewLabel_37 = new JLabel("Anchura paquete 1: ");
		panel_7.add(lblNewLabel_37, "cell 1 15,alignx right");
		
		lConfDatosAnchuraX = new JLabel("10000");
		panel_7.add(lConfDatosAnchuraX, "cell 2 15");
		
		lblNewLabel_45 = new JLabel("cm");
		panel_7.add(lblNewLabel_45, "cell 3 15");
		
		lConfEstadoAnchuraX = new JLabel("estado");
		panel_7.add(lConfEstadoAnchuraX, "cell 4 15");
		
		lblNewLabel_48 = new JLabel("Email:");
		panel_7.add(lblNewLabel_48, "cell 6 15,alignx right");
		
		lConfDatosEmailTransportista = new JLabel("email");
		panel_7.add(lConfDatosEmailTransportista, "cell 7 15");
		
		lConfEstadoEmailTransportista = new JLabel("estado");
		panel_7.add(lConfEstadoEmailTransportista, "cell 8 15");
		
		lblNewLabel_38 = new JLabel("Anchura paquete 2: ");
		panel_7.add(lblNewLabel_38, "cell 1 16,alignx right");
		
		lConfDatosAnchuraY = new JLabel("10000");
		panel_7.add(lConfDatosAnchuraY, "cell 2 16");
		
		lblNewLabel_46 = new JLabel("cm");
		panel_7.add(lblNewLabel_46, "cell 3 16");
		
		lConfEstadoAnchuraY = new JLabel("estado");
		panel_7.add(lConfEstadoAnchuraY, "cell 4 16");
		
		lblNewLabel_49 = new JLabel("Tipo vehiculo:");
		panel_7.add(lblNewLabel_49, "cell 6 16,alignx right");
		
		lConfDatosTipoVehiculoTransportista = new JLabel("tipovehiculo");
		panel_7.add(lConfDatosTipoVehiculoTransportista, "cell 7 16");
		
		lConfEstadoTipoVehiculoTransportista = new JLabel("estado");
		panel_7.add(lConfEstadoTipoVehiculoTransportista, "cell 8 16");
		
		lblNewLabel_39 = new JLabel("Peso paquete: ");
		panel_7.add(lblNewLabel_39, "cell 1 17,alignx right");
		
		lConfDatosPeso = new JLabel("10000");
		panel_7.add(lConfDatosPeso, "cell 2 17");
		
		lblNewLabel_47 = new JLabel("g");
		panel_7.add(lblNewLabel_47, "cell 3 17");
		
		lConfEstadoPeso = new JLabel("estado");
		panel_7.add(lConfEstadoPeso, "cell 4 17");
		
		lblNewLabel_50 = new JLabel("Capacidad vehiculo:");
		panel_7.add(lblNewLabel_50, "cell 6 17,alignx right");
		
		lConfDatosCapacidadVehiculoTransportista = new JLabel("capacidad");
		panel_7.add(lConfDatosCapacidadVehiculoTransportista, "cell 7 17");
		
		lConfEstadoCapacidadVehiculoTransportista = new JLabel("estado");
		panel_7.add(lConfEstadoCapacidadVehiculoTransportista, "cell 8 17");
		
		lblNewLabel_40 = new JLabel("Tarifas aplicadas:");
		panel_7.add(lblNewLabel_40, "cell 1 18,alignx right");
		
		lConfDatosTarifas = new JLabel("");
		panel_7.add(lConfDatosTarifas, "cell 2 18");
		
		lConfEstadoTarifas = new JLabel("estado");
		panel_7.add(lConfEstadoTarifas, "cell 4 18");
		
		scrollPane = new JScrollPane();
		panel_7.add(scrollPane, "cell 1 19 4 1,alignx leading,aligny baseline");
		
		tTarifasSeleccionadas = new JTable();
		tTarifasSeleccionadas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Concepto", "Precio (\u20AC)"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tTarifasSeleccionadas);
		
		lblNewLabel_41 = new JLabel("Total: ");
		panel_7.add(lblNewLabel_41, "cell 1 20,alignx right");
		
		lPrecioTarifas = new JLabel("15.00");
		panel_7.add(lPrecioTarifas, "cell 2 20");
		
		lblNewLabel_42 = new JLabel("€");
		panel_7.add(lblNewLabel_42, "cell 3 20");
		
		bRegistrarEnvio = new JButton("Registrar envío");
		panel_7.add(bRegistrarEnvio, "cell 0 21 10 1,growx");

		this.dispose();
	}
	
	public RegistrarEnvioView(View parent) {
		this();
		this.initParent(parent);
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
	public JSpinner getSAnchuraXPaquete() {
		return sAnchuraXPaquete;
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
	public SearchTableComponent<TransportistaVechiculoDTO> getStcTransportistaVehiculo() {
		return stcTransportistaVehiculo;
	}
	public JLabel getLConfEstadoNombreRemitente() {
		return lConfEstadoNombreRemitente;
	}
	public JLabel getLConfEstadoTipoRemitente() {
		return lConfEstadoTipoRemitente;
	}
	public JLabel getLConfEstadoEmailRemitente() {
		return lConfEstadoEmailRemitente;
	}
	public JLabel getLConfEstadoDireccionRemitente() {
		return lConfEstadoDireccionRemitente;
	}
	public JLabel getLConfDatosEmailRemitente() {
		return lConfDatosEmailRemitente;
	}
	public JLabel getLConfDatosDireccionRemitente() {
		return lConfDatosDireccionRemitente;
	}
	public JLabel getLConfDatosNombreRemitente() {
		return lConfDatosNombreRemitente;
	}
	public JLabel getLConfDatosTipoRemitente() {
		return lConfDatosTipoRemitente;
	}
	public JLabel getLConfEstadoNombreDestinatario() {
		return lConfEstadoNombreDestinatario;
	}
	public JLabel getLConfDatosNombreDestinatario() {
		return lConfDatosNombreDestinatario;
	}
	public JLabel getLConfDatosEmailDestinatario() {
		return lConfDatosEmailDestinatario;
	}
	public JLabel getLConfEstadoDireccionDestinatario() {
		return lConfEstadoDireccionDestinatario;
	}
	public JLabel getLConfDatosDireccionDestinatario() {
		return lConfDatosDireccionDestinatario;
	}
	public JLabel getLConfEstadoEmailDestinatario() {
		return lConfEstadoEmailDestinatario;
	}
	public JLabel getLConfEstadoTipoDestinatario() {
		return lConfEstadoTipoDestinatario;
	}
	public JLabel getLConfDatosTipoDestinatario() {
		return lConfDatosTipoDestinatario;
	}
	public JLabel getLConfEstadoCiudadOrigen() {
		return lConfEstadoCiudadOrigen;
	}
	public JLabel getLConfDatosDireccionOrigen() {
		return lConfDatosDireccionOrigen;
	}
	public JLabel getLConfDatosCiudadDestino() {
		return lConfDatosCiudadDestino;
	}
	public JLabel getLConfDatosNombreDestino() {
		return lConfDatosNombreDestino;
	}
	public JLabel getLConfEstadoDireccionOrigen() {
		return lConfEstadoDireccionOrigen;
	}
	public JLabel getLConfDatosDireccionDestino() {
		return lConfDatosDireccionDestino;
	}
	public JLabel getLConfEstadoCiudadDestino() {
		return lConfEstadoCiudadDestino;
	}
	public JLabel getLConfDatosNombreOrigen() {
		return lConfDatosNombreOrigen;
	}
	public JLabel getLConfEstadoDireccionDestino() {
		return lConfEstadoDireccionDestino;
	}
	public JLabel getLConfEstadoNombreDestino() {
		return lConfEstadoNombreDestino;
	}
	public JLabel getLConfDatosCiudadOrigen() {
		return lConfDatosCiudadOrigen;
	}
	public JLabel getLConfEstadoNombreOrigen() {
		return lConfEstadoNombreOrigen;
	}
	public JLabel getLConfEstadoAnchuraY() {
		return lConfEstadoAnchuraY;
	}
	public JLabel getLConfDatosAnchuraY() {
		return lConfDatosAnchuraY;
	}
	public JLabel getLConfDatosPeso() {
		return lConfDatosPeso;
	}
	public JLabel getLConfEstadoAltura() {
		return lConfEstadoAltura;
	}
	public JLabel getLConfDatosAltura() {
		return lConfDatosAltura;
	}
	public JLabel getLConfEstadoAnchuraX() {
		return lConfEstadoAnchuraX;
	}
	public JLabel getLConfDatosAnchuraX() {
		return lConfDatosAnchuraX;
	}
	public JLabel getLConfEstadoPeso() {
		return lConfEstadoPeso;
	}
	public JLabel getLConfDatosTarifas() {
		return lConfDatosTarifas;
	}
	public JLabel getLConfEstadoTarifas() {
		return lConfEstadoTarifas;
	}
	public JTable getTTarifasSeleccionadas() {
		return tTarifasSeleccionadas;
	}
	public JLabel getLPrecioTarifas() {
		return lPrecioTarifas;
	}
	public JLabel getLConfDatosCapacidadVehiculoTransportista() {
		return lConfDatosCapacidadVehiculoTransportista;
	}
	public JLabel getLConfDatosTipoVehiculoTransportista() {
		return lConfDatosTipoVehiculoTransportista;
	}
	public JLabel getLConfDatosEmailTransportista() {
		return lConfDatosEmailTransportista;
	}
	public JLabel getLConfEstadoEmailTransportista() {
		return lConfEstadoEmailTransportista;
	}
	public JLabel getLConfDatosNombreTransportista() {
		return lConfDatosNombreTransportista;
	}
	public JLabel getLConfEstadoTipoVehiculoTransportista() {
		return lConfEstadoTipoVehiculoTransportista;
	}
	public JLabel getLConfEstadoCapacidadVehiculoTransportista() {
		return lConfEstadoCapacidadVehiculoTransportista;
	}
	public JLabel getLConfEstadoNombreTransportista() {
		return lConfEstadoNombreTransportista;
	}
	public JButton getBRegistrarEnvio() {
		return bRegistrarEnvio;
	}
	public JLabel getLMensajeErrorConfirmacion() {
		return lMensajeErrorConfirmacion;
	}
}
