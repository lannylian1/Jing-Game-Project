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
	private Missile missile;	
	
	//image icon
	private ImageIcon starshipImage;
	private ImageIcon alienshipImage;
	private ImageIcon missileImage;
	
	
	//label
	private JLabel starshipLable;
	private JLabel alienshipLable;
	private JLabel missileLable;
	
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
		
		//missile
		this.missile = new Missile();
		missileLable = new JLabel(new ImageIcon("bin\\missile.png"));
		missile.setMissileLabel(missileLable);		
		missile.setMyStarship(mystarship);
		int missileX = this.mystarship.getSpriteX() + GameProperties.STARSHIP_WIDTH/2;		
		int missileY = this.mystarship.getSpriteY()-20;
		missile.setSpriteX(missileX);
		missile.setSpriteY(missileY);
		missileLable.setSize(missile.getSpriteW(), missile.getSpriteH());
		missileLable.setLocation(missileX, missileY);
		missileLable.setVisible(false);
		//missile.setMove(true);
		//missile.moveMissile();
	
		
		content.add(missileLable);
		missileLable.setFocusable(false);
		
		//add alien ship
		myalienship = new TheAlienship();
		alienshipImage = new ImageIcon (getClass().getResource(myalienship.getFilename()));
		alienshipLable = new JLabel();
		myalienship.setAlienshipLabel(alienshipLable);
		myalienship.setMissile(missile);//collision
		myalienship.setSpriteX(100);
		myalienship.setSpriteY(400);
		alienshipLable.setIcon(alienshipImage);
		alienshipLable.setSize(myalienship.getSpriteW(), myalienship.getSpriteH());
		alienshipLable.setLocation(myalienship.getSpriteX(), myalienship.getSpriteY());
		//myalienship.setAnimationButton(AnimationButton);
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
				aliens[i][j].setMissile(missile);//set collision
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
		
		AnimationButton.setFocusable(false);
		
		content.add(AnimationButton);*/
		
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
			//set bounder for left side
			if (x < GameProperties.STARSHIP_WIDTH ) {
				x = GameProperties.STARSHIP_WIDTH;
			}
		}
		
		//press key move right
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x+= GameProperties.CHARACTER_STEP;
			//set bounder
			if (x >= GameProperties.SCREEN_WIDTH - 2*GameProperties.STARSHIP_WIDTH) {
				x = GameProperties.SCREEN_WIDTH - 2*GameProperties.STARSHIP_WIDTH;
			}
		}
		
		//update star ship state
		mystarship.setSpriteX(x);
		starshipLable.setLocation(mystarship.getSpriteX(),mystarship.getSpriteY());
		
		//if user press SPACE key, missile shows
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			missile.setMove(true);
			missile.moveMissile();
			int missileX = this.mystarship.getSpriteX();
			int missileY = this.mystarship.getSpriteY();
			
			//missile = new Missile(missileX, missileY);

			//missile.setMove(true);
			//missile.moveMissile();

			

			/*if (!missile.isMove()) {
				//System.out.println(missileY);
				missile = new Missile(missileX, missileY);
				
			}*/
			
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
