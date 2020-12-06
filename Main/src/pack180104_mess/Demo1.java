package pack180104_mess;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class Demo1 {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Person person = new Person("zhangsan", "male", 18);
		BeanUtils.setProperty(person, "name", "sb");
		Object object = BeanUtils.getProperty(person, "name");
		System.out.println(object);
		
		int a=2,b=0;
		do{--b;}
		while(a-- >0);
		System.out.println(b);
	}
}
