package pack180916_base.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver {
	/**
	 * 1.建立UDP接收端服务
	 * 2.创建数据包，用户存储接收到的数据
	 * 3.使用socket服务的receive方法接收数据并存到数据包中
	 * 4.通过数据包方法解析数据
	 * 5.关闭资源
	 * @throws IOException 
	 * */

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(10000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		//4.解析数据
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String message = new String(dp.getData(), 0, dp.getLength());
		System.out.println(ip+" "+port+" "+message);
		ds.close();
	}

}
