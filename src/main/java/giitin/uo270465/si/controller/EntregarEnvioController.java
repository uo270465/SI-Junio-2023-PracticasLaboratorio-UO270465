package giitin.uo270465.si.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.model.EntregarEnvioModel;
import giitin.uo270465.si.view.EntregarEnvioView;

public class EntregarEnvioController extends Controller<EntregarEnvioModel, EntregarEnvioView> {

	private List<EnvioDTO> enviosOficinaAlmacen;
	private List<EnvioDTO> enviosDirDestinatario;
	private EnvioDTO envioSeleccionado;

	public EntregarEnvioController(View parent, Date fecha) {
		super(new EntregarEnvioModel(), new EntregarEnvioView(parent), fecha);
		enviosOficinaAlmacen = model.getEnviosOficinaAlmacen();
		enviosDirDestinatario = model.getEnviosDirDestinatario();
	}

	@Override
	public void initController() {
		view.getRbAlmacenOficina().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getRbAlmacenOficina().setSelected(true);
				view.getRbDirDestinatario().setSelected(false);
				view.getStcEnvios().newTable(enviosOficinaAlmacen);
				updateInfo();
			}
		});

		view.getRbDirDestinatario().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getRbDirDestinatario().setSelected(true);
				view.getRbAlmacenOficina().setSelected(false);
				view.getStcEnvios().newTable(enviosDirDestinatario);
				updateInfo();
			}
		});

		view.getBBorrarFirmaRepartidor().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPFirnaRepartidor().clear();
			}
		});

		view.getBBorrarFirmaDestinatario().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPFirmaDestinatario().clear();
			}
		});

		view.getStcEnvios().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateInfo();
			}
		});

		view.getBEntregarEnvio().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.updateEnvio(envioSeleccionado.getEnvioId(), fecha);
				JOptionPane.showInternalMessageDialog(null, "El envío ha sido entregado correctamente");
				view.dispose();
			}
		});
	}

	@Override
	public void initView() {
		updateInfo();

	}

	public void updateInfo() {
		envioSeleccionado = view.getStcEnvios().getSelectedDTO();
		if (envioSeleccionado != null) {
			ClienteDTO remitente = model.getClienteById(envioSeleccionado.getRemitenteId());
			ClienteDTO destinatario = model.getClienteById(envioSeleccionado.getRemitenteId());
			view.getLNombreRemitente().setText(remitente.getNombre());
			view.getLEmailRemitente().setText(remitente.getEmail());
			view.getLNombreDestinatario().setText(destinatario.getNombre());
			view.getLEmailDestinatario().setText(destinatario.getEmail());

			List<TarifaDTO> tarifas = model.getTafifasFromEnvio(envioSeleccionado.getEnvioId());
			double coste = 0.0;

			for (TarifaDTO tarifa : tarifas) {
				coste += tarifa.getPrecio();
			}

			view.getLCoste().setText(String.format("%.2f €", coste));

		} else {
			view.getLNombreRemitente().setText("-----");
			view.getLEmailRemitente().setText("-----");
			view.getLNombreDestinatario().setText("-----");
			view.getLEmailDestinatario().setText("-----");
			view.getLCoste().setText("-----");

		}

		view.getBEntregarEnvio().setEnabled(view.getStcEnvios().getSelectedDTO() != null);

		this.updateView();

	}



}
