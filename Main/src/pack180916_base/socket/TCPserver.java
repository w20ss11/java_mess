package pack180916_base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
/**
 * 1.创建服务端socket服务，通过ServerSocket对象
 * 2.服务端对外提供一个接口来建立连接
 * 3.获取连接过来的客户端对象
 * 4.通过客户端对象获取socket流读取客户端发来的数据
 * 5.关闭资源
 * @throws IOException 
 * */
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10002);
		Socket socket = ss.accept();
		String ip = socket.getInetAddress().getHostAddress();
		InputStream in = socket.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String message = new String(buf, 0, len);
		System.out.println(ip+":"+message);
		socket.close();
		ss.close();
	}

}
