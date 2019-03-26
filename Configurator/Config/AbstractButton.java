package Config;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class AbstractButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AbstractPanel Owner;
	private String name;

	public AbstractButton(AbstractPanel owner, String name) {
		this.Owner = owner;
		this.name = name;
		this.addActionListener(this);
		owner.add(this);
		this.setText(name);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		this.setVisible(true);
		this.setOpaque(true);
		this.setFocusPainted(false);
		this.setFocusable(false);
	}

	protected AbstractPanel getOwner() {
		return this.Owner;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
