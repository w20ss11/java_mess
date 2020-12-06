package pack180801_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBC19_dbcp {
/**
 * 使用DBCP数据库连接池
 * 1.添加jar包 (两个) common-dbcp common-pool
 * 2.创建数据库连接池
 * 3.为数据源实例执行必须的属性
 * 4.从数据源中获取数据库连接
 * @throws SQLException 
 * */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		BasicDataSource dataSource = null;
		//1. 创建DBCP 数据源实例
		dataSource = new BasicDataSource();
		//2. 为数据源实例指定必须的属性
		dataSource.setUsername("root");
		dataSource.setPassword("wss6565");
		dataSource.setUrl("jdbc:mysql:///hello?useSSL=false");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//3. 执行数据源的一些可选的属性
		//3.1 指定数据库连接池中的初始化连接数的个数
		dataSource.setInitialSize(10);
		//3.2 指定最大连接数:同一时刻可以同时向数据库申请的连接数
		dataSource.setMaxTotal(50);
		//3.3 指定最小连接数：想数据库连接池空闲状态下，连接池中最少有多少个连接
		dataSource.setMinIdle(5);
		//3.4 等待数据库连接池分配连接的最长时间，单位为毫秒，超出该时间将抛出异常
		dataSource.setMaxWaitMillis(1000*5);
		
		//4. 从数据源中获取数据库连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}

}
