package giitin.uo270465.si.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.model.RegistrarEnvioModel;
import giitin.uo270465.si.util.UnexpectedException;
import giitin.uo270465.si.view.RegistrarEnvioView;

public class RegistrarEnvioController extends Controller<RegistrarEnvioModel, RegistrarEnvioView> {

	// Constantes generales

	final String INVALIDO = "inválido";
	final String VALIDO = "válido";

	final Color C_INVALIDO = Color.RED;
	final Color C_VALIDO = Color.BLUE;

	private final String NO_TT = "";
	private final String NO_DATOS = "";

	// Constantes: Cliente

	private final String TT_CLIENTE_NO_MODO = "Debes seleccionar 'Nuevo Cliente' o 'Cliente Existente'.";
	private final String TT_CLIENTE_NO_SELECCION = "No se ha seleccionado ningún cliente";
	private final String TT_CLIENTE_NO_NOMBRE = "El campo 'Nombre' no puede estar vacío.";
	private final String TT_CLIENTE_NO_EMAIL = "El campo 'Email' no puede estar vacío.";
	private final String TT_CLIENTE_INVALID_EMAIL = "El campo 'Email' contiene un formato inválido. El formato del email debe ser similar a: 'email@domain.tld'";
	private final String TT_CLIENTE_TAKEN_EMAIL = "El email elegido ya está en uso";
	private final String TT_CLIENTE_NO_DIRECCION = "El campo 'Dirección' no puede estar vacío";

	private final String DATOS_CLIENTE_NO_SELECCION = "No seleccionado";
	private final String DATOS_CLIENTE_NUEVO = "Nuevo Cliente";
	private final String DATOS_CLIENTE_EXISTENTE = "Cliente Existente";

	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	// Constantes: AlmacenOficina

	private boolean nuevoClienteRemitenteMode;
	private boolean clienteExistenteRemitenteMode;
	private String datosTipoRemitente;
	private String datosNombreRemitente;
	private String datosEmailRemitente;
	private String datosDireccionRemitente;
	private ClienteDTO clienteRemitente;

	public RegistrarEnvioController(Date fecha) {
		super(new RegistrarEnvioModel(), new RegistrarEnvioView(), fecha);
	}

	@Override
	public void initController() {

		// General:

		view.getTpRegistrarEnvio().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (view.getTpRegistrarEnvio().getSelectedIndex() == view.getTpRegistrarEnvio().getTabCount() - 1) {
					ComprobarRegistrarEnvio();
				}
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
		clienteRemitente = null;
		
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
			clienteRemitente = view.getStcClientesRemitentes().getSelectedDTO();
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
}
