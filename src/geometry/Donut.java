package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;
	
	public Donut() {
		super();
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		this.setSelected(selected);
	}
	
	public String toString() {
		return super.toString() + ", innerRadius = " + getInnerRadius();
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if (super.equals(pomocna) &&
					this.innerRadius == pomocna.innerRadius)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		return (super.contains(x, y) && 
				getCenter().distance(x,y)> innerRadius);
	}
	
	public double area() { 
		double area = super.area() - innerRadius*innerRadius*Math.PI;
		return area;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(edgeColor);
		g.drawOval(getCenter().getXCoord()-innerRadius,
				getCenter().getYCoord()-innerRadius, 
				2*innerRadius, 2*innerRadius);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getXCoord() - 2, getCenter().getYCoord() - 2, 4, 4);
			g.drawRect(getCenter().getXCoord() - innerRadius - 2, getCenter().getYCoord() - 2, 4, 4);
			g.drawRect(getCenter().getXCoord() + innerRadius - 2, getCenter().getYCoord() - 2, 4, 4);
			g.drawRect(getCenter().getXCoord() - 2, getCenter().getYCoord() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getXCoord() - 2, getCenter().getYCoord() + innerRadius - 2, 4, 4);
			g.setColor(edgeColor);
		}
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Donut) {
			Donut shapeToCompare = (Donut)obj;
			return (int)(this.area() - shapeToCompare.area());
		}
		return 0;
	}
	
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public int getInnerRadius() {
		return this.innerRadius;
	}

}
