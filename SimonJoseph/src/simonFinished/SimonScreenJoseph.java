package simonFinished;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIpractice.components.TextLabel;
import GUIpractice.components.visible;
import GUIpractice.sampleGames.ClickableScreen;
import whackAMole.MoleInterface;

public class SimonScreenJoseph extends ClickableScreen implements Runnable {

	private TextLabel text;
	private TextLabel label;
	private ButtonInterfaceJoseph button;
	private ProgressInterfaceJoseph progress;
	private ArrayList<MoveInterfaceJoseph> move;
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;

	public SimonScreenJoseph(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void run() {

	}

	@Override
	public void initAllObjects(List<visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130, 230, 300, 40, "Let's play Simon!");
		move = new ArrayList<MoveInterfaceJoseph>();
		// add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceJoseph randomMove() {
		Button b;
		// code that randomly selects a ButtonInterfaceX
		return getMove(b);
	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceJoseph getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		Color[] color = { Color.blue, Color.yellow, Color.red, Color.green, Color.orange, Color.cyan };
		for (int i = 0; i < numberOfButtons; i++) {

		}
	}

}
