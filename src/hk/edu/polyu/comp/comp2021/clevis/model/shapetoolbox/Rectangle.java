package hk.edu.polyu.comp.comp2021.clevis.model.shapetoolbox;

import hk.edu.polyu.comp.comp2021.clevis.model.exceptions.IllegalShapeException;
import hk.edu.polyu.comp.comp2021.clevis.model.exceptions.InModelException;
import hk.edu.polyu.comp.comp2021.clevis.model.exceptions.ShapeOutOfMapException;

import javax.swing.*;
import java.awt.*;


/**
 * The class for rectangle.
 * <p>The defining point of a rectangle is its top-left corner.</p>
 *
 * @see SimpleShape
 * @see Square
 */
class Rectangle extends SimpleShape {
	private float width;
	private float height;

	/**
	 * Constructor of Rectangle.
	 *
	 * @param z_arg z_order
	 * @param n_arg name
	 * @param x_arg x-coordinate of the top-left corner
	 * @param y_arg y-coordinate of the top-left corner
	 * @param w_arg width
	 * @param h_arg height
	 * @throws ShapeOutOfMapException when the arguments are illegal for the map
	 * @throws IllegalShapeException  when the width or the height is illegal
	 * @see SimpleShape#SimpleShape(int, String, float, float)
	 * @see Square#Square(int, String, float, float, float)
	 */
	Rectangle(int z_arg, String n_arg, float x_arg, float y_arg, float w_arg, float h_arg) throws ShapeOutOfMapException, IllegalShapeException {
		super(z_arg, n_arg, x_arg, y_arg);
		setWidth(w_arg);
		setHeight(h_arg);
	}

	/**
	 * Gets all the 4 sides of this rectangle.
	 *
	 * @return a LineSegment array of the 4 sides
	 */
	LineSegment[] getSides() {
		float x1 = x, x2 = x + width,
				y1 = y, y2 = y - height;
		try {
			LineSegment l1 = new LineSegment(x1, y1, x2, y1),
					l2 = new LineSegment(x2, y1, x2, y2),
					l3 = new LineSegment(x2, y2, x1, y2),
					l4 = new LineSegment(x1, y2, x1, y1);
			return new LineSegment[]{l1, l2, l3, l4};
		} catch (InModelException ignored) {
			return null;
		}
	}

	@Override
	float upMost() {
		return y;
	}

	@Override
	float downMost() {
		return y - height;
	}

	@Override
	float leftMost() {
		return x;
	}

	@Override
	float rightMost() {
		return x + width;
	}

	@Override
	JPanel draw(float bX, float bY, GraphDrawer drawer) {
		float zoomBase = drawer.getZoomBase();
		return new JPanel() {
			@Override
			public void paintComponent(Graphics graphics) {
				graphics.drawRect((int) ((x - bX) / zoomBase + 10),
						(int) ((y - bY) / zoomBase + 10),
						(int) (width / zoomBase),
						(int) (height / zoomBase));
			}
		};
	}

	@Override
	public String toString() {
		return String.format(
				"%s@Rectangle [top-left] = (%.2f, %.2f) [width] = %.2f [height] = %.2f",
				getName(), getX(), getY(), getWidth(), getHeight());
	}

	/**
	 * Getter of width.
	 *
	 * @return the width of this rectangle
	 * @see #width
	 */
	float getWidth() {
		return width;
	}

	/**
	 * Setter of width.
	 *
	 * @param w_arg the width to be set
	 * @throws IllegalShapeException when the width is illegal
	 * @see #width
	 */
	void setWidth(float w_arg) throws IllegalShapeException {
		if (w_arg <= 0)
			throw new IllegalShapeException("The width cannot <= 0!");
		width = w_arg;
	}

	/**
	 * Getter of height.
	 *
	 * @return the height of this rectangle
	 * @see #height
	 */
	float getHeight() {
		return height;
	}

	/**
	 * Setter of height.
	 *
	 * @param h_arg the height to be set
	 * @throws IllegalShapeException when the height is illegal
	 * @see #height
	 */
	void setHeight(float h_arg) throws IllegalShapeException {
		if (h_arg <= 0)
			throw new IllegalShapeException("The height cannot <= 0");
		height = h_arg;
	}
}