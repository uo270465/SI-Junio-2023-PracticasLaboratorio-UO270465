package giitin.uo270465.si.controller;

import java.util.Date;

import giitin.uo270465.si.abs.Controller;
import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.model.GestionTarifasModel;
import giitin.uo270465.si.view.GestionTarifasView;

public class GestionTarifasController extends Controller<GestionTarifasModel, GestionTarifasView>{

	public GestionTarifasController(View parent, Date fecha) {
		super(new GestionTarifasModel(), new GestionTarifasView(parent), fecha);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initController() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
