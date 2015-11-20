/**
 * 一维数组的连续子数组的最大和
 * 
 * @author MYONERAY
 *
 */
public class Main1 {
    /**
     * 题目：输入一个整型数组，数组里有正数也有负数。 数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间负责度为O(n)。
     * 如果当前和为负数，那么就放弃前面的累加和，从数组中的下一个数再开始计数。
     */
    static int MaxSum(int arr[], int n) {
        int currentSum = arr[0];
        int ans = currentSum;
        for (int i = 1; i < n; i++) {
            System.out.print(currentSum + "+" + arr[i] + " ? " + arr[i]);
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            System.out.println("    MAX:" + currentSum);
            System.out.print(ans + " ? " + currentSum);
            ans = Math.max(ans, currentSum);
            System.out.println("    MAX:" + ans);
            System.out.println("currentSum:" + currentSum + "    ans:" + ans);
            System.out.println("-----------------------------------------------");
        }
        return ans;
    }

    public static int[][] arrSum(int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;
        int p[][] = new int[m + 1][n + 1];
        p[0][0] = arr[0][0];
        for (int i = 0; i <= m; i++)
            p[i][0] = 0;
        for (int i = 0; i <= n; i++)
            p[0][i] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = p[i - 1][j] + p[i][j - 1] + arr[i - 1][j - 1] - p[i - 1][j - 1];
            }
        }
        return p;
    }

    // 遍历所有二维数组的矩形区域
    static int maxArrSum(int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;
        int p[][] = arrSum(arr);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int endi = i; endi <= m; endi++) {
                    for (int endj = j; endj <= n; endj++) {
                        int sum = p[endi][endj] - p[i - 1][endj] - p[endi][j - 1] + p[i - 1][j - 1];
                        if (ans < sum)
                            ans = sum;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temp = { 1, -2, 3, 10, -4, 7, 2, -5 };
        int[][] tempb = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, -8 } };
//        System.out.println(MaxSum(temp, temp.length));
        System.out.println(maxArrSum(tempb));
    }

}
