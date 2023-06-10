package giitin.uo270465.si.abs;

import giitin.uo270465.si.util.Database;

public abstract class Model {
	protected Database db;
	
	public Model() {
		this.db = new Database();
	}
	
}
