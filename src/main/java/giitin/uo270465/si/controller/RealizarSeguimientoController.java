package giitin.uo270465.si.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.MovimientoDTO;
import giitin.uo270465.si.model.RealizarSeguimientoModel;
import giitin.uo270465.si.view.RealizarSeguimientoView;

public class RealizarSeguimientoController extends Controller<RealizarSeguimientoModel, RealizarSeguimientoView> {

	public RealizarSeguimientoController(View parent, Date fecha) {
		super(new RealizarSeguimientoModel(), new RealizarSeguimientoView(parent), fecha);

	}

	@Override
	public void initController() {
		view.getBBuscarEnvio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField lBuscarEnvio = view.getLBuscarEnvio();
				lBuscarEnvio.setText(lBuscarEnvio.getText().toUpperCase());

				EnvioDTO envio = model.getEnvioById(lBuscarEnvio.getText());

				if (envio == null) {
					JOptionPane.showInternalMessageDialog(null, "No se ha encontrado el envío especificado",
							"Envío no encontrado", JOptionPane.WARNING_MESSAGE);
				} else {
					showSeguimientoEnvio(envio);
					lBuscarEnvio.setText("");
				}
			}
		});
	}

	@Override
	public void initView() {
	}

	public void showSeguimientoEnvio(EnvioDTO envio) {
		view.getLInfoSeguimiento().setText(String.format("Mostrando segimiento para el pedido %s", envio.getEnvioId()));
		DefaultListModel<String> seguimientoListModel = ((DefaultListModel<String>) view.getLSeguimiento().getModel());
		List<String> detalles = new LinkedList<>();
		Map<Integer, AlmacenOficinaDTO> almacenesOficinasById = model.getMapAlmacenesOficinas();
		AlmacenOficinaDTO origenEnvio = almacenesOficinasById.get(envio.getOrigenId());
		detalles.add(String.format("[%s] Origen del envío: %s", envio.getFechaSolicitud(), origenEnvio.getNombre()));

		List<MovimientoDTO> movimientos = model.getMovimientosFromEnvio(envio.getEnvioId());

		for (MovimientoDTO movimiento : movimientos) {
			detalles.add(String.format("[%s] %s en %s", movimiento.getFechaHora(), movimiento.getEstado(),
					almacenesOficinasById.get(movimiento.getUbicacionId()).getNombre()));
		}

		String textoDestino = String.format("%sDestino del envío: %s",
				(envio.getFechaRecogida() == null ? "" : "[" + envio.getFechaRecogida() + "] "),
				(envio.getDestinoId() != null ? almacenesOficinasById.get(envio.getDestinoId()).getNombre()
						: model.getClienteById(envio.getDestinatarioId()).getDireccion()));

		if (envio.getFechaRecogida() == null) {

		}

		seguimientoListModel.clear();
		seguimientoListModel.addAll(detalles);
		seguimientoListModel.addElement(textoDestino);
		if (envio.getDestinoId() == almacenesOficinasById
				.get((movimientos.get(movimientos.size() - 1).getUbicacionId())).getAlmacenesOficinasId()
				&& envio.getFechaRecogida() == null) {
			seguimientoListModel.addElement("El envío está listo para su recogida");
		} else if (envio.getFechaRecogida() == null) {
			seguimientoListModel.addElement("El envío está en camino");
		} else {
			seguimientoListModel.addElement("El envío ha sido entregado");
		}
		this.updateView();
	}

}
