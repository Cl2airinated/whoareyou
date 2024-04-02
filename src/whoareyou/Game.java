package whoareyou;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private char screen;


	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		screen = 'S';
	
	}

	public void screen(Graphics g2d) {
		switch (screen) {
		case 'S':
			drawStartScreen(g2d);
			break;
		case 'G':
		}
	}
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		screen(g2d);
		
		
		twoDgraph.drawImage(back, null, 0, 0);
	}
	
	public void drawStartScreen(Graphics g2d) {
		g2d.setColor(Color.WHITE);
		g2d.drawString("start screen placeholder", (getSize().width)/2, (getSize().height)/2);
		System.out.print("pleaseee");
	}

	



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}
