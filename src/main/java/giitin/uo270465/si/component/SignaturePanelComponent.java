package giitin.uo270465.si.component;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.*;

public class SignaturePanelComponent extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;
	private Graphics2D g2;
	private int currentX, currentY, oldX, oldY;

	public SignaturePanelComponent() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				if (g2 != null) {
					g2.drawLine(oldX, oldY, currentX, currentY);
					repaint();
					oldX = currentX;
					oldY = currentY;
				}
			}
		});
		
	}

	protected void paintComponent(Graphics g) {
		if (image == null) {
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D) image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}

		g.drawImage(image, 0, 0, null);
	}

	public void clear() {
		if (g2==null) return;
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(Color.black);
		oldX=Integer.MIN_VALUE;
		repaint();
	}
	
	public boolean isSigned() {
		return oldX!=Integer.MIN_VALUE;
	}

}
