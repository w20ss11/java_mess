package pack180801_jvm;

public class GCDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "haha";
		while(true){
			string += string;
			string.intern();
		}
	}

}
//สำฦต11
//java -Xmx10m -Xms10m -XX:+PrintGCDatils GCDemo3
//java -Xmx10m -Xms10m -XX:+UseSerialGC   -XX:+PrintGCDatils GCDemo3
//java -Xmx10m -Xms10m -XX:+UseParallelGC -XX:+PrintGCDatils GCDemo3
//java -Xmx10m -Xms10m -XX:+UseConcMarkSweepGC -XX:+PrintGCDatils GCDemo3

//สำฦต14
//java -Xmx10m -Xms10m -XX:UseG1GC -XX:+PrintGCDatils GCDemo3