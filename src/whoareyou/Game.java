package whoareyou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;


public class Game  extends JPanel implements Runnable, KeyListener{

	private ArrayList <Ingredients> ingredients;
	private BufferedImage back; 
	private Buttons play, credits, ul, scereal, scake;
	private int key; 
	private int help;
	private char screen;
	private Ingredients milk, cereal, pepper;
	private String dish;
	private Sound s;

	

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		s=new Sound();
		s.playmusic("SoundFile.wav");

		screen = 'S';

		play = new Buttons("play",100,150,Color.CYAN);
		credits = new Buttons("credits",100,200,Color.CYAN);
		ul = new Buttons("update log",100,250,Color.CYAN);
		scereal = new Buttons ("cereal", 100,150,Color.CYAN);
		scake = new Buttons ("cake", 100,200,Color.CYAN);

		help = 1;
		milk = new Ingredients(400,400,20,40,Color.PINK);
		cereal = new Ingredients(700,420,50,20,Color.YELLOW);
		pepper = new Ingredients(490,400,20,40,Color.RED);
		ingredients = new ArrayList<Ingredients>();
		dish = "dish";
	}

	public void screen(Graphics g2d) {
		switch (screen) {
		case 'S':
			drawStartScreen(g2d);
			//test
			
			break;
		case 'T':
			g2d.setColor(Color.WHITE);
			g2d.drawString("selection",500, 400);
			selectionScreen(g2d);
			break;
		case 'G':
			g2d.setColor(Color.WHITE);
		g2d.drawString("game", 500, 400);
//		ArrayTest(g2d);
		getIngredients();
		drawIngredients(g2d);
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
		g2d.setColor(play.getC());
		g2d.drawString(play.getS(), play.getX(), play.getY());
		g2d.setColor(credits.getC());
		g2d.drawString(credits.getS(), credits.getX(), credits.getY());
		g2d.setColor(ul.getC());
		g2d.drawString(ul.getS(), ul.getX(), ul.getY());
		if(help==1) {
			play.setC(Color.WHITE);
		}
		else {
			play.setC(Color.CYAN);
		}
		if(help==2) {
			credits.setC(Color.WHITE);
		}else {
			credits.setC(Color.CYAN);
		}
		if(help==3) {
			ul.setC(Color.WHITE);
		}else {
			ul.setC(Color.CYAN);
		}
	}

	public void selectionScreen(Graphics g2d) {
		g2d.setColor(scereal.getC());
		g2d.drawString(scereal.getS(), scereal.getX(), scereal.getY());
		g2d.setColor(scake.getC());
		g2d.drawString(scake.getS(), scake.getX(), scake.getY());
		if (help==1) {
			scereal.setC(Color.WHITE);
		} else
			scereal.setC(Color.CYAN);
		if(help==2) {
			scake.setC(Color.WHITE);
		}else
			scake.setC(Color.CYAN);
	}
	public void drawIngredients(Graphics g2d) {
		for(int i = 0; i < ingredients.size(); i++) {
				g2d.setColor(ingredients.get(i).getC());
				g2d.fillRect(ingredients.get(i).getX(), ingredients.get(i).getY(), ingredients.get(i).getWidth(), ingredients.get(i).getHeight());
				System.out.println("milk");
			}
		}
	public void getIngredients() {
		if(dish=="cereal") {
			ingredients.add(milk);
			ingredients.add(cereal);
			
		}
		if(dish=="cake") {
			ingredients.add(pepper);
		}
	}
	//	public void ArrayTest(Graphics g2d) {
//		for(int i = 0; i < ingredients.size(); i++) {
//			if (ingredients.get(i)==milk) {
//				g2d.setColor(ingredients.get(i).getC());
//				g2d.fillRect(ingredients.get(i).getX(), ingredients.get(i).getY(), ingredients.get(i).getWidth(), ingredients.get(i).getHeight());
//				System.out.println("milk");
//			}
//		}
//	}
	



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
		if (screen=='S') {
			if(key==10) {
				if(help==1) {
					screen='T';
					help=1;
					
				}
				else if(help==2) {
					screen='C';
					help=1;
				}
				else if(help==3) {
					screen='U';
					help=1;
				}
			}
		} else if (screen=='T') {
			if(key==10) {
				screen = 'G';
				if(help==1) {
					dish = "cereal";
					help=1;
					
				}
				else if(help==2) {
					dish = "cake";
					help=1;
				}
			}		
		}
		if(screen=='S'||screen=='T') {
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
