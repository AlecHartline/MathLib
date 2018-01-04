package sequence;

import java.awt.Graphics;

import core.GlobalTimer;

public class FunctionAnimationSequence implements DrawSequence{
	FunctionGraphSequence fgs;
	CartesianGridSequence grid;
	double period;
	GlobalTimer timer;
	public FunctionAnimationSequence(FunctionGraphSequence fgs, CartesianGridSequence grid, double periodInMs) {
		this.fgs = fgs;
		this.grid = grid;
		period = periodInMs;
		timer = new GlobalTimer();
	}
	@Override
	public void draw(Graphics g) {
		fgs.offsetFunctionInput(timer.deltaTimeMillis() / period);
		
		/*
		if(grid != null) {
			grid.offsetX(timer.deltaTimeMillis() / period);
			grid.offsetWidth(timer.deltaTimeMillis() / period);
			grid.draw(g);
		}
		*/
		fgs.draw(g);
		timer.resetTime();
	}

}
