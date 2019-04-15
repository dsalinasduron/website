
public class TimeSorts {

	public static void main(String[] args) {
		
		for (int n = 25000; n <= 100000; n += 25000) {
			System.out.println("size: " + n);
			SortingAlgorithm.compareSorts(n);
		}
	}
}
