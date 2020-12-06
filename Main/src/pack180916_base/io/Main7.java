package pack180916_base.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main7 {

	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("file_new.txt"));
		dos.writeUTF("ÄãºÃ");
		dos.close();
		
		@SuppressWarnings("resource")
		DataInputStream dis = new DataInputStream(new FileInputStream("file_new.txt"));
		String str = dis.readUTF();
		System.out.println(str);
	}

}
