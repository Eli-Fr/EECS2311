package Config;

import java.awt.event.ActionEvent;

public class ConfigPanelButton extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConfigPanel owner;

	public ConfigPanelButton(AbstractPanel owner, String name) {
		super(owner, name);
		this.owner = (ConfigPanel) getOwner();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.getName().equals("Go Back")) {
			owner.updateButton();
			owner.closeConfig();
		}

	}

}
