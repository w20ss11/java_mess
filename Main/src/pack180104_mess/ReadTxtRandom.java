package pack180104_mess;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReadTxtRandom {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\a.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<String> list = new ArrayList<String>();
		String s = "";
		while ((s = br.readLine()) != null) {
			list.add(s);
		}
		br.close();
		fr.close();

		int n = 3;
		Set<String> aps=new HashSet<String>();
		for(int i=0;i<3;i++){
			int temp = (int) (Math.random() * (list.size()));
			String[] ss = list.get(temp).split("##");
			for(int j=0;j<ss.length;j++){
				String temp_ap = ss[j].split(",")[0].trim();
				if(temp_ap.length()!=0)
					aps.add(temp_ap);
			}
		}
		ArrayList<String> result = new ArrayList<String>(aps);
		System.out.println(result.toString());
		System.out.println(result.size());
	}
}