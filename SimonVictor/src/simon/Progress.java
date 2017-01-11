package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceVictor {
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 60;

	private boolean gameLost;
	private String round;
	private String pattern;
	
	public Progress() {
		super(60,60,WIDTH,HEIGHT);
	}

	@Override
	public void gameOver() {
		lost = true;
		update();
		
	}

	@Override
	public void setRound(int roundNum) {
		round = "Round "+ roundNum;
		update();
		
	}

	@Override
	public void setSequenceSize(int size) {
		pattern = "Pattern length "+size;
		update();
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(lost){
			g.setColor(Color.red);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (WIDTH - fm.stringWidth(go))/2, 20);
			g.drawString(pattern, (WIDTH - fm.stringWidth(pattern))/2, 40);

		}else{
			g.setColor(Color.darkGray);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
			if(round !=null && pattern != null){
				g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 20);
				g.drawString(pattern, (WIDTH - fm.stringWidth(pattern))/2, 40);
			}
		}
		
	}

}
