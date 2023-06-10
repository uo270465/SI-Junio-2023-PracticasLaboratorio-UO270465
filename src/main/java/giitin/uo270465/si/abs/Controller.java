package giitin.uo270465.si.abs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JFrame;

public abstract class Controller<M extends Model, V extends View> {

	protected M model;
	protected V view;
	protected Date fecha;

	public Controller(M model, V view, Date fecha) {
		this.model = model;
		this.view = view;
		this.fecha = fecha;
		this.updateView();
		this.initView();
		this.updateView();
	}

	public void initView() {
		JFrame fView = (JFrame) view;
		fView.setVisible(true);


	}
	
	public void updateView() {
		JFrame fView = (JFrame) view;
		fView.validate();
		fView.pack();
		
		// Poner Pantalla en el medio
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fView.setLocation(dim.width / 2 - fView.getSize().width / 2, dim.height / 2 - fView.getSize().height / 2);
	}

	public abstract void initController();
}
