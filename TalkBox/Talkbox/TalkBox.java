package Talkbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Timer;

public class TalkBox extends MainPanel implements ActionListener {
	private ArrayList<ButtonSet> buttonList = new ArrayList<ButtonSet>();

	// all 0's until a button is pressed, will then turn on(emulates a physical
	// connection)
	private ArrayList<Integer> buttonInterface = new ArrayList<Integer>();

	private ArrayList<AudioObject> audioList = new ArrayList<>();

	private Timer buttonListener;

	public void initComponents() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO ADD events that will happen when we close the window, this can include
				// saving the current config
				// we can call the method saveConfig();
				System.exit(0);
			}
		});
		buttonListener = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttonInterface.size(); i++) {
					Integer I = buttonInterface.get(i);
					if (I.equals(new Integer(1))) {
						audioList.get(i).playSound();
					}
					turnButtonOff(i);
				}

			}
		});

	}

	public void turnButtonON(int n) throws IndexOutOfBoundsException {
		if (n < 0 || n >= buttonInterface.size()) {
			throw new IndexOutOfBoundsException();
		}
		buttonInterface.set(n, new Integer(1));
	}

	private void turnButtonOff(int n) throws IndexOutOfBoundsException {
		if (n < 0 || n >= buttonInterface.size()) {
			throw new IndexOutOfBoundsException();
		}
		buttonInterface.set(n, new Integer(0));
	}

	public TalkBox() {
		initComponents();
		buttonListener.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if the actionEvent is a button press
		if (e.getSource().getClass() == InterfaceButton.class) {
			InterfaceButton ib = (InterfaceButton) e.getSource();
			ib.act();
		}
	}

	public static void main(String[] args) {
		TalkBox tb = new TalkBox();
		tb.setVisible(true);
	}

}
