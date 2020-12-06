package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBC13_ResultSetMetaData {
/**
 * ResultSetMetaData:�����������Ԫ����
 * ���Եõ�������еĻ�����Ϣ�������������Щ�У��������еı����ȡ�
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
			
			//1.�õ�ResultSetMetaData����
			ResultSetMetaData rsmd = resultSet.getMetaData();
			//2.�õ��еĸ���
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);
			
			for(int i=0;i<columnCount;i++){
				//3.�õ�����
				String columnName = rsmd.getColumnName(i+1);
				//4.�õ��еı���
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
