package deviceCode;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class AudioCollection implements Serializable {
	private LinkedList<AudioSet> audioCollection;
	private String loadSet; 
	//private Path path;

	public AudioCollection() {
		audioCollection = new LinkedList<AudioSet>();
		loadSet = "";
		//path = Paths.get("");
	}

	public void add(AudioSet as) {
		if (!audioCollection.contains(as)) {
			audioCollection.addLast(as);
		}
	}
	
	public void setLoadSet(String ls) {
		loadSet = ls;
	}
	
//	public void setPath(String p) {
//		path = Paths.get(p);
//	}
	
	public LinkedList<AudioSet> getAudioCollection() {
		return audioCollection;
	}
	
//	public Path getPath() {
//		return path;
//	}
	
	public String getLoadSet() {
		return loadSet;
	}
}
