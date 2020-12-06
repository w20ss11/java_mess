package pack180916_base.io;

import java.io.File;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) throws IOException {
		File file = new File("file.txt");
//		file.createNewFile();

		//É¾³ý
//		file.delete();
//		dir.delete();
		
		//ÖØÃüÃû
//		File file_new = new File("file_new.txt");
//		file.renameTo(file_new);
		
		//±éÀú
		File dir = new File("src//demo");
		dir.mkdir();
		File[] files = dir.listFiles();
		for(File f:files){
			System.out.println(f);
		}
		
	}

}
