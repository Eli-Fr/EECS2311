package Interface_Config;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class DragNDropLabel extends JLabel{

	List<File> files;
	boolean fileChanger;
	EditBtn edit;
	
	public DragNDropLabel(EditBtn edit) {
		
		super("Drag And Drop Here");
		this.edit = edit;
		this.dndConfigurator();

		this.setLayout(new FlowLayout());
		this.setSize(500,500);
		
	}
	
	public void dndConfigurator() {
		
		TransferHandler th = new TransferHandler() {
			
			@Override
			public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean importData(JComponent comp, Transferable t) {
				// TODO Auto-generated method stub
				
				try {
					files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
					for(File file : files) {
						if(file.getName().endsWith(".jpg")||file.getName().endsWith(".png")) {
							edit.tempImg = file.getName();
							edit.imgBtn(file.getAbsolutePath());
						}
						else if(file.getName().endsWith(".wav")) {
							edit.tempAud = file.getName();
							edit.audBtn(file.getAbsolutePath());
						}
						else {
							
							JOptionPane.showMessageDialog(edit, "Sorry, wrong file format.");
							
						}
					}
				} catch (UnsupportedFlavorException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}
			
		};
		
		this.setTransferHandler(th);
		
	}	
}
