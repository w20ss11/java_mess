package pack180104_mess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitTxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "D:/test.txt";
		splitTxt(4, filename);//filename :"D:/test.txt"
	}

	public static void splitTxt(int count,String filename) {  
        try {  
            FileReader read = new FileReader(filename);  
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(read);  
            String row;  
            List<FileWriter> flist = new ArrayList<FileWriter>();  
            for (int i = 0; i < count; i++) {  
                flist.add(new FileWriter("D:/text" + i + ".txt"));  
            }  
            int rownum = 1;// ¼ÆÊýÆ÷  
            while ((row = br.readLine()) != null) {  
                flist.get(rownum % count).append(row + "\r\n");  
                rownum++;  
            }  
            for (int i = 0; i < flist.size(); i++) {  
                flist.get(i).close();  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
