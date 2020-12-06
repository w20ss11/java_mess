package pack180801_jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class JDBC01_Driver {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		//1. 创建一个Driver实现类对象
		Driver driver = new Driver();
		
		//2. 准备连接数据库的基本信息，url，user，password
		String url = "jdbc:mysql://127.0.0.1:3306/hello";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "wss6565");
		
		//3. 调用Driver接口的connect（url，info）获取数据库的连接
		Connection connection = driver.connect(url, info);
		System.out.println(connection);
		
		Tool tool = new Tool();
		Connection con = tool.getConnection();
		System.out.println(con);
	}
}
class Tool{
	/**
	 * 编写一个通用的方法，在不修改源程序的情况下，可以获取任何数据库的连接
	 * 解决方案，把数据库驱动Driver实现类的全类名，url，user，password放入
	 * 一个配置文件，通过修改配置文件的方式实现和具体的数据库解耦。
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
		
		//读取类路径下的jdbc.properties文件
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
