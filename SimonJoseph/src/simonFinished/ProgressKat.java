package simonFinished;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class ProgressKat extends Component implements ProgressInterfaceJoseph {
	
	private int roundNumber;
	private int size;
	private boolean gameStatus;
	private static int height = 100;
	private static int width = 200;
	
	public ProgressKat() {
		super(0, 0, width, height);
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
		int fontSize = 10;
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		if(gameStatus){
			g.setColor(Color.yellow);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.black);
			g.drawString("Round: "+roundNumber, width/2 - 50, height/2);
			g.drawString("Sequence length: "+size, width/2, height/2);
		}else{
			g.setColor(Color.red);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.black);
			g.drawString("Game over your lost", width/2-25, height/2);
		}
	}
 
}
