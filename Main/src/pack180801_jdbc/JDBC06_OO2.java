package pack180801_jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class JDBC06_OO2 {

	public static void main(String[] args) throws SQLException {
		//练习2.查询
		String name = getNameFromConsole();//得到查询姓名
		JDBC06_Person person = searchPerson(name);//具体查询到人信息
		printPerson(person);//打印人的信息
	}

	private static void printPerson(JDBC06_Person person) {
		if(person!=null){
			System.out.println(person.toString());
		}else{
			System.out.println("查无此人");
		}
		
	}
	private static JDBC06_Person searchPerson(String name) throws SQLException {
		JDBC06_Person person = new JDBC06_Person();
		String sql = "select id,name,age,sex,birth from person where name = '"+name+"'";
		ArrayList<Map<String,Object>> res = JDBC03_Tool.select(sql);
		person.setId((int) res.get(0).get("id"));
		person.setName((String) res.get(0).get("name"));
		person.setAge((int) res.get(0).get("age"));
		person.setSex((String) res.get(0).get("sex"));
		person.setBirth((Date) res.get(0).get("birth"));
		return person;
	}
	@SuppressWarnings("resource")
	private static String getNameFromConsole() {
		System.out.println("请输入查询人的姓名：");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		return name;
	}
}
