
package Device;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * This class contains a file Path which will get and play the associated audio
 * File when the playSound() method is executed. This object is immutable,
 * meaning that the audio file cannot be changed
 * 
 * @author Eli Frungorts, Yash Desai, Kai Xu
 */
public class AudioObject {
	public static Log log  = LogFactory.getLog("logfile2");
	private String fileName;
	private static AudioStream previousFN;
	private FileManager FM;

	/**
	 * Constructs the object taking in the file name
	 * 
	 * @param name
	 */
	public AudioObject(String fileName, FileManager FM) {
		this.fileName = fileName;
		this.FM = FM;
	}

	public void playSound() {
		System.out.println(FM.getConfig().getRelativePathToAudioFiles() + this.getName());
		
		try {
			log.info("Playing audio" + getName());
			if(AudioObject.previousFN != null)	AudioPlayer.player.stop(AudioObject.previousFN);
			
			AudioStream as = new AudioStream(new FileInputStream(FM.getConfig().getRelativePathToAudioFiles()+ this.getName()));
			AudioPlayer.player
					.start(as);
			AudioObject.previousFN = as;

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No Audio File Found for Button: " + getName(), "Okay",
					JOptionPane.ERROR_MESSAGE);
			log.error(e1.getMessage());
		}

	}

	public String getName() {
		return this.fileName;
	}
	
	public static AudioStream getPrevious() {
		return AudioObject.previousFN;
	}

}
