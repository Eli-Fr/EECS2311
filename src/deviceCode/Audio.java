package deviceCode;

import java.io.Serializable;

public class Audio implements Serializable {
	
	private String setName;
	private String audioName;
	
	public Audio(String sn, String an) {
		setName = sn;
		audioName = an;
	}
	
	public String getSetName() {
		return setName;
	}
	
	public String getAudioName() {
		return audioName;
	}
	
}
