/**Faraan Siddiqui
 * December 25, 2018
 * SnakeGame
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable, KeyListener{
	public static final int WIDTH = 600, HEIGHT = 600;
	// Creates the width and height for the border
	
	private Thread thread;
	// Allows multiple threads of execution running concurrently
	
	private boolean running;
	
	private boolean right = true, left = false, up = false, down = false;
	// Starts the game with the snake body part moving right
	
	private Body b;
	private ArrayList<Body> snake;
	// An array list to hold our snake body
	
	private int xCoor = 5, yCoor = 5, size = 5;
	// xCoor and yCoor sets how fast the snake will move across the frame. The size sets how big the snake's body will be at the start
	private int time = 0;
	// Keeps track of time
	
	private Apple apple;
	private ArrayList<Apple> apples;
	
	private Random r;
	// Creates a new random number generator
	
	public Gamepanel() {
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// Sets the preferred size of this component to a constant value
		addKeyListener(this);
		// The listener interface for receiving keyboard events. "(this)" is used to pass the current java instance as parameter
		
		snake = new ArrayList<Body>();
		apples = new ArrayList<Apple>();
		r = new Random();
		// Incorporate random number generator using system-supplied value as seed
		
		start();
		// Starts the thread
	}
		
	public void start() {
		running = true;
		// Allows the game to run
		thread = new Thread(this);
		thread.start();
	}
	public void stop() {
		running = false;
		// Stops running the game when it is over
	}
	public void time() {
		// Keeps track of how much time has passed
		if(snake.size() == 0) {
			// if there is nothing in our snake array then it adds a new body part at xCoor, yCoor, and 10
			b = new Body(xCoor, yCoor, 10);
			snake.add(b);
			// Adds the body part to the next available space in the array list
		}
		time++;
		if(time > 750000) {
			// Controls how fast the snake moves across the frame
			if(right)
				xCoor++;
			if(left)
				xCoor--;
			if(up)
				yCoor --;
			if(down)
				yCoor ++;
			
			time = 0;
			// Reset the time in order to refresh our loop here
			
			b = new Body(xCoor, yCoor, 10);
			snake.add(b);
			// Snake increases size by one body part
			
			if(snake.size() > size)
				snake.remove(0);
		}
		if(apples.size()==0) {
			int xCoor = r.nextInt(49);
			// The apple can move to anywhere on the x-axis
			int yCoor = r.nextInt(49);
			// The apple can move to anywhere on the y-axis
			
			apple = new Apple(xCoor, yCoor, 10);
			// Initializes the size of the apple
			apples.add(apple);
		}
		for(int i = 0; i < apples.size(); i++) {
			if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
				size++;
				// Increase the snake body part by increments of one every time the head meets the apple
				apples.remove(i);
				// Removes the apple when collided with the snake head
			}
		}
		// Collision on snake body part
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					// If the snake eats itself
					System.out.println("GAME OVER");
					stop();
				}
			}
		}
		
		// Collision on border
		if(xCoor < 0 || xCoor > 59 || yCoor < 0 || yCoor > 59) {
			System.out.println("GAME OVER");
			stop();
		}
	}
	public void paint(Graphics g) {
		// Allows for the ability for the score to keep count
		for(int e = 0; e < apples.size(); e++) {
			if(xCoor == apples.get(e).getxCoor() && yCoor == apples.get(e).getyCoor()) {
		size++;
		// Increase the snake body part by increments of one every time the head meets the apple
		apples.remove(e);
		// Removes the apple when collided with the snake head
			}
		// It paints the screen.
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		// Sets the background paint to black
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// Applies the black paint to the background, subsequently hiding the grid
		for(int i = 0; i < WIDTH/10; i++) {
			g.drawLine(i*10, 0, i*10, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(0, i*10, HEIGHT, i*10);
		}
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
			// Draws snake, allowing user to see what they're controlling
		}
		for(int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
			// Draws apples, allowing user to see what they're trying to eat
		}
		g.drawString("Score: " + (size-5), 10, 10);
		// Keeps score in the corner of the screen. Subtract 5 from size so we can start from 0
		}
	}

	@Override
	public void run() {
		while(running) {
			time();
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			// The KeyEvent is a constant for the non-numpad right arrow key
			right = true;
			up = false;
			down = false;
			left = false;
			
		}
		if(key == KeyEvent.VK_LEFT) {
			// The KeyEvent is a constant for the non-numpad left arrow key
			left = true;
			up = false;
			down = false;
			right = false;
		}
		if(key == KeyEvent.VK_UP) {
			// The KeyEvent is a constant for the non-numpad up arrow key
			up = true;
			down = false;
			left = false;
			right = false;
		}
		if(key == KeyEvent.VK_DOWN) {
			// The KeyEvent is a constant for the non-numpad down arrow key
			down = true;
			left = false;
			right = false;
			up = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}