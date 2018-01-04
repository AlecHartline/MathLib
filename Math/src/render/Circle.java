package render;

import java.awt.Dimension;
import java.awt.Graphics;

import core.GlobalTimer;

public class Circle {
	
	private int x, y, w, h;
	private double period;
	GlobalTimer timer = new GlobalTimer();
	
	public Circle(int x, int y, int width, int height, double periodInMs) {
		this.x = x;
		this.y = y;
		w = width;
		h = height;
		period = periodInMs;
	}
	
	public Dimension getCosineAndSine() {
		Dimension out = new Dimension();
		out.setSize(Math.cos(getThetaRadians()) * w/2 + x, Math.sin(getThetaRadians()) * h/2 + y);
		
		return out;
		
	}
	public void draw(Graphics g) {
		g.fillArc(x - w/2, y - h/2, w, h, 0, 360);
		//g.drawArc(x - w/2, y - h/2, w, h, 0, 360);
	}
	public double getThetaDegrees() {
		return Math.toDegrees(getThetaRadians());
	}
	public double getThetaRadians() {
		double ms = timer.deltaTimeMillis();
		double timeInPeriod = ms / period;
		double radians = Math.PI * timeInPeriod;
		return radians;
	}
}
