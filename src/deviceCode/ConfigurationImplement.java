package deviceCode;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.LinkedList;


public class ConfigurationImplement implements TalkBoxConfiguration {	
	private LinkedList<AudioSet> audioCollection;
	public ConfigurationImplement() {
		audioCollection = new LinkedList<AudioSet>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("config.tbc"));
			audioCollection = (LinkedList<AudioSet>)in.readObject(); 
		} catch(Exception e) {
			
		}
	}

	@Override
	public int getNumberOfAudioButtons() {
		return audioCollection.getFirst().getSet().size();
	}

	@Override
	public int getNumberOfAudioSets() {
		return audioCollection.size();
	}

	@Override
	public int getTotalNumberOfButtons() {
		return getNumberOfAudioButtons() + getNumberOfAudioButtons();
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		return null;
	}

	@Override
	public String[][] getAudioFileNames() {
		String[][] audioSet = new String[getNumberOfAudioSets()][];
		for (int i = 0; i < getNumberOfAudioSets(); i++) {
			for (int j = 0; j < getNumberOfAudioButtons(); j++) {
				audioSet[i][j] =  audioCollection.get(i).getSet().get(j).getAudioName();
			}
		}
		return audioSet;
	}

}
