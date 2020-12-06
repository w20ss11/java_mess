package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBC16_Transaction {

	/**
	 * Tom给Jerry汇款500元
	 * 
	 * 关于事物：
	 * 1.如果多个操作，每个操作使用的是自己单独的连接，则无法保证事物；
	 * 2.具体步骤：
	 * 2.1 事务操作开始前，开始事务：取消Connection的默认提交行为： conn.setAutoCommit(false);
	 * 2.2 如果事务的操作都成功，则提交事务：conn.commit();
	 * 2.3 回滚事务：若出现异常，则在catch块中回滚事务：conn.rollback();
	 * */
	public static void main(String[] args) {
//		JDBC10_Dao dao = new JDBC10_Dao();
//		String sql = "UPDATE users SET balance = balance- 500 WHERE id =1";
//		dao.update(sql);
//		
//		sql = "UPDATE users SET balance = balance+ 500 WHERE id =2";
//		dao.update(sql);
		
		Connection conn = null;
		//两个操作用的用一个connection
		try {
			conn = JDBC03_Tool.getConnection();
			//开始事务：取消默认提交
			conn.setAutoCommit(false);
			String sql = "UPDATE users SET balance = balance- 500 WHERE id =1";
			update(conn, sql);
			sql = "UPDATE users SET balance = balance+ 500 WHERE id =2";
			update(conn, sql);
			//提交事务
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//如果出现异常，回滚事务
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
}
