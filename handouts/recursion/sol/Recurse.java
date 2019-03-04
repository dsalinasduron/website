/**
 * Example program illustrating iterative and recursive
 * solutions to the incredibly simply problem of
 * printing out a list of numbers from n ... 0
 */

public class Recurse
{
 /**
  * Outputs a list of numbers from n .. 0
  */
 public static void iterative(int n) {
  for (int i = n; i >= 0; i--)
   System.out.println(i + " ");
 }

 /**
  * Outputs a list of numbers from 0 .. n
  */
 public static void recursive(int n) {
  if (n < 0)
   return;
  else {
   System.out.print(n + " ");
   recursive(n - 1);
   System.out.print("\n DONE " + n);
  }
 } 

 /**
  * Recursive implementation of factorial.
  */
 public static int factorial(int n) {
   if (n == 1)
     return 1;
   else 
     return n * factorial(n-1);
 }
 
 /**
  * Displays the contents of array in forwards order beginning from position
  */
 public static void displayForwards(int[] array, int position) {
   if (position < array.length) {
     System.out.println(array[position]);
     displayForwards(array, position+1);
   }
   
   return;
 }
 
 /**
  * Displays the contents of array in backwards order beginning from position
  */
 public static void displayBackwards(int[] array, int position) {

   if (position < array.length) {
     displayBackwards(array, position+1);
     System.out.println(array[position]);
   }
   
   return;
 }

 public static boolean halt(boolean value) {
        System.out.println("Does it halt ....");

        if (value == false)
            return false;
        else {
            // get random binary value
            if (Math.random() < 0.5)
                return halt(true);
            else
                return halt(false);
        }
    }


 public static void main(String args[]) {
  if (args.length != 1) {
   System.out.println("Usage: java Recurse <n>");
   System.exit(0);
  }

  recursive(Integer.parseInt(args[0]));
  
  System.out.println();
    
  System.out.println(factorial(Integer.parseInt(args[0])));
  
  System.out.println();
  
  int[] nums = {5,10,15,20,25};
  
  System.out.println("Forwards ....");
  displayForwards(nums,0);
  
  System.out.println("Backwards ....");
  displayBackwards(nums,0);

  halt(true);

 }
}
