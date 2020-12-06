package pack180801_jdbc;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class JDBC11_JavaBean {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		//≤‚ ‘set
		Object object = new JDBC06_Person();
		System.out.println(object.toString());
		BeanUtils.setProperty(object, "name", "bean_name");
		System.out.println(object.toString());
		
		//≤‚ ‘get
		Object val= BeanUtils.getProperty(object, "name");
		System.out.println(val);
	}

}
