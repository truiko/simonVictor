package simon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceVictor {
	
	private String text;
	private int sequenceSize;
	private int round;
	private boolean gameLost;

	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		this.gameLost = true;
		update();
	}

	@Override
	public void setRound(int r) {
		this.round = r;
		update();
	}

	@Override
	public void setSequenceSize(int s) {
		this.sequenceSize = s;
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		if(text != null){
			g.setFont(new Font(font,Font.PLAIN,size));
			g.drawString(text, 4, getHeight()-5);
		}
	}

}
