package pack180801_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC07_PreparedStatement {
/**
 * Q��Ϊʲôʹ��PreparedStatement?
 * A��1.ʹ��Statement��Ҫ����SQL��䡣�����࣬�������׳���
 *   2.������Ч�Ľ�ֹSQLע��
 *     SQLע��������ĳЩϵͳû�ж��û���������ݽ��г�ּ�飬�����û�����ע��Ƿ���SQL����
 *     ����Java���ԣ�Ҫ����SQLע�룬ֻҪ��preparedStatementȡ��statement�Ϳ�����
 * PreparedStatement����Statement���ӽӿڣ����Դ����ռλ����SQL��䡣�����ṩ�˲���ռλ�������ķ���
 * 
 * ʹ��PreparedStatement��
 * 1.����PreparedStatement
 * String sql = "INSERT INTO person values(?,?,?,?,?)"
 * PreparedStatement ps = conn.prepareStatement(sql);
 * 2.����PreparedStatement��setXXX(int index,object valu)����ռλ����ֵ
 * indexֵ��1��ʼ
 * 3.ִ��SQL��䣺executeQuery()��executeUpdat()��
 * ע�⣺ִ��ʱ������Ҫ����SQL��䡣
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
