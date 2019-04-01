package TBC_Interface;

import javax.swing.*;
import java.awt.*;

public class PanelMain extends JPanel{
	
	public JPanel headingPane, preTextPane, bodyPane;
	public JScrollPane bodyPaneScroll;
	
	public PanelMain(VisualFrame owner) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(5, 19, 54));
		
		headingPane = new PanelHeading(owner);
		preTextPane = new PanelPreText(owner);
		
		this.add(headingPane);
		this.add(Box.createRigidArea(new Dimension(0,15 * owner.getConfig().getRatio())));
		this.add(preTextPane);
		this.add(Box.createRigidArea(new Dimension(0,15 * owner.getConfig().getRatio())));
	}

}