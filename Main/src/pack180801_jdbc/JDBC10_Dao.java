package pack180801_jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class JDBC10_Dao {
	/**
	 * 访问数据信息的类，包含了对数据的CURD(create,read,update,delete)
	 * 
	 * 1. insert update delete都在其中
	 * void update(String sql,Object ... args);
	 * 
	 * 2. 查询多条记录，返回对应的对象的集合
	 * <T> T get(Class<T> clazz,String sql,Object ...args)
	 * 
	 * 3. 返回某条记录的某一字段的值 或 一个统计的值（一共多少条记录等）
	 * <E> E getForValue(String,Object ... args)
	 * */
	public void update(String sql,Object ...args){
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
	public <T>T get(Class<T> clazz,String sql,Object ...args){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		T entity = null;
		try {
			conn = JDBC03_Tool.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				preparedStatement.setObject(i+1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData md = resultSet.getMetaData(); //获得结果集结构信息,元数据
			Map<String, Object> values = new HashMap<String,Object>();
			while(resultSet.next()){
				for(int i=0;i< md.getColumnCount();i++){
					String columnLabel = md.getColumnLabel(i+1);//列名
					Object columnValue = resultSet.getObject(columnLabel);
					values.put(columnLabel, columnValue);
				}
			}
			if(values.size()>0){
				entity = clazz.newInstance();
				for (Map.Entry<String, Object>entry:values.entrySet()) {
					String fieldName = entry.getKey();
					Object fieldValue = entry.getValue();
					//JDBC11 改为用BeanUtils来赋值
					BeanUtils.setProperty(entity, fieldName, fieldValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC03_Tool.realease(resultSet,preparedStatement,conn);
		}
		return entity;
	}
	//JDBC12 查询多条记录，返回对应的对象集合
	public <T> List<T> getForList(Class<T> clazz,String sql, Object... args) {
		List<T> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//1. 得到结果集
			connection = JDBC03_Tool.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();

			//2. 处理结果集, 得到 Map 的 List, 其中一个 Map 对象
			//就是一条记录. Map 的 key 为 reusltSet 中列的别名, Map 的 value
			//为列的值. 
			List<Map<String, Object>> values = 
					handleResultSetToMapList(resultSet);

			//3. 把 Map 的 List 转为 clazz 对应的 List
			//其中 Map 的 key 即为 clazz 对应的对象的 propertyName, 
			//而 Map 的 value 即为 clazz 对应的对象的 propertyValue
			list = transfterMapListToBeanList(clazz, values);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC03_Tool.realease(resultSet, preparedStatement, connection);
		}
		return list;
	}
	public <T> List<T> transfterMapListToBeanList(Class<T> clazz,
			List<Map<String, Object>> values) throws InstantiationException,
	IllegalAccessException, InvocationTargetException {

		List<T> result = new ArrayList<>();

		T bean = null;

		if (values.size() > 0) {
			for (Map<String, Object> m : values) {
				bean = clazz.newInstance();
				for (Map.Entry<String, Object> entry : m.entrySet()) {
					String propertyName = entry.getKey();
					Object value = entry.getValue();

					BeanUtils.setProperty(bean, propertyName, value);
				}
				// 13. 把 Object 对象放入到 list 中.
				result.add(bean);
			}
		}

		return result;
	}

	/**
	 * 处理结果集, 得到 Map 的一个 List, 其中一个 Map 对象对应一条记录
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> handleResultSetToMapList(
			ResultSet resultSet) throws SQLException {
		// 5. 准备一个 List<Map<String, Object>>:
		// 键: 存放列的别名, 值: 存放列的值. 其中一个 Map 对象对应着一条记录
		List<Map<String, Object>> values = new ArrayList<>();

		List<String> columnLabels = getColumnLabels(resultSet);
		Map<String, Object> map = null;

		// 7. 处理 ResultSet, 使用 while 循环
		while (resultSet.next()) {
			map = new HashMap<>();
			for (String columnLabel : columnLabels) {
				Object value = resultSet.getObject(columnLabel);
				map.put(columnLabel, value);
			}
			// 11. 把一条记录的一个 Map 对象放入 5 准备的 List 中
			values.add(map);
		}
		return values;
	}

	/**
	 * 获取结果集的 ColumnLabel 对应的 List
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<String> getColumnLabels(ResultSet rs) throws SQLException {
		List<String> labels = new ArrayList<>();

		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			labels.add(rsmd.getColumnLabel(i + 1));
		}
		return labels;
	}
	// 返回某条记录的某一个字段的值 或 一个统计的值(一共有多少条记录等.)
	@SuppressWarnings("unchecked")
	public <E> E getForValue(String sql, Object... args) {

		//1. 得到结果集: 该结果集应该只有一行, 且只有一列
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//1. 得到结果集
			connection = JDBC03_Tool.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return (E) resultSet.getObject(1);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JDBC03_Tool.realease(resultSet, preparedStatement, connection);
		}
		//2. 取得结果

		return null;
	}


}
