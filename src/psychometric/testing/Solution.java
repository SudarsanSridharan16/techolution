package psychometric.testing;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	static int[] jobOffers(int[] scores, int[] lowerLimits,int[] upperLimits){
		int[] result = new int[lowerLimits.length];
		for(int i=0;i<lowerLimits.length;i++){
			List<Integer> filtered= findScoresWithin(scores, lowerLimits[i], upperLimits[i]);
			result[i]=filtered.size();
		}
		return result;
	}

	static List<Integer> findScoresWithin(int[] scores,int lower,int higher){
		List<Integer> filter = new ArrayList<Integer>();
		for(int score:scores){
			if((score>=lower && score<=higher)){
				filter.add(score);
			}
		}
		return filter;
	}

	public static void main(String[] args) {
		int[] scores ={1,3,5,6,8};
		int[] lowerLimits ={2};
		int[] upperLimits ={6};
		int[] results = jobOffers(scores, lowerLimits, upperLimits);
		print(results);

		int[] scores1 ={4,8,7};
		int[] lowerLimits1 ={2,4};
		int[] upperLimits1 ={8,4};
		results = jobOffers(scores1, lowerLimits1, upperLimits1);
		print(results);
	}

	private static void print(int[] results) {
		for(int i=0;i<results.length;i++){
			System.out.println(results[i]);
		}
	}
}
