/**Faraan Siddiqui
 * December 25, 2018
 * SnakeGame
 */
import java.awt.Color;
import java.awt.Graphics;

public class Body {

	private int xCoor, yCoor, width, height;
	
	public Body(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		// Makes the width of the snake fit the size of one tile on the frame
		height = tileSize;
		// Makes the height of the snake fit the size of one tile on the frame
	}
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		// Sets this graphics context's current color to green
		g.fillRect(xCoor * width, yCoor * height, width, height);
	
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}	
}