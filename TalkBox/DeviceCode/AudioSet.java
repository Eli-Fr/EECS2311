package DeviceCode;

import java.awt.Button;
import java.util.ArrayList;

public class AudioSet {

	private ArrayList<AudioObject> AudioList = new ArrayList<AudioObject>();

	public AudioSet() {
		for (int i = 0; i < 6; i++) {
			AudioList.add(null);
		}
	}

	public void removeAudio(AudioObject Aobj) {
		AudioList.remove(Aobj);
	}

	public void removeAudio(int i) {
		AudioList.remove(i);
	}

	public void addAudio(AudioObject Aobj) {
		AudioList.add(Aobj);
	}

	public void setAudio(int index, AudioObject Aobj) {
		AudioList.set(index, Aobj);
	}

	public AudioObject getAudio(int index) {
		return AudioList.get(index);
	}

	public int size() {
		return AudioList.size();
	}

	public String[] listOfNames() {
		String[] ret = new String[this.size()];
		int i = 0;
		for (AudioObject AO : AudioList) {
			ret[i] = AO.getName();
			i++;
		}
		return ret;
	}

}
