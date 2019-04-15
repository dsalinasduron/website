
public abstract class Algorithm <T extends Comparable<? super T>> 
{
	public abstract void apply(T[] array);
	
	public long  time(T[] array) {
		long start, end;
		  start = System.currentTimeMillis();
		  
		  this.apply(array);
		  
		  end = System.currentTimeMillis();
		  return  (end - start);
	}

	public static Integer[] createRandomArray(int n) {
		java.util.Random r = new java.util.Random();
		
		Integer[] numbers = new Integer[n];
		
		for (int i = 0; i < n; i++)
			numbers[i] = r.nextInt();
		
		return numbers;
	}
}
