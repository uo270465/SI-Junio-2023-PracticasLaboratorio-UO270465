package giitin.uo270465.si.controller;

import java.util.Date;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.model.EntregarEnvioModel;
import giitin.uo270465.si.view.EntregarEnvioView;

public class EntregarEnvioController extends Controller<EntregarEnvioModel, EntregarEnvioView>{

	public EntregarEnvioController(View parent, Date fecha) {
		super(new EntregarEnvioModel(),new EntregarEnvioView(parent)  , fecha);
	}

	@Override
	public void initView() {
		
	}

	@Override
	public void initController() {
		
	}
	
}
