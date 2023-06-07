package giitin.uo270465.si.abs;

public class Controller<M extends Model, V extends View> {
	
	protected M model;
	protected V view;
	
	public Controller(M model, V view) {
		this.model = model;
		this.view = view;
	}
}
