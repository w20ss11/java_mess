package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBC13_ResultSetMetaData {
/**
 * ResultSetMetaData:描述结果集的元数据
 * 可以得到结果集中的基本信息：结果集中有哪些列，列名，列的别名等。
 * */
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = JDBC03_Tool.getConnection();
			String sql = "SELECT id,name bieName,age bieNameAge,sex,birth from person";
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			//1.得到ResultSetMetaData对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			//2.得到列的个数
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);
			
			for(int i=0;i<columnCount;i++){
				//3.得到列名
				String columnName = rsmd.getColumnName(i+1);
				//4.得到列的别名
				String columnLabel = rsmd.getColumnLabel(i+1);
				System.out.println(columnName+","+columnLabel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(resultSet, preparedStatement, conn);
		}
	}

}
