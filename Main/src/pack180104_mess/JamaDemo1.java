package pack180104_mess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import Jama.Matrix;

public class JamaDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double[][] ds = new double[][]{{1.0,1.0,1.0},  
            {1.0,1.0,1.0},  
            {1.0,1.0,1.0}};
        Matrix A = new Matrix(ds);
        Matrix B = A.times(A);
        B.print(3, 2);
        String[] selected_aps = new String[]{"HaHeiHe","Wi-FiAWare11"};
        getFinalRes("D:\\a.txt",selected_aps);
	}
	
	public static String getFinalRes(String filename,String[] selected_aps) throws IOException{
		//从file中读取 按照selected_aps获取矩阵
        FileInputStream inputStream = new FileInputStream(new File(filename));  //BufferedReader是可以按行读取文件  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        
        ArrayList<String> list = new ArrayList<String>();
        String str = null;  
        while((str = bufferedReader.readLine()) != null)  
        {  
            list.add(str);
        }  
        inputStream.close();  
        bufferedReader.close(); 
        double[][] ds = new double[selected_aps.length][list.size()];
        for(int i=0;i<list.size();i++){
        	String[] per_sec = list.get(i).split("##");
        	for(int j=0;j<per_sec.length;j++){
        		String[] per_wifi = per_sec[j].split(",");
        		for(int m=0;m<selected_aps.length;m++){
        			System.out.println(per_wifi[0]);
        			if(per_wifi[0].equals(selected_aps[m])){
        				System.out.println("####:"+per_wifi[2]);
        				ds[m][i]=Double.parseDouble(per_wifi[2]);
        			}
        		}
        	}
        }
        System.out.println("ds:"+Arrays.deepToString(ds));
		return "";
	}

}
