package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC17_TransactionIsolation {
/**
 * 测试事务的隔离级别
 * 在JDBC程序中可以用Connection的setTrasaction来设置事务的隔离级别
 * */
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = JDBC03_Tool.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE users SET balance = balance- 500 WHERE id =1";
			update(conn,sql);
			//这里添加断点，新建线程使用getForValue可以读取到balance-500后的结果
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(null, conn);
		}
	}

	public static void update(Connection conn,String sql,Object ...args){
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				preparedStatement.setObject(i+1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
		}finally {
			JDBC03_Tool.realease(preparedStatement, null);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <E> E getForValue(String sql, Object... args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBC03_Tool.getConnection();
			//读取未提交的数据
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return (E) resultSet.getObject(1);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JDBC03_Tool.realease(resultSet, preparedStatement, connection);
		}

		return null;
	}
}
