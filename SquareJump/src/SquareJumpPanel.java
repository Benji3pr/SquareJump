import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class SquareJumpPanel extends JComponent {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<SquareJumpWorld> figures = new ArrayList<SquareJumpWorld>();
	private SquareJumpSquare player1 = new SquareJumpSquare();

	private int xFloor;
	private int yFloor;
	private int floorWidth;
	private int floorHeight;
	private int xWorld;





	public int getxWorld() {
		return xWorld;
	}


	public void setxWorld(int xWorld) {
		this.xWorld = xWorld;
	}


	public void add(SquareJumpWorld f) {
		figures.add(f);
	}
	
	public void addPlayer(SquareJumpSquare f) {
		player1.add(f);
	}


	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());

		setxFloor(0);
		setyFloor(this.getHeight());
		setFloorWidth(this.getWidth());
		setFloorHeight(this.getHeight());



		g2.setColor(Color.GREEN);
		g2.drawLine(getxFloor(), getyFloor()-100, getFloorWidth(), getFloorHeight()-100);
		g2.setColor(Color.LIGHT_GRAY);
		//g2.fillRect(getFloorWidth()-100, getFloorHeight()-150, 15, 50);
		//		System.out.println(getFloorWidth()+" 1 "+getFloorHeight());
		for(SquareJumpWorld f :figures){
			g2.setColor(Color.WHITE);
			if(f.checkEnd()){
				f.resetxMinus();
			}
			f.generateWorld(g2, getFloorWidth(), getFloorHeight() );
			//			System.out.println(getFloorWidth()+" 2 "+getFloorHeight());

		}
		
		player1.squarePlayer(g2, getFloorWidth(), getFloorHeight());



	}

	public int getxFloor() {
		return xFloor;
	}

	public void setxFloor(int xFloor) {
		this.xFloor = xFloor;
	}

	public int getyFloor() {
		return yFloor;
	}

	public void setyFloor(int yFloor) {
		this.yFloor = yFloor;
	}

	public int getFloorWidth() {
		return floorWidth;
	}

	public void setFloorWidth(int floorWidth) {
		this.floorWidth = floorWidth;
	}

	public int getFloorHeight() {
		return floorHeight;
	}

	public void setFloorHeight(int floorHeight) {
		this.floorHeight = floorHeight;
	}



}
