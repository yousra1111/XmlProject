package com.gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.bo.Point;
import com.bo.Segment;

public class PaintPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Segment> segments=new ArrayList< Segment>();
	public void addSegment(Segment s) {
		segments.add(s);
	}
	public PaintPanel(MainFrame parent) {
		addMouseListener(new MouseAdapter() {
			Point  A=null,B=null;
			public void mousePressed(MouseEvent e) {
				A =new Point(e.getX(),e.getY());
			}
		public void mouseReleased(MouseEvent e) {
			B =new Point(e.getX(),e.getY());
			Segment segment=new Segment();
			segment.setA(A);
			segment.setB(B);
			addSegment(segment);
			repaint();
		}

		});
	}
	public void drawSegments(Graphics g) {
		for(Segment it : segments) {
		g.drawLine(it.getA().getX(),it.getA().getY(),it.getB().getX(),it.getB().getY());
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		drawSegments(g);
	}
	public List<Segment> getSegments() {
		return segments;
	}
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
}
