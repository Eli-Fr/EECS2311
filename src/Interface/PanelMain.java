package Interface;
import DeviceSpeaker.*;

import javax.swing.*;
import java.awt.*;

public class PanelMain extends JPanel{
	
	public JPanel headingPane, preTextPane, bodyPane;
	public JScrollPane bodyPaneScroll;
	
	public PanelMain(JFrame owner, SpeakerClass sc) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(5, 19, 54));
		
		headingPane = new PanelHeading(owner);
		preTextPane = new PanelPreText(owner);
		bodyPane = new PanelBody(owner, sc);
		
		bodyPaneScroll = new JScrollPane(bodyPane);
		bodyPaneScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		bodyPaneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		bodyPaneScroll.setMaximumSize(new Dimension(owner.getWidth()+15, 225));
		bodyPaneScroll.setMinimumSize(new Dimension(owner.getWidth()+15, 225));
		
		this.add(headingPane);
		this.add(Box.createRigidArea(new Dimension(0,15)));
		this.add(preTextPane);
		this.add(Box.createVerticalGlue());
		this.add(bodyPaneScroll);
		
	}

}
