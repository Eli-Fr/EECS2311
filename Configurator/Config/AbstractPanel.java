package Config;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel {
	private Configurator cfg;

	public AbstractPanel(Configurator cfg) {
		this.cfg = cfg;
		initComponents();
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setSize(Configurator.DEFAULT_SCREEN_SIZE);
		this.setSize(cfg.getSize());
		cfg.add(this);
	}

	protected abstract void initComponents();

	public void resize() {
		this.setSize(cfg.getCurrentDimension());
	}

	public int getHeight() {
		return cfg.getCurrentHeight();
	}

	public int getWidth() {
		return cfg.getCurrentWidth();
	}

	public int standardButtonSize() {
		return cfg.getWidth() / (cfg.maxNumberOfButtons + 2);
	}

	public int middleY() {
		return this.getHeight() / 2;
	}

	protected Configurator getCFG() {
		return this.cfg;
	}
}
