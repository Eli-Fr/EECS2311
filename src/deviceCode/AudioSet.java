package deviceCode;

import java.awt.List;
import java.util.LinkedList;

public class AudioSet {
	private String setName;
	private LinkedList<Audio> set;
	
	public AudioSet(String sn) {
		setName = sn;
		set = new LinkedList<Audio>();
	}
	
	public void add(Audio audio) {
		set.addLast(audio);
	}
	
	public String getSetName() {
		return setName;
	}
	
	public LinkedList<Audio> getSet() {
		return set;
	}
	
	
}
