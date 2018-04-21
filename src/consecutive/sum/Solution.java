package consecutive.sum;

public class Solution {
	static int consecutive(long num) {
		int ans = 0;
		for (int index=1;index*(index+1)<2*num;index++) {
			float a = (1.0f*num-(index*(index+1))/2)/(index+1);
			if (a == Math.round(a)) {
				ans = ans + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		long n = 15;
		System.out.println(consecutive(n));
		n = 10;
		System.out.println(consecutive(n));
	}
}
