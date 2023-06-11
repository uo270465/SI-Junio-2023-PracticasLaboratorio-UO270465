package giitin.uo270465.si.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.model.RegistrarEnvioModel;
import giitin.uo270465.si.view.RegistrarEnvioView;

public class RegistrarEnvioController extends Controller<RegistrarEnvioModel, RegistrarEnvioView> {

	public RegistrarEnvioController(Date fecha) {
		super(new RegistrarEnvioModel(), new RegistrarEnvioView(), fecha);
	}

	@Override
	public void initController() {

		view.getTbNievoClienteMode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectClientesMode(0);
			}
		});

		view.getTbClienteExistenteMode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectClientesMode(1);
			}
		});
	}

	@Override
	public void initView() {
		
		mostrarAlmacenesOficinasOrigenTodos();
		
		view.getStcClientesDestinatario().newTable(model.getClientes());
		
	
		
		view.getSpTAlmacenesOficinasOrigen().setMaximumSize(new Dimension(Integer.MAX_VALUE, view.getTfNombreNuevoCliente().getHeight() * 10));
		selectClientesMode(0);
		
	}


	public void selectClientesMode(int mode) {
		boolean nuevoCliente = true;
		boolean clienteExistente = false;
		if (mode != 0) {
			nuevoCliente = !nuevoCliente;
			clienteExistente = !clienteExistente;
		}

		view.getTbNievoClienteMode().setSelected(nuevoCliente);
		view.getTbClienteExistenteMode().setSelected(clienteExistente);

		view.getTfNombreNuevoCliente().setEnabled(nuevoCliente);
		view.getTfEmailNuevoCliente().setEnabled(nuevoCliente);
		view.getTfDireccionNuevoCliente().setEnabled(nuevoCliente);

		view.getStcClientesDestinatario().setEnabled(clienteExistente);
	}
	
	
	public DefaultTableModel getAlmacenesOficinasModel() {
		return (DefaultTableModel) this.view.getTAlmacenesOficinasOrigen().getModel();
	}
	
	public void cleanAlmacenesOficinasOrigenTable() {
		DefaultTableModel tAlmacenesOficinasModel = getAlmacenesOficinasModel();

		while (view.getTAlmacenesOficinasOrigen().getRowCount() > 0) {
			tAlmacenesOficinasModel.removeRow(0);
		}
	}
	
	public void mostrarAlmacenesOficinasOrigenTodos() {
		DefaultTableModel tAlmacenesOficinasOrigenModel = getAlmacenesOficinasModel();
		cleanAlmacenesOficinasOrigenTable();

		List<AlmacenOficinaDTO> almacenesOficinasOrigen = model.getAlmacenesOficinas();
		for (AlmacenOficinaDTO almacenOficinaOrigen : almacenesOficinasOrigen)
			tAlmacenesOficinasOrigenModel.addRow(new Object[] { almacenOficinaOrigen.getNombre(), almacenOficinaOrigen.getDireccion(), almacenOficinaOrigen.getCiudad() });
	}

}
