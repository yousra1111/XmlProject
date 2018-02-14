package com.bo;

public class Segment {
	private Point A , B;
	
	public Segment(Point a, Point b) {
		super();
		A = a;
		B = b;
	}
	
	public Segment() {
		
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}
	
	
}
