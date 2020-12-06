package pack180801_jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class JDBC22_DBUtils2_BeanListHandler {
	/**
	 * BeanListHandler:把结果集转为一个List，该List不为null，但可能为空集合(size=0)
	 * 若SQL语句的确能查询到记录，List中存放创建BeanListHandler传入的Class对应的对象
	 * */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static void main(String[] args) {
			Connection conn = null;
			QueryRunner queryRunner = new QueryRunner();
			try {
				conn = JDBCTools.getConnection();
				String sql = "select * FROM person";
				List<JDBC06_Person> persons = queryRunner.query(conn, sql, 
						new BeanListHandler(JDBC06_Person.class));
				System.out.println(persons);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCTools.realease(null, null, conn);
			}
		}
}
