package Interface;

import javax.swing.*;

import Device.ButtonInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class BodyPanel extends AbstractPanel {

	private Configurator CG;
	private JPanel setPanel;
	private JScrollPane setScroll;
	private ButtonInterface BI;

	public BodyPanel(TalkBoxUI owner, ButtonInterface BI) {
		super(owner);

		this.BI = BI;
		CG = owner.getConfig();

		this.setMinimumSize(new Dimension(owner.getWidth() + 15, 175 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth() + 15, 175 * owner.getConfig().getRatio()));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new FlowLayout());

		this.initSet();

		setScroll = new JScrollPane(setPanel);
		setScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setScroll.setMaximumSize(new Dimension(150 * owner.getConfig().getRatio(), this.getHeight()));
		setScroll.setMinimumSize(new Dimension(150 * owner.getConfig().getRatio(), this.getHeight()));

		this.add(setScroll);
		this.initBtn();

	}

	public void initBtn() {

		for (int i = 0; i < CG.getNumberOfAudioButtons(); i++) {
			String S = CG.getImageFileNames()[CG.getSetNum()][i];
			S = S.substring(1, S.length());
			S = (CG.getRelativePathToImageFiles() + System.getProperty("file.separator") + S);
			AudioButton btn = new AudioButton(BI, this, CG.getBtnName()[CG.getSetNum()][i], S, i);
			this.add(btn);
			this.revalidate();
			this.repaint();

		}
	}

	public void initSet() {

		setPanel = new JPanel();
		setPanel.setMinimumSize(new Dimension(150 * CG.getRatio(), this.getHeight()));
		setPanel.setMaximumSize(new Dimension(150 * CG.getRatio(), this.getHeight()));
		setPanel.setBackground(new Color(0, 12, 25));

		setPanel.setLayout(new BoxLayout(setPanel, BoxLayout.Y_AXIS));

		JLabel setTitle = new JLabel("Audio Set", SwingConstants.CENTER);
		setTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		setTitle.setForeground(Color.WHITE);

		setPanel.add(setTitle);

		for (int i = 0; i < CG.getNumberOfAudioSets(); i++) {
			SetSelectorButton btn = new SetSelectorButton(CG.getSetBtn()[i], this);
			setPanel.add(btn);
		}

	}

	public void actionPerformed(ActionEvent e) {
	}

}
