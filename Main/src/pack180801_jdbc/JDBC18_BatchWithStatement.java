package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBC18_BatchWithStatement {
/**
 * ��person���ݱ��в����������
 * ������β�����ʱ���
 * 1.ʹ��Statement
 * */
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		try {
			connection = JDBC03_Tool.getConnection();
			JDBC03_Tool.beginTx(connection);
			sql = "INSERT INTO jdbccustomers VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			
			long begin = System.currentTimeMillis();
			int sum = 10;
			int batch = 5;
			for(int i = 0; i < sum; i++){
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setString(3, "email" + i+"@qq.com");
				preparedStatement.setString(4, "2000-" + i+"-1");
				
				//"����" SQL 
				preparedStatement.addBatch();
				
				//�� "����" ��һ���̶�, ��ͳһ��ִ��һ��. ���������ǰ "����" �� SQL
				if((i + 1) % batch == 0){
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}
			}
			
			//������������������ֵ��������, ����Ҫ�ٶ����ִ��һ��. 
			if(sum % batch != 0){
				preparedStatement.executeBatch();
				preparedStatement.clearBatch();
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("Time: " + (end - begin)); 
			
			JDBC03_Tool.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBC03_Tool.rollback(connection);
		} finally{
			JDBC03_Tool.realease(preparedStatement, connection);
		}
	}

}
