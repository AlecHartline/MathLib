package sequence;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.function.Function;

public class FunctionGraphSequence implements DrawSequence{
	private double x, y, width, height, i_hat, j_hat;
	private Function<Double, Double> f;
	private double deltaX;
	private Color color;
	private double functionInputLeft;
	public FunctionGraphSequence(int x, int y, int width, int height, Function<Double, Double> f, double deltaX, int i_hat, int j_hat) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.f = f;
		this.deltaX = deltaX;
		this.i_hat = i_hat;
		this.j_hat = j_hat;
		functionInputLeft = 0;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(getColor());
		//Plot function
		for(double currentX = -width / 2; currentX < width / 2; currentX += deltaX) {
			double lastX = currentX - deltaX;
			double lastY = f.apply(lastX / i_hat + functionInputLeft) * j_hat;
			double nextY = f.apply(currentX / i_hat + functionInputLeft) * j_hat;
			
			if(!f.apply(lastX / i_hat + functionInputLeft).equals(Double.NaN) && !f.apply(currentX / i_hat + functionInputLeft).equals(Double.NaN)) {
				if(lastY > y - height / 2
						&& nextY > y - height / 2
						&& lastY < y + height / 2
						&& nextY < y + height / 2)
					g2d.drawLine((int)(x + lastX), (int)(y - lastY), (int)(x + currentX), (int)(y - nextY));
			}
		}
		
		//Outline rectangle
		g2d.setColor(Color.black);
		g2d.drawRect((int) (x - width/2),(int) (y - height/2), (int)width, (int)height);
		
	}

	public Color getColor() {
		if(color == null)
			return Color.black;
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void offsetFunctionInput(double d) {
		functionInputLeft  += d;
	}

}
