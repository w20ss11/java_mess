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
	 * DriverManager是驱动的管理类
	 * 1. 可以重载的getConnection()方法获取数据库连接，方便
	 * 2. 可以同时管理多个驱动程序：若注册了多个数据库连接，则调用getconnection()
	 * 方法传入参数不同，即返回不同的数据库连接
	 * */
	public Connection getConnection() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//准备连接数据库的4个字符串 驱动的全类名 url user password
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
		
		//2. 加载数据驱动程序
		Class.forName(driverClass);
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		//3. 通过DriverManager的getConnection方法获取数据库连接
		Connection connection = DriverManager.getConnection(url, user, psd);
//		String url1 = null;
//		String user1 = null;
//		String psd1 = null;
//		Connection connection1 = DriverManager.getConnection(url1, user1, psd1);
		return connection;
	}
}
