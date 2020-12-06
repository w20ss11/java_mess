/**
王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
主件	附件
电脑	打印机，扫描仪
书柜	图书
书桌	台灯，文具
工作椅	无
如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
    设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
    请你帮助王强设计一个满足要求的购物单。

输入描述:
输入的第 1 行，为两个正整数，用一个空格隔开：N m
（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）

从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q

（其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）

输出描述:
输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。

输入例子:
1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

输出例子:
2200

**/
import java.util.Scanner;
import java.lang.Integer;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
			int mon=0;
			int res=0;
            String line1=sca.nextLine();
			String[] strs1=line1.split(" ");
			ArrayList<Goods> list=new ArrayList<Goods>();
			int sum=Integer.valueOf(strs1[0]);
			int row=Integer.valueOf(strs1[1]);
			for(int i=0;i<row;i++){
				String line2=sca.nextLine();
				String[] strs2=line2.split(" ");
				//System.out.println(Arrays.toString(strs2));
				if(strs2[2].equals("0")){
					Goods goods=new Goods(Integer.valueOf(strs2[0]),Float.valueOf(strs2[1]),Integer.valueOf(strs2[2]));
					list.add(goods);
					//System.out.println(list.add(goods));
					//System.out.println(list.size());
					//list.get(list.size()-1).toStr();
					//for(int x=0;x<list.size();x++)
						//list.get(x).toStr();
				}
				else{
					Goods g=list.get(list.size()-1);
					g.saveAppendix(Integer.valueOf(strs2[0]),Float.valueOf(strs2[1]),Integer.valueOf(strs2[2]));
					g.hasAppendix=true;
					list.set(list.size()-1,g);
				}
			}
			
			Collections.sort(list,new SortByKey());
			//for(int x=0;x<list.size();x++)
				//list.get(x).toStr();
			while(list.size()!=0){
				Goods go=list.get(0);
				mon=mon+go.getPrice();
				//System.out.println("mon:"+mon);
				res=res+go.getPrice()*(int)go.getLevel();
				if(mon>sum){
					mon=mon-go.getPrice();
					res=res-go.getPrice()*(int)go.getLevel();
					//System.out.println("hahaha");
				}
				if(!go.gethasAppendix()){
					list.remove(0);
				}
				else{
					for(int i=0;i<go.appendixes.size();i++){
						list.add((Goods)go.getAppendixes().get(i));
					}
					list.remove(0);
					Collections.sort(list,new SortByKey());
				}
			}
			System.out.println(res);
        }
    }
}
class Goods{
	boolean hasAppendix=false;
	int price;
	float level;
	int type;
	float key;
	ArrayList<Appendix> appendixes;
	Goods(int price,float level,int type){
		this.price=price;
		this.level=level;
		this.type=type;
		key=(float)level/(price/10);
		//super(price,level,type);
	}
	public void saveAppendix(int price,float level,int type){
		appendixes=new ArrayList<Appendix>();
		appendixes.add(new Appendix(price,level,type));
	}
	public void toStr(){
		System.out.println("price:"+price+" level:"+level+" type:"+type);
	}
	public boolean gethasAppendix(){
		return this.hasAppendix;
	}
	public float getLevel(){
		return this.level;
	}
	public int getPrice(){
		return this.price;
	}
	public ArrayList<Appendix> getAppendixes(){
		return this.appendixes;
	}
}
class Appendix extends Goods{
	int price;
	float level;
	int type;
	float key;
	//ArrayList<String[]> appendix;
	Appendix(int price,float level,int type){
		//this.price=price;
		//this.level=level;
		//this.type=type;
		super(price,level,type);
		key=(float)level/(price/10);
	}
}
class SortByKey implements Comparator<Goods> {
	public int compare(Goods o1, Goods o2) {
		//Goods g1 = (Goods) o1;
		//Goods g2 = (Goods) o2;
		//System.out.println("Comparator-----------------"+o1.key+" compare "+o2.key);
		if (o1.key> o2.key)
			//System.out.println("return -1;");
			return -1;
		else if(o1.key==o2.key)
			//System.out.println("return 0;");
			return 0;
		return 1;
	}
}