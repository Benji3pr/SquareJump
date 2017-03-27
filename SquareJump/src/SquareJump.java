import javax.swing.JFrame;

public class SquareJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int fW = 800;
		int fH = 500;
		
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Square Jump");
		myFrame.setSize(fW, fH);
		
		
		
		SquareJumpPanel newPanel = new SquareJumpPanel();
		
		
		SquareJumpWorld figure1 = new SquareJumpWorld(0);
		SquareJumpWorld figure2 = new SquareJumpWorld(125);
		SquareJumpWorld figure3 = new SquareJumpWorld(225);
		SquareJumpSquare player1 = new SquareJumpSquare();


//		myFrame.add(figure1);

		myFrame.add(newPanel);
		newPanel.add(figure1);
		newPanel.add(figure2);
		newPanel.add(figure3);
		newPanel.addPlayer(player1);


		System.out.println(newPanel.getFloorWidth()+" "+ newPanel.getFloorHeight());
		
		
		
		myFrame.setVisible(true);
		
//		SquareJumpWorld newWorld = new SquareJumpWorld();
//		myFrame.add(newWorld);
		
		while(true) {
			try{
				Thread.sleep(10); // Wait for 0.1 second = 100 milliseconds
			}
			catch(InterruptedException e){}
			
			myFrame.repaint();
			
		} // end while
		
		
	}

}
