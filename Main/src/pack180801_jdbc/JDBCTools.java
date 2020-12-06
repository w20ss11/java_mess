package pack180801_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ����JDBC�Ĺ����࣬���з�װ��һЩ���߷���
 * */
public class JDBCTools {

	/**
	 * JDBC20
	 * */
	private static DataSource dataSource = null;
	static{
		//���ݿ����ӳ�Ӧֻ����ʼ��һ��
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	public static Connection getConnection() throws Exception{
		Connection conn = dataSource.getConnection();
		return conn;
	}
	
	/**
	 * JDBC04������
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
				//���ݿ����ӳص�Connection�������closeʱ����������Ĺرգ�
				//���ǰѸ����ݿ����ӹ黹�����ݿ����ӳ���
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	/**
	 * JDBC18 �ύ����
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
	 * JDBC18 �ع�����
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
	 * JDBC18 ��ʼ����
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
