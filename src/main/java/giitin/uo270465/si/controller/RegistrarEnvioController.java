package giitin.uo270465.si.controller;

import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.model.RegistrarEnvioModel;
import giitin.uo270465.si.view.RegistrarEnvioView;

public class RegistrarEnvioController extends Controller<RegistrarEnvioModel, RegistrarEnvioView> {

	public RegistrarEnvioController(Date fecha) {
		super(new RegistrarEnvioModel(), new RegistrarEnvioView(), fecha);
	}

	@Override
	public void initController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initView() {
		super.initView();
		DefaultTableModel tClientesModel = (DefaultTableModel) this.view.getTClientes().getModel();

		List<ClienteDTO> clientes = model.getClientes();
		for (ClienteDTO cliente : clientes)
			tClientesModel.addRow(new Object[] { cliente.getNombre(), cliente.getEmail(), cliente.getDireccion() });

	}

}
