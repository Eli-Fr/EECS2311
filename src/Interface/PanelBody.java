package Interface;

import DeviceSpeaker.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class PanelBody extends JPanel{
	
	public ArrayList<JButton> talkBtn;
	public BufferedReader br;
	public String line;

	public PanelBody(JFrame owner, SpeakerClass sc) {
		super();
		
		this.setMinimumSize(new Dimension(owner.getWidth(), 250));
		this.setMaximumSize(new Dimension(owner.getWidth(), 250));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new FlowLayout());
		
		
		initBtn(sc);
		for(int i = 0; i < this.talkBtn.size(); i++) {
			
			this.add(this.talkBtn.get(i));
			
		}
		
	}
	
	public void initBtn(SpeakerClass sc) {
		
		talkBtn = new ArrayList<JButton>();
		
		try {
			br= new BufferedReader(new FileReader("src/Interface/Labels.txt"));
			
			while((line = br.readLine()) != null) {
				
				talkBtn.add(new CustomBtn(line, sc));
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
