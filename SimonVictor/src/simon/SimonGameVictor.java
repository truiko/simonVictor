package simon;

import guiPractice.GUIApplication;

public class SimonGameVictor extends GUIApplication {

	public SimonGameVictor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		SimonScreenVictor screen = new SimonScreenVictor(getWidth(),getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		SimonGameVictor game = new SimonGameVictor();
		Thread app = new Thread(game);
		app.start();

	}

}
