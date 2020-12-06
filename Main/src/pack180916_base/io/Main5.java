package pack180916_base.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main5 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("file_new.txt", "rw");
		raf.seek(raf.length());
		raf.write("extra content".getBytes());
		raf.writeInt(97);
		raf.close();
	}

}
