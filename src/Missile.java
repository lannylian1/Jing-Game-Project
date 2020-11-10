import javax.swing.ImageIcon;

public class Missile extends Sprite {
	private int H_space = 6;
	private int V_space = 1;
	
	public Missile () {
		
	}
	
	public Missile (int x, int y) {
		ImageIcon missile = new ImageIcon(this.getClass().getResource("bin\\missile.png"));
		setImage(missile.getImage());
		setSpriteX(x + H_space);
		setSpriteY(y + V_space);
		
	}
}
