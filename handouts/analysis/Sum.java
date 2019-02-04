public class Sum
{
  /**
   * returns the summation of 1 .. n
   */
  public static int summation(int n) {
    // write this method
    
    return -1;
  }
  
  public static void main(String[] args) {
    if (args.length != 1 || Integer.parseInt(args[0]) < 0) {
      System.out.println("Usage: java Sum <integer value >= 0>");
    }
    else
      System.out.println("sum is " + summation(Integer.parseInt(args[0])));
  }
}