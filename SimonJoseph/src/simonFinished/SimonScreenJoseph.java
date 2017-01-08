package simonFinished;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIpractice.components.Action;
import GUIpractice.components.TextLabel;
import GUIpractice.components.visible;
import GUIpractice.sampleGames.ClickableScreen;

public class SimonScreenJoseph extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceJoseph[] button;
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
		 label.setText("");
		    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;	
		roundNumber ++;
		progress.setRound(roundNumber);
		progress.setSequenceSize(move.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;

	}

	private void playSequence() {
			ButtonInterfaceJoseph b = null;	
			for(MoveInterfaceJoseph m: move){
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

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
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
		ButtonInterfaceJoseph b;
		int random = (int) (Math.random()*button.length);
		while(random == lastSelectedButton){
			random = (int) (Math.random()*button.length);
		}
		lastSelectedButton = random;
		return getMove(b);
	}

	private MoveInterfaceJoseph getMove(ButtonInterfaceJoseph b) {
		// TODO Auto-generated method stub
		return null;
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
			final ButtonInterfaceJoseph b = getAButton();
			button[i].setColor(color[i]);
			button[i].setX((int)(100*Math.cos(i*Math.PI/(numberOfButtons))));
			button[i].setY((int)(100*Math.sin(i*Math.PI/(numberOfButtons))));
			button[i].setAction(new Action(){

				public void act(){
					if(acceptingInput){
						
					}
				
				
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

				});
			viewObjects.add(b);
		}
		
	}

	protected void gameOver() {
		// TODO Auto-generated method stub
		
	}

	private ButtonInterfaceJoseph getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
