package defaultPack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class ResolveCSI {
	public static void main(String[] args) throws IOException {
		int limit = 211;
		int[] bytes = new int[212];
		RandomAccessFile file = new RandomAccessFile("D:\\eclipse_workspace\\Main\\src\\0330_R1_132_1.dat", "r");
		System.setOut(new PrintStream(new FileOutputStream("D:\\eclipse_workspace\\Main\\src\\0330_R1_132_1.txt")));
		int count = 0;
		file.seek(3);
		while (true) {
			int temp = file.read();
			System.out.println(temp);
			bytes[count] = temp;
			count++;
			if (count > limit) {
				break;
			}
		}
		file.close();
		int timestamp_low = bytes[0] + (bytes[1] << 8) + (bytes[2] << 16) + (bytes[3] << 24);
		int bfee_count = bytes[4] + (bytes[5] << 8);
		int Nrx = bytes[8];
		int Ntx = bytes[9];
		int rssi_a = bytes[10];
		int rssi_b = bytes[11];
		int rssi_c = bytes[12];
		int noise = bytes[13];
		int agc = bytes[14];
		int antenna_sel = bytes[15];
		int len = bytes[16] + (bytes[17] << 8);
		int fake_rate_n_flags = bytes[18] + (bytes[19] << 8);
		int calc_len = (30 * (Nrx * Ntx * 8 * 2 + 3) + 7) / 8;
		
		System.out.println("timestamp_low: " + timestamp_low);
		System.out.println("bfee_count: " + bfee_count);
		System.out.println("Nrx: " + Nrx);
		System.out.println("Ntx: " + Ntx);
		System.out.println("rssi_a: " + rssi_a);
		System.out.println("rssi_b: " + rssi_b);
		System.out.println("rssi_c: " + rssi_c);
		System.out.println("noise: " + noise);
		System.out.println("agc: " + agc);
		System.out.println("antenna_sel: " + antenna_sel);
		System.out.println("len: " + len);
		System.out.println("fake_rate_n_flags: " + fake_rate_n_flags);
		System.out.println("calc_len: " + calc_len);

		byte b1 = new Integer(bytes[20]).byteValue();
		byte b2 = new Integer(bytes[21]).byteValue();
		byte b3 = new Integer(bytes[22]).byteValue();
//		System.err.println("b1: " + b1);
//		System.err.println("b2: " + b2);
//		System.err.println("b3: " + b3);

		int index = 0;
		index += 3;
		int remainder = index % 8;
		int re = (b1 >> remainder) | (b2 << (8 - remainder));
		System.err.println(b1 >> remainder);
		System.err.println(b2 << (8 - remainder));

		/*
		 * System.err.println(re);
		 * 
		 * // System.err.println(b1); String payload0 =
		 * Integer.toBinaryString(bytes[20]); System.out.println("payload0: " +
		 * payload0);
		 * 
		 * String payload1 = Integer.toBinaryString(bytes[21]);
		 * System.out.println("payload1: " + payload1);
		 * 
		 * String payload2 = Integer.toBinaryString(bytes[22]);
		 * System.out.println("payload2: " + payload2); // int index = 0; //
		 * index += 3; // int remainder = index % 8; // // int temp =
		 * (payload[index / 8] >> remainder) | (payload[index / 8 + // 1] << (8
		 * - remainder)); // System.out.println("temp: " + temp);
		 */
	}
}
