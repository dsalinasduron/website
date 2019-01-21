/**
 * Generate the co-primes from (1,1) to (m,n)
 * 
 * @author greg
 *
 */
public class CoPrimes {

	public static int gcd(int a, int b) {
		int temp = 0;
		
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Must be passed two integer values > 0");
			
			System.exit(0);
		}
		
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		
		char[][] result = new char[m+1][n+1];
		
		// determine the co-prime integers
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (gcd(i,j) == 1)
					result[i][j] = '*';
				else
					result[i][j] = ' ';

		// output the co-prime integers
		for (int i = m; i > 0; i--) {
			for (int j = 1; j <= n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
