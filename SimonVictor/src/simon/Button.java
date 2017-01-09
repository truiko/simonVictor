package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceVictor {
	
	private Color color;

	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
		update();
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public ButtonInterfaceVictor getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		if ()

	}

}
