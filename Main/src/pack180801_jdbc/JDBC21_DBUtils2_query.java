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
	 * 测试QueryRunner类的查询时方法query
	 * 该方法返回值取决于其ResultSetHandler参数的handle方法返回值
	 * */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//1.创建QueryRunner的实现类
		QueryRunner queryRunner = new QueryRunner();
		//2.使用其query方法 
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
	//handle方法的返回值作为了queryRunner.query()方法的返回值
	public Object handle(ResultSet resultSet) throws SQLException {
		//resultSet是queryRunner.query()查询的结果
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