package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SetSelectorButton extends JButton implements ActionListener {

	private BodyPanel own;
	private String name;

	public SetSelectorButton(String S, BodyPanel owner) {
		super(S);
		this.own = owner;
		this.name = S;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("yeets");

		own.getConfig().setSetNum(Arrays.asList(own.getConfig().getSetBtn()).indexOf(name));

		for (int i = own.getConfig().getNumberOfAudioButtons(); i >0; i--) {
			own.remove(i);
		}

		own.getConfig().setNumberOfAudioButtons(own.getConfig().getBtnName()[own.getConfig().getSetNum()].length);
		own.initBtn();

	}

}
