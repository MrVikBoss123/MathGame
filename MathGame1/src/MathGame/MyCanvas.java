package MathGame; // package name

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import sun.audio.*;
import javax.swing.*;
import java.lang.Object;
import java.awt.geom.Ellipse2D;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Timer;
import javax.swing.JButton;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

// importing
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;
import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.shape.MoveTo;

public class MyCanvas extends Canvas implements KeyListener, MouseListener, ActionListener { // inherits the Canvas
																								// class, implements the
																								// Keylistener interface

	// global variables - accessible in all methods
	Player player = new Player(626, 596, 150, 150, "Files/player.png"); // Instance, creates new object link
	Player background = new Player(0, 0, 1200, 800, "Files/racetrack.png"); // Instance, creates new object background
	Player menu = new Player(0, 0, 1200, 800, "Files/startscreen2.png");
	Player menu2 = new Player(0, 0, 1200, 800, "Files/startscreen0.jpg");
	Player easy = new Player(20, 30, 250, 250, "Files/easy.png");
	Player whitebackground = new Player(0, 0, 1200, 800, "Files/whitebackground.png");
	Player medium = new Player(420, 0, 350, 340, "Files/medium.png");
	Player hard = new Player(875, 32, 250, 250, "Files/hard.png");
	Player levels = new Player(80, 80, 200, 200, "Files/levels.png");
	Player timetrials = new Player(80, 80, 600, 200, "Files/timetrials.png");
	Player reload = new Player(520, 525, 50, 50, "Files/reload.png");
	Player close = new Player(580, 525, 50, 50, "Files/close.png" );
	Player blue = new Player(10, 10, 50, 50, "Files/bluesquare.png");
	Player red = new Player(10, 10, 50, 50, "Files/redsquare.png");
	Ellipse2D circle = new Ellipse2D.Double(player.getxCoord(), player.getyCoord(), 125, 125);
	Ellipse2D coverCircle = new Ellipse2D.Double(player.getxCoord(), player.getyCoord(), 125, 125);
	Rectangle reloadrect = new Rectangle(reload.getxCoord(), reload.getyCoord(), reload.getWidth(), reload.getHeight());
	Rectangle closerect = new Rectangle(close.getxCoord(), close.getyCoord(), close.getWidth(), close.getHeight());
	boolean start = true;
	boolean start2 = false;
	boolean insideeasy = false;
	boolean insidemedium = false;
	boolean insidehard = false;
	boolean go = false;
	boolean start3 = false;
	boolean start4 = false;
	boolean start5 = false;
	boolean gamebeginseasy = false;
	boolean gamebeginsmedium = false;
	boolean gamebeginshard = false;
	boolean correct = false;
	boolean incorrect = false;
	boolean started = false;
	boolean leftcorrect = false;
	boolean midcorrect = false;
	boolean rightcorrect = false;
	boolean tryagain = false;
	boolean end = false;
	boolean bell = false;
	int correctcount = 0;

	/**
	 * MyCanvas drawing canvas inherits from java.awt.Canvas
	 * 
	 * @author mhoel
	 * @since Sept. 30, 2018
	 * @param no parameters, default constructor
	 */
	public MyCanvas() { // default constructor
		this.setSize(1200, 1000); // set same size as MyScreen
		this.addKeyListener(this); // add the listener to your canvas
		this.addMouseListener(this); // add the listener to your canvas
		playIt("Files/Superboy.wav"); // method PlayIt
		if (bell == true) {
			playIt("Files/bell.wav");
		}

	}

