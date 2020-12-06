package pack180801_jdbc;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

public class JDBC21_DBUtils1_update {
	/**
	 * ����DBUtils������ queryRunner��update����
	 * */
	public static void main(String[] args) {
		//1.����QueryRunner��ʵ����
		QueryRunner queryRunner = new QueryRunner();
		//2.ʹ����update����  insert update delete
		String sql = "DELETE FROM person WHERE id IN (?,?)";
		Connection conn = null;
		try {
			conn = JDBCTools.getConnection();
			queryRunner.update(conn,sql,5,8);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTools.realease(null, null, conn);
		}
	}
}
