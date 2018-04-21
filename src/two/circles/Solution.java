package two.circles;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	static String[] circles(String[] info) {
		int testCount = Integer.parseInt(info[0]);
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <=testCount; i++) {
			String iThInfo = info[i];
			String[] splited = iThInfo.split("\\s+");
			Integer x1 = Integer.parseInt(splited[0]);
			Integer y1 = Integer.parseInt(splited[1]);
			Integer r1 = Integer.parseInt(splited[2]);
			Integer x2 = Integer.parseInt(splited[3]);
			Integer y2 = Integer.parseInt(splited[4]);
			Integer r2 = Integer.parseInt(splited[5]);
			Integer distancesq = (int)((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
			if (distancesq == ((r1+r2)*(r1+r2))||(r2==r1+Math.sqrt(distancesq))){
				result.add("Touching");
			} else if (distancesq == 0 && r1!=r2) {
				result.add("Concentric");
			} else if (distancesq<((r1+r2)*(r1+r2))) {
				result.add("Intersecting");
			} else if ((r2 >= r1 && Math.sqrt(distancesq) <= (r2 - r1))||((r1 >= r2 && Math.sqrt(distancesq) <= (r1 - r2)))) {
				result.add("Disjoint-Inside");
			} else{
				result.add("Disjoint-Outside");
			}
		}
		return result.toArray(new String[result.size()]);
	}
	
	public static void main(String[] args) {
		String[] info= {"4","12 0 21 14 0 23","0 45 8 0 94 9","35 0 13 10 0 38","0 26 8 0 9 25"};
		String[] result = circles(info);
		for( String s:result){
			System.out.println(s);
		}
		
		String[] info1= {"5","0 5 9 0 9 7","0 15 11 0 20 16","26 0 10 39 0 23","37 0 5 30 0 11","41 0 0 28 0 13"};
		String[] result1 = circles(info1);
		for( String s:result1){
			System.out.println(s);
		}
		
		
	}
}
