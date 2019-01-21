/**
 * @author gagne
 *
 */
public class GenericCoin {
	public enum CoinSide {HEADS, TAILS};
	
	private CoinSide side;
	
	public GenericCoin() {
		side = CoinSide.HEADS;
	}
	
	public void setToHeads() {
		side = CoinSide.HEADS;
	}
	
	public void setToTails() {
		side = CoinSide.TAILS;
	}

	public void toss() {
		double value = Math.random();
		
		if (value < 0.5)
			side = CoinSide.HEADS;
		else
			side = CoinSide.TAILS;
	}
	
	public boolean isHeads() {
		return (side == CoinSide.HEADS) ? true : false;
	}
	
	public boolean isTails() {
		return (side == CoinSide.TAILS) ? true : false;
	}
	
	public String toString() {
		if (isHeads())
			return "heads";
		else
			return "tails";
	}
}
