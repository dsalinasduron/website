import java.util.Scanner;

public class EmployeeInfo
{
    public static void main(String[] args) {
        int x1, x2, x3, i;

        Scanner input = new Scanner(System.in);

        x1 = input.nextInt();
        x2 = input.nextInt();
        x3 = input.nextInt();

        while (x1 != 0) {
            String name = input.next();
            System.out.println(x1 + " " + x2 + " " + x3 + " " + name);
        
            x1 = input.nextInt();
            x2 = input.nextInt();
            x3 = input.nextInt();
        }

        input.close();
    }

}        
