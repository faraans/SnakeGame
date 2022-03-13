/**Faraan Siddiqui
 * December 25, 2018
 * SnakeGame
 */
import java.awt.Color;
import java.awt.Graphics;

public class Apple {

	private int xCoor, yCoor, width, height;
	
	public Apple(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		// Lets the apple spawn on any coordinate on the x-axis
		this.yCoor = yCoor;
		// Lets the apple spawn on any coordinate on the y-axis
		width = tileSize;
		// Makes the width of the apple fit the size of one tile on the frame
		height = tileSize;
		// Makes the height of the apple fit the size of one tile on the frame
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		// Sets graphic's color to red
		g.fillRect(xCoor * width, yCoor * height, width, height);
	
	}
	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
		// Helps the compiler to understand which to use and in which to store.
	}
	

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
		// Helps the compiler to understand which to use and in which to store.
	}
}