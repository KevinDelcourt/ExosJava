package tp1;

public class Point implements Comparable<Point> {

	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
		
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return " ("+x+","+y+") ";
	}
	@Override
	public int compareTo(Point arg0) {
		
		return this.x - arg0.getX();
	}

}
