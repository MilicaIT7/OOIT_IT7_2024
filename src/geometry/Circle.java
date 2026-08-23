package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	private Point center;
	private int radius;
	private Color fillColor = Color.WHITE;
	
	public Circle() {
	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public double area() { 
		return radius*radius*Math.PI;
	}
	public double circumference() { 
		return 2*radius*Math.PI;
	}
	
	public String toString() {
		return "Center: " + center + ", radius = " + radius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		return (this.center.distance(sadrziTacku) <= this.radius);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(center.getXCoord()-radius,
				center.getYCoord() - radius, 2* radius, 2*radius);
		g.setColor(edgeColor);
		g.drawOval(center.getXCoord()-radius,
				center.getYCoord() - radius, 2* radius, 2*radius);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getXCoord() - 2, center.getYCoord() - 2, 4, 4);
			g.drawRect(center.getXCoord() - radius - 2, center.getYCoord() - 2, 4, 4);
			g.drawRect(center.getXCoord() + radius - 2, center.getYCoord() - 2, 4, 4);
			g.drawRect(center.getXCoord() - 2, center.getYCoord() - radius - 2, 4, 4);
			g.drawRect(center.getXCoord() - 2, center.getYCoord() + radius - 2, 4, 4);
			g.setColor(edgeColor);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);	
	}

	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			Circle shapeToCompare = (Circle)obj;
			return (int)(this.area() - shapeToCompare.area());
		}
		return 0;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception{
		if(radius<=0) {
			throw new Exception("Radius ne moze biti manji od 0");
		}
		this.radius = radius;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}


}
