package pack180801_jdbc;

import java.util.List;

//import java.sql.Date;

public class JDBC10_DaoTest {

	public static void main(String[] args) {
		JDBC10_Dao dao = new JDBC10_Dao();
		//≤‚ ‘insert
//		String sql = "INSERT INTO person(id,name,age,sex,birth) VALUES(?,?,?,?,?)";
//		dao.update(sql, 6,"dao_name",42,"male",new Date(new java.util.Date().getTime()));
		
		//≤‚ ‘select
		String sql = "SELECT id,name,age,sex,birth FROM person WHERE id = ?";
		JDBC06_Person person = dao.get(JDBC06_Person.class, sql, 3);
		System.out.println(person.toString());
		
		//JDBC12
		//≤‚ ‘getOForList
		sql = "SELECT id,name,age,sex,birth FROM person";
		List<JDBC06_Person> persons = dao.getForList(JDBC06_Person.class, sql);
		System.out.println(persons);
		
		//≤‚ ‘getForValue
		sql = "SELECT name FROM person WHERE id = ?";
		String name = dao.getForValue(sql, 3);
		System.out.println(name);
		
		sql = "SELECT max(age) FROM person";
		int age = dao.getForValue(sql);
		System.out.println(age);
		
	}

}
