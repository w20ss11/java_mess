package defaultPack;
import java.util.Scanner;

public class HaHa {
    private static long fun(int[] arr, int n, int k) {
        if (k >= n) {
            return n * (n + 1) / 2;
        }

        int res = n;
        for (int i = 0; i < n; i++) {
            for (int j = i+k; j <= n - k; j++) {
                if (check(arr, i, j, k)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean check(int[] arr, int i, int j, int k) {
        if (j - i < k) {
            return true;
        } else {
            int[] count = new int[100000];
            for (int t = i; t <= j; t++) {
                count[arr[t]]++;
            }
            int maxCount = count[0];
            for (int m = 1; m < 100000; m++) {// 找出最多出现的次数
                if (count[m] > maxCount) {
                    maxCount = count[m];
                }
                if (maxCount > k) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(fun(array, n, k));
    }
}