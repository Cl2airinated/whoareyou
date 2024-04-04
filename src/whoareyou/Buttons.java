package whoareyou;

import java.awt.Color;

import javax.swing.*;

public class Buttons {

		
	private int x,y,width,height;
	private Color c;
		public Buttons()
		{
			x=0;
			y=0;
			width=0;
			height=0;
			c=Color.cyan;
		}

		public Buttons(int x1, int y1, int w, int h,Color c1) {
			x=x1;
			y=y1;
			width=w;
			height=h;
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

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		
		public Color getC() {
			return c;
		}

		public void setC(Color c) {
			this.c = c;
		}
	}


