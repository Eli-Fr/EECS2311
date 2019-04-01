package Interface;


import javax.swing.*;
import java.awt.*;

public class HeadingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel title, subTitle;
	
	public HeadingPanel(TalkBoxUI owner) {
		super();
		owner.add(this);
		
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension(owner.getWidth() - 50, 50 * owner.getConfig().getRatio()));
		
		title = new JLabel("TalkBot", SwingConstants.CENTER);
		subTitle = new JLabel("Your friendly Bot that helps you talk ;)", SwingConstants.CENTER);
		
		this.setBackground(new Color(0, 12, 25));
		
		this.add(title, BorderLayout.NORTH);
		this.add(subTitle, BorderLayout.SOUTH);
		formatText(owner);
	}
	
	public void formatText(TalkBoxUI owner) {
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD,24 * owner.getConfig().getRatio()));
		title.setForeground(Color.WHITE);
		subTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16 * owner.getConfig().getRatio()));
		subTitle.setForeground(new Color(225, 225, 225));
		
	}
	
}
