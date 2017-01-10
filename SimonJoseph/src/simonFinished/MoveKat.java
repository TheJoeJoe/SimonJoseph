package simonFinished;

public class MoveKat implements MoveInterfaceJoseph {

	private ButtonInterfaceJoseph b;
	
	public MoveKat(ButtonInterfaceJoseph b) {
		this.b=b;
	}

	@Override
	public ButtonInterfaceJoseph getButton() {
		
		return b;
	}

}
