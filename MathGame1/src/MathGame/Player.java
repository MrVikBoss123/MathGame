package MathGame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.Timer;

public class Player implements ActionListener {

	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	private Image img;
	
	/**
	 * Goodguy default constructor
	 */
	public Player() {
		setxCoord(1000);
		setyCoord(1000);
		setWidth(800);
		setHeight(800);
		setImg("../files/racetrack.png");
	}
	
	/**
	 * Goodguy overloaded constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial height
	 */
	public Player(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}

		
				

	
	
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}
	
	public Image getImg() {
		return img;
	}

	public int getxCoord() {
		return this.xCoord;
	}
	
	public int getyCoord() {
		return this.yCoord;
	}

	public void setxCoord(int x) {
		this.xCoord = x;
	}
	
	public void setyCoord(int y) {
		this.yCoord = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		this.width = w;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		this.height = h;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

