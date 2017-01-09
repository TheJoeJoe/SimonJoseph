package simonFinished;

import guiPractice.GUIApplication;

public class SimonGameJoseph extends GUIApplication {

	public SimonGameJoseph() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		SimonScreenJoseph ssj  = new SimonScreenJoseph(getWidth(), getHeight());
		setScreen(ssj);
	}

	public static void main(String[] args) {
		SimonGameJoseph game = new SimonGameJoseph();
		Thread app = new Thread(game);
		app.start();

	}

}
