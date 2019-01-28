package deviceCode;

import java.awt.List;
import java.util.LinkedList;

public class AudioSet {
	private String setName;
	private LinkedList<String> set = new LinkedList<String>();
	
	public AudioSet(String sn) {
		setName = sn;
	}
	
	public void add(String audio) {
		set.addLast(audio);
	}
	
	public String getSetName() {
		return setName;
	}
	
	public LinkedList<String> getSet() {
		return set;
	}
	
	
}
