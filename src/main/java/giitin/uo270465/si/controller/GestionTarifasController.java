package giitin.uo270465.si.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.model.GestionTarifasModel;
import giitin.uo270465.si.view.GestionTarifasView;

public class GestionTarifasController extends Controller<GestionTarifasModel, GestionTarifasView> {

	private TarifaDTO tarifaSeleccionada;
	private int gestionMode;

	public GestionTarifasController(View parent, Date fecha) {
		super(new GestionTarifasModel(), new GestionTarifasView(parent), fecha);
	}

	@Override
	public void initController() {
		view.getBQuitarSeleccion().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getStcTarifas().clearSelection();
			}
		});

		view.getStcTarifas().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				tarifaSeleccionada = view.getStcTarifas().getSelectedDTO();
				if (tarifaSeleccionada == null) {
					gestionMode = 0;
				} else {
					gestionMode = 1;
				}
				setAutoMode();
			}
		});
		
		view.getBRestablecer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAutoMode();
			}
		});
		
		view.getBAccionTarifa().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comprobarCampos()) {
					gestionarTarifa();
					view.getStcTarifas().newTable(model.getTarifas());
				}
			}
		});

	}

	@Override
	public void initView() {
		view.getStcTarifas().newTable(model.getTarifas());
	}

	public void setAutoMode() {
		switch (gestionMode) {
		case 0:
			setNuevaTarifaMode();
			break;
		case 1:
			setEditarTarifaMode();
			break;
		}
	}

	public void setNuevaTarifaMode() {
		view.getLAccionTarifaInfo().setText("Crear nueva tarifa");
		view.getTfConcepto().setText("");
		view.getSPrecio().setValue(0);
		view.getBAccionTarifa().setText("Crear tarifa");
	}

	public void setEditarTarifaMode() {
		view.getLAccionTarifaInfo().setText("Modificar tarifa existente");
		view.getTfConcepto().setText(tarifaSeleccionada.getConcepto());
		view.getSPrecio().setValue(tarifaSeleccionada.getPrecio());
		view.getBAccionTarifa().setText("Modificar tarifa");
	}
	
	public boolean comprobarCampos() {
		String concepto = view.getTfConcepto().getText();
		Double precio = Double.parseDouble(view.getSPrecio().getValue().toString());
		
		if (concepto.isBlank()) {
			JOptionPane.showInternalMessageDialog(null, "El concepto de la tarifa no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (precio <= 0) {
			JOptionPane.showInternalMessageDialog(null, "El precio escogido debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void addTarifa() {
		model.addTarifa(view.getTfConcepto().getText(), Double.parseDouble(view.getSPrecio().getValue().toString()));
		JOptionPane.showInternalMessageDialog(null, "Tarifa añadida con exito.");
	}
	
	public void alterTarifa() {
		model.alterTarifa(tarifaSeleccionada.getTarifaId(),view.getTfConcepto().getText(), (double)view.getSPrecio().getValue());
		JOptionPane.showInternalMessageDialog(null, "Tarifa modificada con exito.");
	}
	
	public void gestionarTarifa() {
		switch (gestionMode) {
		case 0:
			addTarifa();
			break;
		case 1:
			alterTarifa();
			break;
		}
	}
	

}
