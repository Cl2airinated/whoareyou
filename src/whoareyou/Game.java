package whoareyou;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;


public class Game extends JPanel implements Runnable, KeyListener{
private BufferedImage back;
private int key;
private int lives;
private boolean loser;
private String wrong;
private boolean running;


public Game() {
new Thread(this).start();
this.addKeyListener(this);
key =-1;
lives=7;
wrong="";
running=false;
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
g2d.setFont( new Font("Comic Sans", Font.BOLD, 40));
g2d.drawString("press the long cake to start",100,75);
g2d.clearRect(0,0,getSize().width, getSize().height);
g2d.setFont( new Font("Comic Sans", Font.BOLD, 40));
g2d.drawString(wrong, 500, 300);



	
	



//public void checkRestart() {
//
//	answer=getRandomWord();
//	displayWord= getDisplayWord();
//	
//}
//g2d.drawString("key " + key, 340, 100);

//drawLives(g2d); 

twoDgraph.drawImage(back, null, 0, 0);}


 
public void drawLives(Graphics g2d) {
	switch(lives) {
	
	case 1:
		checkRestart();
		break;
	case 2:
		g2d.drawString("Lost boohoo", 300, 200);
		break;
	case 3:
	
	case 4:
		
		break;

	case 5:

		
		break;

	case 6:

		break;

	case 7:

		break;
	}
	
}

//DO NOT DELETE
@Override
public void keyTyped(KeyEvent e) {
// TODO Auto-generated method stub
}
//DO NOT DELETE
@Override
public void keyPressed(KeyEvent e ) {
// TODO Auto-generated method stub
	key= e.getKeyCode();	
	char c= e.getKeyChar();	


System.out.println(key);
//if (key==32) {
//	lives++;
	
	if(key==32) {
		running=true;
		lives++;}
		if(key==92) {
			checkRestart();
	}
	
}
private void checkRestart() {
	lives=7;
	wrong="";
}

//DO NOT DELETE
@Override
public void keyReleased(KeyEvent e) {
}
}
