package simon;

import guiPractice.components.Visible;

public interface ProgressInterfaceVictor extends Visible {

	void gameOver();
	void setRound(int r);
	void setSequenceSize(int s);

}
