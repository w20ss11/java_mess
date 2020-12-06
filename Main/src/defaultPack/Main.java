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


public class Main {
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();
	static StringBuffer sb3 = new StringBuffer();
	static StringBuffer sb4 = new StringBuffer();
	static StringBuffer sb5 = new StringBuffer();
	static StringBuffer sb6 = new StringBuffer();
	static StringBuffer sb7 = new StringBuffer();
	static String fileName1="Pear";
	static String fileName2="CoCo";
	static String fileName3="dlink";
	static String fileName4="Banana";
	static String fileName5="Blackberry";
	static String fileName6="dlink_test";
	static String fileName7="Orange";
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		try {
			File file=new File("D:\\test.txt");
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
				sb3.setLength(sb3.length()-1);
				sb4.setLength(sb4.length()-1);
				sb5.setLength(sb5.length()-1);
				sb6.setLength(sb6.length()-1);
				sb7.setLength(sb7.length()-1);
			}
			br.close();

			
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName1+".txt")));
			out1.write(sb1.toString());
			PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName2+".txt")));
			out2.write(sb2.toString());
			PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName3+".txt")));
			out3.write(sb3.toString());
			PrintWriter out4 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName4+".txt")));
			out4.write(sb4.toString());
			PrintWriter out5 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName5+".txt")));
			out5.write(sb5.toString());
			PrintWriter out6 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName6+".txt")));
			out6.write(sb6.toString());
			PrintWriter out7 = new PrintWriter(new BufferedWriter(new FileWriter("D:\\temp\\"+fileName7+".txt")));
			out7.write(sb7.toString());
			//System.out.println(sb.toString());
			out1.flush();
			out2.flush();
			out3.flush();
			out4.flush();
			out5.flush();
			out6.flush();
			out7.flush();
			out1.close();
			out2.close();
			out3.close();
			out4.close();
			out5.close();
			out6.close();
			out7.close();
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
			}else if(map.get("wifiName").equals(fileName3)){
				sb3.append(map.get("wifiStrength")+"\r\n");
			}else if(map.get("wifiName").equals(fileName4)){
				sb4.append(map.get("wifiStrength")+"\r\n");
			}else if(map.get("wifiName").equals(fileName5)){
				sb5.append(map.get("wifiStrength")+"\r\n");
			}else if(map.get("wifiName").equals(fileName6)){
				sb6.append(map.get("wifiStrength")+"\r\n");
			}else if(map.get("wifiName").equals(fileName7)){
				sb7.append(map.get("wifiStrength")+"\r\n");
			}else{
				continue;
			}
		}
	}
}

