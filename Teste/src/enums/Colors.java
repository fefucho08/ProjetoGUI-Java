package enums;

import java.awt.Color;

public enum Colors {
	PRIMARY (new Color[] {
			Color.RED,
	        Color.GREEN,
	        Color.BLUE
	}),
	PASTEL (new Color[] {
			new Color(255, 182, 193),
	        new Color(173, 216, 230), 
	        new Color(255, 228, 196),
	        new Color(240, 230, 140),
	        new Color(144, 238, 144) 
	}),
	NEUTRAL (new Color[] {
			Color.WHITE,
	        Color.LIGHT_GRAY,
	        Color.GRAY,
	        Color.DARK_GRAY,
	        Color.BLACK
	}),
	RAINBOW (new Color[] {
			Color.RED,
	        Color.ORANGE,
	        Color.YELLOW,
	        Color.GREEN,
	        Color.BLUE,
	        Color.MAGENTA
	});
	
	public final Color[] colorsArr;
	
	Colors(Color[] colors){
		this.colorsArr = colors;
	}
}
