package pack180104_mess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Min10 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(22);
		list.add(2);
		list.add(9);
		System.out.println(list.size());
		
		System.out.println(list.toString());
		list.set(0, 999);
		System.out.println(list.toString());
		
		HashMap<String, String> map = new HashMap<>();
		map.put("张三", "北京");
		map.put("李四", "上海");
		map.put("王五", "广州");
		System.out.println(map.get("张三"));
		System.out.println(map.size());
		
		Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator(); 
		while (entries.hasNext()) { 
		  Map.Entry<String, String> entry = entries.next(); 
		  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		}

	}

}
