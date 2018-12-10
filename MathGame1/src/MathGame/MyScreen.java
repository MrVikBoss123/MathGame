package MathGame;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


import com.sun.glass.ui.Screen;
public class MyScreen extends JFrame {
/**
 * MyScreen basic window for game, inherits properties and methods from JFrame
 * @author mhoel
 * @since Sept. 27, 2018
 */
	
	/**
	 *  MyScreen default constructor
	 *  @param none, default constructor
	 */
	public MyScreen() {
		// this is current instance, setters are mutator methods which change properties
		this.setSize(1200,1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// main method is required to run the program
	public static void main(String[] args) throws Exception {
		// instantiate an individual instance of MyScreen by calling on constructor
		MyScreen screen = new MyScreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
		
		
		JFrame frame = new JFrame();
	
	    JTextField nameTextField = new JTextField();
	    screen.add(nameTextField, BorderLayout.NORTH);

	    KeyListener keyListener = new KeyListener() {
	      public void keyPressed(KeyEvent keyEvent) {
	        printIt("Pressed", keyEvent);
	      }

	      public void keyReleased(KeyEvent keyEvent) {
	        printIt("Released", keyEvent);
	      }

	      public void keyTyped(KeyEvent keyEvent) {
	        printIt("Typed", keyEvent);
	      }

	      private void printIt(String title, KeyEvent keyEvent) {
	        int keyCode = keyEvent.getKeyCode();
	        String keyText = KeyEvent.getKeyText(keyCode);
	        System.out.println(title + " : " + keyText + " / " + keyEvent.getKeyChar());
	      }
	    };
/*	    nameTextField.addKeyListener(keyListener);
	    
	       Circle circle = new Circle(5);
	        Rectangle rectangle = new Rectangle(10, 20);
	        
	        Group group = new Group(circle, rectangle);
	        
	        PathTransition transition = new PathTransition();
	        transition.setGroup(group);
	        transition.setDuration(Duration.seconds(5));
	        transition.setPath(new Line(0, 0, 500, 500));
	        transition.play();
	        
	        Scene scene = new Scene(group, 800,800);
	        stage.setScene(scene);
	        stage.show();		*/
	    }

	}



