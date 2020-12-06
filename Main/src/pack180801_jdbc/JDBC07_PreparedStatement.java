package pack180801_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC07_PreparedStatement {
/**
 * Q：为什么使用PreparedStatement?
 * A：1.使用Statement需要进行SQL语句。很辛苦，而且容易出错
 *   2.可以有效的禁止SQL注入
 *     SQL注入是利用某些系统没有对用户输入的数据进行充分检查，而在用户输入注入非法的SQL语句段
 *     对于Java而言，要防范SQL注入，只要用preparedStatement取代statement就可以了
 * PreparedStatement：是Statement的子接口，可以传入带占位符的SQL语句。并且提供了补充占位符变量的方法
 * 
 * 使用PreparedStatement：
 * 1.创建PreparedStatement
 * String sql = "INSERT INTO person values(?,?,?,?,?)"
 * PreparedStatement ps = conn.prepareStatement(sql);
 * 2.调动PreparedStatement的setXXX(int index,object valu)设置占位符的值
 * index值从1开始
 * 3.执行SQL语句：executeQuery()或executeUpdat()。
 * 注意：执行时不再需要传入SQL语句。
 * */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBC03_Tool.getConnection();
			String sql = "INSERT INTO person(id,name,age,sex,birth) "
					+ "VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "preName");
			preparedStatement.setInt(3, 31);
			preparedStatement.setString(4, "male");
			preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(preparedStatement, connection);
		}
	}

}
