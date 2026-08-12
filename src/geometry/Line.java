package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public double length() {
		double d = startPoint.distance(endPoint);
		return d;
	}
	
	public String toString() {
		return startPoint.toString() + "-->" + endPoint;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.startPoint)
					&& this.endPoint.equals(pomocna.endPoint)
					&& this.selected == pomocna.selected)
				return true;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		return this.startPoint.distance(sadrziTacku) + 
				this.endPoint.distance(sadrziTacku) - length() <= 2;
	}
	
	public void draw(Graphics g) {
		g.drawLine(startPoint.getXCoord(), startPoint.getYCoord(),
				endPoint.getXCoord(), endPoint.getYCoord());
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getXCoord()-2, startPoint.getYCoord()-2, 4, 4);
			g.drawRect(endPoint.getXCoord()-2, endPoint.getYCoord()-2, 4, 4);
			g.setColor(Color.black);}
	}
	

	@Override
	public void moveTo(int x, int y) {
		// nije logicna
		
	}

	@Override
	public void moveBy(int x, int y) {
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);
		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Line) {
			Line shapeToCompare = (Line)obj;
			return (int)(this.length() - shapeToCompare.length());
		}
		return 0;
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}




}
