package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceVictor {
	
	private static final int RADIUS = 80;
	private Color color;
	private Color originColor;
	private Action action;
	private boolean highlight;
	private String name;

	public Button() {
		super(0, 0, RADIUS, RADIUS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		action.act();
		
	}


	@Override
	public void setColor(Color color) {
		this.color = color;
		originColor = color;
		update();
		
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(originColor != null){
			g.setColor(originColor);
		}else{
			g.setColor(Color.white);
		}
		
		g.fillRect(0, 0, RADIUS, RADIUS);
		g.setColor(Color.black);
		g.drawRect(0, 0, RADIUS-1, RADIUS-1);
		
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+RADIUS/2), 2)+Math.pow(y-(getY()+RADIUS/2), 2));
		System.out.println(distance + " px away from "+name);
		return distance < RADIUS/2;
	}
	
	@Override
	public void dim() {
		originColor = Color.gray;
		highlight = false;
		update();
		
	
	}
	@Override
	public void highlight() {
		if(color != null){
			originColor = color;
		}
		highlight = true;
		update();
		
	}

	

}
