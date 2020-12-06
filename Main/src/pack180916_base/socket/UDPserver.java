package pack180916_base.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver {
	/**
	 * 1.����UDP���ն˷���
	 * 2.�������ݰ����û��洢���յ�������
	 * 3.ʹ��socket�����receive�����������ݲ��浽���ݰ���
	 * 4.ͨ�����ݰ�������������
	 * 5.�ر���Դ
	 * @throws IOException 
	 * */

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(10000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		//4.��������
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String message = new String(dp.getData(), 0, dp.getLength());
		System.out.println(ip+" "+port+" "+message);
		ds.close();
	}

}
