package pack180801_jdbc;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JDBC19_dbcp2 {
/**
 * 1.����dbcp��properties�����ļ��������ļ��еļ���Ҫ����BasicDataSource������
 * 2.����BasicDataSourceFactory��createDataSource��������DataSourceʵ��
 * 3.��DataSourceʵ���л�ȡ���ݿ�����
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
