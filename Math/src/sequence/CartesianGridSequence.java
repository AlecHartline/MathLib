package sequence;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class CartesianGridSequence implements DrawSequence{
	private double x, y, width, height, i_hat, j_hat, x_label_delta, y_label_delta;
	public CartesianGridSequence(int x, int y, int width, int height, int i_hat, int j_hat, int x_label_delta, int y_label_delta) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.i_hat = i_hat;
		this.j_hat = j_hat;
		this.x_label_delta = x_label_delta;
		this.y_label_delta = y_label_delta;
	}
	BasicStroke subGridStroke = new BasicStroke(2);
	@Override
	public void draw(Graphics g) {
		System.out.println(x);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		
		//Draw Y-Axis
		g2d.drawLine((int)x, (int)(y - height / 2), (int)x, (int)(y + height / 2));
		//Draw X-Axis
		g2d.drawLine((int)(x - width / 2), (int)y, (int)(x + width / 2), (int)y);
		
		Stroke oldStroke = g2d.getStroke();
		g2d.setStroke(subGridStroke);
		
		//Draw vertical subgridlines
		int xNum = 0, yNum = 0;
		for(double x_grid = x; x_grid < width / 2; x_grid += i_hat) {
			g2d.drawLine((int)(x + x_grid), (int)(y - height / 2), (int)(x + x_grid), (int)(y + height / 2));
			g2d.drawLine((int)(x - x_grid), (int)(y - height / 2), (int)(x - x_grid), (int)(y + height / 2));
			
			//Draw X-axis labels
			if(xNum++ % x_label_delta == 0) {
				g2d.drawString(xNum - 1 + "", (int)(x + x_grid + g2d.getFontMetrics().stringWidth(xNum - 1 + "") - 5), (int)y + g2d.getFontMetrics().getAscent());
				if(xNum - 1 != 0)
					g2d.drawString(1 - xNum + "", (int)(x - x_grid + g2d.getFontMetrics().stringWidth(-xNum + 1 + "")/2 - 5), (int)y + g2d.getFontMetrics().getAscent());
			}
		}
		//Draw horizontal subgridlines
		for(double y_grid = y; y_grid < height / 2; y_grid += j_hat) {
			g2d.drawLine((int)(x - width / 2), (int)(y + y_grid), (int)(x + width / 2), (int)(y + y_grid));
			g2d.drawLine((int)(x - width / 2), (int)(y - y_grid), (int)(x + width / 2), (int)(y - y_grid));
			
			//Draw Y-axis labels
			if(yNum++ % y_label_delta == 0) {
				g2d.drawString(yNum - 1 + "", (int)(x + g2d.getFontMetrics().stringWidth(yNum - 1 + "") - 5), (int)(y - y_grid + g2d.getFontMetrics().getAscent()));
				if(yNum - 1 != 0)
					g2d.drawString(1 - yNum + "", (int)(x + g2d.getFontMetrics().stringWidth(1 - yNum + "")/2 - 5), (int)(y + y_grid + g2d.getFontMetrics().getAscent()));
			}
		}
		
		
		g2d.setStroke(oldStroke);
	}
	public void offsetX(double d) {
		x -= d;
	}
	public void offsetWidth(double d) {
		width += d*2;
	}

}
