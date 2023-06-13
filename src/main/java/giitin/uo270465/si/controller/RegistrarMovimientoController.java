package giitin.uo270465.si.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.MovimientoDTO;
import giitin.uo270465.si.model.RegistrarMovimientoModel;
import giitin.uo270465.si.view.RegistrarMovimientoView;

public class RegistrarMovimientoController extends Controller<RegistrarMovimientoModel, RegistrarMovimientoView> {

	private MovimientoDTO ultimoMovimientoSeleccionado;

	public RegistrarMovimientoController(Date fecha) {
		super(new RegistrarMovimientoModel(), new RegistrarMovimientoView(), fecha);
	}

	@Override
	public void initView() {
		view.getStcEnvios().newTable(model.getEnvios());

		view.getStcAlmacenesOficinas().newTable(model.getAlmacenesOficinas());
	}

	@Override
	public void initController() {

		view.getRbEntrega().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getRbEntrega().setSelected(true);
				view.getRbRecogida().setSelected(false);
				updatViewDynamicData();
			}
		});

		view.getRbRecogida().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getRbRecogida().setSelected(true);
				view.getRbEntrega().setSelected(false);
				updatViewDynamicData();
			}
		});

		view.getStcEnvios().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				updatViewDynamicData();
			}
		});

		view.getBRegistrarMovimiento().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updatViewDynamicData();
				int comprobacion = comprobarRegistro();
				String mensajeError = "";
				switch (comprobacion) {
				case 1:
					mensajeError = "El envío selecciondado no se puede recoger porque ya que se encuentra en tránsito";
					break;
				case 2:
					mensajeError = "El envío seleccionado no se puede entregar ya que no ha sido recogido";
					break;
				case 3:
					mensajeError = "No se ha seleccionado ningún almacen u oficina";
					break;
				case 4:
					mensajeError = "No se puede entregar un envío en el lugar de recogida";
				}
				if (!mensajeError.isBlank()) {
					JOptionPane.showMessageDialog(null, String.format("%s", mensajeError),
							"Error al registrar movimiento", JOptionPane.ERROR_MESSAGE);
				} else {
					RegistrarMovimiento();
					JOptionPane.showMessageDialog(null, "Movimiento registrado con exito");
					view.dispose();
				}
			}
		});

	}

	public void updatViewDynamicData() {
		boolean bEntrega = view.getRbEntrega().isSelected();
		view.getLAlmacenOficinaInfo().setForeground(bEntrega ? Color.BLACK : Color.GRAY);
		view.getStcAlmacenesOficinas().setEnabled(bEntrega);
		view.getCbIntentoEntrega().setEnabled(bEntrega);
		EnvioDTO envio = view.getStcEnvios().getSelectedDTO();
		view.getBRegistrarMovimiento()
				.setEnabled(envio != null && (view.getRbEntrega().isSelected() || view.getRbRecogida().isSelected()));
		if (envio == null) {
			view.getLEnvioSeleccionadoInfo().setText("No hay hay ningún envío seleccionado");
			view.getLEnvioSeleccionadoInfo().setForeground(Color.RED);
		} else {
			ultimoMovimientoSeleccionado = model.getUltimoMovimiento(envio.getEnvioId());
			view.getLEnvioSeleccionadoInfo().setText(String.format("<html>Envío seleccionado: %s<br>Estado: %s</html>",
					envio.getEnvioId(), envio.getEstado()));
			view.getLEnvioSeleccionadoInfo().setForeground(Color.BLACK);
		}
		this.updateView();
	}

	public int comprobarRegistro() {
		if (view.getRbRecogida().isSelected()) {
			return (ultimoMovimientoSeleccionado == null || (!ultimoMovimientoSeleccionado.getEstado()
					.equals(RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[2])
					&& !ultimoMovimientoSeleccionado.getEstado().equals(RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[1]))
							? 0
							: 1);
		} else if (ultimoMovimientoSeleccionado != null
				&& (ultimoMovimientoSeleccionado.getEstado().equals(RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[2]))
				|| ultimoMovimientoSeleccionado.getEstado().equals(RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[1])) {
			AlmacenOficinaDTO almacenOficina = view.getStcAlmacenesOficinas().getSelectedDTO();
			return (almacenOficina == null ? 3
					: (almacenOficina.getAlmacenesOficinasId() == ultimoMovimientoSeleccionado.getUbicacionId()
							&& !ultimoMovimientoSeleccionado.getEstado()
									.equals(RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[2]) ? 4 : 0));
		} else {
			return 2;
		}
	}

	public void RegistrarMovimiento() {
		if (view.getRbRecogida().isSelected()) {
			int ubicacionId = (ultimoMovimientoSeleccionado != null ? ultimoMovimientoSeleccionado.getUbicacionId()
					: view.getStcEnvios().getSelectedDTO().getOrigenId());
			model.addMovimiento(view.getStcEnvios().getSelectedDTO().getEnvioId(), fecha, ubicacionId,
					RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[1]);

			model.updateEstadoEnvio(view.getStcEnvios().getSelectedDTO().getEnvioId(), "En tránsito");

		} else {
			model.addMovimiento(ultimoMovimientoSeleccionado.getEnvioId(), fecha,
					view.getStcAlmacenesOficinas().getSelectedDTO().getAlmacenesOficinasId(),
					(view.getCbIntentoEntrega().isSelected() ? RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[2]
							: RegistrarMovimientoModel.ESTADOS_MOVIMIENTO[3]));
			model.updateEstadoEnvio(view.getStcEnvios().getSelectedDTO().getEnvioId(), "Clasificado");
		}
	}
}
