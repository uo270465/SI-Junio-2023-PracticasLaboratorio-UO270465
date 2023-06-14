package giitin.uo270465.si.controller;

import java.util.Date;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.model.InformacionEnviosModel;
import giitin.uo270465.si.view.InformacionEnviosView;

public class InformacionEnviosController extends Controller<InformacionEnviosModel, InformacionEnviosView> {

	public InformacionEnviosController(View parent, Date fecha) {
		super(new InformacionEnviosModel(), new InformacionEnviosView(parent), fecha);
	}

	@Override
	public void initController() {
		
	}

	@Override
	public void initView() {
		view.getStcEnvios().newTable(model.getEnviosInfos());
		updateView();
	}

}
