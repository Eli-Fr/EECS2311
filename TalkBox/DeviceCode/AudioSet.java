package DeviceCode;

import java.util.ArrayList;

import Talkbox.Emulator;

/**
 * This Object contains a set of AudioObjects which represent a physical page in
 * the Talkbox.
 * 
 * @author Eli Frungorts, Yash Desai, Kai Xu
 *
 */
public class AudioSet {

	private ArrayList<AudioObject> AudioList = new ArrayList<AudioObject>();

	/**
	 * Inintializes a null array that will be populated by the setAudio Method
	 */
	public AudioSet() {
		for (int i = 0; i < Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE; i++) {
			AudioList.add(null);
		}
	}

	/**
	 * @deprecated This method should not be used, as it breaks the precondition of
	 *             having the list at a constant length
	 * @param Aobj
	 */
	public void removeAudio(AudioObject Aobj) {
		AudioList.remove(Aobj);
	}

	/**
	 * sets the right-most object in the array to null
	 * 
	 */
	public void removeAudio() {
		AudioList.set(this.size() - 1, null);
	}

	/**
	 * @deprecated
	 * @param Aobj
	 */
	public void addAudio(AudioObject Aobj) {
		AudioList.add(Aobj);
	}

	/**
	 * Sets the audio at {@code"index"} to {@code"Aobj"}
	 * 
	 * @param index
	 * @param Aobj
	 * @throws IndexOutOfBoundsException
	 */
	public void setAudio(int index, AudioObject Aobj) throws IndexOutOfBoundsException {
		try {
			AudioList.set(index, Aobj);
		} catch (IndexOutOfBoundsException e) {

		}
	}

	/**
	 * 
	 * @param index
	 * @return AudioObject at {@code"index"}
	 */
	public AudioObject getAudio(int index) {
		return AudioList.get(index);
	}

	/**
	 * 
	 * @return Array size before most recent null element
	 */
	public int size() {
		for (int i = 0; i < AudioList.size(); i++) {
			if (AudioList.get(i) == null) {
				return i;
			}
		}
		return AudioList.size();
	}

	/**
	 * 
	 * @return an array of of all the file names in order
	 */
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
