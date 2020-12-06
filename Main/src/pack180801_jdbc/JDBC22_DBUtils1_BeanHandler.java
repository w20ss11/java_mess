package pack180801_jdbc;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class JDBC22_DBUtils1_BeanHandler {
/**
 * BeanHandler:�ѽ�����ĵ�һ����¼תΪ����BeanHandler����ʱ�����Class������Ӧ�Ķ���
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
