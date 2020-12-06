package pack180801_jdbc;

public class JDBC08_Reflection {
/**
 * 1.先利用SQL查询，得到结果集
 * 2.利用反射创建实体类对象：创建Person对象
 * 3.获取结果集的列的别名：
 * 4.再获取结果集的每一列的值，结合得到一个map，键：列的别名，值：列的值
 * 5.再利用反射对应的属性赋值：属性即为map的键，值即为map的值
 * 
 * ResultSetMetaData：
 * 1.what：是描述ResultSet的元数据对象。即从中可以获取到结果集有多少列，列名是什么
 * 2.how：得到ResultSetMetaData对象：调用ResultSet的getMetaData()方法
 *       ResultSetMetaData的方法：
 *            int getColumnCount()：sql语句中包含哪些列
 *            string getColumnLabel(int column)：获取指定列的别名，索引从1开始
 * */
	public static void main(String[] args) {
		String sql = "SELECT id,name,age,sex,birth FROM person "
				+ "WHERE id = ?";
		JDBC06_Person person = JDBC03_Tool.select(JDBC06_Person.class, sql, 3);
		System.out.println(person.toString());
		sql = "SELECT id,name,age,sex,birth FROM person "
				+ "WHERE name = ?";
		JDBC06_Person person2 = JDBC03_Tool.select(JDBC06_Person.class, sql, "wss");
		System.out.println(person2.toString());
	}
}
