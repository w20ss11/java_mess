package pack180801_jvm;

public class GCdemo1 {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory();
		long totalMemory = runtime.totalMemory();
		System.out.println("maxMemory:"+maxMemory/1024/1024+"M");
		System.out.println("totalMemory:"+totalMemory/1024/1024+"M");

	}

}

// java -Xmx3G -Xms3G -XX:+PrintGCDatils GCDemo1