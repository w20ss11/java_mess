package pack180801_jvm;

import java.util.Random;

public class GCDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		String string = "haha ";
		while(true){
			string += string + random.nextInt(1000) + random.nextInt(100000);
			string.intern();//ǿ�Ʋ�������
		}
	}

}
//��Ƶ6 �����
//java -XmX10m -Xms10m -XX:+PrintGCDatils GCDemo2
//java -XmX10m -Xms10m -XX:SurvivorRatio=6 -XX:+PrintGCDatils GCDemo2 //6:1:1 Eden:s0:s1
//java -XmX100m -Xms100m -XX:PretenureSizeThreshold=512k(������) -XX:NewRatio=1(������) -XX:+PrintGCDatils GCDemo2

//java -XX:MetaspaceSize=1m -XX:MaxMetaspaceSize=1m GCDemo2