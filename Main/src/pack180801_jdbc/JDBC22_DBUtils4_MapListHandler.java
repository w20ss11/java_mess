package pack180801_jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class JDBC22_DBUtils4_MapListHandler {

	/**
	 * MapListHandler:�������תΪһ��Map��List
	 * Map��Ӧ��ѯ��һ����¼��  ����SQL��ѯ�������������еı����� ֵ���е�ֵ
	 * ��MapListHandler�����صĶ�����¼��Ӧ��Map�ļ���
	 * */
	public static void main(String[] args) {
		Connection conn = null;
		QueryRunner queryRunner = new QueryRunner();
		try {
			conn = JDBCTools.getConnection();
			String sql = "select * FROM person";
			List<Map<String, Object>> result = queryRunner.query(conn, sql, 
					new MapListHandler());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTools.realease(null, null, conn);
		}
	}

}
