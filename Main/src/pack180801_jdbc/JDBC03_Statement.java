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
	 * 向指定的数据表中插入一条数据
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		//Version1
		//1. 获取数据库连接
		Connection connection = new Tool3().getConnection();
//		Connection connection = JDBC03_Tool.getConnection();
		//3. 准备插入的SQL语句；
		String sql = "INSERT INTO `jdbccustomers` VALUES (2, 'wangwu', '209@qq.com','1999.2.2')";//这里没有分号
		//4. 强行插入
		//4.1 获取操作SQL语句的Statement对象；调用Connection的cereteStatement()方法获取
		Statement statement = connection.createStatement();
		//4.2 调用Statement对象的executeUpdate(sql)执行SQL语句进行插入
	    statement.executeUpdate(sql);
		//5. 关闭Statement对象
	    statement.close();//最好写finally里面，先关闭后获取的
		//2. 关闭连接 connection statement都是应用程序和数据库服务器的连接资源，使用后一定要关闭
	    connection.close();//最好写finally里面
		
	}
	
	
	/**
	 * 通用的更新方法：包括INSERT UPDATE DELETE
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
		//3. 通过DriverManager的getConnection方法获取数据库连接
		Connection connection = DriverManager.getConnection(url, user, psd);
		return connection;
	}
}