/**Faraan Siddiqui
 * December 25, 2018
 * SnakeGame
 */
import javax.swing.JFrame;

public class Main {

	public Main() {
	
	JFrame frame = new JFrame();
	Gamepanel gamepanel = new Gamepanel();
	
	frame.add(gamepanel);
	frame.setTitle("Snake Game");
	
	frame.pack();
	// Size the frame
	frame.setVisible(true);
	// Show it
	frame.setLocationRelativeTo(null);
	// setLocationRelativeTo(null) used to center frame in the screen.
	}
	
	public static void main(String[] args) {
		new Main();
	}

}