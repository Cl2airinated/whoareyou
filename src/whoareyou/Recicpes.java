package whoareyou;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Recicpes {

	private ArrayList <Ingredients> ingredients;
	private String name;
	private int x,y;
	private Color c;
	
	public Recicpes(String n, ArrayList <Ingredients> i, int x, int y,Color c1) {
		ingredients = i;
		name=n;
		this.x=x;
		this.y=y;
		c=c1;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;
	}
	private void addIngredients(Ingredients i) {
		
		// TODO Auto-generated method stub
		ingredients.add(i);
	}
	
	public ArrayList <Ingredients> getIngredients() {
		return ingredients;
	}
//	public boolean collision(int x2, int y2) {
//		// TODO Auto-generated method stub
//		
//		Rectangle mouse = new Rectangle(x2,y2,1,1);
//		Rectangle recs= new Rectangle(x,y,25,25);
//		System.out.println("rec x" +x+" y"+y);
//		if(recs.intersects(mouse)) {
//			System.out.println("worked");
//
//			return true;
//		}
//		return false;
//	}
}
