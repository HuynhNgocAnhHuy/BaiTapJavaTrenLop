package Bai5_1;

public class LineSub extends Point{
	 private Point end; 

	    public LineSub(int beginX, int beginY, int endX, int endY) {
	        super(beginX, beginY); 
	        this.end = new Point(endX, endY);
	    }

	    public LineSub(Point begin, Point end) {
	        super(begin.getX(), begin.getY()); 
	        this.end = end;
	    }

	    public Point getBegin() { return new Point(getX(), getY()); }
	    public Point getEnd() { return end; }
	    public void setEnd(Point end) { this.end = end; }

	    public int getLength() {
	        int xDiff = end.getX() - getX();
	        int yDiff = end.getY() - getY();
	        return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	    }

	    public double getGradient() {
	        int xDiff = end.getX() - getX();
	        int yDiff = end.getY() - getY();
	        return Math.atan2(yDiff, xDiff);
	    }

	    @Override
	    public String toString() {
	        return "LineSub[begin=(" + getX() + "," + getY() + "), end=" + end + "]";
	    }
}
