package pack180801_jvm;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;


public class GCDemo5 {

	public static void main(String[] args) {
		// สำฦต18
		String key = new String("key");
		String value = new String("value");
		Map<String, String> map = new WeakHashMap<String, String>();
		map.put(key, value);
		System.out.println(map);
		key = null;
		System.out.println(map);
		System.gc();
		System.out.println(map);
		
		System.out.println("---------------------------------");
		
		String string = new String("haha");
		WeakReference<String> reference = new WeakReference<String>(string);
		string = null;
		System.out.println(reference.get());
		System.gc();
		System.out.println(reference.get());
		
	}

}
