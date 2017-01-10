package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceVictor {
	
	private Color color;
	private Color originColor;
	private Action action;
	private int xCoord;
	private int yCoord;
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;

	public Button(int x, int y, int w, int h) {
		super(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x < getX()+getWidth() && y > getY() && y < getY()+getHeight();
	}

	@Override
	public void setColor(Color colorChoice) {
		this.color = colorChoice;
		originColor = color;
		update();
	}
	
	public void setX(int i){
		this.x = i;
	}

	public void setY(int i){
		this.y = i;
	}

	@Override
	public ButtonInterfaceVictor getAButton() {
		return this;
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
		update();
	}

	@Override
	public void highlight() {
		if(color != null){
			originColor = color;
		}
		this.color = Color.gray;
		update();
	}

	@Override
	public void dim() {
		this.color = originColor;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

}
