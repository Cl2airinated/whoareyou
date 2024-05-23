package whoareyou;

import javax.swing.ImageIcon;

public class Background {
	private String s;

	
	public Background() {
		s="";
	}
	public Background(String s1) {
		s=s1;
		
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String toString() {
		return s;
	}
	public ImageIcon getImg() {
		return new ImageIcon(s);
	}

}
