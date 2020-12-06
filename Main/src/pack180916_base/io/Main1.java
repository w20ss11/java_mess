package pack180916_base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
/**
 * �ֽ���������ࣺInputStream,OutputStream
 * �ַ���������ࣺReader,Writer
 * @throws IOException 
 * */
	
	private static final String Line_SEPARATOR = System.getProperty("line.separator");
	public static void main(String[] args) throws IOException {
		//�ַ������1
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter("filewriter.txt");//,true);//true:��д
//			fw.write("filewriter write method");
//			fw.write("\r\nenter");
//			fw.write(Line_SEPARATOR+"separator");
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(fw!=null)
//				try {
//					fw.close();//fw.flush();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}
		
		
		//�ַ������2
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter("filewriter.txt");//,true);//true:��д
//			BufferedWriter bufw = new BufferedWriter(fw);
//			bufw.write("bufw");
//			bufw.newLine();
//			bufw.write("bufw2");
//			bufw.flush();
//			bufw.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(fw!=null)
//				try {
//					fw.close();//fw.flush();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}
		
		//�ַ�������1
//		FileReader fr = new FileReader("filewriter.txt");
//		char[] buf = new char[3];//������
//		int len = 0;
//		while((len=fr.read(buf))!=-1){
//			System.out.print(new String(buf,0,len));
//		}
		
		//�ַ�������2
		FileReader fr = new FileReader("filewriter.txt");
		@SuppressWarnings("resource")
		BufferedReader bufr = new BufferedReader(fr);//������
		String line = null;
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
	}

}
