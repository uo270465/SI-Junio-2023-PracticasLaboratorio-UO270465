package giitin.uo270465.si.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.dto.TransportistaVechiculoDTO;
import giitin.uo270465.si.model.RegistrarEnvioModel;
import giitin.uo270465.si.view.RegistrarEnvioView;

public class RegistrarEnvioController extends Controller<RegistrarEnvioModel, RegistrarEnvioView> {

	// Constantes generales

	final String INVALIDO = "INVÁLIDO";
	final String VALIDO = "VÁLIDO";

	final Color C_INVALIDO = Color.RED;
	final Color C_VALIDO = Color.BLUE;

	private final String NO_TT = "";
	private final String NO_DATOS = "";
	private final String GUION_DATOS = "-----";

	// Constantes: Cliente

	private final String TT_CLIENTE_NO_MODO = "Debes seleccionar 'Nuevo Cliente' o 'Cliente Existente'.";
	private final String TT_CLIENTE_NO_SELECCION = "No se ha seleccionado ningún cliente";
	private final String TT_CLIENTE_NO_NOMBRE = "El campo 'Nombre' no puede estar vacío.";
	private final String TT_CLIENTE_NO_EMAIL = "El campo 'Email' no puede estar vacío.";
	private final String TT_CLIENTE_INVALID_EMAIL = "El campo 'Email' contiene un formato inválido. El formato del email debe ser similar a: 'email@domain.tld'.";
	private final String TT_CLIENTE_TAKEN_EMAIL = "El email elegido ya está en uso.";
	private final String TT_CLIENTE_NO_DIRECCION = "El campo 'Dirección' no puede estar vacío.";
	private final String TT_CLIENTE_REMITENTE_IGUAL_DESTINATARIO = "El remitente no puede ser el mismo que el destinatario.";

	private final String DATOS_CLIENTE_NO_SELECCION = "No seleccionado";
	private final String DATOS_CLIENTE_NUEVO = "Nuevo Cliente";
	private final String DATOS_CLIENTE_EXISTENTE = "Cliente Existente";

	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	// Constantes: AlmacenOficina

	private final String TT_ALMACENOFICINA_NO_SELECCION = "No se ha seleccionado ningún almacen u oficina.";
	private final String TT_ALMACENOFICINA_ORGEN_IGUAL_DESTINO = "El almacen u oficina de origen no puede igual al destino.";

	// Constantes: Detalles

	private final String TT_DETALLES_NO_ALTURA = "La altura del paquete tiene que ser mayor que 0.";
	private final String TT_DETALLES_NO_ANCHURA = "La anchura del paquete tiene que ser mayor que 0.";
	private final String TT_DETALLES_NO_PESO = "El peso del paquete tiene que ser mayor o igual que 10 gramos.";
	private final String TT_DETALLES_NO_TARIFAS = "Debes seleccionar al menos una tarifa para el envío.";

	// Constantes: Transporte

	private final String TT_TRANSPORTE_NO_TRANSPORTISTA = "Debes seleccionar un transportista.";

	// Datos: Remitente

	private boolean nuevoClienteRemitenteMode;
	private boolean clienteExistenteRemitenteMode;
	private String datosTipoRemitente;
	private String datosNombreRemitente;
	private String datosEmailRemitente;
	private String datosDireccionRemitente;
	private ClienteDTO clienteRemitente;

	// Datos: Destinatario

	private boolean nuevoClienteDestinatarioMode;
	private boolean clienteExistenteDestinatarioMode;
	private String datosTipoDestinatario;
	private String datosNombreDestinatario;
	private String datosEmailDestinatario;
	private String datosDireccionDestinatario;
	private ClienteDTO clienteDestinatario;

	// Datos: Origen

	private String datosNombreOrigen;
	private String datosDireccionOrigen;
	private String datosCiudadOrigen;
	private AlmacenOficinaDTO almacenOficinaOrigen;

	// Datos: Destino

	private String datosNombreDestino;
	private String datosDireccionDestino;
	private String datosCiudadDestino;
	private AlmacenOficinaDTO almacenOficinaDestino;

