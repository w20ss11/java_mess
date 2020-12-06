package pack180801_multiThread;

public class W2_JoinYield {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JoinMain t1 = new JoinMain();
		t1.start();
		t1.join();
		System.out.println("½áÊø");
		
	}

}

class JoinMain extends Thread{
	public void run(){
		for(int i=0;i<3;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
