package whoareyou;

import java.awt.Color;

import javax.swing.*;

public class Buttons {

	private String s;	
	private int x,y;
//	private int width,height;
	private Color c;
		public Buttons()
		{
			s="";
			x=0;
			y=0;
//			width=0;
//			height=0;
			c=Color.cyan;
		}

		
		public Buttons(String s1, int x1, int y1,Color c1) {
			s=s1;
			x=x1;
			y=y1;
//			width=w;
//			height=h;
			c=c1;
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

//		public int getWidth() {
//			return width;
//		}
//
//		public void setWidth(int width) {
//			this.width = width;
//		}
//
//		public int getHeight() {
//			return height;
//		}
//
//		public void setHeight(int height) {
//			this.height = height;
//		}
		
		public Color getC() {
			return c;
		}

		public void setC(Color c) {
			this.c = c;
		}
		
		public ImageIcon getImg() {
			return new ImageIcon(s);
		}

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}
		
	}


