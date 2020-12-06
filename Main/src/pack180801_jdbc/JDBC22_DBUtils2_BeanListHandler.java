package pack180801_jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class JDBC22_DBUtils2_BeanListHandler {
	/**
	 * BeanListHandler:�ѽ����תΪһ��List����List��Ϊnull��������Ϊ�ռ���(size=0)
	 * ��SQL����ȷ�ܲ�ѯ����¼��List�д�Ŵ���BeanListHandler�����Class��Ӧ�Ķ���
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
