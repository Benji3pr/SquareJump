import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class SquareJumpSquare extends JComponent {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int xPos = 0;
	private int yPos = 0;
	private int height = 20;
	private int width = 20;
	private int yJump;
	private boolean pressed = false;


	public int getxPos() {
		return xPos;
	}


	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public int getyPos() {
		return yPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getyJump() {
		return yJump;
	}


	public void setyJump(int yJump) {
		this.yJump = yJump;
	}


	public void squarePlayer(Graphics g, int W, int H){
		setxPos(0+150);
		setyPos(H-(100+getHeight()));

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fillRect(xPos, yPos, width, height);
		g2.setColor(Color.BLUE);
		g2.fillRect(xPos+2, yPos+2, width-4, height-4);


	}

	public void keyPressed(KeyEvent e){

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			pressed = true;
			System.out.println("Yes Pressed");

		}

	}

}
