package pack180916_base.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main6 {
	 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
 
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		Input input = new Input(in);
		Output output = new Output(out);
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);
		
		t1.start();
		t2.start();
		
	}
 
	
 
 
}
class Input implements Runnable{
 
	private PipedInputStream in;
	Input(PipedInputStream in){
		this.in = in;
	}
	@Override
	public void run() {
		try {
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String str = new String(buf,0,len);
			System.out.println(str);
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
class Output implements Runnable{
	private PipedOutputStream out;
	Output(PipedOutputStream out){
		this.out = out;
	}
	@Override
	public void run() {
		try {
			out.write("管道来了".getBytes());
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

