package pack180801_jdbc;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBC20_c3p02 {
/**
 * 1.创建c3p0-config.xml文件，参考doc→inde.html→quickStart
 * 2.创建ComboPooledDataSource实例；
 * DataSource dataSource = 
				new ComboPooledDataSource("helloc3p0"); 
 * 3.从DataSource实例中获取数据库连接
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
