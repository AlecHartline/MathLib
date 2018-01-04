package core;

public class GlobalTimer {
	
	public final static float SIXTY_HERTZ  = 1000.0f / 60.0f;
	public final static float THIRTY_HERTZ = 1000.0f / 30.0f;
	public final static float TWENTY_HERTZ = 1000.0f / 20.0f;
	
	private long lastTime;
	
	public GlobalTimer() {
		lastTime = System.nanoTime();
	}
	
	public long deltaTimeNano() {
		return getTime() - getLastTime();
	}
	
	public float deltaTimeMillis() {
		return nanoToMillis(deltaTimeNano());
	}

	private float nanoToMillis(long nanoTime) {
		return (float) (nanoTime / 1e6);
	}

	public void resetTime() {
		lastTime = System.nanoTime();
	}

	private long getTime() {
		return System.nanoTime();
	}

	private long getLastTime() {
		return lastTime;
	}

	public static double getTickRate() {
		return SIXTY_HERTZ;
	}
	
}