	public void playIt(String filename) {

		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	/**
	 * paint overload java.awt.Canvas paint method and make it draw an oval
	 * 
	 * @param graphics context variable called g
	 */

	@Override
	public void paint(Graphics g) {
		Timer t = new Timer();
		Graphics2D g2 = (Graphics2D)g;

		if (start == true) {
			g.drawImage(menu.getImg(), menu.getxCoord(), menu.getyCoord(), menu.getWidth(), menu.getHeight(), this);
		}

		if (start2 == true) {
			g.drawImage(whitebackground.getImg(), whitebackground.getxCoord(), whitebackground.getyCoord(),
					whitebackground.getWidth(), whitebackground.getHeight(), this);
			g.drawImage(easy.getImg(), easy.getxCoord(), easy.getyCoord(), easy.getWidth(), easy.getHeight(), this);
			g.drawImage(medium.getImg(), medium.getxCoord(), medium.getyCoord(), medium.getWidth(), medium.getHeight(),
					this);
			g.drawImage(hard.getImg(), hard.getxCoord(), hard.getyCoord(), hard.getWidth(), hard.getHeight(), this);

			g.setColor(new Color(175, 0, 0, 100));
			g.drawOval(47, 50, 200, 200);
			g.drawOval(431, 55, 320, 200);
			g.drawOval(899, 50, 205, 200);

			if (insideeasy == true) {
				g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(), background.getWidth(),
						background.getHeight(), this);
				g.setColor(new Color(255, 0, 0, 100));
				g.setFont(new Font("SansSerif", Font.PLAIN, 40));
				g.drawString("Easy Mode", 250, 350);
				g.drawString("This race will consist of trying to find equivalent fractions.", 250, 400);
				g.drawString("Press Enter when you are ready", 250, 450);
				start3 = true;

				if (gamebeginseasy = true) {
					g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(),
							background.getWidth(), background.getHeight(), this);
					g.drawImage(blue.getImg(), blue.getxCoord(), blue.getyCoord(),
							blue.getWidth(), blue.getHeight(), this);
					
					}
					//g2.fill(circle);
					int numerator = (int) (Math.random() * 10 + 1);
					int denominator = (int) (Math.random() * 10 + 1);
					int factor1 = (int) (Math.random() * 4 + 2);
					int random1 = (int) (Math.random() * 10 + 1);
					int random2 = (int) (Math.random() * 10 + 1);
					int random3 = (int) (Math.random() * 10 + 1);
					int random4 = (int) (Math.random() * 10 + 1);
					int randomposition = (int) (Math.random() * 3);
					if (randomposition == 0) {
						leftcorrect = true;
						midcorrect = false;
						rightcorrect = false;
						System.out.println(randomposition);
					}
					if (randomposition == 1) {
						leftcorrect = false;
						midcorrect = true;
						rightcorrect = false;

						System.out.println(randomposition);
					}
					if (randomposition == 2) {
						leftcorrect = false;
						midcorrect = false;
						rightcorrect = true;
						System.out.println(randomposition);
					}
					g.setColor(Color.BLACK);
					g.drawString("What is equivalent to " + numerator + "/" + denominator + "?", 325, 300);
					g.drawString(numerator * factor1 + "/" + denominator * factor1, 325 + 200 * randomposition, 350);
					g.drawString(random1 + "/" + random2, 325 + (200 * ((randomposition + 1) % 3)), 350);
					g.drawString(random3 + "/" + random4, 325 + (200 * ((randomposition + 2) % 3)), 350);
					if (tryagain == true && started == true) {
						g.drawString("Invalid", 525, 450);
						System.out.println("Invalid");
					}
					if (correct == true && started == true) {
						g.drawString("Correct!", 525, 450);
						System.out.println("Correct");
						
					}
					if (correct == false && started == true && tryagain == false) {
						g.drawString("Nope!", 525, 450);
						System.out.println("Nope");
						
					}
				}

			}

		

		if (insidemedium == true) {
			g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(), background.getWidth(),
					background.getHeight(), this);
			g.setFont(new Font("SansSerif", Font.PLAIN, 40));
			g.drawString("Easy Mode", 250, 350);
			g.drawString("This race will consist of trying to find equivalent fractions.", 250, 400);
			g.drawString("Press Enter when you are ready", 250, 450);
			start4 = true;

