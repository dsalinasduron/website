public class Display
{
    public static void displayForwards(int[] array, int position) {
        if (position == array.length)
            return;
        else {
            displayForwards(array,position+1);
            System.out.println(array[position]);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {5,10,15,20,25};
        
        displayForwards(nums,0);
    }
}
