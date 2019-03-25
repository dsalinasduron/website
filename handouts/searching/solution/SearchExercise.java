import java.util.Random;
import java.util.Arrays;

public class SearchExercise
{
  public static final int SIZE = 1000;
  
  /**
   * A sequential search
   *
   * @param list[] - the array to be searched through
   * @param Object key - the item being searched for
   *
   * @return the index where key occurs in list[] (>= 0) or -1 if unsuccessful
   */
   private static <T extends Comparable<? super T>> int sequentialSearch(T[] list, T key)
   {
       for (int i = 0; i < list.length; i++) {
           if (key.equals(list[i]))
               return i;
       }

       return -1;
   }
  
  
   /**
    * A binary search
    * 
    * @param list[] - the array to be searched through
    * @param int first - the position to begin searching from
    * @param int last - the last index in the array to search
    * @param Object key - the item being searched for
    *
    * @return the index where key occurs in list[] (>= 0) or -1 if unsuccessful
    */
   private static <T extends Comparable<? super T>> int binarySearch(T[] list, int first, int last, T key)
   {
      int foundPosition;
      int mid = first + (last - first) / 2;
      
      if (first > last)
         foundPosition = -1;
      else if (key.equals(list[mid]))
         foundPosition = mid;
      else if (key.compareTo(list[mid]) < 0)
         foundPosition = binarySearch(list, first, mid - 1, key);
      else
         foundPosition = binarySearch(list, mid + 1, last, key);
         
      return foundPosition;
   } // end binarySearch

   public static <T extends Comparable<? super T>> int search(T[] list, int first, int last, T key)
   {
      return binarySearch(list, 0, list.length - 1, key);
   } 
   
   public static void runTest(int occurrences) {
     Integer[] values = new Integer[SIZE];
     Integer[] keys = new Integer[occurrences];
     
     Random r = new Random();
     
     // generate a list of random numbers
     for (int i = 0; i < SIZE; i++)
       values[i] = r.nextInt(SIZE*10);
     
     // now sort the list
     Arrays.sort(values);
     
     // now generate a series of random numbers from that list
     for (int i = 0; i < occurrences; i++)
       keys[i] = values[r.nextInt(SIZE)];
     
     long startTime, endTime;
    
	// record the start time 
     startTime = System.currentTimeMillis();

	// perform the binary search
     for (int i = 0; i < occurrences; i++) {
       binarySearch(values,0,SIZE-1,keys[i]);
     }

	// record the ending time
     endTime = System.currentTimeMillis();
     
     System.out.println("Binary search (in ms): " + (endTime - startTime));
    
	// repeat the process for sequential search 
     startTime = System.currentTimeMillis();
     for (int i = 0; i < occurrences; i++) {
       sequentialSearch(values,keys[i]);
     }
      endTime = System.currentTimeMillis(); 
      
      System.out.println("Sequential search (in ms): " + (endTime - startTime));
   }
       
   
   public static void main(String[] args) {
     if (args.length != 1) {
       System.err.println("Usage: java SearchExercise [number of tests]");
       System.exit(0);
     }
     
     runTest(Integer.parseInt(args[0]));
   }
} 
