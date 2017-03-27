import java.awt.Component;
import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MyKeyAdapter extends KeyAdapter{
	
	public void keyPressed(KeyEvent e){
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Pressed Space");
            //y += 10;
           // repaint();
        }
		
		
		
		
	}

}
