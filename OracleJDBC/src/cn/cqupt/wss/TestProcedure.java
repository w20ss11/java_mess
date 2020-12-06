package cn.cqupt.wss;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.driver.OracleTypes;

/*

  1.导入驱动包
  2.注册驱动
  3.获取连接
  4.获取执行SQL的statement
  5.封装参数
  6.执行SQL
  7.获取结果
  8.释放资源   
 */
public class TestProcedure {

	@Test
	/*
	 create or replace procedure proc_gettotalsal(vempno in number,vtotalsal out number)
	is
	       
	begin
	  select sal*12 + nvl(comm,0) into vtotalsal from emp where empno = vempno;
	end;
	 * */
	public void test1() throws Exception{
		//注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接
		String url = "jdbc:racle:thin:@192.168.1.110:1521:orcl";
		String username = "c##dakang";
		String password = "c##dakang";
		Connection conn = DriverManager.getConnection(url, username, password);
		//3.获取执行SQL的statement.这是一个固定格式  proc_gettotalsal是一个存储函数
		String sql = "{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);
		//设置输入参数
		state.setInt(1, 7788);//设置员工编号
		//注册输出参数类型
		state.registerOutParameter(2, OracleTypes.NUMBER);
		
		//4.执行statement
		state.execute();
		
		//5.获取执行结果
		int totalsal = state.getInt(2);
		
		//输出结果
		System.out.println("工资:"+ totalsal);
		
		//6.释放资源
		state.close();
		conn.close();
	}
	
	//调用存储函数
	/*
	 create or replace function func_getsal(vempno number) return number
	is
	  --声明变量.保存年薪
	  vtotalsal number;     
	begin
	  select sal*12 + nvl(comm,0) into vtotalsal from emp where empno = vempno;
	  return vtotalsal;
	end; 
	 */
	@Test
	public void test2() throws Exception{
		//注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接
		String url = "jdbc:oracle:thin:@192.168.80.100:1521:orcl";
		String username = "dakang";
		String password = "dakang";
		Connection conn = DriverManager.getConnection(url, username,password);
		//3.获取执行SQL的statement
		String sql = " {?= call func_getsal(?)}";
		CallableStatement state = conn.prepareCall(sql);
		//4.封装参数
		//注册返回类型参数
		state.registerOutParameter(1, OracleTypes.NUMBER);
		//设置第二个参数
		state.setInt(2, 7788);
		//5.执行SQL
		state.execute();		
		//6.获取结果
		int totalsal = state.getInt(1);
		System.out.println("年薪 :  ====" +totalsal);		
		//7.释放资源
		state.close();
		conn.close();
	}
	
	/*
	 create or replace procedure proc_getemps(vrows out sys_refcursor)
		is
		
		begin
		  --1.打开游标, 给游标赋值
		  open vrows for select * from emp;
		end;
	 * */
	@Test
	public void test3() throws Exception{
		//注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接
		String url = "jdbc:oracle:thin:@192.168.80.100:1521:orcl";
		String username = "dakang";
		String password = "dakang";
		Connection conn = DriverManager.getConnection(url, username,password);
		//3.获取执行SQL的statement
		String sql = "{call proc_getemps(?)}";
		CallableStatement call = conn.prepareCall(sql);
		//接口  --- > 对象 -->实现类的名称
		System.out.println(call.getClass().getName());
		OracleCallableStatement oracleCall = (OracleCallableStatement)call;
		//4.注册输出类型的参数
		call.registerOutParameter(1, OracleTypes.CURSOR);
		//5.执行SQL
		call.execute();
		//6.获取执行的结果
		ResultSet resultSet = oracleCall.getCursor(1);
		while(resultSet.next()){
			int empno = resultSet.getInt("empno");
			String name = resultSet.getString("ename");
			System.out.println(empno +" ==== "+name);
		}
		
		//7.释放资源
		resultSet.close();
		call.close();
		conn.close();
	}
}
