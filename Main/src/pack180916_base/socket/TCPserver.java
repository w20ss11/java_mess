package pack180916_base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
/**
 * 1.���������socket����ͨ��ServerSocket����
 * 2.����˶����ṩһ���ӿ�����������
 * 3.��ȡ���ӹ����Ŀͻ��˶���
 * 4.ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷���������
 * 5.�ر���Դ
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
