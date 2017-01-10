package simon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceVictor {
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 60;

	private boolean gameOver;
	private String round;
	private String sequence;

	public Progress() {
		super(60,60,WIDTH,HEIGHT);
	}



	public void setRound(int roundNumber) {
		round = "Round "+roundNumber;
		update();
	}

	public void setSequenceLength(int size) {
		sequence = "Sequence length "+size;
		update();
	}

	public void gameOver() {
		gameOver = true;
		update();
	}



	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(lost){
			g.setColor(new Color(255,55,90));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (WIDTH - fm.stringWidth(go))/2, 20);
			g.drawString(pattern, (WIDTH - fm.stringWidth(pattern))/2, 40);

		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.black);
			g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
			if(round !=null && pattern != null){

				g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 20);
				g.drawString(pattern, (WIDTH - fm.stringWidth(pattern))/2, 40);
			}
		}
		
	}

}
