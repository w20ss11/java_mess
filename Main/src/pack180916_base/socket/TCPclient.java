package pack180916_base.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPclient {
/**
 * 1.����TCP�ͻ��˷���ʹ��Socket���󣨰���Ŀ�ĵأ�
 * 2.���������ӳɹ���˵�����ݴ���ܵ��ѽ���
 * 3.ʹ���������������д��
 * 4.�ر���Դ
 * @throws IOException 
 * */
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 10002);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("TCP��ʾ".getBytes());
		socket.close();
	}

}
