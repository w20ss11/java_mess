package pack180801_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC04_ResultSet {
/**
 * ResultSet:���������װ��ʹ��JDBC���в�ѯ�Ľ��
 * 1.����Statement�����executeQuery(sql)���Եõ��������
 * 2.ResultSet���ص�ʵ���Ͼ���һ�����ݱ���һ��ָ��ָ�����ݱ�ĵ�һ����ǰ�档
 * ���Ե���next()���������һ���Ƿ���Ч������Ч�÷�������ture����ָ�����ƣ��൱��Iterator�����
 * hasNext()��next()�����Ľ����
 * 3.��ָ�붨λ����Ҫһ��ʱ������ͨ������getXXX(index)��getXXX(columnName)
 * 4.ResultSetҲ��Ҫ���йرա�
 * */
	public static void main(String[] args) {
		//��ȡid=1��jdbccustomers���ݱ�ļ�¼������ӡ
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			//1.��ȡConnection
			conn = JDBC03_Tool.getConnection();
			//2.��ȡStatement
			statement = conn.createStatement();
			//3.׼��SQL
			String sql = "select id,name,email,birth from jdbccustomers "
					+ "where id = 1;";
			//4.ִ�в�ѯ���õ�ResultSet
			rs = statement.executeQuery(sql);
			//5.����ResultSet
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
			//6.�ر����ݿ���Դ
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
