package Interface;


import javax.swing.*;

public class VisualFrame extends JFrame{
	
	public JPanel mainPanel;
	
	public VisualFrame(String title) {
		
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setSize(720, 480);
		
		mainPanel = new PanelMain(this);
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
	
}
