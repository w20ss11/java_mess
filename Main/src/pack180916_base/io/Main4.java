package pack180916_base.io;

import java.io.File;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) throws IOException {
		File file = new File("file.txt");
//		file.createNewFile();

		//ɾ��
//		file.delete();
//		dir.delete();
		
		//������
//		File file_new = new File("file_new.txt");
//		file.renameTo(file_new);
		
		//����
		File dir = new File("src//demo");
		dir.mkdir();
		File[] files = dir.listFiles();
		for(File f:files){
			System.out.println(f);
		}
		
	}

}
