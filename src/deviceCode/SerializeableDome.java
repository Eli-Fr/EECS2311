package deviceCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeableDome {
	public static void main(String[] args) {
		AudioSet as = new AudioSet("Feeling");
		Audio a1 = new Audio("Feeling", "Happy");
		Audio a2 = new Audio("Feeling", "Sad");
		Audio a3 = new Audio("Feeling", "Angry");
		AudioCollection ac = new AudioCollection();
		as.add(a1);
		as.add(a2);
		as.add(a3);
		ac.add(as);
		ac.setLoadSet("Feeling");
		try {
			FileOutputStream fo = new FileOutputStream("tmp/config.tbc");
			ObjectOutputStream out = new ObjectOutputStream(fo);
			//ac.setPath("tmp/");
			out.writeObject(ac);
			out.close();
			System.out.println("Serialized data is saved in tmp/config.tbc");
		} catch (IOException i) {
			i.printStackTrace();
		}

		AudioCollection nac = new AudioCollection();

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("tmp/config.tbc"));
			nac = (AudioCollection) in.readObject();
			//System.out.println(nac.getPath().toString());
			System.out.println(nac.getAudioCollection().getFirst().getSet().get(1).getAudioName());
		} catch (Exception e) {

		}

	}
}
