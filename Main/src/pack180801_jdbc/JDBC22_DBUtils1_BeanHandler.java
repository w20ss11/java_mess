package pack180801_jdbc;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class JDBC22_DBUtils1_BeanHandler {
/**
 * BeanHandler:把结果集的第一条记录转为创建BeanHandler对象时传入的Class参数对应的对象
 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Connection conn = null;
		QueryRunner queryRunner = new QueryRunner();
		try {
			conn = JDBCTools.getConnection();
			String sql = "select * FROM person WHERE id = ?";
			JDBC06_Person person = queryRunner.query(conn, sql, 
					new BeanHandler(JDBC06_Person.class),2);
			System.out.println(person.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTools.realease(null, null, conn);
		}
	}

}
