package pack180916_base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main3 {

	public static void main(String[] args) throws IOException {
		//ת����
		InputStream in = System.in;//�ֽ�������
		InputStreamReader isr = new InputStreamReader(in);//ת����
		BufferedReader bufr = new BufferedReader(isr);
		String line = bufr.readLine();
		in.close();
		isr.close();
		bufr.close();
		System.out.println(line);
		
		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bufw = new BufferedWriter(osw);
		out.close();
		osw.close();
		bufw.close();
	}

}
