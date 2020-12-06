package defaultPack;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CSI {
	public static void main(String[] args) {
		ArrayList<Byte> realitys = new ArrayList<>();
		ArrayList<Byte> images = new ArrayList<>();
		int len = 192;
		try (DataInputStream in = new DataInputStream(new FileInputStream("D:\\eclipse_workspace\\Main\\src\\0330_R1_132_1.txt"))) {
			int count = 0;
			int[] payload = new int[len];
			while (count < 20) {
				try {
					in.readUnsignedByte();
				} catch (IOException e) {
					e.printStackTrace();
				}
				count++;
			}

			for (int i = 0; i < len; i++) {
				payload[i] = in.readUnsignedByte();
			}
			int index = 0;
			byte temp;

			for (int j = 0; j < 30; j++) {
				index += 3;
				int remainder = index % 8;
				for (int k = 0; k < 3; ++k) {
					temp = (byte) ((payload[index / 8] >> remainder) | (payload[index / 8 + 1] << (8 - remainder)));
					realitys.add(temp);
					temp = (byte) ((payload[index / 8 + 1] >> remainder) | (payload[index / 8 + 2] << (8 - remainder)));
					images.add(temp);
					index += 16;
				}
			}
			for (int i = 0; i < realitys.size(); i++) {
				System.out.println(realitys.get(i) + ":" + images.get(i));
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
