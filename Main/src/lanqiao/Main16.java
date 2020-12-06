package lanqiao;

import java.util.Scanner;

public class Main16 {
/**
 * ��������
����Huffman���ڱ��������Ź㷺��Ӧ�á����������ֻ����Huffman���Ĺ�����̡�
��������һ����{pi}={p0, p1, ��, pn-1}��������������Huffman���Ĺ������£�
����1. �ҵ�{pi}����С������������Ϊpa��pb����pa��pb��{pi}��ɾ������Ȼ�����ǵĺͼ��뵽{pi}�С�
������̵ķ��ü�Ϊpa + pb��
����2. �ظ�����1��ֱ��{pi}��ֻʣ��һ������
����������Ĳ��������У������еķ�����ӣ��͵õ��˹���Huffman�����ܷ��á�
�����������񣺶��ڸ�����һ�����У�������������ø����й���Huffman�����ܷ��á�

�������磬��������{pi}={5, 3, 8, 2, 9}��Huffman���Ĺ���������£�
����1. �ҵ�{5, 3, 8, 2, 9}����С�����������ֱ���2��3����{pi}��ɾ�����ǲ�����5���룬�õ�{5, 8, 9, 5}������Ϊ5��
����2. �ҵ�{5, 8, 9, 5}����С�����������ֱ���5��5����{pi}��ɾ�����ǲ�����10���룬�õ�{8, 9, 10}������Ϊ10��
����3. �ҵ�{8, 9, 10}����С�����������ֱ���8��9����{pi}��ɾ�����ǲ�����17���룬�õ�{10, 17}������Ϊ17��
����4. �ҵ�{10, 17}����С�����������ֱ���10��17����{pi}��ɾ�����ǲ�����27���룬�õ�{27}������Ϊ27��
����5. ���ڣ�������ֻʣ��һ����27��������̽������ܷ���Ϊ5+10+17+27=59��
�����ʽ
��������ĵ�һ�а���һ��������n��n<=100����
������������n������������ʾp0, p1, ��, pn-1��ÿ����������1000��
�����ʽ
�����������Щ������Huffman�����ܷ��á�
��������
5
5 3 8 2 9
�������
59*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] ints = new int[n];
		for(int i=0;i<n;i++)
			ints[i] = scanner.nextInt();
		int sum = 0;
		while(ints.length>2){
			ints = get_min(ints);
			//System.out.println(ints[0]);
			sum+=ints[0];
		}
		System.out.println(sum+ints[0]+ints[1]);
	}
	//����������С����������ӣ����Һϲ�Ϊ����0λ
	public static int[] get_min(int[] ints){
		int len = ints.length - 1;
		int[] ints_new = new int[len];
		//�ҳ���С�������������õڶ�С����Ϊmin1
		int min1;
		int min2;
		if(ints[0]>ints[1]){
			min1 = ints[0];
			min2 = ints[1];
		}else{
			min1 = ints[1];
			min2 = ints[0];
		}
		for(int i=2;i<ints.length;i++){
			if(ints[i]<min1){
				ints_new[i-1] = min1;
				if(ints[i]<min2){
					min1 = min2;
					min2 = ints[i];
				}else{
					min1 = ints[i];
				}
				//ints_new[i-1] = min1;���� ����ʱmin1�����ѻ�
				continue;
			}
			if(ints[i]<min2){
				ints_new[i-1] = min2;
				min2 = ints[i];
				continue;
			}
			ints_new[i-1] = ints[i];
		}
		ints_new[0] = min1 + min2;
//		System.out.println(min1);
//		System.out.println(min2);
//		System.out.println(Arrays.toString(ints_new));
//		System.out.println("-------------");
		return ints_new;
	}
}
