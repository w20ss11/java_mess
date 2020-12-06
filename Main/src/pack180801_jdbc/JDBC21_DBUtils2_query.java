package pack180801_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class JDBC21_DBUtils2_query {
	/**
	 * ����QueryRunner��Ĳ�ѯʱ����query
	 * �÷�������ֵȡ������ResultSetHandler������handle��������ֵ
	 * */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//1.����QueryRunner��ʵ����
		QueryRunner queryRunner = new QueryRunner();
		//2.ʹ����query���� 
		String sql = "select * FROM person";
		Connection conn = null;
		try {
			conn = JDBCTools.getConnection();
			Object object = queryRunner.query(conn,sql,
					new MyResultSetHandler());
			System.out.println(object);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTools.realease(null, null, conn);
		}
	}

}

@SuppressWarnings("rawtypes")
class MyResultSetHandler implements ResultSetHandler{
	@Override
	//handle�����ķ���ֵ��Ϊ��queryRunner.query()�����ķ���ֵ
	public Object handle(ResultSet resultSet) throws SQLException {
		//resultSet��queryRunner.query()��ѯ�Ľ��
		List<JDBC06_Person> persons = new ArrayList<>();

		while(resultSet.next()){
			Integer id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			Integer age = resultSet.getInt(3);
			String sex = resultSet.getString(4);
			Date birth = resultSet.getDate(5);

			JDBC06_Person person = 
					new JDBC06_Person(id, name, age, sex,birth);
			persons.add(person);
		}

		return persons;
	}

}