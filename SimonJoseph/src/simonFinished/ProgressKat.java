package simonFinished;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class ProgressKat extends Component implements ProgressInterfaceJoseph {
	
	private int roundNumber;
	private int size;
	private boolean gameStatus;
	
	public ProgressKat() {
		super(60, 60, 60, 120);
		gameStatus = true;
		update();
	}

	@Override
	public void gameOver() {
		gameStatus=false;
		update();
	}

	@Override
	public void setRound(int roundNumber) {
		this.roundNumber=roundNumber;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		this.size=size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.white);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.black);
	
		if(gameStatus){
			g.drawString("Round: "+roundNumber, getX()+5, getY()+5);
			g.drawString("Sequence length: "+size, getX()+5, getY()+15);
		}else{
			g.drawString("Game over your lost", getX()+5,getY()+5);
		}
	}

}
