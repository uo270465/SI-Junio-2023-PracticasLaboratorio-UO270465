package giitin.uo270465.si.controller;

import java.util.Date;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.model.RealizarSeguimientoModel;
import giitin.uo270465.si.view.RealizarSeguimientoView;

public class RealizarSeguimientoController extends Controller<RealizarSeguimientoModel, RealizarSeguimientoView> {

	public RealizarSeguimientoController(View parent, Date fecha) {
		super(new RealizarSeguimientoModel(), new RealizarSeguimientoView(parent), fecha);

	}

	@Override
	public void initController() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub

	}

}
