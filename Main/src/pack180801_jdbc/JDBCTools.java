package pack180801_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 操作JDBC的工具类，其中封装了一些工具方法
 * */
public class JDBCTools {

	/**
	 * JDBC20
	 * */
	private static DataSource dataSource = null;
	static{
		//数据库连接池应只被初始化一次
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	public static Connection getConnection() throws Exception{
		Connection conn = dataSource.getConnection();
		return conn;
	}
	
	/**
	 * JDBC04中内容
	 * */
	public static void realease(ResultSet rs,Statement statement,Connection conn){
		if(rs!=null)
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		if(statement!=null)
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		if(conn!=null)
			try {
				//数据库连接池的Connection对象进行close时，并不是真的关闭，
				//而是把该数据库连接归还到数据库连接池中
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	/**
	 * JDBC18 提交事务
	 * */
	public static void commit(Connection conn){
		if(conn!=null){
			try {
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * JDBC18 回滚事务
	 * */
	public static void rollback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * JDBC18 开始事务
	 * */
	public static void beginTx(Connection conn){
		if(conn!=null){
			try {
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
