package pack180801_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class JDBC13_MetaData {
/**
 * DatabaseMetaData ���������ݿ��Ԫ���ݶ���
 * ������Connection�õ�
 * */
	public static void main(String[] args){
		Connection conn = null;
		ResultSet resultSet = null;
		try {
			conn = JDBC03_Tool.getConnection();
			DatabaseMetaData data = conn.getMetaData();
			
			//���Եõ����ݿⱾ���һЩ������Ϣ
			//1.�õ����ݿ�İ汾��
			int version = data.getDatabaseMajorVersion();
			System.out.println(version);
			
			//2.�õ����ӵ����ݿ���û���
			String user = data.getUserName();
			System.out.println(user);
			
			//3.�õ�Mysql������Щ���ݿ�
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
