package whoareyou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener,MouseMotionListener{

	private ArrayList <Recicpes> rec;
	private ArrayList <Tap> tap;
	private BufferedImage back; 
	private Buttons play, credits, ul, scereal, scake;
	private int key, help, grr, adding; 
	private char screen;
	private Ingredients milk, cereal, cend;
	private int dish;
	private boolean tapper, stopmult,first;

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		key =-1; 
		grr=600;
		screen = 'S';
		play = new Buttons("play",100,150,Color.CYAN);
		credits = new Buttons("credits",100,200,Color.CYAN);
		ul = new Buttons("update log",100,250,Color.CYAN);
//		scereal = new Buttons ("cereal", 100,150,Color.CYAN);
//		scake = new Buttons ("cake", 100,200,Color.CYAN);
		help = 1;
		milk = new Ingredients("milk.png","milk",400,400,100,100);
		cereal = new Ingredients("cerealbox.png","cereal",700,420,100,100);
		cend = new Ingredients("placeholder.png","placeholder",490,400,20,40);
		rec = new ArrayList<Recicpes>();
		tap = setTap();
		dish = 0;
		adding = 0;
		tapper=true;
		stopmult=true;
		first=true;
		setRec();
	}

	private void setRec() {
		// TODO Auto-generated method stub
		rec.add(new Recicpes("cereal", setCerealArray(), 50,50,Color.CYAN));
		rec.add(new Recicpes("cake", setCakeArray(), 50, 75,Color.CYAN));
		//rec.add(new Recicpes("placeholder",setCakeArray(),50,75,Color.CYAN));

	}

	private ArrayList<Ingredients> setCakeArray() {
		// TODO Auto-generated method stub
		ArrayList <Ingredients>temp  = new ArrayList <Ingredients>();
		temp.add(new Ingredients("sugar", "filename"));	
		temp.add(new Ingredients("flour", "filename"));	
		temp.add(cereal);
		temp.add(milk);	
		temp.add(new Ingredients("eggs", "filename"));	

	
		return temp;
	}

	private ArrayList <Ingredients> setCerealArray() {
		// TODO Auto-generated method stub
		ArrayList <Ingredients>temp  = new ArrayList <Ingredients>();
		temp.add(milk);
		temp.add(cereal);
		temp.add(new Ingredients("tp.png","end"));
				return temp;
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
		drawIngredients(g2d);
		cookSequence(g2d);
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
	
	public ArrayList <Tap> setTap(){
		ArrayList <Tap> temp = new ArrayList <Tap>();
		int x=400;
		int y=100;
			for(int i=0; i<0; i++){
				temp.add(new Tap(i+x,y,20,20, Color.WHITE));
				x+=60;
				//System.out.println("working");
			}
		return temp;
	}
	
	public void drawTap(Graphics g2d) {
		for (Tap a: tap) {
			g2d.setColor(a.getC());
			g2d.fillRect(a.getX(), a.getY(), a.getWidth(), a.getHeight());
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
		
		
		//System.out.println(rec.get(dish));
		
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
//		g2d.setColor(scereal.getC());
//		g2d.drawString(scereal.getS(), scereal.getX(), scereal.getY());
//		g2d.setColor(scake.getC());
//		g2d.drawString(scake.getS(), scake.getX(), scake.getY());
//		if (help==1) {
//			scereal.setC(Color.WHITE);
//		} else
//			scereal.setC(Color.CYAN);
//		if(help==2) {
//			scake.setC(Color.WHITE);
//		}else
//			scake.setC(Color.CYAN);
//		
//		g2d.setColor(Color.WHITE);
		int x=100;
		int y=150;
		for(int i=0; i<rec.size(); i++) {
			g2d.setColor(rec.get(i).getC());
			g2d.drawString(rec.get(i).getName(), x, i+y);
			y+=50;
			if (help==i+1) {
				rec.get(i).setC(Color.WHITE);
				dish=i;
		}	else {
			rec.get(i).setC(Color.CYAN);
		}
		}
	}
	public void drawIngredients(Graphics g2d) {
		int x = 100;
		for(Ingredients ing: rec.get(dish).getIngredients()) {
			g2d.drawImage(ing.getImg().getImage(), x, ing.getWidth(), ing.getWidth(), ing.getHeight(), getFocusCycleRootAncestor());
			
			x+=2-00;
		}
			
			
			
	/*	for(int i = 0; i < rec.get(dish).getIngredients().size(); i++) {
				g2d.drawImage(new ImageIcon (ingredients.get(i).getS()).getImage(), ingredients.get(i).getX(), ingredients.get(i).getY(), ingredients.get(i).getWidth(), ingredients.get(i).getHeight(), getFocusCycleRootAncestor());
				//System.out.println("milk");
			}
			*/
		}
	
	public void cookSequence(Graphics g2d) {
	/*	if (rec.get(dish)==milk||ingredients.get(0)==cereal) {
			//System.out.println("Milkkkk");
			g2d.setColor(Color.WHITE);
			drawTap(g2d);
			g2d.drawString("press the up arrow to pour " + ingredients.get(0).getN(), 500, 300);
			tapper=true;
		}
		if(ingredients.get(0)==cend) {
			g2d.drawString("you did it! you made " + dish, 500, 300);
		}
		*/
		if(rec.get(dish).getIngredients().get(0)==milk||rec.get(dish).getIngredients().get(0)==cereal) {
			g2d.setColor(Color.WHITE);
			drawTap(g2d);
			tapper=true;
			g2d.drawString("press the up arrow to pour " + rec.get(dish).getIngredients().get(0).getN(), 500, 300);
		} else if(rec.get(dish).getIngredients().size()==1) {
			g2d.drawString("you did it! you made " + rec.get(dish).getName(), 500, 300);
		}
		System.out.println("list of ingredients "+ rec.get(dish).getIngredients());
		
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
//		dish++;
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
			}		
		}
		if(screen=='S'||screen=='T') {
			if(key==40) {
				help++;
				//System.out.println(help);
			}
			else if(key==38) {
				help--;
				//System.out.println(help);
			}
			
		}
		if (screen=='G') {
			
			if (key==38&&tapper) {
				
				tap.add(0, new Tap(grr+tap.size(),100,20,20, Color.WHITE));
				
				grr+=30;
				System.out.println(grr);
				if(tap.size()==5) {
					for(int i=0; i<5; i++) {
						tap.remove(0);
					}
					grr=600;
					rec.get(dish).getIngredients().remove(0);
					//ingredients.remove(0);
					tapper=false;
					//System.out.println("ingredients:"+ ingredients.size());
				}
			}
		}
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//System.out.println("clicked" +e.getX() +" y " +e.getY());
//		switch (screen) {
//		case 'T':
//			for(int i=0; i<rec.size(); i++) {
//				if(rec.get(i).collision(e.getX(), e.getY())) {
//					dish=i;
//					screen='G';
//					break;
//				}
//			}
//		}
//		
		}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
