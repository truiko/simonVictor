package simon;

public class Move implements MoveInterfaceVictor {

	private ButtonInterfaceVictor b; 
	
	public Move(ButtonInterfaceVictor b) {
		this.b = b;
	}

	public ButtonInterfaceVictor getButton() {
		return b;
	}
}
