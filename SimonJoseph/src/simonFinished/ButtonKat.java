package simonFinished;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class ButtonKat extends Component implements ButtonInterfaceJoseph {

	private Color color;
	private Action action;
	private boolean on;
	
	public ButtonKat() {
		super(0, 0, 50, 50);
		on=false;
		update();
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(x>getX()&&x<(getX()+getWidth())&&y>getY()&&y<(getY()+getHeight()))
			return true;
		return false;
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void setAction(Action a) {
		this.action=a;
		update();
	}

	@Override
	public void highlight() {
		on=true;
		update();
	}

	@Override
	public void dim() {
		on=false;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		if(on){
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(color);
			g.fillOval(getX(), getY(), getWidth(), getHeight());
		}else{
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(color);
				g.fillOval(getX(), getY(), getWidth(), getHeight());
		}
		
	}

}
