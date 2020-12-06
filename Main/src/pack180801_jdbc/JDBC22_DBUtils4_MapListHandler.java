package pack180801_jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class JDBC22_DBUtils4_MapListHandler {

	/**
	 * MapListHandler:将结果集转为一个Map的List
	 * Map对应查询的一条记录：  键：SQL查询的列名（不是列的别名） 值：列的值
	 * 而MapListHandler：返回的多条记录对应的Map的集合
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
