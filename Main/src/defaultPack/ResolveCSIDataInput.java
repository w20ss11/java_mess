package defaultPack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResolveCSIDataInput {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("D:\\eclipse_workspace\\Main\\src\\0330_R1_132_1.txt"));
		try (DataInputStream in = new DataInputStream(
				new FileInputStream("D:\\csi.dat"))) {
			boolean flag = true;
			int count = 0;
			int temp;
			// System.setOut(out);
			while (flag) {
				temp = in.readUnsignedByte();
//				if (count > 0) {
//					System.out.println(temp);
//					out.writeByte(temp);
//				} else {
//					count++;
//					continue;
//				}

				 System.out.println(temp);
				 out.writeByte(temp);
				if (count > 211) {
					flag = false;
				}
				count++;
			}
			out.close();
		}

	}
}
