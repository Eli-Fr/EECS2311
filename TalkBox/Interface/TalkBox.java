package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Talkbox.ButtonInterface;

public class TalkBox extends MainPanel implements ActionListener {

	private ButtonInterface BI = new ButtonInterface();

	public void initComponents() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				/**
				 * TODO ADD events that will happen when we close the window, this can include
				 * saving the current config. we can call the method saveConfig();
				 */
				System.exit(0);
			}
		});
	}

	public TalkBox(ButtonInterface BI) {
		super();
		this.BI = BI;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if the actionEvent is a button press
		if (e.getSource().getClass() == InterfaceButton.class) {
			InterfaceButton ib = (InterfaceButton) e.getSource();
			BI.turnOnButton(ib.getID()%6);
		}
	}

}
