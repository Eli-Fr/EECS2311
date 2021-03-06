package Recording;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.audio.*;

import javax.swing.*;

public class RecorderFrame extends JFrame implements ActionListener{

	private String fName;
	public boolean useRec;
	public static Log log = LogFactory.getLog("logfile1");
	public String getfName() {
		return fName;
	}

	private JPanel paneRecord, panePreview, paneExit;
	public JButton btnOK, btnCancel, btnPreview, btnRecord, btnStop;
	private JLabel AudioName;
	public JLabel recStatus;
	private JavaRecorder record;
	private Boolean stopRec = false;
	private Thread stopper;
	public int check = 0;
	
	
	public RecorderFrame() {
		
		super("Recorder");
		
		this.fName = "TalkBoxData/Audio/Recording.wav";
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		this.init();
		this.setSize(400, 185);
		this.setVisible(true);

	}
	
	public void init() {
		btnOK = new JButton("OK");
		btnCancel = new JButton("Cancel");
		btnRecord = new JButton("Record");
		btnStop = new JButton("Stop");
		btnPreview = new JButton("Preview");
		recStatus = new JLabel("Not Recording");
		
		AudioName = new JLabel(this.fName);
		
		record = new JavaRecorder(this.fName, this);
		
		this.recordInit();
		this.previewInit();
		this.exitInit();
		this.addAL();
		
		this.pack();
	}
	
	public void recordInit() {
		
		paneRecord = new JPanel();
		
		paneRecord.add(btnRecord);
		paneRecord.add(AudioName);
		paneRecord.add(btnStop);
		
		this.add(paneRecord);
		
	}
	
	public void previewInit() {
		
		panePreview = new JPanel();
		
		panePreview.add(recStatus);
		
		this.add(panePreview);		
	}
	
	public void exitInit() {
		
		paneExit = new JPanel();
		
		paneExit.add(btnOK);
		paneExit.add(btnCancel);
		
		this.add(paneExit);
	}
	
	public void addAL() {
		
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		btnRecord.addActionListener(this);
		btnStop.addActionListener(this);
		btnPreview.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		if(btn.equals(btnRecord)) {
			check = 1;
			log.info("Recorder Configuring");
			this.recStatus.setText("Recorder Configuring");
			new SwingWorker() {

				@Override
				protected Object doInBackground() throws Exception {
					// TODO Auto-generated method stub
					
					record.start();
					return null;
				}
			}.execute();
		}
		
		if(btn.equals(btnStop)) {
			check = 2;
			record.finish();
			log.info("Recording Finished");
			this.recStatus.setText("Recording Finished");
			if(btnPreview.getParent()!=paneRecord)		panePreview.add(btnPreview);
			this.repaint();
			this.revalidate();
		}
		
		if(btn.equals(btnOK)) {
			check = 3;
			this.useRec = true;
			log.info("OK button click and use record");
			JOptionPane.showMessageDialog(this, "The recording will be used for the button.");
			this.dispose();			
		}
		
		if(btn.equals(btnCancel)) {
			check = 4;
			log.info("Cancel button click and not use record");
			JOptionPane.showMessageDialog(this, "The recording will NOT be used for the button.");
			this.dispose();
						
		}
		
		
		
		if(btn.equals(btnPreview)) {
			check = 5;
			try {
				log.info("Preview the record audio");
				AudioPlayer.player.start(new AudioStream(new FileInputStream(this.fName)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				log.error(e1.getMessage());
			}
		}
		

		
	}
		
}
