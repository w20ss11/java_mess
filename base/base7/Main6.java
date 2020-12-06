package cn.cqupt.wss;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int res;
        res = fun(str1, str2);
        System.out.println(res);
    }
    private static int fun(String str1, String str2) {
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int len1 = chs1.length;
        int len2 = chs2.length;
        int[][] ints = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            ints[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            ints[0][i] = i;
        }
 
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    ints[i][j] = ints[i - 1][j - 1];
                } else {
                    int op1 = ints[i][j - 1] + 1;
                    int op2 = ints[i - 1][j] + 1;
                    int op3 = ints[i - 1][j - 1] + 1;
                    ints[i][j] = Math.min(op1, op2) > Math.min(op2, op3) ? Math.min(op2, op3) :Math.min(op1, op2);
                }
            }
        }
        return ints[len1][len2];
    }
}
