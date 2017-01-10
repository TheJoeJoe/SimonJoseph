package simonFinished;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.ClickableScreen;
import guiPractice.GUIApplication;

public class SimonScreenJoseph extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceJoseph[] button;
	private ProgressInterfaceJoseph progress;
	private ArrayList<MoveInterfaceJoseph> move;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private	int lastSelectedButton;

	public SimonScreenJoseph(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void run() {
		label.setText("");
		    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;	
		roundNumber ++;
		move.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(move.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;

	}

	private void playSequence() {
		ButtonInterfaceJoseph b = null;	
		for(MoveInterfaceJoseph m: move){
			if(b!=null)
				b.dim();
			
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

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}		

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
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
		ButtonInterfaceJoseph b = null;
		int random = (int) (Math.random()*button.length);
		while(random == lastSelectedButton){
			random = (int) (Math.random()*button.length);
		}
		lastSelectedButton = random;
		return getMove(button[random]);
	}

	private MoveInterfaceJoseph getMove(ButtonInterfaceJoseph b) {
		return new MoveKat(b);
	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceJoseph getProgress() {
		return new ProgressKat();
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons = 6;
		int[][] coordinates = {{50,100}, {100,100}, {150,100}, {200,100}, {250,100}, {300,100}};
		Color[] color = { Color.blue, Color.yellow, Color.red, Color.green, Color.orange, Color.cyan };
		button = new ButtonInterfaceJoseph[numberOfButtons];
		
		for (int i = 0; i < numberOfButtons; i++) {
			button[i] = getAButton();
			button[i].setColor(color[i]);
			button[i].setX(coordinates[i][0]);
			button[i].setY(coordinates[i][1]);
			final ButtonInterfaceJoseph b =button[i];
			button[i].setAction(new Action(){
				
				public void act(){
					if(acceptingInput){			
						Thread blink = new Thread(new Runnable(){

					public void run(){
						b.highlight();
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						b.dim();
					}
					});
					blink.start();
					if(b == move.get(sequenceIndex).getButton()){
						sequenceIndex ++;
					}
					else{
						gameOver();
					}
					if(sequenceIndex == move.size()){
						Thread nextRound = new Thread(SimonScreenJoseph.this);
						nextRound.start();
					}
					}
				}

			});
			viewObjects.add(b);
			
	}
	}
	protected void gameOver() {
		progress.gameOver();
	}

	private ButtonInterfaceJoseph getAButton() {
		return new ButtonKat();
	}

	

	

	

}
