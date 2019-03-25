package Interface;

import java.nio.file.Path;
import java.nio.file.Paths;
public class Configurator implements TalkBoxConfiguration{
	
	private int ratio;
	private String[][] btnName;
	private String[]  setBtn;
	private int setNum;
	
	private int numberOfAudioButtons;
	private int numberOfAudioSets;
	private int totalNumberOfButtons;
	
	//private Path relativePathToAudioFiles;
	private String relativePathToAudioFiles;
	private String[][] audioFileNames;
	
	//private Path relativePathToImageFiles;
	private String relativePathToImageFiles;
	private String[][] imageFileNames;
	
	public String [][] getBtnName() {
		return btnName;
	}

	public void setBtnName(String [][] btnName) {
		this.btnName = btnName;
	}

	public String[] getSetBtn() {
		return setBtn;
	}

	public void setSetBtn(String[] setBtn) {
		this.setBtn = setBtn;
	}

	public int getSetNum() {
		return setNum;
	}

	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public Path getRelativePathToImageFiles() {
		//return relativePathToImageFiles;
		return Paths.get(this.relativePathToImageFiles);
	}

	public void setRelativePathToImageFiles(String relativePathToImageFiles) {
		this.relativePathToImageFiles = relativePathToImageFiles;
	}

	public String[][] getImageFileNames() {
		return imageFileNames;
	}

	public void setImageFileNames(String[][] imageFileNames) {
		this.imageFileNames = imageFileNames;
	}

	public void setNumberOfAudioButtons(int numberOfAudioButtons) {
		this.numberOfAudioButtons = numberOfAudioButtons;
	}

	public void setNumberOfAudioSets(int numberOfAudioSets) {
		this.numberOfAudioSets = numberOfAudioSets;
	}

	public void setTotalNumberOfButtons(int totalNumberOfButtons) {
		this.totalNumberOfButtons = totalNumberOfButtons;
	}

	public void setRelativePathToAudioFiles(String relativePathToAudioFiles) {
		this.relativePathToAudioFiles = relativePathToAudioFiles;
	}

	public void setAudioFileNames(String[][] audioFileNames) {
		this.audioFileNames = audioFileNames;
	}

	public int getNumberOfAudioButtons() {
		return numberOfAudioButtons;
	}

	public int getNumberOfAudioSets() {
		return numberOfAudioSets;
	}

	public int getTotalNumberOfButtons() {
		return totalNumberOfButtons;
	}

	public Path getRelativePathToAudioFiles() {
		//return relativePathToAudioFiles;
		return Paths.get(this.relativePathToAudioFiles);
	}

	public String[][] getAudioFileNames() {
		return audioFileNames;
	}


}
