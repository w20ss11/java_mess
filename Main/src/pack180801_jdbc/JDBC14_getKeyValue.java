package pack180801_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC14_getKeyValue {
/**
 * 获取数据库
 * */
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			conn = JDBC03_Tool.getConnection();
			String sql = "INSERT INTO person(id,name,age,sex,birth) VALUES(?,?,?,?,?)";
//			preparedStatement = conn.prepareStatement(sql);
			//使用重载的prepareStatement(sql,flag)来生成PrepreadStatement对象
			preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, 8);
			preparedStatement.setString(2, "key");
			preparedStatement.setInt(3, 33);
			preparedStatement.setString(4, "female");
			preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));
			preparedStatement.executeUpdate();
			
			//通过
			rs = preparedStatement.getGeneratedKeys();
			if(rs.next()){
				System.out.println(rs.getObject(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(rs,preparedStatement, conn);
		}
	}

}
