package pack180801_jdbc;

import java.sql.Date;
import java.util.Scanner;

public class JDBC07_PreparedStatement2 {
/**
 * ÃÌº”»À
 * */
	public static void main(String[] args){
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
		String sql = "INSERT INTO person(id,name,age,sex,birth) VALUES (?,?,?,?,?)";
		JDBC03_Tool.update(sql,person.getId(),
				person.getName(),
				person.getAge(),
				person.getSex(),
				person.getBirth());
	}
}
