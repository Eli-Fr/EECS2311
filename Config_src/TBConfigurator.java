import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import Interface.Configurator;
import Interface.*;

public class TBConfigurator {

	public static void main(String[] args) throws Exception{
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("TalkBoxData/Config.tbc")));
		  
		String line;
		
		Configurator config = new Configurator();
		
		BufferedReader br= new BufferedReader(new FileReader("TalkBoxData/Labels.txt"));
		
		config.setRatio(1);
		
		String[][] bN = new String[2][4];
		String[][] afN = new String[2][4];
		String[][] ifN = new String[2][4];
		
		int i = 0;
		while((line = br.readLine()) != null) {
			bN[0][i] = line;
			afN[0][i] = "/" +line +".wav";
			ifN[0][i] = "/" +line +".jpg";
			i++;
		}
		
		br= new BufferedReader(new FileReader("TalkBoxData/Labels2.txt"));
		
		i = 0;
		while((line = br.readLine()) != null) {
			bN[1][i] = line;
			afN[1][i] = "/" +line +".wav";
			ifN[1][i] = "/" +line +".jpg";
			i++;
		}
		
        String[] setbtn = new String[2];
        setbtn[0] = "Expression";
        setbtn[1] = "Needs";
        config.setSetBtn(setbtn);
        config.setBtnName(bN);
        config.setAudioFileNames(afN);
        config.setImageFileNames(ifN);
		config.setSetNum(0);
		config.setNumberOfAudioButtons(config.getBtnName()[config.getSetNum()].length);
		config.setNumberOfAudioSets(2);
		config.setTotalNumberOfButtons(9);
		Path rptaf = Paths.get("TalkBoxData/Audio");
		Path rptif = Paths.get("TalkBoxData/Icon");
		
		config.setRelativePathToAudioFiles(rptaf.toString());
		config.setRelativePathToImageFiles(rptif.toString());

		
		oos.writeObject(config);
		oos.close();
	}

}