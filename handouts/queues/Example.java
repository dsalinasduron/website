public class Example
{
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "ghi";
        String s4 = "ghi";

        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
        System.out.println(s3.compareTo(s4));
    }
}
