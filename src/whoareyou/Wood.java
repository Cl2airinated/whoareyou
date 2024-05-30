package whoareyou;

import javax.swing.ImageIcon;

public class Wood {

	private String s,n;	
	private int x,y;
	private int width,height;
//	private Color c;
		public Wood()
		{
			s="";
			n="";
			x=0;
			y=0;
			width=0;
			height=0;
//			c=Color.cyan;
		}

		public Wood(String s1, String n1, int x1, int y1,int w, int h) {
			s=s1;
			n=n1;
			x=x1;
			y=y1;
			width=w;
			height=h;
//			c=c1;
		}
		public Wood(String s1, String n1) {
			s=s1;
			n=n1;
			x=0;
			y=0;
			width=100;
			height=100;
//			c=c1;
		}
		
		public String toString() {
			return n;
		}
		
		public String getN() {
			return n;
		}

		public void setN(String n) {
			this.n = n;
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
		
//		public Color getC() {
//			return c;
//		}
//
//		public void setC(Color c) {
//			this.c = c;
//		}
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
