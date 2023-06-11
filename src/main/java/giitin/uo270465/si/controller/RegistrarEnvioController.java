package giitin.uo270465.si.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.model.RegistrarEnvioModel;
import giitin.uo270465.si.view.RegistrarEnvioView;

public class RegistrarEnvioController extends Controller<RegistrarEnvioModel, RegistrarEnvioView> {

	public RegistrarEnvioController(Date fecha) {
		super(new RegistrarEnvioModel(), new RegistrarEnvioView(), fecha);
	}

	@Override
	public void initController() {

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
	}

	@Override
	public void initView() {

		view.getStcClientesRemitentes().newTable(model.getClientes());

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

}
