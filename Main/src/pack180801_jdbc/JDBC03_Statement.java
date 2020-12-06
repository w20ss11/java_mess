package pack180801_jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03_Statement {

	/**
	 * ��ָ�������ݱ��в���һ������
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		//Version1
		//1. ��ȡ���ݿ�����
		Connection connection = new Tool3().getConnection();
//		Connection connection = JDBC03_Tool.getConnection();
		//3. ׼�������SQL��䣻
		String sql = "INSERT INTO `jdbccustomers` VALUES (2, 'wangwu', '209@qq.com','1999.2.2')";//����û�зֺ�
		//4. ǿ�в���
		//4.1 ��ȡ����SQL����Statement���󣻵���Connection��cereteStatement()������ȡ
		Statement statement = connection.createStatement();
		//4.2 ����Statement�����executeUpdate(sql)ִ��SQL�����в���
	    statement.executeUpdate(sql);
		//5. �ر�Statement����
	    statement.close();//���дfinally���棬�ȹرպ��ȡ��
		//2. �ر����� connection statement����Ӧ�ó�������ݿ��������������Դ��ʹ�ú�һ��Ҫ�ر�
	    connection.close();//���дfinally����
		
	}
	
	
	/**
	 * ͨ�õĸ��·���������INSERT UPDATE DELETE
	 * Version2
	 * */
	public void update(String sql){
		Connection conn = null;
		Statement statement = null;
		Tool3 tool = new Tool3();
		try {
			conn = tool.getConnection();
			statement = conn.createStatement();
			statement.executeQuery(sql);
		} catch (Exception e) {
		}finally {
//			JDBC03_Tool.realease(statement, conn);
			if(statement!=null)
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}

}
class Tool3{
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
		//3. ͨ��DriverManager��getConnection������ȡ���ݿ�����
		Connection connection = DriverManager.getConnection(url, user, psd);
		return connection;
	}
}