	// Datos: Detalles

	private int datosAltura;
	private int datosAnchuraX;
	private int datosAnchuraY;
	private int datosPeso;
	private List<TarifaDTO> datosTatifas;

	// Datos: Transporte

	private TransportistaVechiculoDTO transportistaVehiculo;
	private String datosNombreTransportista;
	private String datosEmailTransportista;
	private String datosTipoVechiculoTransportista;
	private double datosCapacidadVechiculoTransportista;

	private boolean datosCorrectos;

	public RegistrarEnvioController(Date fecha) {
		super(new RegistrarEnvioModel(), new RegistrarEnvioView(), fecha);
		datosCorrectos = false;
	}

	@Override
	public void initController() {

		// General:

		view.getTpRegistrarEnvio().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (view.getTpRegistrarEnvio().getSelectedIndex() == view.getTpRegistrarEnvio().getTabCount() - 1) {
					datosCorrectos = ComprobarRegistrarEnvio();
				}
				updateView();
			}
		});

		// Tab: Remitente
		view.getTbNuevoClienteRemitenteMode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectClientesRemitentesMode(0);
			}
		});

		view.getTbClienteExistenteRemitenteMode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectClientesRemitentesMode(1);
			}
		});

		// Tab: Destinatario

		view.getTbNuevoClienteDestinatarioMode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectClientesDestinatariosMode(0);
			}
		});

		view.getTbClienteExistenteDestinatarioMode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectClientesDestinatariosMode(1);
			}
		});

		// Tab: Origen

		// No se realiza nada para esta pestaña

		// Tab: Destino

		view.getCbEnviarDestinatarioDestino().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				view.getStcAlmacenOficinaDestino().setEnabled(!view.getCbEnviarDestinatarioDestino().isSelected());

			}
		});

		view.getBRegistrarEnvio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String seguimiento = RegistrarEnvio();
				JOptionPane.showMessageDialog(null, "<html><center>Envío registrado con exito.<br>"
						+ "Nº de seguimiento:    " + seguimiento + "</center></html>");

			}
		});
	}

	@Override
	public void initView() {

		// Tab: Remitente
		view.getStcClientesRemitentes().newTable(model.getClientes());

		// Tab: Destinantario
		view.getStcClientesDestinatarios().newTable(model.getClientes());

		// Tab: Origen
		view.getStcAlmacenOficinaOrigen().newTable(model.getAlmacenesOficinas());

		// Tab: Destino
		view.getStcAlmacenOficinaDestino().newTable(model.getAlmacenesOficinas());

		// Tab: Detalles
		view.getStcTarifa().newTable(model.getTarifas());

		// Tab: Transporte
		view.getStcTransportistaVehiculo().newTable(model.getTransportistasVehiculos());

	}

	public void selectClientesRemitentesMode(int mode) {
		boolean nuevoCliente = true;
		boolean clienteExistente = false;
		if (mode != 0) {
			nuevoCliente = !nuevoCliente;
			clienteExistente = !clienteExistente;
		}

		view.getTbNuevoClienteRemitenteMode().setSelected(nuevoCliente);
		view.getTbClienteExistenteRemitenteMode().setSelected(clienteExistente);

		view.getTfNombreRemitente().setEnabled(nuevoCliente);
		view.getTfEmailRemitente().setEnabled(nuevoCliente);
		view.getTfDireccionRemitente().setEnabled(nuevoCliente);

		view.getStcClientesRemitentes().setEnabled(clienteExistente);
	}

	public void selectClientesDestinatariosMode(int mode) {
		boolean nuevoCliente = true;
		boolean clienteExistente = false;
		if (mode != 0) {
			nuevoCliente = !nuevoCliente;
			clienteExistente = !clienteExistente;
		}

		view.getTbNuevoClienteDestinatarioMode().setSelected(nuevoCliente);
		view.getTbClienteExistenteDestinatarioMode().setSelected(clienteExistente);

		view.getTfNombreDestinatario().setEnabled(nuevoCliente);
		view.getTfEmailDestinatario().setEnabled(nuevoCliente);
		view.getTfDireccionDestinatario().setEnabled(nuevoCliente);

		view.getStcClientesDestinatarios().setEnabled(clienteExistente);
	}

	public boolean updateConfDatosEstado(JLabel lDatos, JLabel lEstado, String estado, String tooltip) {
		lDatos.setText(estado);
		lEstado.setText((tooltip.isEmpty() ? VALIDO : INVALIDO));
		lEstado.setForeground((tooltip.isEmpty() ? C_VALIDO : C_INVALIDO));
		if (tooltip.isEmpty()) {
			lEstado.setToolTipText(null);
			return true;
		} else {
			lEstado.setToolTipText(tooltip);
			return false;
		}
	}

	public boolean updateConfDatosEstado(JLabel lDatos, JLabel lEstado, String estado) {
		return updateConfDatosEstado(lDatos, lEstado, estado, "");
	}

	public boolean ComprobarRegistrarEnvio() {
		boolean b = true;

		b &= ComprobarRemitente();
		b &= ComprobarDestinatario();
		b &= ComprobarOrigen();
		b &= ComprobarDestino();
		b &= comprobarDetalles();
		b &= comprobarTransporte();

		view.getLMensajeErrorConfirmacion().setVisible(!b);
		view.getBRegistrarEnvio().setEnabled(b);

		return b;
	}

	public boolean ComprobarRemitente() {
		boolean b = true;

		nuevoClienteRemitenteMode = view.getTbNuevoClienteRemitenteMode().isSelected();
		clienteExistenteRemitenteMode = view.getTbClienteExistenteRemitenteMode().isSelected();
		datosTipoRemitente = DATOS_CLIENTE_NO_SELECCION;
		datosNombreRemitente = NO_DATOS;
		datosEmailRemitente = NO_DATOS;
		datosDireccionRemitente = NO_DATOS;
		clienteRemitente = view.getStcClientesRemitentes().getSelectedDTO();

		String ttTipoRemitente = TT_CLIENTE_NO_MODO;
		String ttNombreRemitente = TT_CLIENTE_NO_MODO;
		String ttEmailRemitente = TT_CLIENTE_NO_MODO;
		String ttDireccionRemitente = TT_CLIENTE_NO_MODO;

		if (nuevoClienteRemitenteMode) {
			datosTipoRemitente = DATOS_CLIENTE_NUEVO;
			ttTipoRemitente = NO_TT;
			datosNombreRemitente = view.getTfNombreRemitente().getText();
			if (datosNombreRemitente.isBlank()) {
				ttNombreRemitente = TT_CLIENTE_NO_NOMBRE;
			} else {
				ttNombreRemitente = NO_TT;
			}
			datosEmailRemitente = view.getTfEmailRemitente().getText();
			if (datosEmailRemitente.isBlank()) {
				ttEmailRemitente = TT_CLIENTE_NO_EMAIL;
			} else if (!PATTERN.matcher(datosEmailRemitente).matches()) {
				ttEmailRemitente = TT_CLIENTE_INVALID_EMAIL;
			} else if (model.isEmailTaken(datosEmailRemitente)) {
				ttEmailRemitente = TT_CLIENTE_TAKEN_EMAIL;
			} else {
				ttEmailRemitente = NO_TT;
			}

			datosDireccionRemitente = view.getTfDireccionRemitente().getText();
			if (datosDireccionRemitente.isBlank()) {
				ttDireccionRemitente = TT_CLIENTE_NO_DIRECCION;
			} else {
				ttDireccionRemitente = NO_TT;
			}
		} else if (clienteExistenteRemitenteMode) {
			datosTipoRemitente = DATOS_CLIENTE_EXISTENTE;
			ttTipoRemitente = NO_TT;
			if (clienteRemitente == null) {
				ttTipoRemitente = TT_CLIENTE_NO_SELECCION;
				ttNombreRemitente = TT_CLIENTE_NO_SELECCION;
				ttEmailRemitente = TT_CLIENTE_NO_SELECCION;
				ttDireccionRemitente = TT_CLIENTE_NO_SELECCION;
				datosNombreRemitente = NO_DATOS;
				datosEmailRemitente = NO_DATOS;
				datosEmailRemitente = NO_DATOS;
			} else {
				ttTipoRemitente = NO_DATOS;
				ttNombreRemitente = NO_DATOS;
				ttEmailRemitente = NO_DATOS;
				ttDireccionRemitente = NO_DATOS;
				datosNombreRemitente = clienteRemitente.getNombre();
				datosEmailRemitente = clienteRemitente.getEmail();
				datosDireccionRemitente = clienteRemitente.getDireccion();
			}
		}

		b &= updateConfDatosEstado(view.getLConfDatosTipoRemitente(), view.getLConfEstadoTipoRemitente(),
				datosTipoRemitente, ttTipoRemitente);
		b &= updateConfDatosEstado(view.getLConfDatosNombreRemitente(), view.getLConfEstadoNombreRemitente(),
				datosNombreRemitente, ttNombreRemitente);
		b &= updateConfDatosEstado(view.getLConfDatosEmailRemitente(), view.getLConfEstadoEmailRemitente(),
				datosEmailRemitente, ttEmailRemitente);
		b &= updateConfDatosEstado(view.getLConfDatosDireccionRemitente(), view.getLConfEstadoDireccionRemitente(),
				datosDireccionRemitente, ttDireccionRemitente);

		return b;
	}

	public boolean ComprobarDestinatario() {
		boolean b = true;

		nuevoClienteDestinatarioMode = view.getTbNuevoClienteDestinatarioMode().isSelected();
		clienteExistenteDestinatarioMode = view.getTbClienteExistenteDestinatarioMode().isSelected();
		datosTipoDestinatario = DATOS_CLIENTE_NO_SELECCION;
		datosNombreDestinatario = NO_DATOS;
		datosEmailDestinatario = NO_DATOS;
		datosDireccionDestinatario = NO_DATOS;
		clienteDestinatario = view.getStcClientesDestinatarios().getSelectedDTO();

		String ttTipoDestinatario = TT_CLIENTE_NO_MODO;
		String ttNombreDestinatario = TT_CLIENTE_NO_MODO;
		String ttEmailDestinatario = TT_CLIENTE_NO_MODO;
		String ttDireccionDestinatario = TT_CLIENTE_NO_MODO;

		if (nuevoClienteDestinatarioMode) {
			datosTipoDestinatario = DATOS_CLIENTE_NUEVO;
			ttTipoDestinatario = NO_TT;
			datosNombreDestinatario = view.getTfNombreDestinatario().getText();
			if (datosNombreDestinatario.isBlank()) {
				ttNombreDestinatario = TT_CLIENTE_NO_NOMBRE;
			} else {
				ttNombreDestinatario = NO_TT;
			}
			datosEmailDestinatario = view.getTfEmailDestinatario().getText();
			if (datosEmailDestinatario.isBlank()) {
				ttEmailDestinatario = TT_CLIENTE_NO_EMAIL;
			} else if (!PATTERN.matcher(datosEmailDestinatario).matches()) {
				ttEmailDestinatario = TT_CLIENTE_INVALID_EMAIL;
			} else if (model.isEmailTaken(datosEmailDestinatario)
					|| datosEmailDestinatario.equals(datosEmailRemitente)) {
				ttEmailDestinatario = TT_CLIENTE_TAKEN_EMAIL;
			} else {
				ttEmailDestinatario = NO_TT;
			}

			datosDireccionDestinatario = view.getTfDireccionDestinatario().getText();
			if (datosDireccionDestinatario.isBlank()) {
				ttDireccionDestinatario = TT_CLIENTE_NO_DIRECCION;
			} else {
				ttDireccionDestinatario = NO_TT;
			}
		} else if (clienteExistenteDestinatarioMode) {
			datosTipoDestinatario = DATOS_CLIENTE_EXISTENTE;
			ttTipoDestinatario = NO_TT;
			if (clienteDestinatario == null) {
				ttTipoDestinatario = TT_CLIENTE_NO_SELECCION;
				ttNombreDestinatario = TT_CLIENTE_NO_SELECCION;
				ttEmailDestinatario = TT_CLIENTE_NO_SELECCION;
				ttDireccionDestinatario = TT_CLIENTE_NO_SELECCION;
				datosNombreDestinatario = NO_DATOS;
				datosEmailDestinatario = NO_DATOS;
				datosEmailDestinatario = NO_DATOS;
			} else {
				if (clienteRemitente != null && clienteDestinatario.getClienteId() == clienteRemitente.getClienteId()) {
					ttTipoDestinatario = TT_CLIENTE_REMITENTE_IGUAL_DESTINATARIO;
					ttNombreDestinatario = TT_CLIENTE_REMITENTE_IGUAL_DESTINATARIO;
					ttEmailDestinatario = TT_CLIENTE_REMITENTE_IGUAL_DESTINATARIO;
					ttDireccionDestinatario = TT_CLIENTE_REMITENTE_IGUAL_DESTINATARIO;
				} else {
					ttTipoDestinatario = NO_TT;
					ttNombreDestinatario = NO_TT;
					ttEmailDestinatario = NO_TT;
					ttDireccionDestinatario = NO_TT;
				}

				datosNombreDestinatario = clienteDestinatario.getNombre();
				datosEmailDestinatario = clienteDestinatario.getEmail();
				datosDireccionDestinatario = clienteDestinatario.getDireccion();

			}
		}

		b &= updateConfDatosEstado(view.getLConfDatosTipoDestinatario(), view.getLConfEstadoTipoDestinatario(),
				datosTipoDestinatario, ttTipoDestinatario);
		b &= updateConfDatosEstado(view.getLConfDatosNombreDestinatario(), view.getLConfEstadoNombreDestinatario(),
				datosNombreDestinatario, ttNombreDestinatario);
		b &= updateConfDatosEstado(view.getLConfDatosEmailDestinatario(), view.getLConfEstadoEmailDestinatario(),
				datosEmailDestinatario, ttEmailDestinatario);
		b &= updateConfDatosEstado(view.getLConfDatosDireccionDestinatario(),
				view.getLConfEstadoDireccionDestinatario(), datosDireccionDestinatario, ttDireccionDestinatario);

		return b;
	}

	public boolean ComprobarOrigen() {
		boolean b = true;

		almacenOficinaOrigen = view.getStcAlmacenOficinaOrigen().getSelectedDTO();

		datosNombreOrigen = NO_DATOS;
		datosDireccionOrigen = NO_DATOS;
		datosCiudadOrigen = NO_DATOS;

		String ttNombreOrigen = TT_ALMACENOFICINA_NO_SELECCION;
		String ttDireccionOrigen = TT_ALMACENOFICINA_NO_SELECCION;
		String ttCiudadOrigen = TT_ALMACENOFICINA_NO_SELECCION;

		if (almacenOficinaOrigen != null) {
			datosNombreOrigen = almacenOficinaOrigen.getNombre();
			datosDireccionOrigen = almacenOficinaOrigen.getDireccion();
			datosCiudadOrigen = almacenOficinaOrigen.getCiudad();

			ttNombreOrigen = NO_TT;
			ttDireccionOrigen = NO_TT;
			ttCiudadOrigen = NO_TT;
		}

		// TODO: Añadir método updateConfDatosEstado
		b &= updateConfDatosEstado(view.getLConfDatosNombreOrigen(), view.getLConfEstadoNombreOrigen(),
				datosNombreOrigen, ttNombreOrigen);
		b &= updateConfDatosEstado(view.getLConfDatosDireccionOrigen(), view.getLConfEstadoDireccionOrigen(),
				datosDireccionOrigen, ttDireccionOrigen);
		b &= updateConfDatosEstado(view.getLConfDatosCiudadOrigen(), view.getLConfEstadoCiudadOrigen(),
				datosCiudadOrigen, ttCiudadOrigen);
		return b;
	}

	public boolean ComprobarDestino() {
		boolean b = true;

		almacenOficinaDestino = view.getStcAlmacenOficinaDestino().getSelectedDTO();

		datosNombreDestino = NO_DATOS;
		datosDireccionDestino = NO_DATOS;
		datosCiudadDestino = NO_DATOS;

		String ttNombreDestino = TT_ALMACENOFICINA_NO_SELECCION;
		String ttDireccionDestino = TT_ALMACENOFICINA_NO_SELECCION;
		String ttCiudadDestino = TT_ALMACENOFICINA_NO_SELECCION;

		if (view.getCbEnviarDestinatarioDestino().isSelected()) {
			datosNombreDestino = GUION_DATOS;
			datosDireccionDestino = datosDireccionDestinatario;
			datosCiudadDestino = GUION_DATOS;

			ttNombreDestino = NO_TT;
			ttDireccionDestino = (datosDireccionDestinatario.isBlank() ? TT_CLIENTE_NO_DIRECCION : NO_TT);
			ttCiudadDestino = NO_TT;
		} else if (almacenOficinaDestino != null) {
			datosNombreDestino = almacenOficinaDestino.getNombre();
			datosDireccionDestino = almacenOficinaDestino.getDireccion();
			datosCiudadDestino = almacenOficinaDestino.getCiudad();

			if (almacenOficinaDestino.getAlmacenesOficinasId() == almacenOficinaOrigen.getAlmacenesOficinasId()) {
				ttNombreDestino = TT_ALMACENOFICINA_ORGEN_IGUAL_DESTINO;
				ttDireccionDestino = TT_ALMACENOFICINA_ORGEN_IGUAL_DESTINO;
				ttCiudadDestino = TT_ALMACENOFICINA_ORGEN_IGUAL_DESTINO;
			} else {
				ttNombreDestino = NO_TT;
				ttDireccionDestino = NO_TT;
				ttCiudadDestino = NO_TT;
			}
		}

		// TODO: Añadir método updateConfDatosEstado
		b &= updateConfDatosEstado(view.getLConfDatosNombreDestino(), view.getLConfEstadoNombreDestino(),
				datosNombreDestino, ttNombreDestino);
		b &= updateConfDatosEstado(view.getLConfDatosDireccionDestino(), view.getLConfEstadoDireccionDestino(),
				datosDireccionDestino, ttDireccionDestino);
		b &= updateConfDatosEstado(view.getLConfDatosCiudadDestino(), view.getLConfEstadoCiudadDestino(),
				datosCiudadDestino, ttCiudadDestino);
		return b;
	}

	public boolean comprobarDetalles() {
		boolean b = true;

		datosAltura = (int) view.getSAlturaPaquete().getValue();
		datosAnchuraX = (int) view.getSAnchuraXPaquete().getValue();
		datosAnchuraY = (int) view.getSAnchuraYPaquete().getValue();
		datosPeso = (int) view.getSPesoPaquete().getValue();
		datosTatifas = view.getStcTarifa().getSelectedDTOs();

		String ttAltura = (datosAltura > 0 ? NO_TT : TT_DETALLES_NO_ALTURA);
		String ttAnchuraX = (datosAnchuraX > 0 ? NO_TT : TT_DETALLES_NO_ANCHURA);
		String ttAnchuraY = (datosAnchuraY > 0 ? NO_TT : TT_DETALLES_NO_ANCHURA);
		String ttPeso = (datosPeso >= 10 ? NO_TT : TT_DETALLES_NO_PESO);
		String ttTarifas = (datosTatifas.size() > 0 ? NO_TT : TT_DETALLES_NO_TARIFAS);

		b &= updateConfDatosEstado(view.getLConfDatosAltura(), view.getLConfEstadoAltura(),
				String.format("%d", datosAltura), ttAltura);
		b &= updateConfDatosEstado(view.getLConfDatosAnchuraX(), view.getLConfEstadoAnchuraX(),
				String.format("%d", datosAnchuraX), ttAnchuraX);
		b &= updateConfDatosEstado(view.getLConfDatosAnchuraY(), view.getLConfEstadoAnchuraY(),
				String.format("%d", datosAnchuraY), ttAnchuraY);
		b &= updateConfDatosEstado(view.getLConfDatosPeso(), view.getLConfEstadoPeso(), String.format("%d", datosPeso),
				ttPeso);

		b &= updateConfDatosEstado(view.getLConfDatosTarifas(), view.getLConfEstadoTarifas(), "", ttTarifas);
		JTable tTarifas = view.getTTarifasSeleccionadas();
		double totalTarifas = 0;
		while (tTarifas.getRowCount() > 0)
			((DefaultTableModel) tTarifas.getModel()).removeRow(0);
		for (TarifaDTO tarifa : datosTatifas) {
			((DefaultTableModel) tTarifas.getModel())
					.addRow(new Object[] { tarifa.getConcepto(), String.format("%.2f", tarifa.getPrecio()) });
			totalTarifas += tarifa.getPrecio();
		}
		view.getLPrecioTarifas().setText(String.format("%.2f", totalTarifas));
		return b;
	}

	public boolean comprobarTransporte() {
		boolean b = true;

		transportistaVehiculo = view.getStcTransportistaVehiculo().getSelectedDTO();

		String ttTransporte = (transportistaVehiculo == null ? TT_TRANSPORTE_NO_TRANSPORTISTA : NO_TT);
		datosNombreTransportista = "";
		datosEmailTransportista = "";
		datosTipoVechiculoTransportista = "";
		datosCapacidadVechiculoTransportista = 0.0;

		if (transportistaVehiculo != null) {
			datosNombreTransportista = transportistaVehiculo.getNombre();
			datosEmailTransportista = transportistaVehiculo.getEmail();
			datosTipoVechiculoTransportista = transportistaVehiculo.getTipo();
			datosCapacidadVechiculoTransportista = transportistaVehiculo.getCapacidad();
		}

		b &= updateConfDatosEstado(view.getLConfDatosNombreTransportista(), view.getLConfEstadoNombreTransportista(),
				datosNombreTransportista, ttTransporte);
		b &= updateConfDatosEstado(view.getLConfDatosEmailTransportista(), view.getLConfEstadoEmailTransportista(),
				datosEmailTransportista, ttTransporte);
		b &= updateConfDatosEstado(view.getLConfDatosTipoVehiculoTransportista(),
				view.getLConfEstadoTipoVehiculoTransportista(), datosTipoVechiculoTransportista, ttTransporte);
		b &= updateConfDatosEstado(view.getLConfDatosCapacidadVehiculoTransportista(),
				view.getLConfEstadoCapacidadVehiculoTransportista(),
				String.format("%.2f", datosCapacidadVechiculoTransportista), ttTransporte);

		return b;
	}

	public String RegistrarEnvio() {
		if (!datosCorrectos)
			return "Error";

		int idRemitente;
		if (nuevoClienteRemitenteMode) {
			model.addCliente(datosNombreRemitente, datosEmailRemitente, datosDireccionRemitente);
			idRemitente = model.getClienteByEmail(datosEmailRemitente).getClienteId();
		} else {
			idRemitente = clienteRemitente.getClienteId();
		}

		int idDestinatario;
		if (nuevoClienteDestinatarioMode) {
			model.addCliente(datosNombreDestinatario, datosEmailDestinatario, datosDireccionDestinatario);
			idDestinatario = model.getClienteByEmail(datosEmailDestinatario).getClienteId();
		} else {
			idDestinatario = clienteDestinatario.getClienteId();
		}

		String seguimiento = model.addEnvio(idRemitente, idDestinatario, almacenOficinaOrigen.getAlmacenesOficinasId(),
				(view.getCbEnviarDestinatarioDestino().isSelected() ? -1
						: almacenOficinaDestino.getAlmacenesOficinasId()),
				this.fecha, datosPeso, String.format("%dx%dx%d", datosAltura, datosAnchuraX, datosAnchuraY),
				"Pendiente", transportistaVehiculo.getTransportistaId());

		for (TarifaDTO tarifa : datosTatifas) {
			model.addEnvioTarfa(seguimiento, tarifa.getTarifaId());
		}
		return seguimiento;
	}
}
