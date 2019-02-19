package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PanelBody extends JPanel implements ActionListener{
	
	public ArrayList<CustomBtn> talkBtn;
	public BufferedReader br;
	public ObjectInputStream ois;
	public FileInputStream fis;
	public Object obj;
	public int i;

	public PanelBody(JFrame owner){
		super();
		
		this.setMinimumSize(new Dimension(owner.getWidth(), 225));
		this.setMaximumSize(new Dimension(owner.getWidth(), 225));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new FlowLayout());
		
		initBtn();
		
		
		for(i = 0; i < this.talkBtn.size(); i++) {
			
			this.talkBtn.get(i).addActionListener(this);
						
			this.add(this.talkBtn.get(i));
			
		}
		
	}
	
	public void initBtn() {
		
		talkBtn = new ArrayList<CustomBtn>();
		
		try {
			
			fis = new FileInputStream("btnsFile.srf");
			ois =  new ObjectInputStream(fis);
			
			while(fis.available() > 0) {
				
				obj = ois.readObject();
				talkBtn.add((CustomBtn)obj);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		
		CustomBtn btn = (CustomBtn)e.getSource();

		AudioStream audioStream;
		try {
			audioStream = new AudioStream(new ByteArrayInputStream(btn.getWavFile()));
			AudioPlayer.player.start(audioStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

}
