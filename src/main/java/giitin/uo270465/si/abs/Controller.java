package giitin.uo270465.si.abs;

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
		this.initView();
	}
	
	public void initView() {
		((JFrame)view).setVisible(true);
		((JFrame)view).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public abstract void initController();
}
