package com.spicstome.client.ui.chart;

public class Point2D {

	public double x, y;
	
	public Point2D() {
		x = 0;
		y = 0;
	}
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
}
