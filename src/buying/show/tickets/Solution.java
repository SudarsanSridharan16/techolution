package buying.show.tickets;

public class Solution {
	static long waitingTime(int[] tickets, int p) {
		long answer = 0;
		int i = 0;
		int length = tickets.length;
		if(length > p)
		{
			while(tickets[p] != 0)
			{
				if(tickets[i] != 0)
				{
					tickets[i] = tickets[i] -1;
					if(i == length -1){
						i = 0;
					}
					else{
						i=i+1;
					}
					answer =answer+1;
				}
				else {
					if (i == length - 1){
						i = 0;
					}
					else{
						i=i+1;
					}
				}
			}
		}
		return answer;
	}

	static void printArray(int[] tickets){
		for(int i=0;i<tickets.length;i++){
			System.out.println(tickets[i]);
		}
	}

	public static void main(String[] args) {
		int[] tickets = {5,5,2,3};
		int p = 3;
		System.out.println(waitingTime(tickets,p));
	}
}
