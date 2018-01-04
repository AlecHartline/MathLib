package render;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {
	
	private static final long serialVersionUID = -717665739855085279L;
	private Thread repainter;
	private GraphContainer graph;
	public Window(String title, int x, int y) {
		super(title);
		setSize(x,y);
		repainter = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					repaint();
				}
			}
		});
		graph = new GraphContainer();
	}

	@Override
	public void run() {
		add(graph);
		setVisible(true);
		repainter.start();
	}
	
}
