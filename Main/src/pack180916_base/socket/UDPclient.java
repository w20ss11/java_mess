package pack180916_base.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPclient {
/**
 * 1.����UDP��socket����
 * 2.��Ҫ���͵����ݷ�װ�����ݰ���
 * 3.ͨ��UDP��socket�������ݰ����ͳ�ȥ
 * @throws IOException 
 * */
	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket();
		String message = "udp��ʾ";
		byte[] buf = message.getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,
				InetAddress.getByName("127.0.0.1"),10000);
		ds.send(dp);
		ds.close();
	}
}
