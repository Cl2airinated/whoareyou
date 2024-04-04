package whoareyou;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private char screen;
	private Buttons test1;
	private Buttons test2;
	private Buttons test3;
	private int help;

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		screen = 'S';
		test1 = new Buttons("play",100,150,Color.CYAN);
		test2 = new Buttons("credits",100,200,Color.CYAN);
		test3 = new Buttons("update log",100,250,Color.CYAN);
		help = 1;
	}

	public void screen(Graphics g2d) {
		switch (screen) {
		case 'S':
			drawStartScreen(g2d);
			break;
		case 'G':
			g2d.setColor(Color.WHITE);
		g2d.drawString("game", 500, 400);
		break;
		case 'C':
		g2d.setColor(Color.WHITE);
		g2d.drawString("credits", 500, 400);
		break;
		case 'U':
		g2d.setColor(Color.WHITE);
		g2d.drawString("updates", 500, 400);
		break;	
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
		g2d.setColor(test1.getC());
		g2d.drawString(test1.getS(), test1.getX(), test1.getY());
		g2d.setColor(test2.getC());
		g2d.drawString(test2.getS(), test2.getX(), test2.getY());
		g2d.setColor(test3.getC());
		g2d.drawString(test3.getS(), test3.getX(), test3.getY());
		if(help==1) {
			test1.setC(Color.WHITE);
		}
		else {
			test1.setC(Color.CYAN);
		}
		if(help==2) {
			test2.setC(Color.WHITE);
		}else {
			test2.setC(Color.CYAN);
		}
		if(help==3) {
			test3.setC(Color.WHITE);
		}else {
			test3.setC(Color.CYAN);
		}
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
		if(key==10) {
			if(help==1) {
				screen='G';
				
			}
			else if(help==2) {
				screen='C';
			}
			else if(help==3) {
				screen='U';
			}
		}
		if(screen=='S') {
			if(key==40) {
				help++;
				System.out.println(help);
			}
			else if(key==38) {
				help--;
				System.out.println(help);
			}
			
		}
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}
