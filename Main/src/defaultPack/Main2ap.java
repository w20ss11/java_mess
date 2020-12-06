package defaultPack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Main2ap {
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();

	static String fileName1="dlink";
	static String fileName2="CoCo";

	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		try {
			File file=new File("D:\\data.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str =null;
			Iterator<Map<String, String>> iterator;
			List<Map<String, String>> list=new ArrayList<Map<String, String>>();
			while((str=br.readLine()) != null){
				if(str.endsWith("]")){
					getApFromList(str);
				}
//				else if(str.endsWith("0")|str.endsWith("1"))
//					getApFromList(str.substring(0, str.length()-2));
				else
					continue;
			}
			if(str!=null){
				sb1.setLength(sb1.length()-1);
				sb2.setLength(sb2.length()-1);
			}
			br.close();

			
			@SuppressWarnings("resource")
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName1+".txt")));
			out1.write(sb1.toString());
			@SuppressWarnings("resource")
			PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName2+".txt")));
			out2.write(sb2.toString());
			//System.out.println(sb.toString());
			out1.flush();
			out2.flush();
		}catch(FileNotFoundException e){
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getApFromList(String str) {
		Iterator<Map<String, String>> iterator;
		List<Map<String, String>> list;
		list = HandleJsonString.readJsonString(str);
		iterator=list.iterator();
		while(iterator.hasNext()){
			Map<String, String>map=(Map<String, String>) iterator.next();
			if(map.get("wifiName").equals(fileName1)){
				sb1.append(map.get("wifiStrength")+"\r\n");
			}else if(map.get("wifiName").equals(fileName2)){
				sb2.append(map.get("wifiStrength")+"\r\n");
			}else{
				continue;
			}
		}
	}
}

