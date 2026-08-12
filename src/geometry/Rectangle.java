package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	private Point upperLeftPoint;
	private int width;
	private int height;
	
	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}
	
	public int area() {
		return width * height;
	}
	public int circumference() {
		return 2*width + 2*height;
	}
	
	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", width = " + width + ", height = " + height;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		return (x >= this.upperLeftPoint.getXCoord() 
				&& x <= this.upperLeftPoint.getXCoord() + width
				&& y >= this.upperLeftPoint.getYCoord() 
				&& y <= this.upperLeftPoint.getYCoord() + height);
	}
	
	public boolean contains(Point clickedPoint) {
		return (clickedPoint.getXCoord() >= this.upperLeftPoint.getXCoord() 
				&& clickedPoint.getXCoord() <= this.upperLeftPoint.getXCoord() + width
				&& clickedPoint.getYCoord() >= this.upperLeftPoint.getYCoord() 
				&& clickedPoint.getYCoord() <= this.upperLeftPoint.getYCoord() + height);
	}
	
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getXCoord(),
				upperLeftPoint.getYCoord(), width, height);
		if (isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getXCoord() - 2, upperLeftPoint.getYCoord() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getXCoord() + width - 2, upperLeftPoint.getYCoord() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getXCoord() - 2, upperLeftPoint.getYCoord() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getXCoord() + width - 2, upperLeftPoint.getYCoord() 
					+ height - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);	
	}

	@Override
	public void moveBy(int x, int y) {
		upperLeftPoint.moveBy(x, y);
	}	
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle shapeToCompare = (Rectangle)obj;
			return this.area() - shapeToCompare.area();
		}
		return 0;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	

}
