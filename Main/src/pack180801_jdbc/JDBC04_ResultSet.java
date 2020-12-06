package pack180801_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC04_ResultSet {
/**
 * ResultSet:结果集，封装了使用JDBC进行查询的结果
 * 1.调用Statement对象的executeQuery(sql)可以得到结果集。
 * 2.ResultSet返回的实际上就是一张数据表，有一个指针指向数据表的第一样的前面。
 * 可以调用next()方法检测下一行是否有效。若有效该方法返回ture，且指针下移，相当于Iterator对象的
 * hasNext()和next()方法的结合体
 * 3.当指针定位到所要一行时，可以通过代用getXXX(index)或getXXX(columnName)
 * 4.ResultSet也需要进行关闭。
 * */
	public static void main(String[] args) {
		//获取id=1的jdbccustomers数据表的记录，并打印
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			//1.获取Connection
			conn = JDBC03_Tool.getConnection();
			//2.获取Statement
			statement = conn.createStatement();
			//3.准备SQL
			String sql = "select id,name,email,birth from jdbccustomers "
					+ "where id = 1;";
			//4.执行查询，得到ResultSet
			rs = statement.executeQuery(sql);
			//5.处理ResultSet
			if(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birth = rs.getString(4);
				System.out.println(id+" "+name+" "+email+" "+birth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.关闭数据库资源
			JDBC03_Tool.realease(rs, statement, conn);
		}
	}
	
	public void update(String sql){
		Connection conn = null;
		Statement statement = null;
		try {
			conn = JDBC03_Tool.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
		}finally {
			JDBC03_Tool.realease(statement, conn);
		}
	}

}
