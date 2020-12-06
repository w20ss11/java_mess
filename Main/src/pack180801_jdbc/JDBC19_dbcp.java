package pack180801_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBC19_dbcp {
/**
 * ʹ��DBCP���ݿ����ӳ�
 * 1.���jar�� (����) common-dbcp common-pool
 * 2.�������ݿ����ӳ�
 * 3.Ϊ����Դʵ��ִ�б��������
 * 4.������Դ�л�ȡ���ݿ�����
 * @throws SQLException 
 * */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		BasicDataSource dataSource = null;
		//1. ����DBCP ����Դʵ��
		dataSource = new BasicDataSource();
		//2. Ϊ����Դʵ��ָ�����������
		dataSource.setUsername("root");
		dataSource.setPassword("wss6565");
		dataSource.setUrl("jdbc:mysql:///hello?useSSL=false");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//3. ִ������Դ��һЩ��ѡ������
		//3.1 ָ�����ݿ����ӳ��еĳ�ʼ���������ĸ���
		dataSource.setInitialSize(10);
		//3.2 ָ�����������:ͬһʱ�̿���ͬʱ�����ݿ������������
		dataSource.setMaxTotal(50);
		//3.3 ָ����С�������������ݿ����ӳؿ���״̬�£����ӳ��������ж��ٸ�����
		dataSource.setMinIdle(5);
		//3.4 �ȴ����ݿ����ӳط������ӵ��ʱ�䣬��λΪ���룬������ʱ�佫�׳��쳣
		dataSource.setMaxWaitMillis(1000*5);
		
		//4. ������Դ�л�ȡ���ݿ�����
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}

}
