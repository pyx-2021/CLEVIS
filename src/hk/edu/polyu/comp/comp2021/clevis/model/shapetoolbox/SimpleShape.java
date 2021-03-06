package hk.edu.polyu.comp.comp2021.clevis.model.shapetoolbox;

import hk.edu.polyu.comp.comp2021.clevis.model.exceptions.ShapeOutOfMapException;

import javax.swing.*;

import static hk.edu.polyu.comp.comp2021.clevis.model.shapetoolbox.ShapeManager.*;


/**
 * The abstract class for simple shape.
 * <p>Defines and implements some common fields and methods of all simple shapes.</p>
 * <p>All simple shapes should have a defining point.</p>
 *
 * @see Shape
 * @see LineSegment
 * @see Circle
 * @see Rectangle
 */
abstract class SimpleShape extends Shape {

	/**
	 * x-coordinate of the defining point.
	 */
	protected float x;

	/**
	 * y-coordinate of the defining point.
	 */
	protected float y;

	/**
	 * Constructor of SimpleShape.
	 *
	 * @param z_arg z_order
	 * @param n_arg name
	 * @param x_arg x-coordinate of the defining point
	 * @param y_arg y-coordinate of the defining point
	 * @see Shape#Shape(int, String)
	 * @see Rectangle#Rectangle(int, String, float, float, float, float)
	 * @see LineSegment#LineSegment(int, String, float, float, float, float)
	 * @see Circle#Circle(int, String, float, float, float)
	 */
	SimpleShape(int z_arg, String n_arg, float x_arg, float y_arg) {
		super(z_arg, n_arg);
		setaGroup(false);
		setX(x_arg);
		setY(y_arg);
	}

	/**
	 * Getter of x.
	 *
	 * @return the x-coordinate of the defining point
	 * @see #x
	 */
	float getX() {
		return x;
	}

	/**
	 * Setter of x.
	 *
	 * @param x_arg the x-coordinate to be set to the defining point
	 * @see #x
	 */
	void setX(float x_arg) {
		x = x_arg;
	}

	/**
	 * Getter of y.
	 *
	 * @return the y-coordinate of the defining point
	 * @see #y
	 */
	float getY() {
		return y;
	}

	/**
	 * Setter of y.
	 *
	 * @param y_arg the y coordinate to be set to the defining point
	 * @see #y
	 */
	void setY(float y_arg) {
		y = y_arg;
	}

	@Override
	void move(float dx_arg, float dy_arg) throws ShapeOutOfMapException {
		if (rightMost() + dx_arg > CX_MAX_VALUE || leftMost() + dx_arg < CX_MIN_VALUE
				|| upMost() + dy_arg > CY_MAX_VALUE || downMost() + dy_arg < CY_MIN_VALUE)
			throw new ShapeOutOfMapException("Failure! Attempting to move out of map!");

		setX(x + dx_arg);
		setY(y + dy_arg);
	}

	/**
	 * This method return a jPanel object according to its type.
	 *
	 * @param bX     bounding x
	 * @param bY     bounding y
	 * @param drawer the drawer
	 * @return a jPanel to be added
	 */
	abstract JPanel draw(float bX, float bY, GraphDrawer drawer);
}