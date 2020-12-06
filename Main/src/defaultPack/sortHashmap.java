package defaultPack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class sortHashmap {
	public static void main(String[] args){
//		HashMap<String, String> map_Data=new HashMap<String, String>();  
//	    map_Data.put("A", "98");  
//	    map_Data.put("B", "50");  
//	    map_Data.put("C", "50");  
//	    map_Data.put("D", "25");  
//	    map_Data.put("E", "85");  
//	    System.out.println(map_Data);  
//	    List<Map.Entry<String, String>> list_Data = new ArrayList<Map.Entry<String, String>>(map_Data.entrySet());  
//	    Collections.sort(list_Data, new Comparator<Map.Entry<String, String>>()  
//	      {   
//	          public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)  
//	          {  
//	           if(o2.getValue()!=null&&o1.getValue()!=null&&o2.getValue().compareTo(o1.getValue())>0){  
//	            return 1;  
//	           }else{  
//	            return -1;  
//	           }  
//	              
//	          }  
//	      });  
//	    System.out.println(list_Data);  
	    
	    HashMap<Integer, Double> map_Data=new HashMap<Integer, Double>();  
	    map_Data.put(0, 2.1);  
	    map_Data.put(1, 8.5);  
	    map_Data.put(2, 4.9);  
	    map_Data.put(3, 7.3);  
	    map_Data.put(4, 0.9);
	    ArrayList<Entry<Integer, Double>> arrayList=sortHashmap(map_Data);
	    System.out.println(arrayList);
	    System.out.println(arrayList.get(0).getKey());
	}
	private static ArrayList<Entry<Integer, Double>> sortHashmap(Map<Integer, Double> map_dis) {
		List<Map.Entry<Integer, Double>> entries = new ArrayList<Map.Entry<Integer, Double>>(map_dis.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<Integer, Double>>() {
			public int compare(Map.Entry<Integer, Double> obj1 , Map.Entry<Integer, Double> obj2) {
				int res=obj2.getValue()>obj1.getValue()?-1:1;
				return res;
			}
		});
		//System.out.println((ArrayList<Entry<Integer, Double>>) entries);
		return (ArrayList<Entry<Integer, Double>>) entries;
		
	}
}
