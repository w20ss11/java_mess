package pack180801_jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC02_DriverManager {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		Tool2 tool = new Tool2();
		Connection conn = tool.getConnection();
		System.out.println(conn);
	}

}
class Tool2{
	/**
	 * DriverManager�������Ĺ�����
	 * 1. �������ص�getConnection()������ȡ���ݿ����ӣ�����
	 * 2. ����ͬʱ����������������ע���˶�����ݿ����ӣ������getconnection()
	 * �������������ͬ�������ز�ͬ�����ݿ�����
	 * */
	public Connection getConnection() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//׼���������ݿ��4���ַ��� ������ȫ���� url user password
		String driverClass = null;
		String url = null;
		String user = null;
		String psd = null;
		InputStream in = 
				getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		psd = properties.getProperty("psd");
		
		//2. ����������������
		Class.forName(driverClass);
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//3. ͨ��DriverManager��getConnection������ȡ���ݿ�����
		Connection connection = DriverManager.getConnection(url, user, psd);
//		String url1 = null;
//		String user1 = null;
//		String psd1 = null;
//		Connection connection1 = DriverManager.getConnection(url1, user1, psd1);
		return connection;
	}
}
