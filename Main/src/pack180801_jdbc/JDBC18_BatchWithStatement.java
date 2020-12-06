package pack180801_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBC18_BatchWithStatement {
/**
 * 向person数据表中插入多条数据
 * 测试如何插入用时最短
 * 1.使用Statement
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
				
				//"积攒" SQL 
				preparedStatement.addBatch();
				
				//当 "积攒" 到一定程度, 就统一的执行一次. 并且清空先前 "积攒" 的 SQL
				if((i + 1) % batch == 0){
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}
			}
			
			//若总条数不是批量数值的整数倍, 则还需要再额外的执行一次. 
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
