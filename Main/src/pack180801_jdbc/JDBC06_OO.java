package pack180801_jdbc;

import java.sql.Date;
import java.util.Scanner;

public class JDBC06_OO {

	public static void main(String[] args) {
		//练习1.添加学生
		JDBC06_Person person = getPeronFromConsole();
		addNewPerson(person);
	}
	
	@SuppressWarnings({ "resource"})
	private static JDBC06_Person getPeronFromConsole(){
		Scanner scanner = new Scanner(System.in);
		JDBC06_Person person = new JDBC06_Person();
		System.out.print("id:");
		person.setId(scanner.nextInt());
		System.out.print("name:");
		person.setName(scanner.next());
		System.out.print("age:");
		person.setAge(scanner.nextInt());
		System.out.print("sex:");
		person.setSex(scanner.next());
		System.out.print("birth:");
		person.setBirth(Date.valueOf(scanner.next()));
		return person;
	}
	public static void addNewPerson(JDBC06_Person person){
		//1.准备一条SQL语句
		String sql = "INSERT INTO `person` VALUES ("
				+ person.getId()
				+",'"+person.getName()
				+"',"+person.getAge()
				+",'"+person.getSex()
				+"','"+person.getBirth() +"')";
		//2.调用JDBC03_Tool类中的update(sql)方法执行插入操作
		JDBC03_Tool.update(sql);
	}
}
