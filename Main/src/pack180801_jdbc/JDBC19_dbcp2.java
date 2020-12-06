package pack180801_jdbc;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JDBC19_dbcp2 {
/**
 * 1.加载dbcp的properties配置文件：配置文件中的键需要来自BasicDataSource的属性
 * 2.调用BasicDataSourceFactory的createDataSource方法创建DataSource实例
 * 3.从DataSource实例中获取数据库连接
 * */
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		InputStream in = JDBC19_dbcp2.class
				.getClassLoader().getResourceAsStream("dbcp.properties");
		properties.load(in);
		DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
		System.out.println(dataSource.getConnection());
		
		BasicDataSource basicDataSource = (BasicDataSource) dataSource;
		System.out.println(basicDataSource.getMaxWaitMillis());
	}

}
