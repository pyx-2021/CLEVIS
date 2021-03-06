package hk.edu.polyu.comp.comp2021.clevis.model.shapetoolbox;

import hk.edu.polyu.comp.comp2021.clevis.model.exceptions.IllegalShapeException;
import hk.edu.polyu.comp.comp2021.clevis.model.exceptions.ShapeOutOfMapException;

import javax.swing.*;
import java.awt.*;


/**
 * The class for circle.
 * <p>The defining point of a circle is its center.</p>
 *
 * @see SimpleShape
 */
class Circle extends SimpleShape {
	private float radius;

	/**
	 * Constructor of Cicle, specifically designed for temporary objects.
	 *
	 * @param x_arg x-coordinate of the center
	 * @param y_arg y-coordinate of the center
	 * @param r_arg radius
	 * @throws ShapeOutOfMapException when the arguments are illegal for the map
	 * @throws IllegalShapeException  when the radius is illegal
	 * @see #Circle(int, String, float, float, float)
	 */
	Circle(float x_arg, float y_arg, float r_arg) throws ShapeOutOfMapException, IllegalShapeException {
		this(DEF_Z_ARG, DEF_NAME_ARG, x_arg, y_arg, r_arg);
	}

	/**
	 * Constructor of Circle.
	 *
	 * @param z_arg z_order
	 * @param n_arg name
	 * @param x_arg x-coordinate of the center
	 * @param y_arg y-coordinate of the center
	 * @param r_arg radius
	 * @throws ShapeOutOfMapException when the arguments are illegal for the map
	 * @throws IllegalShapeException  when the radius is illegal
	 * @see SimpleShape#SimpleShape(int, String, float, float)
	 */
	Circle(int z_arg, String n_arg, float x_arg, float y_arg, float r_arg) throws ShapeOutOfMapException, IllegalShapeException {
		super(z_arg, n_arg, x_arg, y_arg);
		setRadius(r_arg);
	}

	@Override
	float upMost() {
		return y + radius;
	}

	@Override
	float downMost() {
		return y - radius;
	}

	@Override
	float leftMost() {
		return x - radius;
	}

	@Override
	float rightMost() {
		return x + radius;
	}

	@Override
	JPanel draw(float bX, float bY, GraphDrawer drawer) {
		float zoomBase = drawer.getZoomBase();
		System.out.println(zoomBase);
		return new JPanel() {
			@Override
			public void paintComponent(Graphics graphics) {
				graphics.drawOval((int) ((x - bX - radius) / zoomBase),
						(int) ((y - bY + radius) / zoomBase),
						(int) ((2 * radius) / zoomBase),
						(int) ((2 * radius) / zoomBase));
			}
		};
	}

	@Override
	public String toString() {
		return String.format("%s@Circle [center] = (%.2f, %.2f) [radius] = %.2f",
				getName(), getX(), getY(), getRadius());
	}

	/**
	 * Getter of radius.
	 *
	 * @return the radius of this circle
	 * @see #radius
	 */
	float getRadius() {
		return radius;
	}

	/**
	 * Setter of radius.
	 *
	 * @param r_arg the radius to be set
	 * @throws IllegalShapeException when the radius is illegal
	 * @see #radius
	 */
	void setRadius(float r_arg) throws IllegalShapeException {
		if (r_arg < 0)
			throw new IllegalShapeException("The radius cannot <= 0!");
		radius = r_arg;
	}
}