package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceVictor {
	
	private static final int WIDTH = 80;
	private static final int HEIGHT = 80;
	private Action action;
	private Color c;
	private Color displayColor;
	private boolean highlight;
	private String name;

	public Button() {
		super(0, 0, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		action.act();
		
	}


	@Override
	public void setColor(Color color) {
		this.c = color;
		displayColor = color;
		update();
		
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(displayColor != null){
			g.setColor(displayColor);
		}else{
			g.setColor(Color.gray);
		}
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+WIDTH/2), 2)+Math.pow(y-(getY()+HEIGHT/2), 2));
		System.out.println(distance + " px away from "+name);
		return distance < WIDTH/2;
	}

	@Override
	public void highlight() {
		if(c != null){
			displayColor = c;
		}
		highlight = true;
		update();
		
	}

	@Override
	public void dim() {
		displayColor = Color.gray;
		highlight = false;
		update();
		
	}

}
