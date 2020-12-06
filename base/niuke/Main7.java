/**
数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

输入描述:
先输入键值对的个数
然后输入成对的index和value值，以空格隔开


输出描述:
输出合并后的键值对（多行）

输入例子:
4
0 1
0 2
1 2
3 4

输出例子:
0 3
1 2
3 4
**/
import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String line1=sca.nextLine();
            int n=Integer.valueOf(line1);
			//System.out.println("n:"+n);
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
			for(int i=0;i<n;i++){
                String[] strs=new String[2];
				String line2=sca.nextLine();
                strs=line2.split(" ");
                int[] ints=new int[2];
                ints[0]=Integer.parseInt(strs[0]);
                ints[1]=Integer.parseInt(strs[1]);
				if(map.containsKey(ints[0])){
					int value=ints[1]+map.get(ints[0]);
					map.put(ints[0],value);
				}
				else
					map.put(ints[0],ints[1]);
            }
			Set<Integer> set=map.keySet();
            TreeSet<Integer> t=new TreeSet<Integer>(set);
			//System.out.println("------------------"+t.toString());
			Iterator<Integer> it=t.iterator();
			while(it.hasNext()){
				int key=it.next();
				System.out.print(key+" "+map.get(key)+" ");
			}
        }
    }
}