package balanced.or.not;

public class Solution {
	static int[] balancedOrNot(String[] expressions,int[] maxReplacements){
		int[] resultArray = new int[expressions.length];
		for(int i=0;i<expressions.length;i++){
			boolean balanced = isBalanced(expressions[i]);
			if(!balanced){
				for(int replacement=1;replacement<=maxReplacements[i];replacement++){
					balanced=replace(expressions[i], replacement);
					if(balanced){
						break;
					}
				}

			}
			if(balanced){
				resultArray[i]=1;
			}
			else{
				resultArray[i]=0;
			}
		}
		return resultArray;
	}

	static boolean replace(String expression,int maxReplacement){
		for(int i=0;i<maxReplacement;i++){
			expression=expression.replaceFirst(">", "<>");
			if(isBalanced(expression)){
				return true;
			}
		}
		return false;

	}

	static boolean isBalanced(String expression){
		int counter = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '<') {
				counter++;
			} else if (expression.charAt(i) == '>') {
				if (counter == 0) {
					return false;
				}
				counter--;
			}
		}
		return counter == 0;
	}

	public static void main(String[] args) {
		String[] expression1 = {"<>","<>><","<>>>","<>>>>"};
		int[] maxReplacement1 = {1,0,2,2};
		int[] result=balancedOrNot(expression1, maxReplacement1);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

}
