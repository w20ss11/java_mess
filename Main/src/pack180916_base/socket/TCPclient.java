package pack180916_base.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPclient {
/**
 * 1.创建TCP客户端服务，使用Socket对象（包含目的地）
 * 2.若建立连接成功，说明数据传输管道已建立
 * 3.使用输出流，将数据写出
 * 4.关闭资源
 * @throws IOException 
 * */
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 10002);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("TCP演示".getBytes());
		socket.close();
	}

}
