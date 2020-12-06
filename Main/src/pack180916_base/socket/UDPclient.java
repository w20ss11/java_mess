package pack180916_base.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPclient {
/**
 * 1.建立UDP的socket服务
 * 2.将要发送的数据封装到数据包中
 * 3.通过UDP的socket服务奖数据包发送出去
 * @throws IOException 
 * */
	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket();
		String message = "udp演示";
		byte[] buf = message.getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,
				InetAddress.getByName("127.0.0.1"),10000);
		ds.send(dp);
		ds.close();
	}
}
