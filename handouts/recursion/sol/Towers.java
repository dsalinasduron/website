/**
 * Recursive solution to Towers of Hanoi
 */

public class Towers
{
  /**
   * Move num disks from startPole to endPole using tempPole as intermediary
   */
  public static void solve(int num, char startPole, char tempPole, char endPole) {
    if (num > 0) {
      // first move num-1 disks from start pole to temp pole
      solve(num-1, startPole, endPole, tempPole);
      
      // output the disk being moved
      System.out.println("Moving " + num + " disk from " + startPole + " to " + endPole);
      
      // move num-1 disks from temp pole to end pole
      solve(num-1, tempPole, startPole, endPole);
    }
  }
  
  public static void main(String[] args) {
    solve(3, 'a','b','c');
  }
}