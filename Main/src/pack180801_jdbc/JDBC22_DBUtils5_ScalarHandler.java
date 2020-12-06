package pack180801_jdbc;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class JDBC22_DBUtils5_ScalarHandler {
	/**
	 * ScalarHandler:把结果集转为一个数值（可以使任意基本数据类型和字符串，Date）
	 * */
	public static void main(String[] args) {
		Connection conn = null;
		QueryRunner queryRunner = new QueryRunner();
		try {
			conn = JDBCTools.getConnection();
			//String sql = "select name FROM person WHERE id = ?";
			String sql = "select count(id) FROM person";
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Object result = queryRunner.query(conn, sql, 
					new ScalarHandler());//,1);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTools.realease(null, null, conn);
		}
	}

}
