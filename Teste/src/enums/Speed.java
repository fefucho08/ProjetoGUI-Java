package enums;

public enum Speed {
	HIGH(125, 6),
	MEDIUM(500, 3),
	LOW(2000, 1);
	
	public final int backgroundSpeed;
	public final int starSpeed;
	
	Speed(int speedValue, int starSpeed) {
		this.backgroundSpeed = speedValue;
		this.starSpeed = starSpeed;
	}
}
