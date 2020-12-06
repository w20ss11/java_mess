package pack180801_jdbc;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

public class JDBC21_DBUtils1_update {
	/**
	 * 测试DBUtils工具类 queryRunner的update方法
	 * */
	public static void main(String[] args) {
		//1.创建QueryRunner的实现类
		QueryRunner queryRunner = new QueryRunner();
		//2.使用其update方法  insert update delete
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
