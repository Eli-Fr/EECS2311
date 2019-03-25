package Config;

import java.util.ArrayList;

import Talkbox.Emulator;

public class AudioSet {

	private ArrayList<AudioObject> AudioList = new ArrayList<AudioObject>();

	public AudioSet() {
		for (int i = 0; i < Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE; i++) {
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
		for (int i = 0; i < AudioList.size(); i++) {
			if (AudioList.get(i) == null) {
				return i;
			}
		}
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
