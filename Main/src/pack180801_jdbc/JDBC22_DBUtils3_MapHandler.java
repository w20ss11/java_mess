package pack180801_jdbc;

import java.sql.Connection;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

public class JDBC22_DBUtils3_MapHandler {
	/**
	 * MapHandler:返回SQL对应的第一条记录对应的Map对象
	 * 键：SQL查询的列名（不是列的别名）
	 * 值：列的值
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
