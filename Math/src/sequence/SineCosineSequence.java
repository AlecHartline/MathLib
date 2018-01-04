package sequence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import render.Circle;

public class SineCosineSequence implements DrawSequence{
	
	private Circle circle;
	
	public SineCosineSequence(int circle_x, int circle_y, int circle_width, int circle_height, double periodInMs) {
		circle = new Circle(circle_x, circle_y, circle_width, circle_height, periodInMs);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		circle.draw(g2d);
		
		Dimension circle_dimensions = circle.getCosineAndSine();
		
		int[] triangleX = {0, (int) circle_dimensions.getWidth(), (int) circle_dimensions.getWidth()};
		int[] triangleY = {0, 0, (int) circle_dimensions.getHeight()};
		g2d.setColor(Color.white);
		g2d.fillPolygon(triangleX, triangleY, triangleX.length);
		
		String thetaString = String.format("     \u03B8: %6.2f\u00B0", -circle.getThetaDegrees() % 360);
		String sineString = String.format("sin(\u03B8): %6.2f", Math.sin(-circle.getThetaRadians()));
		String cosineString = String.format("cos(\u03B8): %6.2f", Math.cos(-circle.getThetaRadians()));

		g2d.setColor(Color.black);
		g2d.drawString(thetaString, 120, -50);
		g2d.drawString(sineString, 120, 0);
		g2d.drawString(cosineString, 120, 50);
		
	}

}
