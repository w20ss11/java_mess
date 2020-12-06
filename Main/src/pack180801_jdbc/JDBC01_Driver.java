package pack180801_jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class JDBC01_Driver {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		//1. ����һ��Driverʵ�������
		Driver driver = new Driver();
		
		//2. ׼���������ݿ�Ļ�����Ϣ��url��user��password
		String url = "jdbc:mysql://127.0.0.1:3306/hello";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "wss6565");
		
		//3. ����Driver�ӿڵ�connect��url��info����ȡ���ݿ������
		Connection connection = driver.connect(url, info);
		System.out.println(connection);
		
		Tool tool = new Tool();
		Connection con = tool.getConnection();
		System.out.println(con);
	}
}
class Tool{
	/**
	 * ��дһ��ͨ�õķ������ڲ��޸�Դ���������£����Ի�ȡ�κ����ݿ������
	 * ��������������ݿ�����Driverʵ�����ȫ������url��user��password����
	 * һ�������ļ���ͨ���޸������ļ��ķ�ʽʵ�ֺ;�������ݿ���
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 * */
	
	public Connection getConnection() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String driverClass = null;
		String url = null;
		String user = null;
		String psd = null;
		
		//��ȡ��·���µ�jdbc.properties�ļ�
		InputStream in = 
				getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		psd = properties.getProperty("psd");
		
		Driver driver = (Driver)Class.forName(driverClass).newInstance();
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", psd);
		Connection connection = driver.connect(url, info);
		
		return connection;
	}
}
