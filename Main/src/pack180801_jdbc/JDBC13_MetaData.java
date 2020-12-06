package pack180801_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class JDBC13_MetaData {
/**
 * DatabaseMetaData 是描述数据库的元数据对象
 * 可以由Connection得到
 * */
	public static void main(String[] args){
		Connection conn = null;
		ResultSet resultSet = null;
		try {
			conn = JDBC03_Tool.getConnection();
			DatabaseMetaData data = conn.getMetaData();
			
			//可以得到数据库本身的一些基本信息
			//1.得到数据库的版本号
			int version = data.getDatabaseMajorVersion();
			System.out.println(version);
			
			//2.得到连接到数据库的用户名
			String user = data.getUserName();
			System.out.println(user);
			
			//3.得到Mysql中有哪些数据库
			resultSet = data.getCatalogs();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(resultSet, null, conn);
		}
	}

}
