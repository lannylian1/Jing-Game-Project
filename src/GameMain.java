import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameMain extends JFrame implements KeyListener, ActionListener{
	//star ship and alien ship
	private TheStartship mystarship;
	private TheAlienship myalienship;
	//private List<TheAlienship> aliens;
	
	
	
	//image icon
	private ImageIcon starshipImage;
	private ImageIcon alienshipImage;
	
	
	//label
	private JLabel starshipLable;
	private JLabel alienshipLable;
	
	//container
	private Container content;
	
	//constructor
	public GameMain () {
		super("Super Glaxian");
		//screen size
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		content = getContentPane();

		JLabel background1 = new JLabel(new ImageIcon("bin\\background0.jpg"));

		add(background1);
	
		//add starship
		mystarship = new TheStartship ();
		starshipImage = new ImageIcon (getClass().getResource(mystarship.getFilename()));
		starshipLable = new JLabel();
		mystarship.setSpriteX(360);
		mystarship.setSpriteY(450);
		starshipLable.setIcon(starshipImage);
		starshipLable.setSize(mystarship.getSpriteW(), mystarship.getSpriteH());
		starshipLable.setLocation(mystarship.getSpriteX(), mystarship.getSpriteY());
		background1.add(starshipLable);
		content.add(background1);
		starshipLable.setFocusable(false);
		
		//add alien ship
		myalienship = new TheAlienship();
		alienshipImage = new ImageIcon (getClass().getResource(myalienship.getFilename()));
		alienshipLable = new JLabel();
		myalienship.setAlienshipLabel(alienshipLable);
		myalienship.setMyStarship(mystarship);//collision
		myalienship.setSpriteX(100);
		myalienship.setSpriteY(0);
		alienshipLable.setIcon(alienshipImage);
		alienshipLable.setSize(myalienship.getSpriteW(), myalienship.getSpriteH());
		alienshipLable.setLocation(myalienship.getSpriteX(), myalienship.getSpriteY());
		background1.add(alienshipLable);
		content.add(background1);
		
		alienshipLable.setFocusable(false);
		
		/*==>add array to content
		JLabel[] aliens = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			aliens[i]= new JLabel(new ImageIcon("bin\\alienNormal.jpg"));
		}
		content.add(aliens);*/
		
		
		//alien array
		/*for (int row = 0; row < 3; row++) {
			myalienship[row] = new TheAlienship();
			alienshipImage[row] = new ImageIcon (getClass().getResource(myalienship.getFilename()));
			alienshipLable[row] = new JLabel();
			myalienship[row].setAlienshipLabel(alienshipLable);
			myalienship[row].setMyStarship(mystarship);//collision
			myalienship[row].setSpriteX(100);
			myalienship[row].setSpriteY(0);
			alienshipLable[row].setIcon(alienshipImage);
			alienshipLable[row].setSize(myalienship.getSpriteW(), myalienship.getSpriteH());
			alienshipLable[row].setLocation(myalienship.getSpriteX(), myalienship.getSpriteY());
		}
		background1.add(alienshipLable);
		content.add(background1);
		
		alienshipLable.setFocusable(false);*/
		
		/*
		aliens = new ArrayList<>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col <5; col ++) {
				//var alien = new TheAlienship(GameProperties.ALIEN_INI_X + 10*col,  GameProperties.ALIEN_INI_Y + 10*row);
				//aliens.add(alien);
			}
		}
		
		//draw aliens
		 private void drawAlien(Graphic g) {
			 for (TheAlienship alien: aliens) {
			 	if (alien.isVisible()) {
			 		g.drawImage(alien.getFilename(),alien.getSpriteX(), alien.getSpriteY());
			 	}
			 }
		 }*/
		
		
		
		//keylistener
		content.addKeyListener(this);
		content.setFocusable(true);
		
		
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameMain myGame = new GameMain ();

		myGame.setVisible(true);
		myGame.setResizable(false);
		

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		//get star ship current position
		int x = mystarship.getSpriteX();

		
		//press key move left
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x-= GameProperties.CHARACTER_STEP;
			//set bounder
			if (x + mystarship.getSpriteW() <0 ) {
			x = GameProperties.SCREEN_WIDTH;
			}
		}
		
		//press key move right
		//press key move left
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x+= GameProperties.CHARACTER_STEP;
			//set bounder
			if (x > GameProperties.SCREEN_WIDTH) {
				x= -1* mystarship.getSpriteW();
			}
		}
		
		//update star ship state
		mystarship.setSpriteX(x);
		starshipLable.setLocation(mystarship.getSpriteX(),mystarship.getSpriteY());
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
