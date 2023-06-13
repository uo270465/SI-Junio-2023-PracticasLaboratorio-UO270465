package giitin.uo270465.si.abs;

import javax.swing.JFrame;

public abstract class View extends JFrame {

	private static final long serialVersionUID = 1L;
	protected View parent;

	public View() {
		super();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void initParent(View parent) {
		this.parent = parent;
		if (this.parent != null)
			this.parent.setVisible(false);
	}

	@Override
	public void dispose() {
		super.dispose();
		if (parent != null) {
			parent.setVisible(true);
		}
	}

}
