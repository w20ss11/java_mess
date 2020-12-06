package pack180801_jdbc;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBC20_c3p0 {

	public static void main(String[] args) throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql:///hello?useSSL=false" );
		cpds.setUser("root");                                  
		cpds.setPassword("wss6565");   
		
		System.out.println(cpds.getConnection()); 

	}

}
