package deviceCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;

public class ConfigurationImplement implements TalkBoxConfiguration {

	@Override
	public int getNumberOfAudioButtons() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfAudioSets() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalNumberOfButtons() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		
		return null;
	}

	@Override
	public String[][] getAudioFileNames() {
		String[][] audioSet = new String[getNumberOfAudioSets()][];
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("config.tbc"));
			Audio[][] audioFile = (Audio[][])in.readObject(); 
			for (int i = 0; i < getNumberOfAudioSets(); i++) {
				for (int j = 0; j < getNumberOfAudioButtons(); j++) {
					audioSet[i][j] =  audioFile[i][j].getAudioName();
				}
			}
		} catch(Exception e) {
			
		}
		return audioSet;
	}

}