			if (gamebeginsmedium = true) {
				g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(), background.getWidth(),
						background.getHeight(), this);
				g.drawImage(blue.getImg(), blue.getxCoord(), blue.getyCoord(),
						blue.getWidth(), blue.getHeight(), this);
				
				//g2.fill(circle);
				int numerator = (int) (Math.random() * 20 + 1);
				int denominator = (int) (Math.random() * 20 + 1);
				int factor1 = (int) (Math.random() * 4 + 2);
				int random1 = (int) (Math.random() * 10 + 1);
				int random2 = (int) (Math.random() * 10 + 1);
				int random3 = (int) (Math.random() * 10 + 1);
				int random4 = (int) (Math.random() * 10 + 1);
				int randomposition = (int) (Math.random() * 3);
				if (randomposition == 0) {
					leftcorrect = true;
					midcorrect = false;
					rightcorrect = false;
					System.out.println(randomposition);
				}
				if (randomposition == 1) {
					leftcorrect = false;
					midcorrect = true;
					rightcorrect = false;

					System.out.println(randomposition);
				}
				if (randomposition == 2) {
					leftcorrect = false;
					midcorrect = false;
					rightcorrect = true;
					System.out.println(randomposition);
				}
				g.setColor(Color.BLACK);
				g.drawString("What is equivalent to " + numerator + "/" + denominator + "?", 325, 300);
				g.drawString(numerator * factor1 + "/" + denominator * factor1, 325 + 200 * randomposition, 350);
				g.drawString(random1 + "/" + random2, 325 + (200 * ((randomposition + 1) % 3)), 350);
				g.drawString(random3 + "/" + random4, 325 + (200 * ((randomposition + 2) % 3)), 350);
				if (tryagain == true && started == true) {
					g.drawString("Invalid", 525, 450);
					System.out.println("Invalid");
				}
				if (correct == true && started == true) {
					g.drawString("Correct!", 525, 450);
					System.out.println("Correct");

				}
				if (correct == false && started == true && tryagain == false) {
					g.drawString("Nope!", 525, 450);
					System.out.println("Nope");
				}
			}
		}
		if (insidehard == true) {
			g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(), background.getWidth(),
					background.getHeight(), this);
			g.setFont(new Font("SansSerif", Font.PLAIN, 40));
			g.setColor(new Color(70, 0, 0, 100));
			g.drawString("Hard Mode", 580, 350);
			g.drawString("This race will consist of trying to find equivalent fractions.", 300, 400);
			g.drawString("Press Space when you are ready", 400, 450);
			start5 = true;
			if (gamebeginshard = true) {
				g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(), background.getWidth(),
						background.getHeight(), this);
				g.drawImage(blue.getImg(), blue.getxCoord(), blue.getyCoord(),
						blue.getWidth(), blue.getHeight(), this);
			
				//g2.fill(circle);
				int numerator = (int) (Math.random() * 30 + 1);
				int denominator = (int) (Math.random() * 30 + 1);
				int factor1 = (int) (Math.random() * 4 + 2);
				int random1 = (int) (Math.random() * 10 + 1);
				int random2 = (int) (Math.random() * 10 + 1);
				int random3 = (int) (Math.random() * 10 + 1);
				int random4 = (int) (Math.random() * 10 + 1);
				int randomposition = (int) (Math.random() * 3);
				if (randomposition == 0) {
					leftcorrect = true;
					midcorrect = false;
					rightcorrect = false;
					System.out.println(randomposition);
				}
				if (randomposition == 1) {
					leftcorrect = false;
					midcorrect = true;
					rightcorrect = false;

					System.out.println(randomposition);
				}
				if (randomposition == 2) {
					leftcorrect = false;
					midcorrect = false;
					rightcorrect = true;
					System.out.println(randomposition);
				}
				g.setColor(Color.BLACK);
				g.drawString("What is equivalent to " + numerator + "/" + denominator + "?", 325, 300);
				g.drawString(numerator * factor1 + "/" + denominator * factor1, 325 + 200 * randomposition, 350);
				g.drawString(random1 + "/" + random2, 325 + (200 * ((randomposition + 1) % 3)), 350);
				g.drawString(random3 + "/" + random4, 325 + (200 * ((randomposition + 2) % 3)), 350);
			}
		}
		if (tryagain == true && started == true) {
			g.drawString("Invalid", 525, 450);
			System.out.println("Invalid");
		}
		
		if (correct == true && started == true) {
			correctcount++;
			g.drawString("Correct!", 525, 450);
			System.out.println("Correct");
			//g.setColor(new Color(55,55,55,160));
			//g2.clearRect((int)coverCircle.getX(), (int)coverCircle.getY(), (int)coverCircle.getWidth(), (int)coverCircle.getHeight());
			//g.setColor(Color.red);
			if (correctcount == 16) {
				bell = true;
				System.out.println("Bell");
			}
			if (correctcount % 16 == 0) {
				circle.setFrame(626, 596, circle.getWidth(), circle.getHeight());			
			}
			else if (correctcount % 16 == 15) {
				circle.setFrame(circle.getX() - 110, circle.getY() + 65, circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 14) {
				circle.setFrame(circle.getX() - 60, circle.getY() + 130, circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 13) {
				circle.setFrame(circle.getX() + 40, circle.getY() + 130, circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 12) {
				circle.setFrame(circle.getX() + 130, circle.getY() + 92, circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 11) {
				circle.setFrame(circle.getX() + 130, circle.getY() + 40, circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 10) {
				circle.setFrame(circle.getX() + 150, circle.getY() + 20, circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 9) {
				circle.setFrame(circle.getX() + 150, circle.getY() - 13 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 8) {
				circle.setFrame(circle.getX() + 150, circle.getY() - 50 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 7) {
				circle.setFrame(circle.getX() + 120, circle.getY() - 90 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 6) {
				circle.setFrame(circle.getX() + 45, circle.getY() - 140 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 5) {
				circle.setFrame(circle.getX() - circle.getWidth() + 62, circle.getY() - 120 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 4) {
				circle.setFrame(circle.getX() - circle.getWidth() + 10, circle.getY() - 80 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 3) {
				circle.setFrame(circle.getX() - circle.getWidth(), circle.getY() - 35 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 2) {
				circle.setFrame(circle.getX() - circle.getWidth(), circle.getY() - 20 , circle.getWidth(), circle.getHeight());
			}
			else if (correctcount % 16 == 1) {
				circle.setFrame(circle.getX() - circle.getWidth(), circle.getY() + 20 , circle.getWidth(), circle.getHeight());
			}
			
			//coverCircle.setFrame(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
					
			}
			if (correct == false && started == true && tryagain == false) {
				g.drawString("Nope!", 525, 450);
				System.out.println("Nope");
			}
			
			if (insideeasy || insidemedium || insidehard) {
				
				g.setColor(Color.red);
				g2.fill(circle);
			}
			if (correctcount == 33) {
				started = false;
				end = true;
				
			}
			if (end) {
				g.drawImage(background.getImg(), background.getxCoord(), background.getyCoord(), background.getWidth(),
						background.getHeight(), this);
				g.drawString("Good Game!!!", 455, 300);
				g.setFont(new Font("SansSerif", Font.PLAIN, 30));
				g.setColor(Color.blue);
				g.drawString("Press escape to quit", 450, 350);
				g.drawImage(reload.getImg(), reload.getxCoord(), reload.getyCoord(),
						reload.getWidth(), reload.getHeight(), this);
				g.drawImage(close.getImg(), close.getxCoord(), close.getyCoord(),
						close.getWidth(), close.getHeight(), this);
				
			}
		}
		
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		
		if (end) {
			if (e.getKeyCode() == 27) {
				System.exit(0);
			}
		}
		if (e.getKeyCode() == 32) {
			start = false;
			start2 = true;
		}
		repaint();

		if (e.getKeyCode() == 13 && start3 == true) {
			gamebeginseasy = true;
		}
		if (e.getKeyCode() == 13 && start4 == true) {
			gamebeginsmedium = true;
		}
		if (e.getKeyCode() == 13 && start5 == true) {
			gamebeginshard = true;
		}
		repaint();
		if (start3 == true || start4 == true || start5 == true) {
			if (leftcorrect == true) {
				if (e.getKeyCode() == 37) {
					tryagain = false;
					started = true;
					correct = true;
				}
				if (e.getKeyCode() == 40) {
					tryagain = false;
					started = true;
					correct = false;
				}
				if (e.getKeyCode() == 39) {
					tryagain = false;
					started = true;
					correct = false;
				}
				if (e.getKeyCode() != 37 && e.getKeyCode() != 39 && e.getKeyCode() != 40) {
					tryagain = true;
					correct = false;
				}
			}
			if (midcorrect == true) {
				leftcorrect = false;
				rightcorrect = false;
				if (e.getKeyCode() == 37) {
					tryagain = false;
					started = true;
					correct = false;
				}
				if (e.getKeyCode() == 40) {
					tryagain = false;
					started = true;
					correct = true;
				}
				if (e.getKeyCode() == 39) {
					tryagain = false;
					started = true;
					correct = false;
				}
				if (e.getKeyCode() != 37 && (e.getKeyCode() != 39 && e.getKeyCode() != 40)) {
					tryagain = true;
					correct = false;
				}
			}
			if (rightcorrect == true) {
				leftcorrect = false;
				midcorrect = false;
				if (e.getKeyCode() == 37) {
					tryagain = false;
					started = true;
					correct = false;
				}
				if (e.getKeyCode() == 40) {
					tryagain = false;
					started = true;
					correct = false;
				}
				if (e.getKeyCode() == 39) {
					tryagain = false;
					started = true;
					correct = true;
				}
				if (e.getKeyCode() != 37 && (e.getKeyCode() != 39 && e.getKeyCode() != 40)) {
					tryagain = true;
					correct = false;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;

		Ellipse2D.Float ovaleasy = new Ellipse2D.Float(47, 50, 200, 200);
		Ellipse2D.Float ovalmedium = new Ellipse2D.Float(431, 55, 320, 200);
		Ellipse2D.Float ovalhard = new Ellipse2D.Float(899, 50, 205, 200);
		if (ovaleasy.contains(mouseX, mouseY)) {
			insideeasy = true;
		}
		if (ovalmedium.contains(mouseX, mouseY)) {
			insidemedium = true;
		}
		if (ovalhard.contains(mouseX, mouseY)) {
			insidehard = true;
		}

		System.out.println("mouseClicked");
		
		
		if (end == true) {
			if (reloadrect.contains(mouseX, mouseY)) {
				boolean start = true;
				boolean start2 = false;
				boolean insideeasy = false;
				boolean insidemedium = false;
				boolean insidehard = false;
				boolean go = false;
				boolean start3 = false;
				boolean start4 = false;
				boolean start5 = false;
				boolean gamebeginseasy = false;
				boolean gamebeginsmedium = false;
				boolean gamebeginshard = false;
				boolean correct = false;
				boolean incorrect = false;
				boolean started = false;
				boolean leftcorrect = false;
				boolean midcorrect = false;
				boolean rightcorrect = false;
				boolean tryagain = false;
				boolean end = false;
				
			}
			else if (closerect.contains(mouseX, mouseY)) {
				System.exit(0);
			}
			else System.out.println("Invalid");
		}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e) {
	
		}

	}

