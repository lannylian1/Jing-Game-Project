import javax.swing.JLabel;

public class TheAlienship extends Sprite {

	//variables
	private Boolean move;
	private Boolean visible;
	private JLabel alienshipLabel;
	private TheStartship myStarship;
	private int hor, ver;
	
	
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
	//second constructor
	public TheAlienship (int x, int y) {
		initAlien(x, y);
	}
	private void initAlien(int x, int y) {
		this.hor =x;
		this.ver = y;
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
		t1 = new Thread ("Move Alienship");
		t1.start();
	}
	
	//stop alien
	public void stopAlien () {
		this.move = false;
	}
	
	
	
}
