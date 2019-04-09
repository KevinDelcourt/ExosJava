package templateMethod;

import java.awt.Color;

public class MyColor extends MyComparable {

	public Color color;
	
	public MyColor(Color color) {
		super();
		this.color = color;
	}

	public int rgbSum() {
		return color.getBlue() + color.getGreen() + color.getRed();
	}
	@Override
	public boolean egal(MyComparable mc) {
		if(mc instanceof MyColor)
			return this.color.getRGB() == ((MyColor)mc).color.getRGB();
		
		throw new ClassCastException();
	}

	@Override
	public boolean inferieur(MyComparable mc) {
		if(mc instanceof MyColor)
			return this.rgbSum() < ((MyColor)mc).rgbSum();
		
		throw new ClassCastException();
	}

}
