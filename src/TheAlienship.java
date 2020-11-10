import javax.swing.JLabel;

public class TheAlienship extends Sprite implements Runnable {

	//variables
	private Boolean move;
	private Boolean visible;
	private JLabel alienshipLabel;
	private TheStartship myStarship;

	
	
	//add variable to move
	private Thread t1;
	
	
	//getter and setters
	public void setAlienshipLabel (JLabel temp) {
		alienshipLabel = temp;	
	}
	public void setMyStarship (TheStartship temp) {
		myStarship = temp;
	}
	
	public Boolean getMove () {
		return move;
	}
	public boolean isMove() {
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
	
	//default constructor
	public TheAlienship() {
		super(0,0,"alienNormal.jpg",60,80);
		this.move = false; this.visible = true;
	}
	
	//show and hide function
	public void hide () {
		this.visible = false;
	}
	public void show() {
		this.visible = true;
	}
	//display
	public void Display () {
		System.out.println("X, Y: " + this.spriteX+ ", " + this.spriteY + 
							" /v: " + this.visible+ "/ m: " + this.move);
	}
	
	//move alien
	public void moveAlienship () {

		t1 = new Thread (this, "Move Alienship");
		t1.start();
	}
	
	//stop alien
	public void stopAlien () {
		this.move = false;
	}
	
	@Override
	public void run() {

		while (move) {
			int x = this.spriteX + GameProperties.CHARACTER_STEP * 2;
			
			if (x > GameProperties.SCREEN_WIDTH) {
				x = -1 * this.spriteW;
			}

			this.setSpriteX(x);
			
			alienshipLabel.setLocation(this.spriteX, this.spriteY);
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				
			}
		}
		
	}
	
}
