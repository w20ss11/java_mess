package defaultPack;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		CSI csi=new CSI();
		DataInputStream inputStream=new DataInputStream(new FileInputStream("D://csi.dat"));
		int[] bs = new int[212];
		int temp = 0;
		for(int i=0;i<213;i++){
			temp = inputStream.readUnsignedByte();
			if(i > 0) {
				bs[i-1]= temp;
				//System.out.println(temp);
			}
		}
//		csi.readCSI(bs);
	}

}
