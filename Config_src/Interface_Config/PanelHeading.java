package Interface_Config;


import javax.swing.*;
import java.awt.*;

public class PanelHeading extends JPanel{

	public JLabel title, subTitle;
	
	public PanelHeading(VisualFrame owner) {
		super();
		
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension(owner.getWidth() - 50, 50 * owner.getConfig().getRatio()));
		
		title = new JLabel("TalkBotConfigurator", SwingConstants.CENTER);
		subTitle = new JLabel("Configure your Talk Bot here, and see the changes there.", SwingConstants.CENTER);
		
		this.setBackground(new Color(211,211,211));
		
		this.add(title, BorderLayout.NORTH);
		this.add(subTitle, BorderLayout.SOUTH);
		formatText(owner);
	}
	
	public void formatText(VisualFrame owner) {
		
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD,24 * owner.getConfig().getRatio()));
		title.setForeground(Color.BLACK);
		subTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16 * owner.getConfig().getRatio()));
		subTitle.setForeground(new Color(0, 0, 0));
		
	}
	
}
