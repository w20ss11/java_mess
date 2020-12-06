package pack180916_base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) throws IOException {
		//字节输出流 写
//		@SuppressWarnings("resource")
//		FileOutputStream fos = new FileOutputStream("filewriter.txt",true);
//		fos.write("outputStream".getBytes());
		
		//字节输出流 读
//		@SuppressWarnings("resource")
//		FileInputStream fis = new FileInputStream("filewriter.txt");
//		byte[] buf = new byte[fis.available()];
//		fis.read(buf);
//		System.out.println(new String(buf));
		
		//复制图片
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
