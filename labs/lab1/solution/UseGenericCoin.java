
public class UseGenericCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final  int TOSS_TIMES = 100;
		
		GenericCoin coin1 = new GenericCoin();
		GenericCoin coin2 = new GenericCoin();
		
		// toss each coin 
		double headsCoin1 = 0, headsCoin2 = 0;
		
		for (int i = 0; i < TOSS_TIMES; i++) {
			coin1.toss();
			if (coin1.isHeads())
				++headsCoin1;
			
			coin2.toss();
			if (coin2.isHeads())
				++headsCoin2;
		}
			
		System.out.println("Coin1 was heads " + headsCoin1/TOSS_TIMES);
		System.out.println("Coin2 was heads " + headsCoin2/TOSS_TIMES);
		
		if (headsCoin1 > headsCoin2)
			System.out.println("The first coin was heads " + (headsCoin1-headsCoin2) + " more times.");
		else if (headsCoin1 < headsCoin2)
			System.out.println("The second coin was heads " + (headsCoin2-headsCoin1) + " more times.");
		else
			System.out.println("Both coins had the same number of heads.");
			

	}

}
