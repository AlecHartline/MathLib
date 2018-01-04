package render;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import core.Runner;
import sequence.DrawSequence;

public class GraphContainer extends JPanel{
	
	private static final long serialVersionUID = 8402400843670847041L;
	private Font monospacedFontDefault = new Font(Font.MONOSPACED, Font.PLAIN, 20);
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		
		//Translate origin from top left to center
		at.setToTranslation(getWidth()/2.0, getHeight()/2.0);
		g2d.setTransform(at);
		
		//Enable antialiasing
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		
		//Set thickness of line to 5px
		BasicStroke bs = new BasicStroke(5);
		g2d.setStroke(bs);
		
		g2d.setFont(monospacedFontDefault); 
		
		//Set background to white
		g.setColor(Color.white);
		g.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
		
		for(DrawSequence sequence : Runner.getSequences()) {
			sequence.draw(g);
		}
		
	}
	
}
