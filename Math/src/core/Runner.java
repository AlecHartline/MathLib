package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Function;

import javax.swing.SwingUtilities;

import render.Window;
import sequence.CartesianGridSequence;
import sequence.DrawSequence;
import sequence.FunctionAnimationSequence;
import sequence.FunctionGraphSequence;
import sequence.SineCosineSequence;

public class Runner {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public static void main(String[] args) {
		Window window = new Window("Math", 800, 600);
		SwingUtilities.invokeLater(window);
	}
	private static ArrayList<DrawSequence> drawSequence = new ArrayList<DrawSequence>() {{
		//CartesianGridSequence grid = new CartesianGridSequence(0, 0, WIDTH, HEIGHT, 60, 60, 3, 2);
		Function<Double, Double> f = (Double x) -> Math.sin(x);
		FunctionGraphSequence sineFunction = new FunctionGraphSequence(0, 0, (int) (Math.PI * 120), (int) (Math.PI * 120), f, 0.1, 100, 100);
		sineFunction.setColor(Color.blue);
//		add(sineFunction);
		add(new FunctionAnimationSequence(sineFunction, null, 1000));
		//add(new SineCosineSequence(0, 0, 200, 200, -1000D));
	}};
	public static ArrayList<DrawSequence> getSequences() {
		return drawSequence;
	}

}
