import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Missile extends Sprite implements Runnable{
	//variable
	private JLabel missileLabel;
	private Thread t2;
	private Boolean move;
	private Boolean visible;
	private TheStartship myStarship;
	private Missile missile;
	
	public Missile () {
		super(0,0,"missile.png",10,10);
		this.move = false; this.visible = true;
	}
	
	/*public Missile (int x, int y) {
		this.spriteX =x;
		this.spriteY = y;
		initialize();
	}

	private void initialize() {

		//ImageIcon missile = new ImageIcon(this.getClass().getResource("bin\\missile.png"));
		//setImage(missile.getImage());
		
		//setSpriteX(spriteX + GameProperties.STARSHIP_WIDTH/2);
		//setSpriteY(spriteY);
		
	}*/
	
	
	public void setMissileLabel (JLabel temp) {
		missileLabel = temp;	
	}
	public void setMyStarship (TheStartship temp) {
		myStarship = temp;
	}
	public Boolean getMove () {
		return move;
	}
	public Boolean isMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	
	public Boolean getVisible () {
		return visible;
	}
	public Boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public void hide () {
		this.visible = false;
	}
	public void show() {
		this.visible = true;
	}
	
	public void moveMissile() {
		if (this.move) {
			this.move = true;
			t2 = new Thread (this, "move missile");
			t2.start();
		}

	}
	public void stopMissile() {
		this.move = false;
		missileLabel.setVisible(false);
		
	}
	

	@Override
	public void run() {
		missileLabel.setVisible(true);
		int missileX = this.myStarship.getSpriteX() + GameProperties.STARSHIP_WIDTH/2;
		int missileY = this.myStarship.getSpriteY()-20;
		this.setSpriteX(missileX);
		this.setSpriteY(missileY);
		missileLabel.setLocation(missileX, missileY);//myStarship.getSpriteX(), myStarship.getSpriteY());
		while (move) {
			System.out.println("Missile x,y: " + this.spriteX + ","+ this.spriteY);

			this.spriteY -= GameProperties.LASER_ANIMATE;
			missileY = this.spriteY;
			
			if (this.spriteY < 0) {
				this.stopMissile();
				
				//this.hide();
			}
			this.setSpriteX(missileX);
			this.setSpriteY(missileY);
			//this.setSpriteY(this.spriteY);
			//this.setSpriteX(myStarship.spriteX);
			
			missileLabel.setLocation(missileX, missileY);//myStarship.getSpriteX(), myStarship.getSpriteY());
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				
			}
			
		}
		
	}
}
