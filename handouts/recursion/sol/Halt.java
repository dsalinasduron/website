public class Halt
{
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

    public static void main(String[] args) {
        halt(true);
    }
}

