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
	//private ArrayList <Background> bgs;
	private ArrayList <Background> bgs;
	private ArrayList <Wood> bowls;
	private BufferedImage back; 
	private Buttons play, credits, ul, scereal, scake, kea;
	private int key, help, grr, adding; 
	private char screen;
	private Ingredients milk, cereal, cend;
	private int dish;
	private boolean tapper, stopmult,first;
	private String bgee, bole, smartie;
//	private Background kitchen1;

	
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
		kea = new Buttons("upb.png",100,150,Color.CYAN);
//		scereal = new Buttons ("cereal", 100,150,Color.CYAN);
//		scake = new Buttons ("cake", 100,200,Color.CYAN);
		help = 1;
		milk = new Ingredients("milk.png","milk","pourmilk",0,550-418,314,418);
		cereal = new Ingredients("cerealbox.png","cereal","pourcereal",0,550-500,437,522);
		cend = new Ingredients("placeholder.png","placeholder","placeholder",490,400,20,40);
		rec = new ArrayList<Recicpes>();
		bgs= new ArrayList<Background>();
		bowls= new ArrayList<Wood>();
		tap = setTap();
		dish = 0;
		bgee= "";
		bole= "";
		smartie = "";
		adding = 0;
		tapper=true;
		stopmult=true;
		first=true;
		setRec();
		
		bgs.add(new Background("kitchen1.png"));
		bgs.add(new Background("blue.png"));
		bgs.add(new Background("instructions.png"));
		
		bowls.add(new Wood("emptybowl.png","emptybowl",100,561-339 ,546,339));
		bowls.add(new Wood("pourmilk.gif","pourmilk",100,561-561,546,561));
		bowls.add(new Wood("pourcereal.gif","pourcereal",100,561-561,546,561));
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
		bole="emptybowl";
		temp.add(milk);
		temp.add(cereal);
		temp.add(new Ingredients("tp.png","end"));
				return temp;
	}
	
	public void screen(Graphics g2d) {
		switch (screen) {
		case 'S':
			drawStartScreen(g2d);
			//g2d.drawImage(bowls.get(1).getImg().getImage(), bowls.get(1).getX(), bowls.get(1).getY(), bowls.get(1).getWidth(),bowls.get(1).getHeight(), getFocusCycleRootAncestor());
			//test
			System.out.println(getWidth());
			System.out.println(getHeight());
			break;
		case 'T':
			g2d.setColor(Color.WHITE);
			g2d.drawString("selection",500, 400);
			selectionScreen(g2d);
			break;
		case 'G':
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font ("Consolas", Font.CENTER_BASELINE, 36));
		g2d.drawString("game", 500, 400);
//		ArrayTest(g2d);
		drawBg(g2d);
		drawIngredients(g2d);
		drawBowl(g2d);
		cookSequence(g2d);
		break;
		case 'I':
		//g2d.setColor(Color.WHITE);
		//g2d.drawString("lalala", 400, 200);
			bgee="instructions.png";
		drawBg(g2d);
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
		int x = 800;
		for(Ingredients ing: rec.get(dish).getIngredients()) {
			g2d.drawImage(ing.getImg().getImage(), x, ing.getY(), ing.getWidth(), ing.getHeight(), getFocusCycleRootAncestor());
			
			x+=50+ing.getWidth();
		}
			
			
			
	/*	 {
				g2d.drawImage(new ImageIcon (ingredients.get(i).getS()).getImage(), ingredients.get(i).getX(), ingredients.get(i).getY(), ingredients.get(i).getWidth(), ingredients.get(i).getHeight(), getFocusCycleRootAncestor());
				//System.out.println("milk");
			}
			*/
		}
	
	public boolean drawBg(Graphics g2d) {
		int temp = 0;
		for(int i = 0; i < bgs.size(); i++) {
			if (bgee==bgs.get(i).getS()) {
				temp=i;
			}
		}
		//System.out.println(getWidth()+ " "+ getHeight());
		g2d.drawImage(bgs.get(temp).getImg().getImage(), 0, 0, getWidth(), getHeight(), getFocusCycleRootAncestor());
		return true;
	}
	public boolean drawBowl(Graphics g2d) {
		int temp = 0;
		for(int i = 0; i < bowls.size(); i++) {
			if (bole==bowls.get(i).getN()) {
				temp=i;
			}
		}
		//System.out.println(getWidth()+ " "+ getHeight());
		g2d.drawImage(bowls.get(temp).getImg().getImage(), bowls.get(temp).getX(), bowls.get(temp).getY(), bowls.get(temp).getWidth(), bowls.get(temp).getHeight(), getFocusCycleRootAncestor());
		return true;
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
		//g2d.drawImage((new ImageIcon("tb1.png").getImage()), 240, 550, 847, 144, getFocusCycleRootAncestor());
		g2d.drawImage(kea.getImg().getImage(), kea.getX(), kea.getY(), 400, 400, getFocusCycleRootAncestor());
		if(rec.get(dish).getIngredients().get(0)==milk||rec.get(dish).getIngredients().get(0)==cereal) {
//			setKitchen1();
			bgee="kitchen1.png";
			g2d.setColor(Color.WHITE);
			drawTap(g2d);
			tapper=true;
			g2d.drawString("pour the " + rec.get(dish).getIngredients().get(0).getN() + " by pressing the ↑ button", 10, 620);
			//System.out.print(bole);
		} else if(rec.get(dish).getIngredients().size()==1) {
			g2d.drawString("you did it! you made " + rec.get(dish).getName(), 410, 610);
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
				screen = 'I';
			}		
		} else if (screen=='I') {
			if (key==10) {
				screen = 'G';
			}
		} else if (screen=='G') {			
			if (key==38&&tapper) {
				
				tap.add(0, new Tap(grr+tap.size(),100,20,20, Color.WHITE));
				
				grr+=30;
				System.out.println(grr);
				if(tap.size()==5) {
					bole = rec.get(dish).getIngredients().get(0).getP();
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
