package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBC16_Transaction {

	/**
	 * Tom��Jerry���500Ԫ
	 * 
	 * �������
	 * 1.������������ÿ������ʹ�õ����Լ����������ӣ����޷���֤���
	 * 2.���岽�裺
	 * 2.1 ���������ʼǰ����ʼ����ȡ��Connection��Ĭ���ύ��Ϊ�� conn.setAutoCommit(false);
	 * 2.2 �������Ĳ������ɹ������ύ����conn.commit();
	 * 2.3 �ع������������쳣������catch���лع�����conn.rollback();
	 * */
	public static void main(String[] args) {
//		JDBC10_Dao dao = new JDBC10_Dao();
//		String sql = "UPDATE users SET balance = balance- 500 WHERE id =1";
//		dao.update(sql);
//		
//		sql = "UPDATE users SET balance = balance+ 500 WHERE id =2";
//		dao.update(sql);
		
		Connection conn = null;
		//���������õ���һ��connection
		try {
			conn = JDBC03_Tool.getConnection();
			//��ʼ����ȡ��Ĭ���ύ
			conn.setAutoCommit(false);
			String sql = "UPDATE users SET balance = balance- 500 WHERE id =1";
			update(conn, sql);
			sql = "UPDATE users SET balance = balance+ 500 WHERE id =2";
			update(conn, sql);
			//�ύ����
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//��������쳣���ع�����
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
