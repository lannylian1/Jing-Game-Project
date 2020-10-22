import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameMain extends JFrame implements KeyListener, ActionListener{
	//star ship
	private TheStartship mystarship;
	
	//image icon
	private ImageIcon starshipImage;
	private ImageIcon background = new ImageIcon ("backgound.jpg");
	
	//label
	private JLabel starshipLable;
	
	//container
	private Container content;
	
	//constructor
	public GameMain () {
		super("Super Glaxian");
		//screen size
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		content = getContentPane();

		JLabel background1 = new JLabel(new ImageIcon("C:\\Users\\lanny\\eclipse-workspace\\Jing Game Project\\bin\\backgroundO.jpg"));

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
