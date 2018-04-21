package in.the.future;

public class Solution {

	static int minNum(int A, int K,int P){
		int result=1;
		while((result*K)<=(result*A)+P){
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		int result=minNum(3, 5, 1);
		System.out.println(result);
		int result1=minNum(4, 5, 1);
		System.out.println(result1);
	}

}
