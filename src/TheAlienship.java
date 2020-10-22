import javax.swing.JLabel;

public class TheAlienship extends Sprite {

	//variables
	private boolean move;
	private boolean visible;
	private JLabel alienshipLabel;
	private TheStartship myStarship;
	
	
	//add variable to move
	private Thread t1;
	
	
	//getter and setters
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	public boolean isVisible() {
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
	
	
	
}
