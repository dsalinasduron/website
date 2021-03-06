/********************************************************************
  * Class for sorting an array of Comparable objects from smallest to 
  * largest.
  * This version of the class uses the Comparable interface but not generics.
  ********************************************************************/

 @SuppressWarnings("unchecked")
 
public class BasicSelectionSort
{
  /*
   * Sorts the first n objects in an array into ascending order
   * using selection sort algorithm.
   */
  public static void selectionSort(Comparable[] a, int n) 
  {
    for (int index = 0; index < n - 1; index++)
    {
      int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
      swap(a, index, indexOfNextSmallest);
      
    } 
  } 
  
  /** Task: Finds the index of the smallest value in a portion of an 
    *        array.
    *  @param a      an array of Comparable objects
    *  @param first  an integer >= 0 and < a.length that is the index of 
    *                the first array element to consider
    *  @param last   an integer >= first and < a.length that is the index 
    *                of the last array element to consider
    *  @return the index of the smallest value among
    *          a[first], a[first + 1], . . . , a[last] */
  private static int getIndexOfSmallest(Comparable[] a, int first, int last)
  {
    Comparable min = a[first];
    int indexOfMin = first;
    for (int index = first + 1; index <= last; index++)
    {
      if (a[index].compareTo(min) < 0)
      {
        min = a[index];
        indexOfMin = index;
      } 
    } 
    return indexOfMin;
  } 
  
  /** Task: Swaps the array elements a[i] and a[j].
    *  @param a  an array of objects
    *  @param i  an integer >= 0 and < a.length
    *  @param j  an integer >= 0 and < a.length */
  private static void swap(Object[] a, int i, int j)
  {
    Object temp = a[i];
    a[i] = a[j];
    a[j] = temp; 
  } 
  
  public static void main(String[] args) {
    String[] array = {"hello", "world", "alpha", "cmpt", "sorting"};
    System.out.println("original array: ");
    for (int i=0; i<array.length; i++) 
      System.out.print (array[i] + " ");
    System.out.println();
    
    // Apply the sorting algorithm
    selectionSort(array, array.length);

    System.out.println("sorted array: ");
    for (int i=0; i<array.length; i++) 
      System.out.print (array[i] + " ");
    System.out.println();
  } 
  
} 
