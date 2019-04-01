package Interface;

import javax.swing.JPanel;

public class AbstractPanel extends JPanel {

	private TalkBoxUI TBUI;

	public AbstractPanel(TalkBoxUI TBUI) {
		super();
		this.TBUI = TBUI;

	}

	public Configurator getConfig() {
		return TBUI.getConfig();
	}

}
