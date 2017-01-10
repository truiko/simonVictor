package simon;

public class Move implements MoveInterfaceVictor {

	private ButtonInterface b; 
	
	public Move(ButtonInterface b) {
		this.b = b;
	}

	public ButtonInterface getButton() {
		return b;
	}
}
