import java.awt.Button;
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
import javax.swing.JButton;
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
	
	private JLabel[][] alienLabels = new JLabel[5][3];
	private TheAlienship[][] aliens = new TheAlienship[5][3];
	
	private JButton AnimationButton;
	
	//container
	private Container content;
	
	//constructor
	public GameMain () {
		super("Super Glaxian");
		//screen size
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		
		//background 
		JLabel background1 = new JLabel(new ImageIcon("bin\\background0.jpg"));
		background1.setLocation(0, 0);
		background1.setSize(800, 600);
		
		//button
		AnimationButton = new JButton("Start");
	
		//add starship
		mystarship = new TheStartship ();
		starshipImage = new ImageIcon (getClass().getResource(mystarship.getFilename()));
		starshipLable = new JLabel();
		mystarship.setSpriteX(360);
		mystarship.setSpriteY(450);
		starshipLable.setIcon(starshipImage);
		starshipLable.setSize(mystarship.getSpriteW(), mystarship.getSpriteH());
		starshipLable.setLocation(mystarship.getSpriteX(), mystarship.getSpriteY());
		content.add(starshipLable);
		starshipLable.setFocusable(false);
		
		//add alien ship
		myalienship = new TheAlienship();
		alienshipImage = new ImageIcon (getClass().getResource(myalienship.getFilename()));
		alienshipLable = new JLabel();
		myalienship.setAlienshipLabel(alienshipLable);
		myalienship.setMyStarship(mystarship);//collision
		myalienship.setSpriteX(100);
		myalienship.setSpriteY(400);
		alienshipLable.setIcon(alienshipImage);
		alienshipLable.setSize(myalienship.getSpriteW(), myalienship.getSpriteH());
		alienshipLable.setLocation(myalienship.getSpriteX(), myalienship.getSpriteY());
		//content.add(alienshipLable);
		
		//move
		//myalienship.setMove(true);
		//myalienship.moveAlienship();
		

		alienshipLable.setFocusable(false);

		//add array to content
		int startx = 0;
		int starty = 0;
		for (int i = 0; i < 5; i++) {
			startx = 20*i;
			for (int j =0; j < 3; j++) {
				starty = 50 * j;
				aliens[i][j] = new TheAlienship();
				alienLabels[i][j]= new JLabel(new ImageIcon("bin\\alienNormal.jpg"));
				aliens[i][j].setAlienshipLabel(alienLabels[i][j]);
				aliens[i][j].setSpriteX(startx + 60*i);
				aliens[i][j].setSpriteY(starty);
				alienLabels[i][j].setSize(aliens[i][j].getSpriteW(), aliens[i][j].getSpriteH());
				alienLabels[i][j].setLocation(aliens[i][j].getSpriteX(), aliens[i][j].getSpriteY());	

				content.add(alienLabels[i][j]);
				alienLabels[i][j].setFocusable(false);
				aliens[i][j].setMove(true);
				aliens[i][j].moveAlienship();
			}
		}
		content.add(background1);
		
		//add button to screen
		
		/*AnimationButton.setLocation(GameProperties.SCREEN_WIDTH -100, GameProperties.SCREEN_HEIGHT -15);
		AnimationButton.setSize(100, 50);
		AnimationButton.addActionListener(this);
		content.add(AnimationButton);
		AnimationButton.setFocusable(false);*/
		
		//key listener
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
		/*if(e.getSource() == AnimationButton) {
			if (aliens[i][j].getMove()) {
				
			}
		}*/
		
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
