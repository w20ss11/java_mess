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
 * 操作JDBC的工具类，其中封装了一些工具方法
 * */
public class JDBC03_Tool {

	/**
	 * JDBC03
	 * 获取连接的方法//后面会修改，不能每进行一次操作就进行一次连接，使用数据库连接池
	 * */
	public static Connection getConnection() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//准备连接数据库的4个字符串 驱动的全类名 url user password
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

		//2. 加载数据驱动程序
		Class.forName(driverClass);
		//3. 通过DriverManager的getConnection方法获取数据库连接
		Connection connection = DriverManager.getConnection(url, user, psd);
		return connection;
	}
	
	/**
	 * JDBC03
	 * 关闭Statement和connection
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
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	/**
	 * JDBC06 update
	 * 执行sql：insert update delete 无select
	 * 每一次执行都会获取一次连接
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
			ResultSetMetaData md = resultSet.getMetaData(); //获得结果集结构信息,元数据
			int columnCount = md.getColumnCount();   //获得列数 
			//视频中在此直接生成Person对象
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
	 * 执行SQL语句，使用preparedStatement
	 * args：填写SQL占位符的可变参数
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
	 * 通过反射生成查询对象，而不是在06中将对象属性值通过map传回去
	 * */
	public static <T>T select(Class<T> clazz,String sql,Object ...args){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		T entity = null;
		try {
			//1.得到Result对象
			conn = JDBC03_Tool.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				preparedStatement.setObject(i+1, args[i]);
				//preparedStatement.setInt(1, arg);
			}
			resultSet = preparedStatement.executeQuery();
			//2。得到ResultSetMetaData对象
			ResultSetMetaData md = resultSet.getMetaData(); //获得结果集结构信息,元数据
			//3.创建Map<String, Object>对象，键：SQL查询的列的别名
			Map<String, Object> values = new HashMap<String,Object>();
			//4.处理结果集，填充3对应的Map对象
			while(resultSet.next()){
				for(int i=0;i< md.getColumnCount();i++){
					String columnLabel = md.getColumnLabel(i+1);//列名
					Object columnValue = resultSet.getObject(columnLabel);
					values.put(columnLabel, columnValue);
				}
			}
			//5.若Map不为空集，利用反射创建clazz对应的对象
			if(values.size()>0){
				entity = clazz.newInstance();
				//6.遍历Map对象，利用反射为Class对象的对应的属性赋值
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
