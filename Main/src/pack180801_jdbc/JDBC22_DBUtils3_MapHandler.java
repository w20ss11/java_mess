package pack180801_jdbc;

import java.sql.Connection;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

public class JDBC22_DBUtils3_MapHandler {
	/**
	 * MapHandler:����SQL��Ӧ�ĵ�һ����¼��Ӧ��Map����
	 * ����SQL��ѯ�������������еı�����
	 * ֵ���е�ֵ
	 * */
		public static void main(String[] args) {
			Connection conn = null;
			QueryRunner queryRunner = new QueryRunner();
			try {
				conn = JDBCTools.getConnection();
				String sql = "select * FROM person";
				Map<String, Object> result = queryRunner.query(conn, sql, 
						new MapHandler());
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCTools.realease(null, null, conn);
			}
		}

}
