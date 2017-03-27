import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

public class SquareJumpWorld extends JComponent {
	/**
	 * 
	 */
	
	//private int fWidth = this.getWidth();
	private static final long serialVersionUID = 1L;
	private int squareHeight;
	private int squareWidth;
	private int xLeft;
	private int yTop;
	private int speed;
	private double angle;
	private int xMinus = 0;
	private int gap;
	private int xWorld;
	
	public int getSquareHeight() {
		return squareHeight;
	}

	public void setSquareHeight(int height) {
		this.squareHeight = height;
	}

	public int getSquareWidth() {
		return squareWidth;
	}

	public void setSquareWidth(int width) {
		this.squareWidth = width;
	}

	public int getxLeft() {
		return xLeft;
	}

	public void setxLeft(int xLeft) {
		this.xLeft = xLeft;
	}

	public int getyTop() {
		return yTop;
	}

	public void setyTop(int yTop) {
		this.yTop = yTop;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public Random getRandGen() {
		return randGen;
	}

	public void setRandGen(Random randGen) {
		this.randGen = randGen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private int frameHeight;
	private int frameWidth;
	private Random randGen = new Random();
	
	public SquareJumpWorld(int gap){
		this.angle = 180;
		this.speed = 50;
		this.gap =gap;
		this.xMinus = 0;
		
		
		do{
			this.squareHeight = randGen.nextInt(50);
		}while(this.squareHeight<15);
		this.squareWidth = 15;
		
		
		
		
	}
	
	public void generateWorld(Graphics g, int W, int H){
		setxLeft(W);
		setyTop(H);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		xWorld = getxLeft()-this.xMinus+this.gap;
		
//		Rectangle rectangle = new Rectangle();
		g2.fillRect(xWorld, getyTop()-(100+squareHeight), squareWidth , squareHeight);
		this.xMinus++;
		
	}
	
	public boolean checkEnd(){
		if((xWorld)<(0-squareWidth)){
			return true;			
		}
		return false;
	}
	
	public void resetxMinus(){
		this.xMinus = 0+this.gap;
		do{
			this.squareHeight = randGen.nextInt(50);
		}while(this.squareHeight<15);
	}
	
	
	
	
	
	protected void move() {
		
		// Protected method to be called from paintComponent() in subclass
		moveAtAngle(getAngle(),getSpeed());
		// Change trajectory upon collision with border

	}

	public void moveAtAngle(double angle,int pixelsPerSec){

		// Divide speed by 10 because frame is repainted every 0.1 sec
		int magnitude = Math.max(pixelsPerSec / 100,1);

		// Compute horizontal and vertical components of linear translation
		// 90 degrees trajectory -> move straight up. 
		// 0 degrees trajectory -> move horizontally to the right
		int xVector= (int) (magnitude*Math.cos(Math.toRadians(angle)));
		int yVector= -(int) (magnitude*Math.sin(Math.toRadians(angle))); 


		//current values, for debugging purposes
		System.out.println("Current (x,y) position and vectors values to be added or substracted");
		System.out.println("xVector=" +xVector);
		System.out.println("yVector=" +yVector);
		System.out.println("xPosition=" + this.xLeft);
		System.out.println("yPosition=" + this.yTop);
		
		//other values for debugging
		System.out.println("angle in degrees: "+ angle);
		System.out.println("angle in radians: " + Math.toRadians(angle));

		//moving to the new coordinates by addition
		this.xLeft=this.xLeft+xVector;
		this.yTop=this.yTop+yVector;

		//new positions on the (x,y) plane for debugging purposes
		System.out.println("New (x,y) position with vectors values updated");
		System.out.println("xPosition=" + this.xLeft);
		System.out.println("yPosition=" + this.yTop);
	}
	
	
}
