package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

public class SimonScreenVictor extends ClickableScreen implements Runnable {
	
	private ProgressInterfaceVictor progress;
	private ArrayList<MoveInterfaceVictor> moves;
	private int movesIndex;
	private ButtonInterfaceVictor[] buttons;
	private int roundNumber;
	private int lastSelectedButton;
	private boolean validInput;
	private TextLabel label;

	public SimonScreenVictor(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		changeText("");
		nextRound();

	}

	private void nextRound() {
		validInput = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		moves.add(randomMove());
		progress.setSequenceSize(moves.size());
		changeText("Simon's turn.");
		label.setText("");
		showSequence();
		changeText("Your turn.");
		label.setText("");
		validInput = true;
		movesIndex = 0;
		
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects); // added parameter
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceVictor>();
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}

	private void showSequence() {
		ButtonInterfaceVictor b = null;
		for(MoveInterfaceVictor m: moves){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}
	
	private MoveInterfaceVictor randomMove() {
		Button b = null;
		b = (Button) buttons[(int) (Math.random()*buttons.length)];
		return getMove(b);
	}
	
	private MoveInterfaceVictor getMove(Button b) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceVictor getProgress() {
		
		return null;
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons = 6;
		Color[] colors = {Color.BLACK,Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN,Color.ORANGE};
		
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterfaceVictor b = getAButton();
			b.setColor(colors[i]);
			b.setX((30*i) + 50); 
			b.setY(80); 
			
			b.setAction(new Action(){
				public void act(){
					if(validInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
									b.dim();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						blink.start();
						if(b == moves.get(movesIndex).getButton()){
							movesIndex++;
							progress.gameOver();
						}
						if(movesIndex == moves.size()){
							Thread nextRound = new Thread(SimonScreenVictor.this);
							nextRound.start();
						}
					}
				}

				});
			viewObjects.add(b);
			
		}
	}

	private ButtonInterfaceVictor getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
