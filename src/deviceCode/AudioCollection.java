package deviceCode;

import java.util.LinkedList;

public class AudioCollection {
	private LinkedList<AudioSet> audioCollection;
	
	 public AudioCollection() {
		 audioCollection = new LinkedList<AudioSet>();
	 }
	 
	 public void add(AudioSet as) {
		 if (!audioCollection.contains(as)) {
			 audioCollection.addLast(as);
		 }
	 }
	 
	 public LinkedList<AudioSet> getAudioCollection() {
		 return audioCollection;
	 }
}
