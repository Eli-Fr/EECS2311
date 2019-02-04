package deviceCode;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;


public class ConfigurationImplement implements TalkBoxConfiguration {	
	
	AudioCollection nac;
	public ConfigurationImplement() {
		nac = new AudioCollection();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("tmp/config.tbc"));
			nac = (AudioCollection) in.readObject();
		} catch(Exception e) {
			
		}
	}

	@Override
	public int getNumberOfAudioButtons() {
		for (int i = 0; i < nac.getAudioCollection().size(); i++) {
			if (nac.getAudioCollection().get(i).getSetName() == nac.getLoadSet()) {
				return nac.getAudioCollection().get(i).getSet().size();
			}
		}
		return 0;
	}

	@Override
	public int getNumberOfAudioSets() {
		return nac.getAudioCollection().size();
	}

	@Override
	public int getTotalNumberOfButtons() {
		return getNumberOfAudioButtons() + getNumberOfAudioButtons();
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		Path p = Paths.get("c:\\data\\myfile.txt");
		return p;
	}

	@Override
	public String[][] getAudioFileNames() {
		String[][] audioSet = new String[nac.getAudioCollection().size()][];
		for (int i = 0; i < nac.getAudioCollection().size(); i++) {
			for (int j = 0; j < nac.getAudioCollection().get(i).getSet().size(); j++) {
				audioSet[i][j] =  nac.getAudioCollection().get(i).getSet().get(j).getAudioName();
			}
		}
		return audioSet;
	}

}
