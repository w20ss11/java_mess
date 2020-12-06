package pack180801_jdbc;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBC20_c3p02 {
/**
 * 1.����c3p0-config.xml�ļ����ο�doc��inde.html��quickStart
 * 2.����ComboPooledDataSourceʵ����
 * DataSource dataSource = 
				new ComboPooledDataSource("helloc3p0"); 
 * 3.��DataSourceʵ���л�ȡ���ݿ�����
 * @throws Exception 
 * */

	public static void main(String[] args) throws Exception {
		DataSource dataSource = 
				new ComboPooledDataSource("helloc3p0");  
		
		System.out.println(dataSource.getConnection()); 
		
		ComboPooledDataSource comboPooledDataSource = 
				(ComboPooledDataSource) dataSource;
		System.out.println(comboPooledDataSource.getMaxStatements());
		
//		Connection conn = JDBCTools.getConnection();
//		System.out.println(conn);
	}

}
