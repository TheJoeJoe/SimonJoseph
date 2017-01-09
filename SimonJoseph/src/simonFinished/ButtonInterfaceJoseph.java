package simonFinished;

import java.awt.Color;


import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceJoseph extends Clickable {
	
	void setAction(Action action);

	void highlight();

	void dim();

	void setY(int i);

	void setX(int i);

	void setColor(Color color);
}
