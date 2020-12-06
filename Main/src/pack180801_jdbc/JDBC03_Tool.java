package pack180801_jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ����JDBC�Ĺ����࣬���з�װ��һЩ���߷���
 * */
public class JDBC03_Tool {

	/**
	 * JDBC03
	 * ��ȡ���ӵķ���//������޸ģ�����ÿ����һ�β����ͽ���һ�����ӣ�ʹ�����ݿ����ӳ�
	 * */
	public static Connection getConnection() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//׼���������ݿ��4���ַ��� ������ȫ���� url user password
		String driverClass = null;
		String url = null;
		String user = null;
		String psd = null;
		InputStream in = 
				JDBC03_Tool.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		psd = properties.getProperty("psd");

		//2. ����������������
		Class.forName(driverClass);
		//3. ͨ��DriverManager��getConnection������ȡ���ݿ�����
		Connection connection = DriverManager.getConnection(url, user, psd);
		return connection;
	}
	
	/**
	 * JDBC03
	 * �ر�Statement��connection
	 * */
	public static void realease(Statement statement,Connection conn){
		if(statement!=null)
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	/**
	 * JDBC06 update
	 * ִ��sql��insert update delete ��select
	 * ÿһ��ִ�ж����ȡһ������
	 * */
	public static void update(String sql){
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
	/**
	 * JDBC06 select
	 * */
	public static ArrayList<Map<String,Object>> select(String sql){
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			conn = JDBC03_Tool.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			ResultSetMetaData md = resultSet.getMetaData(); //��ý�����ṹ��Ϣ,Ԫ����
			int columnCount = md.getColumnCount();   //������� 
			//��Ƶ���ڴ�ֱ������Person����
			while (resultSet.next()) {
				Map<String,Object> rowData = new HashMap<String,Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), resultSet.getObject(i));
				}
				list.add(rowData);
	 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(resultSet,statement, conn);
		}
		return list;
	}
	
	/**
	 * JDBC07 update
	 * ִ��SQL��䣬ʹ��preparedStatement
	 * args����дSQLռλ���Ŀɱ����
	 * */
	public static void update(String sql,Object ...args){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = JDBC03_Tool.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				preparedStatement.setObject(i+1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
		}finally {
			JDBC03_Tool.realease(preparedStatement, conn);
		}
	}
	
	/**
	 * JDBC08 select
	 * ͨ���������ɲ�ѯ���󣬶�������06�н���������ֵͨ��map����ȥ
	 * */
	public static <T>T select(Class<T> clazz,String sql,Object ...args){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		T entity = null;
		try {
			//1.�õ�Result����
			conn = JDBC03_Tool.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				preparedStatement.setObject(i+1, args[i]);
				//preparedStatement.setInt(1, arg);
			}
			resultSet = preparedStatement.executeQuery();
			//2���õ�ResultSetMetaData����
			ResultSetMetaData md = resultSet.getMetaData(); //��ý�����ṹ��Ϣ,Ԫ����
			//3.����Map<String, Object>���󣬼���SQL��ѯ���еı���
			Map<String, Object> values = new HashMap<String,Object>();
			//4.�������������3��Ӧ��Map����
			while(resultSet.next()){
				for(int i=0;i< md.getColumnCount();i++){
					String columnLabel = md.getColumnLabel(i+1);//����
					Object columnValue = resultSet.getObject(columnLabel);
					values.put(columnLabel, columnValue);
				}
			}
			//5.��Map��Ϊ�ռ������÷��䴴��clazz��Ӧ�Ķ���
			if(values.size()>0){
				entity = clazz.newInstance();
				//6.����Map�������÷���ΪClass����Ķ�Ӧ�����Ը�ֵ
				for (Map.Entry<String, Object>entry:values.entrySet()) {
					String fieldName = entry.getKey();
					Object fieldValue = entry.getValue();
					ReflectionUtils.setFieldValue(entity, fieldName, fieldValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(resultSet,preparedStatement,conn);
		}
		return entity;
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
