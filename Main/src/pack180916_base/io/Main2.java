package pack180916_base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) throws IOException {
		//�ֽ������ д
//		@SuppressWarnings("resource")
//		FileOutputStream fos = new FileOutputStream("filewriter.txt",true);
//		fos.write("outputStream".getBytes());
		
		//�ֽ������ ��
//		@SuppressWarnings("resource")
//		FileInputStream fis = new FileInputStream("filewriter.txt");
//		byte[] buf = new byte[fis.available()];
//		fis.read(buf);
//		System.out.println(new String(buf));
		
		//����ͼƬ
		FileInputStream fis = new FileInputStream("tu1.jpg");
		BufferedInputStream bufis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("tu2.jpg");
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		
		int ch = 0;
		while((ch=bufis.read())!=-1){
			bufos.write(ch);
		}
		
		
		bufos.close();
		bufis.close();
		
	}

}
