package giitin.uo270465.si.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
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
		view.getBBuscarClienteExistente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				filterClientes(view.getTfFiltroClienteExistente().getText());
			}
		});

		view.getBMostrarTodosClienteExistente().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarClientesTodos();
			}
		});

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
		
		mostrarClientesTodos();

		view.getSpTClientes()
				.setMaximumSize(new Dimension(Integer.MAX_VALUE, view.getTfNombreNuevoCliente().getHeight() * 10));
		
		view.getSpCentroAlmacenOrigen().setMaximumSize(new Dimension(Integer.MAX_VALUE, view.getTfNombreNuevoCliente().getHeight() * 10));
		selectClientesMode(0);
		
	}

	public DefaultTableModel getClientesModel() {
		return (DefaultTableModel) this.view.getTClientes().getModel();
	}

	public void cleanClientesTable() {
		DefaultTableModel tClientesModel = getClientesModel();

		while (view.getTClientes().getRowCount() > 0) {
			tClientesModel.removeRow(0);
		}
	}

	public void filterClientes(String filter) {
		DefaultTableModel tClientesModel = getClientesModel();
		cleanClientesTable();

		List<ClienteDTO> clientes = model.getClientesFilterAnyColumn(filter);
		for (ClienteDTO cliente : clientes)
			tClientesModel.addRow(new Object[] { cliente.getNombre(), cliente.getEmail(), cliente.getDireccion() });
	}

	public void mostrarClientesTodos() {
		DefaultTableModel tClientesModel = getClientesModel();
		cleanClientesTable();

		List<ClienteDTO> clientes = model.getClientes();
		for (ClienteDTO cliente : clientes)
			tClientesModel.addRow(new Object[] { cliente.getNombre(), cliente.getEmail(), cliente.getDireccion() });
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

		view.getTfFiltroClienteExistente().setEnabled(clienteExistente);
		view.getBBuscarClienteExistente().setEnabled(clienteExistente);
		view.getBMostrarTodosClienteExistente().setEnabled(clienteExistente);
		view.getSpTClientes()
				.setHorizontalScrollBarPolicy((clienteExistente ? JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
						: JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		view.getSpTClientes().setVerticalScrollBarPolicy(
				(clienteExistente ? JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED : JScrollPane.VERTICAL_SCROLLBAR_NEVER));
		view.getTClientes().setEnabled(clienteExistente);
	}

}
