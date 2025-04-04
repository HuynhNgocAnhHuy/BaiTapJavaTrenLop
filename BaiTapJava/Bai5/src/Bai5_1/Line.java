package Bai5_1;

public class Line {
	private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Line(int beginX, int beginY, int endX, int endY) {
        this.begin = new Point(beginX, beginY);
        this.end = new Point(endX, endY);
    }

    public Point getBegin() { return begin; }
    public Point getEnd() { return end; }
    public void setBegin(Point begin) { this.begin = begin; }
    public void setEnd(Point end) { this.end = end; }

    public int getLength() {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double getGradient() {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return Math.atan2(yDiff, xDiff);
    }

    @Override
    public String toString() {
        return "Line[begin=" + begin + ", end=" + end + "]";
    }
}
