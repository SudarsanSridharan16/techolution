package largest.subset.sum;

public class Solution {

	static long[] maxSubsetSum(int[] k) {
		long[] result = new long[k.length];
		for (int c = 0; c < k.length; c++) {
			int sum = 1;
			for (int i = 2; i <= k[c]; i++) {
				while (k[c] % i == 0) {
					sum += k[c];
					k[c] = k[c] / i;
				}
			}
			result[c] = sum;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] k = { 2, 4 };
		long[] ans = maxSubsetSum(k);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
